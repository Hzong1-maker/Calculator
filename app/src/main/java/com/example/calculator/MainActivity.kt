package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNumberEditText = findViewById<EditText>(R.id.firstNumber)
        val secondNumberEditText = findViewById<EditText>(R.id.secondNumber)
        val operationSpinner = findViewById<Spinner>(R.id.operationSpinner)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val firstNumber = firstNumberEditText.text.toString().toDoubleOrNull()
            val secondNumber = secondNumberEditText.text.toString().toDoubleOrNull()
            val operation = operationSpinner.selectedItem.toString()

            if (firstNumber != null && secondNumber != null) {
                val result = when (operation) {
                    "Addition" -> firstNumber + secondNumber
                    "Subtraction" -> firstNumber - secondNumber
                    "Multiplication" -> firstNumber * secondNumber
                    "Division" -> {
                        if (secondNumber != 0.0) {
                            firstNumber / secondNumber
                        } else {
                            "Error: Division by zero"
                        }
                    }
                    else -> "Error: Unknown operation"
                }

                resultTextView.text = "Result: $result"
            } else {
                resultTextView.text = "Error: Please enter valid numbers"
            }
        }
    }
}
