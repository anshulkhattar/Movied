package com.example.movied.adapters


import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movied.fragments.TopRatedFragment
import com.example.movied.fragments.UpcomingFragment

class TabAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return TopRatedFragment()
            }
            1 -> {
                return UpcomingFragment()
            }
        }
        return TopRatedFragment()
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}
