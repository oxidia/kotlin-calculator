package com.example.calculator

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1),
            )

            state.operation != null -> state = state.copy(
                operation = null,
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1),
            )
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 == null || number2 == null) {
            return
        }

        val result = when (state.operation) {
            CalculatorOperation.Divide -> number1 / number2
            CalculatorOperation.Multiply -> number1 * number2
            CalculatorOperation.Subtract -> number1 - number2
            CalculatorOperation.Add -> number1 + number2
            CalculatorOperation.Power -> number1.pow(number2)
            else -> 0.0
        }

        state = state.copy(
            number1 = result.toString().take(15),
            number2 = "",
            operation = null,
        )
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number2.isNotBlank()) {
            performCalculation()
            state = state.copy(operation = operation)
        } else if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && state.number1.isNotBlank() && !state.number1.contains(".")) {
            state = state.copy(
                number1 = state.number1 + "."
            )
        } else if (state.number2.isNotBlank() && !state.number2.contains(".")) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length < MAX_NUM_LENGTH) {
                state = state.copy(
                    number1 = state.number1 + number
                )
            }
        } else {
            if (state.number2.length < MAX_NUM_LENGTH) {
                state = state.copy(
                    number2 = state.number2 + number
                )
            }
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}