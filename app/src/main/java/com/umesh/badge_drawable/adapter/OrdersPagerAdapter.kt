package com.umesh.badge_drawable.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.umesh.badge_drawable.fragment.ConfirmedFragment
import com.umesh.badge_drawable.fragment.DeliveredFragment
import com.umesh.badge_drawable.fragment.PendingFragment

class OrdersPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return PendingFragment()
            1 -> return ConfirmedFragment()
            else -> return DeliveredFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}