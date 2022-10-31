package dev.luisjaramillo.countries


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dev.luisjaramillo.countries.viewmodel.CountryListAdapter
import dev.luisjaramillo.countries.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    lateinit var viewModel:ListViewModel
    private val countriesAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()
        countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                countriesAdapter.updateCountries(it)
            }
        })
        viewModel.countryLoadError.observe(this, Observer { isError ->
            isError?.let {
                countryLoadError.visibility = if(it) View.VISIBLE else View.GONE
            }
        })
    }

}