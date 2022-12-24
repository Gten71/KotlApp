package com.example.myapplication

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class ReverseDialog : DialogFragment() {

    private lateinit var input: EditText
    private lateinit var uppercaseCheckBox: CheckBox
    private lateinit var reverseCheckBox: CheckBox

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_reverse, null)


        input = view.findViewById(R.id.input)
        uppercaseCheckBox = view.findViewById(R.id.uppercase_checkbox)
        reverseCheckBox = view.findViewById(R.id.reverse_checkbox)

        builder.setView(view)
            .setPositiveButton(R.string.ok) { _, _ ->
                val inputText = input.text.toString()
                var resultText = inputText
                if (uppercaseCheckBox.isChecked) {
                    resultText = resultText.toUpperCase()
                }
                if (reverseCheckBox.isChecked) {
                    resultText = resultText.reversed()
                }

                    input.setText(resultText)

            }
            .setNegativeButton(R.string.cancel) { _, _ ->

            }
        return builder.create()

    }


}
