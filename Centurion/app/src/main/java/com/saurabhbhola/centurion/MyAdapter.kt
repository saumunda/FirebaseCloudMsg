package com.saurabhbhola.centurion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter


class MyAdapter(private val context: FragmentActivity?, private val myModelArrayList: ArrayList<MyModel>) : PagerAdapter()  {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return myModelArrayList.size //return list of records or items
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.card_view, container, false)

        //get data
        val model = myModelArrayList[position]
        val image = model.image
        val bannerIv: ImageView = view.findViewById(R.id.bannerIv)


        // add data to ui vieiew
        bannerIv.setImageResource(image)
//        view.setOnClickListener {
//            Toast.makeText(context, "$title ", Toast.LENGTH_SHORT).show()
//
//        }
        container.addView(view, position)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}