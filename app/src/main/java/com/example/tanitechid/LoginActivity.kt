package com.example.tanitechid

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi Views dari layout XML
        val emailInput: EditText = findViewById(R.id.emailInput)
        val passwordInput: EditText = findViewById(R.id.passwordInput)
        val loginButton: Button = findViewById(R.id.loginButton)
        val signupText: TextView = findViewById(R.id.signupText)

        // Atur onClickListener untuk tombol Login
        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Validasi sisi klien sederhana
            if (email.isEmpty()) {
                emailInput.error = "Email wajib diisi"
                emailInput.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailInput.error = "Masukkan alamat email yang valid"
                emailInput.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordInput.error = "Password wajib diisi"
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) { // Contoh: minimum 6 karakter untuk password
                passwordInput.error = "Password minimal 6 karakter"
                passwordInput.requestFocus()
                return@setOnClickListener
            }

            // --- Contoh Logika Login (Ganti dengan autentikasi sesungguhnya Anda) ---
            if (email == "user@example.com" && password == "password123") {
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                // Navigasi ke aktivitas lain setelah login berhasil
                // Contoh:
                // val intent = Intent(this, HomeActivity::class.java)
                // startActivity(intent)
                // finish() // Opsional: akhiri aktivitas saat ini agar pengguna tidak bisa kembali ke layar login
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        // Atur onClickListener untuk teks "Sign up"
        signupText.setOnClickListener {
            Toast.makeText(this, "Menavigasi ke layar Pendaftaran...", Toast.LENGTH_SHORT).show()
            // Contoh: Navigasi ke SignUpActivity
            // val intent = Intent(this, SignUpActivity::class.java)
            // startActivity(intent)
        }
    }
}