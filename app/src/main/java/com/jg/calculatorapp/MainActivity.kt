package com.jg.calculatorapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.btnAdd.setOnClickListener {
            val (num1, num2) = getNumbers()
            mainBinding.tvResult.text = "Result: ${num1 + num2}"
        }

        mainBinding.btnSub.setOnClickListener {
            val (num1, num2) = getNumbers()
            mainBinding.tvResult.text = "Result: ${num1 - num2}"
        }

        mainBinding.btnMul.setOnClickListener {
            val (num1, num2) = getNumbers()
            mainBinding.tvResult.text = "Result: ${num1 * num2}"
        }

        mainBinding.btnDiv.setOnClickListener {
            val (num1, num2) = getNumbers()
            if (num2 != 0f) {
                mainBinding.tvResult.text = "Result: ${num1 / num2}"
            } else {
                mainBinding.tvResult.text = "Cannot divide by zero"
            }
        }
    }

    private fun getNumbers(): Pair<Float, Float> {
        val num1 = mainBinding.etNumber1.text.toString().toFloatOrNull() ?: 0f
        val num2 = mainBinding.etNumber2.text.toString().toFloatOrNull() ?: 0f
        return Pair(num1,num2)
    }
}

