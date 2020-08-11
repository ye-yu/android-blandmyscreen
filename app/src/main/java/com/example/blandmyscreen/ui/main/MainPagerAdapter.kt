package com.example.blandmyscreen.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.blandmyscreen.R

class MainPagerAdapter(fragmentManager: FragmentManager, private val context: Context) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val pageTitles = arrayOf(
        R.string.configuration,
        R.string.about
    )

    private fun instantiate(section: Int): Fragment {
        return when (section) {
            0 -> ConfigurationFragment()
            1 -> AboutFragment()
            else -> throw IndexOutOfBoundsException("There are only ${pageTitles.size} pages!")
        }
    }

    override fun getItem(position: Int): Fragment {
        return instantiate(position)
    }

    override fun getCount(): Int {
        return pageTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(pageTitles[position])
    }
}