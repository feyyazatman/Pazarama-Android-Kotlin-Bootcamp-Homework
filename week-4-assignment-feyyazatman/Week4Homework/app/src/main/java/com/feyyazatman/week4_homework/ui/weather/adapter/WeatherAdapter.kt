package com.feyyazatman.week4_homework.ui.weather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.feyyazatman.week4_homework.data.model.Daily
import com.feyyazatman.week4_homework.databinding.ItemWeatherCardBinding
import com.squareup.picasso.Picasso
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt


// create adapter for recyclerview, define high-order func. for pass data to detail fragment with arguments
class WeatherAdapter(private val onItemClicked : (Daily) -> Unit) : ListAdapter<Daily, WeatherAdapter.WeatherViewHolder>(WeatherDiffUtil()) {

    class WeatherViewHolder(private val itemWeatherCardBinding: ItemWeatherCardBinding) :
        RecyclerView.ViewHolder(itemWeatherCardBinding.root) {
            fun bind(daily: Daily) {
                val date = daily.dt?.toLong()
                val icon = daily.weather?.get(0)?.icon
                val maxTemp = ((daily.temp?.max!! * 1.0).roundToInt() / 1.0).toInt().toString()
                val minTemp = ((daily.temp.min!! * 1.0).roundToInt() / 1.0).toInt().toString()

                // dt value convert to date
                fun newDate(dt : Long) {
                    val timeStamp = date?.let { Timestamp(dt) }
                    val dateName = Date(timeStamp!!.time * 1000)
                    itemWeatherCardBinding.tvName.text = SimpleDateFormat("EEEE", Locale("tr")).format(dateName)
                }

                itemWeatherCardBinding.apply {
                    date?.let { newDate(it) }
                    tvTempMax.text = "$maxTemp \u2103"  // u2103 is centigrade symbol
                    tvTempMin.text = "$minTemp \u2103"
                    Picasso.get().load("https://openweathermap.org/img/wn/${icon}@2x.png").into(ivWeather)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemWeatherCardBinding = ItemWeatherCardBinding.inflate(LayoutInflater.from(parent.context))
        return WeatherViewHolder(itemWeatherCardBinding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener { onItemClicked(item) }
        holder.bind(item)
    }


    class WeatherDiffUtil : DiffUtil.ItemCallback<Daily>() {
        override fun areItemsTheSame(oldItem: Daily, newItem: Daily): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Daily, newItem: Daily): Boolean {
            return oldItem == newItem
        }

    }


}