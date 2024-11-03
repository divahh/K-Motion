package com.example.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video (
    val name: String,
    val description: String,
    val photo: Int,
    val album: String,
    val releaseYear: String,
    val agency: String
): Parcelable