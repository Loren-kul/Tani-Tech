package com.example.tanitechid

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set layout ke activity_main.xml yang sudah Anda berikan
        setContentView(R.layout.activity_main)

        // Inisialisasi Views yang relevan
        val searchBar: EditText = findViewById(R.id.search_bar)
        val btnCariTanaman: LinearLayout = findViewById(R.id.btn_cari_tanaman)
        val btnPanduanBertani: LinearLayout = findViewById(R.id.btn_panduan_bertani)
        val btnPetaTanah: LinearLayout = findViewById(R.id.btn_peta_tanah)
        val btnRekomendasiPupuk: LinearLayout = findViewById(R.id.btn_rekomendasi_pupuk)
        // Inisialisasi Tombol Logout yang sekarang adalah TextView
        val logoutButton: TextView = findViewById(R.id.logoutButton)
        logoutButton.setOnClickListener {
            Toast.makeText(this, "Logout berhasil!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        // --- Contoh Penanganan Klik untuk Tombol-tombol di GridLayout ---

        btnCariTanaman.setOnClickListener {
            Toast.makeText(this, "Membuka Cari Tanaman", Toast.LENGTH_SHORT).show()
            // TODO: Tambahkan Intent untuk menavigasi ke Activity Cari Tanaman Anda
            // val intent = Intent(this, CariTanamanActivity::class.java)
            // startActivity(intent)
        }

        btnPanduanBertani.setOnClickListener {
            Toast.makeText(this, "Membuka Panduan Bertani", Toast.LENGTH_SHORT).show()
            // TODO: Tambahkan Intent untuk menavigasi ke Activity Panduan Bertani Anda
            // val intent = Intent(this, PanduanBertaniActivity::class.java)
            // startActivity(intent)
        }

        btnPetaTanah.setOnClickListener {
            Toast.makeText(this, "Membuka Peta Jenis Tanah", Toast.LENGTH_SHORT).show()
            // TODO: Tambahkan Intent untuk menavigasi ke Activity Peta Jenis Tanah Anda
            // val intent = Intent(this, PetaJenisTanahActivity::class.java)
            // startActivity(intent)
        }

        btnRekomendasiPupuk.setOnClickListener {
            Toast.makeText(this, "Membuka Rekomendasi Pupuk", Toast.LENGTH_SHORT).show()
            // TODO: Aktifkan navigasi ke RekomendasiPupukActivity jika sudah ada
            val intent = Intent(this, RekomendasiPupukActivity::class.java) // Menggunakan Activity yang sudah Anda deklarasikan
            startActivity(intent)
        }

        searchBar.setOnClickListener {
            Toast.makeText(this, "Mengaktifkan fitur pencarian...", Toast.LENGTH_SHORT).show()
            // TODO: Tambahkan Intent untuk menavigasi ke Activity Pencarian jika ada
        }

        // --- Tambahkan Tombol Logout (opsional, jika Anda menginginkan tombol fisik) ---
        // Jika Anda ingin tombol Logout di MainActivity, Anda harus menambahkannya di activity_main.xml
        // Misalnya di bawah tips_container:
        // <Button
        //     android:id="@+id/logoutButton"
        //     android:layout_width="wrap_content"
        //     android:layout_height="wrap_content"
        //     android:text="Logout"
        //     app:layout_constraintTop_toBottomOf="@id/tips_container"
        //     app:layout_constraintStart_toStartOf="parent"
        //     app:layout_constraintEnd_toEndOf="parent"
        //     android:layout_marginTop="24dp" />
        //
        // Jika sudah ada, inisialisasi di sini:
        // val logoutButton: Button = findViewById(R.id.logoutButton)
        // logoutButton.setOnClickListener {
        //     Toast.makeText(this, "Logout berhasil!", Toast.LENGTH_SHORT).show()
        //     val intent = Intent(this, LoginActivity::class.java)
        //     intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        //     startActivity(intent)
        //     finish()
        // }
    }
}
