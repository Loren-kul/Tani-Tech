package com.example.tanitechid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.example.tanitechid.databinding.ActivityPetaTanahBinding

class PetaTanahActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityPetaTanahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPetaTanahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Notifikasi saat peta siap digunakan.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Setup toolbar sebagai action bar
        setSupportActionBar(findViewById(R.id.toolbar_peta)) //  menambahkan Toolbar di XML
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Peta Jenis Tanah"
    }

    /**
     * Memanggil saat peta siap digunakan.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // --- Bagian Paling Penting: Menambahkan Overlay Gambar ---

        // 1. Tentukan batas geografis di mana gambar akan ditempatkan.
                val lampungBounds = LatLngBounds(
            LatLng(-6.65, 106.75), // Sudut Barat Daya (misalnya)
            LatLng(-6.55, 106.85)  // Sudut Timur Laut (misalnya)
        )

        // 2. Siapkan opsi untuk Ground Overlay
        val groundOverlayOptions = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.peta_tanah_lampung))
            .positionFromBounds(lampungBounds) // Posisikan gambar sesuai batas yang ditentukan
            .transparency(0.4f) // Buat sedikit transparan agar peta di bawahnya terlihat

        // 3. Tambahkan overlay ke peta
        mMap.addGroundOverlay(groundOverlayOptions)

        // 4. Arahkan kamera ke lokasi overlay dengan zoom yang sesuai
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lampungBounds.center, 12f))

        // Opsional: Tambahkan penanda untuk memperjelas
        mMap.addMarker(
            com.google.android.gms.maps.model.MarkerOptions()
                .position(lampungBounds.center)
                .title("Wilayah Lampung")
                .snippet("Peta Jenis Tanah")
        )
    }

    // Fungsi untuk handle tombol kembali di toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}