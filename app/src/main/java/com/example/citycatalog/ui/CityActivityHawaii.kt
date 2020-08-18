package com.example.citycatalog.ui

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
import com.example.citycatalog.adapter.ViewPagerAdapterHawaii
import com.example.citycatalog.model.TravelLocationModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.math.abs

class CityActivityHawaii : AppCompatActivity() {
    lateinit var viewPager: ViewPager2
    lateinit var adapter: PagerAdapter
    lateinit var compositePageTransformer: CompositePageTransformer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_hawaii)

        viewPager = findViewById(R.id.locationsViewPager)
        val hawaiiFab : FloatingActionButton = findViewById(R.id.floatingActionButtonHawaii)
        val istanbulFab : FloatingActionButton = findViewById(R.id.floatingActionButtonTR)
        val boliviaFab : FloatingActionButton = findViewById(R.id.floatingActionButtonBolivia)
        val newYorkFab : FloatingActionButton = findViewById(R.id.floatingActionButtonABD)
        val mainFab : FloatingActionButton = findViewById(R.id.mainFab)
        val openFabAnim : Animation = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val closeFabAnim : Animation = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        var isOpen: Boolean = false

        val list = ArrayList<TravelLocationModel>()

        val card1 = TravelLocationModel(
            "Hawaii",
            "Kauai",
            "https://images.unsplash.com/photo-1505852679233-d9fd70aff56d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
            4.8f
        )
        val card2 = TravelLocationModel(
            "Hawaii",
            "Kihei",
            "https://images.unsplash.com/photo-1462400362591-9ca55235346a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1017&q=80",
            4.5f
        )
        val card3 = TravelLocationModel(
            "Hawaii",
            "Hanauma Bay Nature Preserve",
            "https://images.unsplash.com/photo-1585352141368-b7833cca7e39?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1934&q=80",
            4.9f
        )
        val card4 = TravelLocationModel(
            "Hawaii",
            "Haleakala National Park",
            "https://images.unsplash.com/photo-1469826834904-e92950ee5bf9?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1031&q=80",
            4.4f
        )
        list.add(card1)
        list.add(card2)
        list.add(card3)
        list.add(card4)

        viewPager.adapter = ViewPagerAdapterHawaii(list)
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

            if(isOpen){

                hawaiiFab.startAnimation(closeFabAnim)
                boliviaFab.startAnimation(closeFabAnim)
                istanbulFab.startAnimation(closeFabAnim)
                newYorkFab.startAnimation(closeFabAnim)

                isOpen = false


            }else{
                hawaiiFab.startAnimation(openFabAnim)
                boliviaFab.startAnimation(openFabAnim)
                istanbulFab.startAnimation(openFabAnim)
                newYorkFab.startAnimation(openFabAnim)

                isOpen = true

            }
        }

    }
}