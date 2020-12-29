package xyz.divineugorji.bookexplorer.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import xyz.divineugorji.bookexplorer.network.BookProperty

class DetailViewModelFactory(
    private val bookProperty: BookProperty,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(bookProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}