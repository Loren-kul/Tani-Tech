package com.example.tanitechid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set layout ke activity_main.xml
        setContentView(R.layout.activity_main)


        // Inisialisasi Views yang relevan
        val search_bar: EditText = findViewById(R.id.search_bar)
        val btnCariTanaman: LinearLayout = findViewById(R.id.btn_cari_tanaman)
        val btnPanduanBertani: LinearLayout = findViewById(R.id.btn_panduan_bertani)
        val btnPetaTanah: LinearLayout = findViewById(R.id.btn_peta_tanah)
        val btnRekomendasiPupuk: LinearLayout = findViewById(R.id.btn_rekomendasi_pupuk)

        // Inisialisasi Tombol Logout yang sekarang adalah TextView
        val logoutButton: TextView = findViewById(R.id.logoutButton)




        //      searchBar.setOnEditorActionListener { v, actionId, event ->
        //     }

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
            val intent = Intent(
                this,
                RekomendasiPupukActivity::class.java
            ) // Menggunakan Activity yang sudah Anda deklarasikan
            startActivity(intent)
        }

        search_bar.setOnClickListener {
            Toast.makeText(this, "Mengaktifkan fitur pencarian...", Toast.LENGTH_SHORT).show()
            // TODO: Tambahkan Intent untuk menavigasi ke Activity Pencarian jika ada
        }


        // --- Logika untuk Search Bar dan Tombolnya ---

        // 1. Inisialisasi komponen dari layout XML
        val searchBar: EditText = findViewById(R.id.search_bar)
        val searchButton: ImageButton = findViewById(R.id.searchButton)

        // 2. Buat satu blok aksi pencarian agar tidak ada duplikasi kode
        val performSearchAction = {
            val query = searchBar.text.toString().trim()
            hideKeyboard() // Panggil fungsi untuk sembunyikan keyboard

            if (query.isNotEmpty()) {
                // Logika pencarian utama Anda di sini
                Toast.makeText(this, "Mencari: $query", Toast.LENGTH_SHORT).show()
                // TODO: Tambahkan Intent untuk pindah ke halaman hasil pencarian
            } else {
                Toast.makeText(this, "Silakan masukkan nama tanaman", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Pasang aksi pencarian ke Tombol Ikon
        searchButton.setOnClickListener {
            performSearchAction()
        }

        // 4. Pasang aksi pencarian ke Tombol "Search" di Keyboard
        searchBar.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearchAction()
                return@setOnEditorActionListener true // Aksi sudah ditangani
            }
            return@setOnEditorActionListener false //  sistem menangani aksi lain
        }
    }

    private fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}