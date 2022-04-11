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
    var temp_num: String = ""
    var firstNum: String = ""
    var secondNum: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        findViews()
        setNumberListener()
    }

    fun setNumberListener() {
        val numberList: List<Button> = listOf(
            oneButton, twoButton, threeButton, fourButton, fiveButton,
            sixButton, sevenButton, eightButton, nineButton, zeroButton,
            dotButton
        )
        val listener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                inputValue += (p0 as Button).text
                resultNumber.text = inputValue
            }
        }
        numberList.forEach { it.setOnClickListener(listener) }
    }

    fun setOperatorListener() {
        // first, second num 사용해서 다시 한번 해보자.....
        // NumberListener도 수정이 필요하면 수정하자...
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