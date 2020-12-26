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

class HomeViewModel: ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val status: LiveData<String>
        get() = _status

    private val _property = MutableLiveData<BookProperty>()

    val property: LiveData<BookProperty>
    get() = _property

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

            try {
                var listResult = getPropertiesDeferred.await()
                if (listResult.size > 0){
                    _property.value = listResult[0]
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}