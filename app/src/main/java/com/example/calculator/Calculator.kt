package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

            CalculatorRow(spacing = buttonSpacing) {
                CalculatorButton(symbol = "AC", modifier = Modifier
                    .background(
                        color = LightGray
                    )
                    .aspectRatio(2f)
                    .weight(2f), onClick = {
                    onAction(CalculatorAction.Clear)
                })

                CalculatorButton(symbol = "Del", modifier = Modifier
                    .background(
                        color = MediumGray,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Delete)
                })

                CalculatorButton(symbol = "/", modifier = Modifier
                    .background(
                        color = Orange,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                })
            }

            CalculatorRow(spacing = buttonSpacing) {
                CalculatorButton(symbol = "7", modifier = Modifier
                    .background(
                        color = MediumGray,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Number(7))
                })

                CalculatorButton(symbol = "8", modifier = Modifier
                    .background(
                        color = MediumGray
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Number(8))
                })

                CalculatorButton(symbol = "9", modifier = Modifier
                    .background(
                        color = MediumGray
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Number(9))
                })

                CalculatorButton(symbol = "x", modifier = Modifier
                    .background(
                        color = Orange,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                })
            }

            CalculatorRow(spacing = buttonSpacing) {
                CalculatorButton(symbol = "4", modifier = Modifier
                    .background(
                        color = MediumGray
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Number(4))
                })

                CalculatorButton(symbol = "5", modifier = Modifier
                    .background(
                        color = MediumGray
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Number(5))
                })

                CalculatorButton(symbol = "6", modifier = Modifier
                    .background(
                        color = MediumGray,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Number(6))
                })

                CalculatorButton(symbol = "-", modifier = Modifier
                    .background(
                        color = Orange,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                })
            }

            CalculatorRow(spacing = buttonSpacing) {
                CalculatorButton(symbol = "3", modifier = Modifier
                    .background(
                        color = MediumGray
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Number(3))
                })

                CalculatorButton(symbol = "2", modifier = Modifier
                    .background(
                        color = MediumGray
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Number(2))
                })

                CalculatorButton(symbol = "1", modifier = Modifier
                    .background(
                        color = MediumGray,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Number(1))
                })

                CalculatorButton(symbol = "+", modifier = Modifier
                    .background(
                        color = Orange,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                })
            }

            CalculatorRow(spacing = buttonSpacing) {
                CalculatorButton(symbol = "0", modifier = Modifier
                    .background(
                        color = MediumGray
                    )
                    .aspectRatio(2f)
                    .weight(2f), onClick = {
                    onAction(CalculatorAction.Number(0))
                })

                CalculatorButton(symbol = ".", modifier = Modifier
                    .background(
                        color = MediumGray,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Decimal)
                })

                CalculatorButton(symbol = "=", modifier = Modifier
                    .background(
                        color = Orange,
                    )
                    .aspectRatio(1f)
                    .weight(1f), onClick = {
                    onAction(CalculatorAction.Calculate)
                })
            }
        }
    }
}

@Composable
fun CalculatorRow(
    spacing: Dp,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(spacing)
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    val viewModel = CalculatorViewModel()
    val state = viewModel.state
    val buttonSpacing = 8.dp

    Calculator(state = state, buttonSpacing = buttonSpacing, onAction = {})
}
