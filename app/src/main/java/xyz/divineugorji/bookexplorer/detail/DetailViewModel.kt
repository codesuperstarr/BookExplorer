package xyz.divineugorji.bookexplorer.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import xyz.divineugorji.bookexplorer.network.BookProperty

class DetailViewModel(bookProperty: BookProperty, application: Application) : AndroidViewModel(application) {


    private val _selectedProperty = MutableLiveData<BookProperty>()

    val selectedProperty: LiveData<BookProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = bookProperty
    }
}
