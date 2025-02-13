package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.LightGray
import com.example.calculator.ui.theme.MediumGray
import com.example.calculator.ui.theme.Orange

val buttons = listOf(
    Button(
        symbol = "AC", color = LightGray, weight = 1f, action = CalculatorAction.Clear
    ),
    Button(
        symbol = "Del", color = MediumGray, weight = 1f, action = CalculatorAction.Delete
    ),
    Button(
        symbol = "^",
        color = Orange,
        weight = 1f,
        action = CalculatorAction.Operation(CalculatorOperation.Power)
    ),
    Button(
        symbol = "/",
        color = Orange,
        weight = 1f,
        action = CalculatorAction.Operation(CalculatorOperation.Divide)
    ),

    Button(symbol = "7", color = MediumGray, weight = 1f, action = CalculatorAction.Number(7)),
    Button(symbol = "8", color = MediumGray, weight = 1f, action = CalculatorAction.Number(8)),
    Button(symbol = "9", color = MediumGray, weight = 1f, action = CalculatorAction.Number(9)),
    Button(
        symbol = "x",
        color = Orange,
        weight = 1f,
        action = CalculatorAction.Operation(CalculatorOperation.Multiply)
    ),

    Button(symbol = "4", color = MediumGray, weight = 1f, action = CalculatorAction.Number(4)),
    Button(symbol = "5", color = MediumGray, weight = 1f, action = CalculatorAction.Number(5)),
    Button(symbol = "6", color = MediumGray, weight = 1f, action = CalculatorAction.Number(6)),
    Button(
        symbol = "-",
        color = Orange,
        weight = 1f,
        action = CalculatorAction.Operation(CalculatorOperation.Subtract)
    ),

    Button(symbol = "3", color = MediumGray, weight = 1f, action = CalculatorAction.Number(3)),
    Button(symbol = "2", color = MediumGray, weight = 1f, action = CalculatorAction.Number(2)),
    Button(symbol = "1", color = MediumGray, weight = 1f, action = CalculatorAction.Number(1)),
    Button(
        symbol = "+",
        color = Orange,
        weight = 1f,
        action = CalculatorAction.Operation(CalculatorOperation.Add)
    ),

    Button(symbol = "0", color = MediumGray, weight = 1f, action = CalculatorAction.Number(0)),
    Button(symbol = ".", color = MediumGray, weight = 1f, action = CalculatorAction.Decimal),
    Button(symbol = ".", color = MediumGray, weight = 1f, action = CalculatorAction.Decimal),
    Button(symbol = "=", color = Orange, weight = 1f, action = CalculatorAction.Calculate),
)


@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit,
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            val text = state.number1 + (state.operation?.symbol ?: "") + state.number2

            val textFontSize = when {
                text.length > 16 -> 30
                text.length > 8 -> 40
                else -> 80
            }

            Text(
                text = text,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(vertical = 32.dp)
                    .fillMaxWidth(),
                fontWeight = FontWeight.Light,
                fontSize = textFontSize.sp,
                lineHeight = textFontSize.sp,
                color = Color.White,
                maxLines = 2,
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 4),
                verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                items(buttons) {
                    CalculatorButton(symbol = it.symbol, modifier = Modifier
                        .background(
                            color = it.color,
                        )
                        .aspectRatio(it.weight)
                        .weight(it.weight), onClick = {
                        onAction(it.action)
                    })
                }
            }
        }
    }
}

data class Button(
    val symbol: String,
    val color: Color,
    val weight: Float,
    val action: CalculatorAction,
)

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    val viewModel = CalculatorViewModel()
    val state = viewModel.state
    val buttonSpacing = 8.dp

    Calculator(state = state, buttonSpacing = buttonSpacing, onAction = {})
}
