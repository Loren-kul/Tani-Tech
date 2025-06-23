package com.example.tanitechid

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set layout untuk Activity ini
        setContentView(R.layout.activity_sign_up)

        // Inisialisasi Views dari layout XML
        val nameInput: EditText = findViewById(R.id.nameInput)
        val emailSignUpInput: EditText = findViewById(R.id.emailSignUpInput)
        val passwordSignUpInput: EditText = findViewById(R.id.passwordSignUpInput)
        val confirmPasswordInput: EditText = findViewById(R.id.confirmPasswordInput)
        val signUpButton: Button = findViewById(R.id.signUpButton)
        val backToLoginText: TextView = findViewById(R.id.backToLoginText)

        // Atur onClickListener untuk tombol Daftar
        signUpButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val email = emailSignUpInput.text.toString().trim()
            val password = passwordSignUpInput.text.toString().trim()
            val confirmPassword = confirmPasswordInput.text.toString().trim()

            // Validasi sisi klien
            if (name.isEmpty()) {
                nameInput.error = "Nama wajib diisi"
                nameInput.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                emailSignUpInput.error = "Email wajib diisi"
                emailSignUpInput.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailSignUpInput.error = "Masukkan alamat email yang valid"
                emailSignUpInput.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordSignUpInput.error = "Password wajib diisi"
                passwordSignUpInput.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) {
                passwordSignUpInput.error = "Password minimal 6 karakter"
                passwordSignUpInput.requestFocus()
                return@setOnClickListener
            }

            if (confirmPassword.isEmpty()) {
                confirmPasswordInput.error = "Konfirmasi password wajib diisi"
                confirmPasswordInput.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                confirmPasswordInput.error = "Password tidak cocok"
                confirmPasswordInput.requestFocus()
                return@setOnClickListener
            }

            // --- Contoh Logika Pendaftaran  ---
            // Mengirim data pendaftaran ke server atau database
            Toast.makeText(this, "Pendaftaran berhasil! (Contoh)", Toast.LENGTH_LONG).show()

            // Setelah pendaftaran berhasil, arahkan kembali ke LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Opsional: akhiri SignUpActivity agar pengguna tidak bisa kembali
        }

        // Atur onClickListener untuk teks "Sudah punya akun? Login"
        backToLoginText.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // Opsional: akhiri SignUpActivity
        }
    }
}