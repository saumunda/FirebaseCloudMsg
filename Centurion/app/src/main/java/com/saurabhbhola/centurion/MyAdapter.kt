package com.saurabhbhola.centurion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter


class MyAdapter (private val context: Context, private val myModelArrayList: ArrayList<MyModel>) : PagerAdapter()  {

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
        val title = model.title
        val image = model.image

        val linearlayout: LinearLayout = view.findViewById(R.id.linearlayout)
        val bannerIv: ImageView = view.findViewById(R.id.bannerIv)
        val ttl: TextView = view.findViewById(R.id.titleTv)


        // add data to ui vieiew


        bannerIv.setImageResource(image)
     //   bannerIv.clipToOutline
        ttl.text =title


        view.setOnClickListener {
            Toast.makeText(context, "$title ", Toast.LENGTH_SHORT).show()

        }

        container.addView(view, position)



        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}