package com.saurabhbhola.centurion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: MyAdapter
    private lateinit var myModelList: ArrayList<MyModel>
    var adapter = ViewpagerAdapter(supportFragmentManager, lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            loadCards()
        loadCards2()
       viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        }

        )


    }



    private fun loadCards2() {

        viewPager2.adapter = adapter
        TabLayoutMediator(tab_layout, viewPager2, object : TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                when(position){
                    0->{
                     tab.text="Live"
                    }
                    1->{
                        tab.text="Upcoming"
                    }
                    2->{
                        tab.text="Results"

                    }
                }
            }

        }).attach()

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    private fun loadCards() {
        //init list
        myModelList = ArrayList()

        //add items to the list
        myModelList.add(
            MyModel(R.drawable.bannenew)
        )
        myModelList.add(
            MyModel(R.drawable.bannenew))
        myModelList.add(
                MyModel(R.drawable.bannenew))
        myModelList.add(
                MyModel(R.drawable.bannenew))

        // setup adapter
        myAdapter = MyAdapter(this, myModelList)

        //set adapter to view Pager
       viewPager.adapter = myAdapter


        //set default padding
           viewPager.setPadding(100, 0, 100, 0)

    }

}