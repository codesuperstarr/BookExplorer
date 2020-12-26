package xyz.divineugorji.bookexplorer.network

import com.squareup.moshi.Json

class BookProperty(
    val id: String,
    @Json(name = "img_src")
    val imgSrcUrl: String,
    val type: String,
    val price: Double
)


