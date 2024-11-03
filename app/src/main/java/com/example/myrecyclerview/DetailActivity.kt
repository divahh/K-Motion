package com.example.myrecyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailName: TextView = findViewById(R.id.tvDetailName)
        val tvDetailDescription: TextView = findViewById(R.id.tvDetailDescription)
        val imgDetailPhoto: ImageView = findViewById(R.id.imgDetailPhoto)
        val tvAlbum: TextView = findViewById(R.id.tvAlbum)
        val tvReleaseYear: TextView = findViewById(R.id.tvReleaseYear)
        val tvAgency: TextView = findViewById(R.id.tvAgency)

        val videoName = intent.getStringExtra("VIDEO_NAME")
        val videoDescription = intent.getStringExtra("VIDEO_DESCRIPTION")
        val videoPhoto = intent.getIntExtra("VIDEO_PHOTO", 0)
        val videoAlbum = intent.getStringExtra("VIDEO_ALBUM")
        val videoReleaseYear = intent.getStringExtra("VIDEO_RELEASE_YEAR")
        val videoAgency = intent.getStringExtra("VIDEO_AGENCY")

        tvDetailName.text = videoName
        tvDetailDescription.text = videoDescription
        imgDetailPhoto.setImageResource(videoPhoto)
        tvAlbum.text = "Album: $videoAlbum"
        tvReleaseYear.text = "Tahun Rilis: $videoReleaseYear"
        tvAgency.text = "Agency: $videoAgency"

        supportActionBar?.title = "Detail"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
