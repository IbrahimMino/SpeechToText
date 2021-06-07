package com.minoone.speechtotext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.minoone.speechtotext.fragments.SpeechtoText
import com.minoone.speechtotext.fragments.TexttoSpeech

class ViewPagerAdapter(fragmentManager : FragmentManager) : FragmentPagerAdapter(fragmentManager)  {
    val mFragmentList: MutableList<Fragment> = ArrayList<Fragment>()
    val mFragmentTitleList: MutableList<String> = ArrayList<String>()

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {
     when(position){
         0 -> {
             return TexttoSpeech()
         }
         1 -> {
               return SpeechtoText()
         }

     }
        return TexttoSpeech()
    }

    fun addFragment(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
}