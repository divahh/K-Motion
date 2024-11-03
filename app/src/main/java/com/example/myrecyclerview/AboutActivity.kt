package com.example.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = "About Me"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Button untuk Share
        val btnShare: Button = findViewById(R.id.action_share)
        btnShare.setOnClickListener {
            shareProfileInfo()
        }
    }

    // Fungsi untuk menampilkan intent share
    private fun shareProfileInfo() {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Tentang Saya")
            putExtra(
                Intent.EXTRA_TEXT,
                """
                    Nama: Diva Halimah Hasan
                    Email: divahalimahh@gmail.com
                    
                    Saya sedang mengembangkan aplikasi 'My K-Motion' yang bertujuan untuk mendata video-video cover dance favorit yang telah saya cover.
                    
                    Path di Bangkit:
                    - Cloud Computing Path (2023)
                    - Mobile Development Path (2024, ongoing)
                """.trimIndent()
            )
        }

        // Memulai activity untuk share dengan intent chooser
        startActivity(Intent.createChooser(shareIntent, "Bagikan profil melalui"))
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
