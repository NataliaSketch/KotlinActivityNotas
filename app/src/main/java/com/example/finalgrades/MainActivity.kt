package com.example.finalgrades

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.finalgrades.R.*
import com.example.finalgrades.R.id.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val note1 = findViewById<EditText>(note1)
        val note2 = findViewById<EditText>(note2)
        val note3 = findViewById<EditText>(note3)
        val btnCalculate = findViewById<Button>(btnCalculate)
        val btnDelete = findViewById<Button>(btnDelete)
        val txtResult = findViewById<TextView>(txtResult)

        btnCalculate.setOnClickListener {
            val n1 = note1.text.toString().toDoubleOrNull()?: 0.0
            val n2 = note2.text.toString().toDoubleOrNull()?: 0.0
            val n3 = note3.text.toString().toDoubleOrNull()?: 0.0

            val average = (n1+n2+n3) / 3
            val message = if(average >= 3.0) {
                "Average: %.2f ✅Approved".format(average)
            } else {
                "Average: %2.f ❌Failed".format(average)
            }


            txtResult.text = message

            btnDelete.setOnClickListener {
                note1.text.clear()
                note2.text.clear()
                note3.text.clear()
                txtResult.text = ""
            }

        }

    }
}