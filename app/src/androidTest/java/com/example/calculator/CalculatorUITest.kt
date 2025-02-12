package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.performClick


class CalculatorUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val viewModel = CalculatorViewModel()

    @Test
    fun test_addition() {
        composeTestRule.setContent {
            CalculatorTheme {
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("1").performClick()
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("=").performClick()


        composeTestRule.onNodeWithText("3.0").assertExists(
            "No node with this text was found."
        )
    }

    @Test
    fun test_multiplication() {
        composeTestRule.setContent {
            CalculatorTheme {
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("3").performClick()
        composeTestRule.onNodeWithText("x").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("=").performClick()

        composeTestRule.onNodeWithText("6.0").assertExists(
            "No node with this text was found."
        )
    }

    @Test
    fun test_division() {
        composeTestRule.setContent {
            CalculatorTheme {
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("6").performClick()
        composeTestRule.onNodeWithText("/").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("=").performClick()


        composeTestRule.onNodeWithText("3.0").assertExists(
            "No node with this text was found."
        )
    }

    @Test
    fun test_subtraction() {
        composeTestRule.setContent {
            CalculatorTheme {
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("6").performClick()
        composeTestRule.onNodeWithText("-").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("=").performClick()


        composeTestRule.onNodeWithText("4.0").assertExists(
            "No node with this text was found."
        )
    }

    @Test
    fun test_decimal_point() {
        composeTestRule.setContent {
            CalculatorTheme {
                val state = viewModel.state
                val buttonSpacing = 8.dp

                Calculator(
                    state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp)
                )
            }
        }
        composeTestRule.onNodeWithText("6").performClick()
        composeTestRule.onNodeWithText(".").performClick()
        composeTestRule.onNodeWithText("5").performClick()
        composeTestRule.onNodeWithText("+").performClick()
        composeTestRule.onNodeWithText("2").performClick()
        composeTestRule.onNodeWithText("=").performClick()


        composeTestRule.onNodeWithText("8.5").assertExists(
            "No node with this text was found."
        )
    }
}
