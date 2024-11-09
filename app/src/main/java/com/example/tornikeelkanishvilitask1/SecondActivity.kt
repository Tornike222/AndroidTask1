package com.example.tornikeelkanishvilitask1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    private lateinit var fromEmailText: TextView
    private lateinit var toEmailText: TextView
    private lateinit var messageText: TextView
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        fromEmailText = findViewById(R.id.fromEmailText)
        toEmailText = findViewById(R.id.toEmailText)
        messageText = findViewById(R.id.messageText)
        clearButton = findViewById(R.id.clearButton)

        // Get data from intent
        val fromEmail = intent.getStringExtra("FROM_EMAIL") ?: ""
        val toEmail = intent.getStringExtra("TO_EMAIL") ?: ""
        val message = intent.getStringExtra("MESSAGE") ?: ""

        // Set the text
        fromEmailText.text = fromEmail
        toEmailText.text = toEmail
        messageText.text = message

        clearButton.setOnClickListener {
            clearFields()
        }
    }

    private fun clearFields() {
        messageText.text = ""
        toEmailText.text = ""
        Toast.makeText(this, "cleared successfully", Toast.LENGTH_SHORT).show()
    }
}