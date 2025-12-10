package com.example.wishem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home_Screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)



        replaceFragment(HomeFragment())

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home     -> replaceFragment(HomeFragment())
                R.id.navigation_calendar -> replaceFragment(CalendarFragment())
                R.id.navigation_add      -> replaceFragment(AddFragment())
                R.id.navigation_manage   -> replaceFragment(ManageFragment())
                R.id.navigation_profile  -> replaceFragment(ProfileFragment())
                else -> false
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
        return true
    }

}
