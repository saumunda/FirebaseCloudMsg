package com.saurabhbhola.centurion.BottomFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.saurabhbhola.centurion.Fragment.FirstFragment
import com.saurabhbhola.centurion.MyModel

class MyViewPagerAdapter(fragmentManager: FragmentManager?, private val images: ArrayList<MyModel>) :
        FragmentStatePagerAdapter(fragmentManager!!) {

    // 2
    override fun getItem(position: Int): Fragment {
        return FirstFragment.newInstance(images[position])
    }

    // 3
    override fun getCount(): Int {
        return images.size
    }
}