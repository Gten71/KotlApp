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
    private lateinit var lover:CheckBox
    private lateinit var clear: Button
    private lateinit var okButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)
        lover=findViewById(R.id.lowercase_checkbox)
        rev=findViewById(R.id.reverse_checkbox)
        okButton=findViewById(R.id.Ok)
        result=findViewById(R.id.result_text)
        upper=findViewById(R.id.uppercase_checkbox)
        setText=findViewById(R.id.editTexts)
        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val text = sharedPref.getString("text", "")

        result.text = text
        fun lowercaseTramsform(text:String):String{
            return text.lowercase()
        }
        fun uppercaseTransform(text: String): String {
            return text.uppercase()
        }
        fun reverseTransform(text: String): String {
            return text.reversed()
        }

        okButton.setOnClickListener {
            if (lover.isChecked){
                val inputlower = setText.text.toString()
                val resultlower=lowercaseTramsform(inputlower)
                setText.setText(resultlower)
                result.text=resultlower
            }
            if (rev.isChecked) {
                val input = setText.text.toString()
                val resulti = reverseTransform(input)
                setText.setText(resulti)
                result.text = resulti
            }
            if (upper.isChecked){
                val inputup = setText.text.toString()
                val resultup = uppercaseTransform(inputup)
                setText.setText(/* text = */ resultup)
                result.text = resultup
            }
        }


        clear=findViewById(R.id.Clear_button)
        clear.setOnClickListener {
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


