package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ReverseActivity : AppCompatActivity() {
    private lateinit var setText: EditText
    private lateinit var result: TextView
    private lateinit var rev: CheckBox
    private lateinit var Clear: Button
    private lateinit var okButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)
        rev=findViewById(R.id.reverse_checkbox)
        okButton=findViewById(R.id.Ok)
        result=findViewById(R.id.result_text)
        setText=findViewById(R.id.editTexts)
        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val text = sharedPref.getString("text", "")
        result.text = text
        okButton.setOnClickListener {
            if (rev.isChecked) {
                val text = setText.text.toString()
                val reversedText = text.reversed()
                result.text = reversedText

            }
            val text = result.text.toString()
            val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("text", text)
            editor.apply()

        }
        Clear=findViewById(R.id.Clear_button)
        Clear.setOnClickListener {
            result.text = ""
            rev.isChecked=false
            setText.text.clear()
        }


        val buttonBacks = findViewById<Button>(R.id.buttons_back)
        buttonBacks.setOnClickListener {
            finish()
        }
    }
}


