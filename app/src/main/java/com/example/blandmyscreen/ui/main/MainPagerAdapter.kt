package com.example.blandmyscreen.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.blandmyscreen.R

class MainPagerAdapter(fragmentManager: FragmentManager, private val context: Context) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val pageTitles = arrayOf(R.string.configuration, R.string.about)

    private val fragments = arrayOf(ConfigurationFragment, AboutFragment)

    private fun instantiate(section: Int): Fragment = fragments[section]

    override fun getItem(position: Int): Fragment = instantiate(position)

    override fun getCount(): Int = pageTitles.size

    override fun getPageTitle(position: Int): CharSequence =
        context.resources.getString(pageTitles[position])
}