package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class ReverseActivity : AppCompatActivity() {
    private lateinit var setText: EditText
    private lateinit var result: TextView
    private lateinit var rev: CheckBox
    private lateinit var upper: RadioButton
    private lateinit var lower:RadioButton
    private lateinit var clear: Button
    private lateinit var okButton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)
        lower=findViewById(R.id.lowercase_checkbox)
        rev=findViewById(R.id.reverse_checkbox)
        okButton=findViewById(R.id.Ok)
        result=findViewById(R.id.result_text)
        upper=findViewById(R.id.uppercase_checkbox)
        setText=findViewById(R.id.editTexts)
        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val text = sharedPref.getString("text", "")

        result.text = text
        fun lowercaseTransform(text:String):String{
            return text.lowercase()
        }
        fun uppercaseTransform(text: String): String {
                return text.uppercase()
        }
        fun reverseTransform(text: String): String {
            return text.reversed()
        }

        okButton.setOnClickListener {
            if (lower.isChecked){
                val inputlower = setText.text.toString()
                val resultlower=lowercaseTransform(inputlower)
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
                setText.setText( resultup)
                result.text = resultup
            }
        }


        clear=findViewById(R.id.Clear_button)
        clear.setOnClickListener {
            result.text = ""
            upper.isChecked=false
            rev.isChecked=false
            lower.isChecked=false
            setText.text.clear()
        }
//        lower.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
//            upper.isEnabled = !isChecked
//        })
//        upper.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
//            lower.isEnabled = !isChecked
//        })




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


