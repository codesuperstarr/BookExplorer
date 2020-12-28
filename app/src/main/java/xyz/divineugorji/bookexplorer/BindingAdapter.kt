package xyz.divineugorji.bookexplorer

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import xyz.divineugorji.bookexplorer.home.BookApiStatus
import xyz.divineugorji.bookexplorer.home.HomeGridAdapter
import xyz.divineugorji.bookexplorer.home.HomeViewModel
import xyz.divineugorji.bookexplorer.network.BookProperty

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<BookProperty>?) {
    val adapter = recyclerView.adapter as HomeGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
                .apply(RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image))
            .into(imgView)

    }
}

@BindingAdapter("bookApiStatus")
fun bindStatus(statusImageView: ImageView, status:BookApiStatus?) {
    when (status) {
        BookApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        BookApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        BookApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}