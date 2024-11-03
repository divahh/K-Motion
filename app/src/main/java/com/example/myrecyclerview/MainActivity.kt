package com.example.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvVideos: RecyclerView
    private val list = ArrayList<Video>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvVideos = findViewById(R.id.rv_videos)
        rvVideos.setHasFixedSize(true)

        list.addAll(getListVideos())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                // Intent ke AboutActivity saat menu About diklik
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListVideos(): ArrayList<Video> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataAlbum = resources.getStringArray(R.array.data_album)
        val dataReleaseYear = resources.getStringArray(R.array.data_release_year)
        val dataAgency = resources.getStringArray(R.array.data_agency)

        val listVideo = ArrayList<Video>()
        for (item in dataName.indices) {
            val video = Video(
                dataName[item],
                dataDescription[item],
                dataPhoto.getResourceId(item, -1),
                dataAlbum[item],
                dataReleaseYear[item],
                dataAgency[item]
            )
            listVideo.add(video)
        }
        dataPhoto.recycle()
        return listVideo
    }


    private fun showRecyclerList() {
        rvVideos.layoutManager = LinearLayoutManager(this)
        val listVideoAdapter = ListVideoAdapter(list)
        rvVideos.adapter = listVideoAdapter
    }
}
