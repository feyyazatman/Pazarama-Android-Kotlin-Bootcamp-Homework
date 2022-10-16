package com.feyyazatman.week3homework.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.feyyazatman.week3homework.databinding.FragmentItemDetailBinding


class ItemDetailFragment : Fragment() {

    private val navigationArgs: ItemDetailFragmentArgs by navArgs() // gönderilen verileri almak icin safeArgs kullandim.

    private var _binding: FragmentItemDetailBinding? = null // xml ile haberlesmek icin binding kullandim.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemDetailBinding.inflate(inflater,container,false) // binding inflate edildi.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = navigationArgs.item  // arguments'daki veri degiskene atildi.
        //binding islemleri yapiliyor.
        binding.apply {
            tvItemName.text =  item.ItemName
            tvItemDescription.text = item.ItemDescription
            tvItemPrice.text = item.ItemPrice
            ivItemImage.setImageResource(item.ItemImage)
        }
        // back tusuna navigate islemi tanimladim.
        binding.btnBack.setOnClickListener {
            val action = ItemDetailFragmentDirections.actionItemDetailFragmentToItemPriceListFragment()
            this.findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}