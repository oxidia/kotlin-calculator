package com.example.calculator

data class CalculatorState(
    var number1: String = "",
    var number2: String = "",
    var operation: CalculatorOperation? = null,
)
