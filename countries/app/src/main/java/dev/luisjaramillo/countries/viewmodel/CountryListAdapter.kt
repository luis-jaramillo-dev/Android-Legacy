package dev.luisjaramillo.countries.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.luisjaramillo.countries.R
import dev.luisjaramillo.countries.model.Country


class CountryListAdapter(var countries: ArrayList<Country>):
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries : List<Country>){
       countries.clear()
       countries.addAll(newCountries)
       notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = CountryViewHolder (
         LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
    )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bing(countries[position ])
    }

    override fun getItemCount() = countries.size


    class CountryViewHolder(view:View):RecyclerView.ViewHolder(view){
        val cuntryName by lazy { view.findViewById<TextView>(R.id.countryName) }

        fun bing(country: Country){
            cuntryName.text = country.countryName
        }
    }
}