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
    private lateinit var upper: CheckBox
    private lateinit var Clear: Button
    private lateinit var okButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)
        rev=findViewById(R.id.reverse_checkbox)
        okButton=findViewById(R.id.Ok)
        result=findViewById(R.id.result_text)
        upper=findViewById(R.id.uppercase_checkbox)
        setText=findViewById(R.id.editTexts)
        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val text = sharedPref.getString("text", "")
        result.text = text
        okButton.setOnClickListener {
            if (upper.isChecked){
                val text = setText.text.toString()
                val upperText = text.uppercase()
                result.text=upperText
            }
            if (rev.isChecked) {
                val text = setText.text.toString()
                val reversedText = text.reversed()
                result.text = reversedText

            }
            if (rev.isChecked && upper.isChecked){
                val text = setText.text.toString()
                val allText = text.reversed().uppercase()
                result.text=allText
            }


        }
        Clear=findViewById(R.id.Clear_button)
        Clear.setOnClickListener {
            result.text = ""
            upper.isChecked=false
            rev.isChecked=false
            setText.text.clear()
        }


        val buttonBacks = findViewById<Button>(R.id.buttons_back)
        buttonBacks.setOnClickListener {
            val text = result.text.toString()
            val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("text", text)
            editor.apply()
            finish()

        }
    }
}


