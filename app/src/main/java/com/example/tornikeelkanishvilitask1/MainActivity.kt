package com.example.tornikeelkanishvilitask1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var emailInput: EditText
    private lateinit var recipientEmailInput: EditText
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailInput = findViewById(R.id.emailInput)
        recipientEmailInput = findViewById(R.id.recipientEmailInput)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener {
            if (validateInputs()) {
                navigateToSecond()
            }
        }
    }

    private fun validateInputs(): Boolean {
        val email = emailInput.text.toString()
        val recipientEmail = recipientEmailInput.text.toString()
        val message = messageInput.text.toString()

        if (email.isEmpty() || recipientEmail.isEmpty() || message.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!email.contains("@") || !recipientEmail.contains("@")) {
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
            return false
        }

        if (message.length > 250) {
            Toast.makeText(this, "Message cannot exceed 250 characters", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun navigateToSecond() {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("FROM_EMAIL", emailInput.text.toString())
            putExtra("TO_EMAIL", recipientEmailInput.text.toString())
            putExtra("MESSAGE", messageInput.text.toString())
        }
        startActivity(intent)
    }
}