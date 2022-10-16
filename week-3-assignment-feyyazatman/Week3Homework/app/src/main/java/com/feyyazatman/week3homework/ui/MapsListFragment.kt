package com.feyyazatman.week3homework.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.feyyazatman.week3homework.adapter.RecyclerViewAdapter
import com.feyyazatman.week3homework.data.mapsListData
import com.feyyazatman.week3homework.databinding.FragmentMapsListBinding


class MapsListFragment : Fragment() {

    private var _binding: FragmentMapsListBinding? = null // xml ile haberlesmek icin binding kullandim.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapsListBinding.inflate(inflater,container,false) // binding inflate edildi.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    // recyclerView'i kullanmak icin olusturduğum adapter'i tanimladim. ve navigate islemi tanimladim
    private fun setupAdapter() {
        binding.rvMapsList.adapter = RecyclerViewAdapter(mapsListData) {
            val action = ItemPriceListFragmentDirections.actionItemPriceListFragmentToItemDetailFragment(it)
            this.findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}