package xyz.divineugorji.bookexplorer.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookProperty(
    val id: String,
    @Json(name = "img_src")
    val imgSrcUrl: String,
    val type: String,
    val price: Double
):Parcelable


