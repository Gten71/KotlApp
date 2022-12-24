package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReverseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reverse)
        // Получаем ссылку на EditText
        val editText = findViewById<EditText>(R.id.editTexts)

        // Получаем ссылку на TextView
        val textView = findViewById<TextView>(R.id.result_text)

        // Находим кнопку и устанавливаем слушатель события нажатия
        val button = findViewById<Button>(R.id.Ok_button)
        button.setOnClickListener {
            // Получаем текст из EditText и разворачиваем его
            val reversedText = editText.text.toString().reversed()

            // Устанавливаем развернутый текст в TextView
            textView.text = reversedText
        }
        val buttonBacks = findViewById<Button>(R.id.buttons_back)
        buttonBacks.setOnClickListener {
            finish()
        }
    }
}


