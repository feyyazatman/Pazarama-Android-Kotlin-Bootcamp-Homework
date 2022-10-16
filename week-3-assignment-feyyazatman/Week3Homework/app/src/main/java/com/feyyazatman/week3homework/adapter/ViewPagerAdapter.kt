package com.feyyazatman.week3homework.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.feyyazatman.week3homework.ui.MapsListFragment
import com.feyyazatman.week3homework.ui.SkinListFragment
import com.feyyazatman.week3homework.ui.TextureListFragment

class ViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { SkinListFragment() }
            1 -> { TextureListFragment() }
            else -> { MapsListFragment() }
        }
    }

}