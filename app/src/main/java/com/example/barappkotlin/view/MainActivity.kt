package com.example.barappkotlin.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.barappkotlin.MyViewPagerAdapter
import com.example.barappkotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigationViews()
    }

    private fun setupNavigationViews() {
        val adapter =
            MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(BarFragment(), "Bar")
        adapter.addFragment(MapFragment(), "Map")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}