package com.example.citycatalog.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.citycatalog.R
import com.example.citycatalog.adapter.ViewPagerAdapterCities
import com.example.citycatalog.model.TravelLocationModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs

class CityActivityNewYork : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var adapter: PagerAdapter
    lateinit var compositePageTransformer: CompositePageTransformer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_new_york)



        viewPager = findViewById(R.id.locationsViewPager)
        val hawaiiFab: FloatingActionButton = findViewById(R.id.nyFloatingActionButtonHawaii)
        val istanbulFab: FloatingActionButton = findViewById(R.id.nyFloatingActionButtonTR)
        val boliviaFab: FloatingActionButton = findViewById(R.id.nyFloatingActionButtonBolivia)
        val newYorkFab: FloatingActionButton = findViewById(R.id.nyFloatingActionButtonABD)
        val mainFab: FloatingActionButton = findViewById(R.id.mainFab)
        val openFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val closeFabAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        var isOpen = false

        val list = ArrayList<TravelLocationModel>()

        val card1 = TravelLocationModel(
            "New York",
            "Times Square",
            "https://imagesvc.meredithcorp.io/v3/mm/image?q=85&c=sc&poi=face&w=2000&h=1047&url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F9%2F2020%2F05%2F27%2Ftimes-square-billboards-going-dark-FT-BLOG0520.jpg",
            4.8f,
            6
        )
        val card2 = TravelLocationModel(
            "New York",
            "Empire State Building",
            "https://www.muzebiletleri.com/wp-content/uploads/2019/07/Empire-State-Binas%C4%B1-2.jpg",
            4.5f,
            7
        )
        val card3 = TravelLocationModel(
            "New York",
            "Brooklyn Bridge",
            "https://www.nuhotelbrooklyn.com/wp-content/uploads/2016/09/iStock_50554732_SMALL.jpg",
            4.9f,
            8
        )
        val card4 = TravelLocationModel(
            "New York",
            "Statue of Liberty",
            "https://www.mevzusanat.com/wp-content/uploads/2019/08/liberty-mevzusanat.jpg",
            4.4f,
            9
        )
        val card5 = TravelLocationModel(
            "New York",
            "Manhattan Bridge",
            "https://puzzlepalace.com.au/wp-content/uploads/2017/09/Manhattan-Bridge-New-York-1000-Piece-Educa-Puzzle.jpg",
            4.6f,
            10
        )
        list.add(card1)
        list.add(card2)
        list.add(card3)
        list.add(card4)
        list.add(card5)

        viewPager.adapter = ViewPagerAdapterCities(list)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.offscreenPageLimit = 3
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { view: View, fl: Float ->
            fun transformPage(page: View, position: Float) {
                val r = 1 - abs(position)
                page.scaleY = 0.95f + r * 0.05f
            }
        })

        viewPager.setPageTransformer(compositePageTransformer)

        mainFab.setOnClickListener {

            if (isOpen) {

                hawaiiFab.startAnimation(closeFabAnim)
                boliviaFab.startAnimation(closeFabAnim)
                istanbulFab.startAnimation(closeFabAnim)
                newYorkFab.startAnimation(closeFabAnim)

                isOpen = false


            } else {
                hawaiiFab.startAnimation(openFabAnim)
                boliviaFab.startAnimation(openFabAnim)
                istanbulFab.startAnimation(openFabAnim)
                newYorkFab.startAnimation(openFabAnim)

                isOpen = true

            }
        }

        newYorkFab.setOnClickListener {
            val intent = Intent(it.context, CityActivityNewYork::class.java)
            it.context.startActivity(intent)
        }
        istanbulFab.setOnClickListener {
            val intent = Intent(it.context, CityActivityIstanbul::class.java)
            it.context.startActivity(intent)
        }
        hawaiiFab.setOnClickListener {
            val intent = Intent(it.context, CityActivityHawaii::class.java)
            it.context.startActivity(intent)
        }
        boliviaFab.setOnClickListener {
            val intent = Intent(it.context, CityActivityBolivia::class.java)
            it.context.startActivity(intent)
        }
    }
}