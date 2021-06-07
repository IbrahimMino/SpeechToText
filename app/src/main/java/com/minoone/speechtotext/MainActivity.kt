package com.minoone.speechtotext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.minoone.speechtotext.fragments.SpeechtoText
import com.minoone.speechtotext.fragments.TexttoSpeech
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
   //lateinit var apadter:ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ViewPagerAdapter(supportFragmentManager)
       adapter.addFragment(TexttoSpeech(),"Text to Speech")
       adapter.addFragment(SpeechtoText(),"Speech to Text")

       viewpager.adapter = adapter
       tablayout.setupWithViewPager(viewpager)
        setMarginOntabItems()

    }

    fun setMarginOntabItems(){
        for(i in 0 until tablayout.tabCount){
            val tabItem = (tablayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val params =   tabItem.layoutParams as ViewGroup.MarginLayoutParams
            params.setMargins(30,0,30,0)
        }
    }
}