package com.bitingbit.news.mobileapp.main

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.bitingbit.news.mobileapp.R
import com.bitingbit.news.mobileapp.adapters.MyFragmentPagerAdapter
import com.bitingbit.news.mobileapp.fragments.UserProfileFragment
import com.bitingbit.news.mobileapp.fragments.NewsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupViewPager()
    }

    private fun initViews() {
        tabs = findViewById(R.id.tabs)
        viewpager = findViewById(R.id.view_pager)
    }

    private fun setupViewPager() {

        val adapter = MyFragmentPagerAdapter(getSupportFragmentManager())


        initViews()

        var firstFragmet: NewsFragment = NewsFragment.newInstance("Profile \nFirst name: Max \nSurname: Musterman \nEmail: max@gmail.com")
        var secondFragmet: UserProfileFragment = UserProfileFragment.newInstance("<h2>Profile</h2>" +
                "<p><b>First Name:</b><pre>&nbsp;John</pre></p>" +
                "<p><b>Surname:</b><pre>Snow</pre></p>" +
                "<p><b>Email:</b><pre>freezinginthenorth@gmail.com</pre></p>"
        )

        adapter.addFragment(firstFragmet, "News")
        adapter.addFragment(secondFragmet, "Profile")

        viewpager!!.adapter = adapter

        tabs!!.setupWithViewPager(viewpager)

    }
}
