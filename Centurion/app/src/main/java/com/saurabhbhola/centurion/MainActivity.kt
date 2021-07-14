package com.saurabhbhola.centurion

import Persons
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var actionBar: ActionBar
    private lateinit var myAdapter: MyAdapter
    private lateinit var recyclerAdapter: RecyclerAdapter

    private lateinit var myModelList: ArrayList<MyModel>
    var currentPage = 0
    val apiInterface = ApiInterface.create().getPerson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  val apiInterface = ApiInterface.create().getPerson()

        actionBar = this.supportActionBar!!

        loadCards()

        recyclerAdapter = RecyclerAdapter(this)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = recyclerAdapter


        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<List<Persons>>{
            override fun onResponse(call: Call<List<Persons>>?, response: Response<List<Persons>>?) {

                if(response?.body() != null)
                    recyclerAdapter.setPersonsListItems(response.body()!!)

            }

            override fun onFailure(call: Call<List<Persons>>?, t: Throwable?) {

            }
        })


        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

                val title = myModelList[position].title
                actionBar.title = title
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        }

        )

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
            MyModel(
                "First",
                    R.drawable.bannenew)
        )
        myModelList.add(
            MyModel(
            "second",
                R.drawable.bannenew))
        myModelList.add(
                MyModel(
                        "third",
                        R.drawable.bannenew))
        myModelList.add(
                MyModel(
                        "fourth",
                        R.drawable.bannenew))

        // setup adapter
        myAdapter = MyAdapter(this, myModelList)

        //set adapter to view Pager
       viewPager.adapter = myAdapter
     //   viewPager.setCurrentItem(2,true)
  //      viewPager.setCurrentItem(2);


        //set default padding
           viewPager.setPadding(100, 0, 100, 0)

    }
}