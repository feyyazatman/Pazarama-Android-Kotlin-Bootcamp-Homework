package com.feyyazatman.week4_homework.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.feyyazatman.week4_homework.databinding.FragmentDetailBinding
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*


class DetailFragment : Fragment() {

    // define navArgs for get data that pass with navgraph
    private val navigationArgs: DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val daily = navigationArgs.daily
        val day = daily.dt
        newDate(day)

        // set text value to components in layout
        binding.apply {
            tvMornTemp.text = daily.temp?.morn?.toInt().toString() + "\u2103"
            tvAftTemp.text = daily.temp?.day?.toInt().toString() + "\u2103"
            tvEveTemp.text = daily.temp?.eve?.toInt().toString() + "\u2103"
            tvNightTemp.text = daily.temp?.night?.toInt().toString() + "\u2103"
            tvMornFeelTemp.text = daily.feelsLike?.morn?.toInt().toString() + "\u2103"
            tvAftFeelTemp.text = daily.feelsLike?.day?.toInt().toString() + "\u2103"
            tvEveFeelTemp.text = daily.feelsLike?.eve?.toInt().toString() + "\u2103"
            tvNightFeelTemp.text = daily.feelsLike?.night?.toInt().toString() + "\u2103"
            // define navigate method
            btnBack.setOnClickListener{
                val action = DetailFragmentDirections.actionDetailFragmentToWeatherFragment()
                findNavController().navigate(action)
            }
        }
    }

    // dt value convert to date
    fun newDate(dt : Int?)  {
        val timeStamp = dt?.let { Timestamp(it.toLong()) }
        val dateName = Date(timeStamp!!.time * 1000)
        binding.tvDay.text = SimpleDateFormat("EEEE", Locale("tr")).format(dateName)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}