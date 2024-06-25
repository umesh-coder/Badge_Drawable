package com.umesh.badge_drawable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.umesh.badge_drawable.adapter.OrdersPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager);
        viewPager.adapter = OrdersPagerAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Pending"
                    tab.setIcon(ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_pending))
                    val BadgeDrawable = tab.orCreateBadge
                    BadgeDrawable.isVisible = true
                    BadgeDrawable.backgroundColor =
                        ContextCompat.getColor(this@MainActivity, R.color.badgeColor)
                }

                1 -> {
                    tab.text = "Confirmed"
                    tab.setIcon(
                        ContextCompat.getDrawable(
                            this@MainActivity,
                            R.drawable.ic_confirmed
                        )
                    )

                    val BadgeDrawable = tab.orCreateBadge
                    BadgeDrawable.number = 1
                    BadgeDrawable.isVisible = true
                    BadgeDrawable.backgroundColor =
                        ContextCompat.getColor(this@MainActivity, R.color.badgeColor)
                }

                else -> {
                    tab.text = "Delivered"
                    tab.setIcon(
                        ContextCompat.getDrawable(
                            this@MainActivity,
                            R.drawable.ic_delivered
                        )
                    )
                    val BadgeDrawable = tab.orCreateBadge
                    BadgeDrawable.number = 10
                    BadgeDrawable.isVisible = true
                    BadgeDrawable.backgroundColor =
                        ContextCompat.getColor(this@MainActivity, R.color.badgeColor)
                }

            }
        }.attach()

    }


}
