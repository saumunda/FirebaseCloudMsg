package com.saurabhbhola.centurion.BottomFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.saurabhbhola.centurion.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first_bottom.*
import kotlinx.android.synthetic.main.fragment_first_bottom.viewPager
import kotlinx.android.synthetic.main.activity_main.tab_layout as tab_layout1
import kotlinx.android.synthetic.main.fragment_first_bottom.viewPager2 as viewPager21


class FirstFragment : Fragment() {


    private lateinit var myAdapter: MyAdapter
    private lateinit var myModelList: ArrayList<MyModel>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_bottom, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       loadCard()

        loadCards2()

    }

    private fun loadCards2() {
        val adapter = ViewpagerAdapter(childFragmentManager, lifecycle)

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

    private fun loadCard() {
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
        myAdapter = MyAdapter(activity, myModelList)

        //set adapter to view Pager
        viewPager.adapter = myAdapter


        //set default padding
        viewPager.setPadding(100, 0, 100, 0)


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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
 }




}


