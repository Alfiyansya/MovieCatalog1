package com.alfian.moviecatalog1.ui.main

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.alfian.moviecatalog1.R
import com.alfian.moviecatalog1.databinding.ActivityMainBinding
import com.alfian.moviecatalog1.ui.adapter.SectionPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUp()
    }
    private fun setUp(){
        val sectionPagerAdapter = SectionPagerAdapter(this@MainActivity)
        binding?.viewPager?.adapter = sectionPagerAdapter
        binding?.viewPager?.let {
            binding?.tabLayout?.let { it1 ->
                TabLayoutMediator(it1, it) { tab, position ->
                    tab.text = resources.getString(TAB_TITLES[position])
                }.attach()
            }
        }
        supportActionBar?.elevation = 0f

    }
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}