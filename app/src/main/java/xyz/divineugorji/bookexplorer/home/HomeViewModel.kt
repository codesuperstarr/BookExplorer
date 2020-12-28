package xyz.divineugorji.bookexplorer.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.divineugorji.bookexplorer.network.BookApi
import xyz.divineugorji.bookexplorer.network.BookProperty
enum class BookApiStatus{ERROR, LOADING, DONE}

class HomeViewModel: ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<BookApiStatus>()

    // The external immutable LiveData for the request status String
    val status: LiveData<BookApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<BookProperty>>()

    val properties: LiveData<List<BookProperty>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<BookProperty>()

    val navigateToSelectedProperty: LiveData<BookProperty>
        get() = _navigateToSelectedProperty

    //Craete a Coroutine scope for the
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getBookProperties()
    }

    private fun getBookProperties() {
        coroutineScope.launch {
            var getPropertiesDeferred = BookApi.retrofitService.getProperties()

            _status.value = BookApiStatus.LOADING
            try {
                // this will run on a thread managed by Retrofit
                val listResult = getPropertiesDeferred.await()

                _status.value = BookApiStatus.DONE
                _properties.value = listResult

                
            } catch (e: Exception) {
                _status.value = BookApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPropertyDetails(marsProperty: BookProperty) {
        _navigateToSelectedProperty.value = marsProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}