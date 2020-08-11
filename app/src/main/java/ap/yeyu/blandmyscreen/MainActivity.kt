package ap.yeyu.blandmyscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import ap.yeyu.blandmyscreen.ui.ConfigurationEventHandlers
import ap.yeyu.blandmyscreen.ui.MainPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = MainPagerAdapter(supportFragmentManager, this)
        val configurationTab = findViewById<TabLayout>(R.id.main_tab)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        configurationTab.setupWithViewPager(viewPager)

        ConfigurationEventHandlers.initContentResolver(contentResolver)
    }
}