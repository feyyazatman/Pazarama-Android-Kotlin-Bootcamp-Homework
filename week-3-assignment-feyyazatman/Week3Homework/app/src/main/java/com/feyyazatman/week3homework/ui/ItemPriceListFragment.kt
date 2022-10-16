package com.feyyazatman.week3homework.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.feyyazatman.week3homework.adapter.ViewPagerAdapter
import com.feyyazatman.week3homework.databinding.FragmentItemPriceListBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_item_price_list.*


class ItemPriceListFragment : Fragment() {

    private var _binding: FragmentItemPriceListBinding? = null // xml ile haberlesmek icin binding kullandim.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemPriceListBinding.inflate(inflater,container,false) // binding inflate edildi.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // viewPager kullanmak icin olusturduğum adapter'i tanimladim.
        val adapter = ViewPagerAdapter(parentFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter

        // tabLayout ile viewPager gecislerini görsellestirdim.
        TabLayoutMediator(tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Skin"
                }
                1 -> {
                    tab.text = "Texture"
                }
                2 -> {
                    tab.text = "Maps"
                }
            }
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}