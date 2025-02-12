package com.example.calculator

sealed class CalculatorOperation(val symbol: String) {
    data object Add : CalculatorOperation(symbol = "+")
    data object Subtract : CalculatorOperation(symbol = "-")
    data object Multiply : CalculatorOperation(symbol = "x")
    data object Divide : CalculatorOperation(symbol = "/")
}
