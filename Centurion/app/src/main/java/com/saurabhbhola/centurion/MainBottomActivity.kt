package com.saurabhbhola.centurion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.saurabhbhola.centurion.BottomFragments.FirstFragment
import com.saurabhbhola.centurion.BottomFragments.FourthFragment
import com.saurabhbhola.centurion.BottomFragments.SecondFragment
import com.saurabhbhola.centurion.BottomFragments.ThirdFragment
import kotlinx.android.synthetic.main.activity_main_bottom.*

class MainBottomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_bottom)

        if (savedInstanceState == null) {
            val fragment = FirstFragment()
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                .commit()


        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)





    }
    val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {
            R.id.Edit1 -> {

                // Respond to navigation item 1 click
                val fragment1 = FirstFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment1, fragment1.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true


            }
            R.id.Edit2 -> {
                // Respond to navigation item 2 click
                val fragment2 = SecondFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment2, fragment2.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.Edit3 -> {
                // Respond to navigation item 2 click
                val fragment3 = ThirdFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment3, fragment3.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.Edit4 -> {
                // Respond to navigation item 2 click
                val fragment4 = FourthFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment4, fragment4.javaClass.getSimpleName())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            else -> false
        }
    }
}