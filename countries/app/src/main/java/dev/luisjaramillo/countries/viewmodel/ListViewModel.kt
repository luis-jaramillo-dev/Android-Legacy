package dev.luisjaramillo.countries.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.luisjaramillo.countries.model.Country

/**
 * This class looks like a state machine
 */
class ListViewModel : ViewModel() {

    // this variable does know who is subscribed or who is going to be notify
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading  = MutableLiveData<Boolean>()

    fun refresh(){
        fetchCountries()
    }

    private fun fetchCountries(){

        val mockData = listOf<Country>(
            Country("Argentina"),
            Country("Bolivia"),
            Country("Colombia"),
            Country("Chile"),
            Country("Peru"),
            Country("Uruguay"),
            Country("Paraguay"),
            Country("Venezuela")
        )

        loading.value= false
        countryLoadError.value = false
        countries.value = mockData

    }

}
