package com.alfian.moviecatalog1.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alfian.moviecatalog1.ui.catalog.CatalogFragment

class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return CatalogFragment.newInstance(position + 1)
    }

}