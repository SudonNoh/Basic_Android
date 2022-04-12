package com.example.fastcampus

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView


class Calculator : AppCompatActivity() {
    lateinit var oneButton: Button
    lateinit var twoButton: Button
    lateinit var threeButton: Button
    lateinit var fourButton: Button
    lateinit var fiveButton: Button
    lateinit var sixButton: Button
    lateinit var sevenButton: Button
    lateinit var eightButton: Button
    lateinit var nineButton: Button
    lateinit var zeroButton: Button
    lateinit var plusButton: Button
    lateinit var minusButton: Button
    lateinit var divideButton: Button
    lateinit var multiplyButton: Button
    lateinit var equalButton: Button
    lateinit var dotButton: Button
    lateinit var initButton: Button
    lateinit var backspaceButton: Button
    lateinit var resultNumber: TextView
    lateinit var processNumber: TextView

    var inputValue: String = ""
    var operatorValue: String = ""
    var tempNum: String = ""
    var processNum: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        findViews()
        setNumberListener()
        setOperatorListener()

        equalButton.setOnClickListener {
            val resultNum: Float? =
                calculatorFunction(tempNum, resultNumber.text.toString(), operatorValue)
            processNum += resultNumber.text.toString()
            processNumber.text = processNum
            resultNumber.text = resultNum.toString()
            inputValue = ""
            operatorValue = ""
            tempNum = resultNum.toString()
        }

        initButton.setOnClickListener {
            inputValue = ""
            operatorValue = ""
            tempNum = ""
            processNum = ""
            processNumber.text = ""
            resultNumber.text = ""
        }

        backspaceButton.setOnClickListener {
            val tempText: String = resultNumber.text.toString()
            inputValue = tempText.dropLast(1)
            resultNumber.text = inputValue
        }

        dotButton.setOnClickListener {
            if (resultNumber.text.contains(".")) {
                resultNumber.text = resultNumber.text
            } else {
                inputValue += (it as Button).text as String
                resultNumber.text = inputValue
            }
        }
    }

    fun setNumberListener() {
        val numberList: List<Button> = listOf(
            oneButton, twoButton, threeButton, fourButton, fiveButton,
            sixButton, sevenButton, eightButton, nineButton, zeroButton,
        )
        val listener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if (inputValue == "") {
                    processNum += (operatorValue + " ")
                    processNumber.text = processNum
                }
                inputValue += (p0 as Button).text as String
                resultNumber.text = inputValue
            }
        }
        numberList.forEach { it.setOnClickListener(listener) }
    }

    fun setOperatorListener() {
        val operatorList: List<Button> = listOf(
            plusButton, minusButton, divideButton, multiplyButton
        )
        val listener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if (operatorValue != "") {
                    val resultNum: Float? =
                        calculatorFunction(tempNum, resultNumber.text.toString(), operatorValue)
                    processNum += (resultNumber.text.toString() + " ")
                    processNumber.text = processNum
                    operatorValue = (p0 as Button).text as String
                    resultNumber.text = operatorValue
                    inputValue = ""
                    tempNum = resultNum.toString()
                } else {
                    operatorValue = (p0 as Button).text as String
                    tempNum = resultNumber.text.toString()
                    processNum += (tempNum + " ")
                    processNumber.text = processNum
                    resultNumber.text = operatorValue
                    inputValue = ""
                }
            }
        }
        operatorList.forEach { it.setOnClickListener(listener) }
    }

    fun calculatorFunction(firstNum: String, secondNum: String, operatorStr: String): Float? {
        val firstNumber: Float = firstNum.toFloat()
        val secondNumber: Float = secondNum.toFloat()
        val result: Float? = when (operatorStr) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "*" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            else -> null
        }
        return result
    }

    fun findViews() {
        oneButton = findViewById(R.id.one)
        twoButton = findViewById(R.id.two)
        threeButton = findViewById(R.id.three)
        fourButton = findViewById(R.id.four)
        fiveButton = findViewById(R.id.five)
        sixButton = findViewById(R.id.six)
        sevenButton = findViewById(R.id.seven)
        eightButton = findViewById(R.id.eight)
        nineButton = findViewById(R.id.nine)
        zeroButton = findViewById(R.id.zero)
        plusButton = findViewById(R.id.plus)
        minusButton = findViewById(R.id.minus)
        divideButton = findViewById(R.id.divide)
        multiplyButton = findViewById(R.id.multiply)
        equalButton = findViewById(R.id.equal)
        dotButton = findViewById(R.id.dot)
        initButton = findViewById(R.id.init)
        backspaceButton = findViewById(R.id.backspace)
        resultNumber = findViewById(R.id.result_number)
        processNumber = findViewById(R.id.process)
    }
}