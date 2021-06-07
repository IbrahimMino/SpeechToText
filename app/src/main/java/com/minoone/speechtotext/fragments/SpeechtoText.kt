package com.minoone.speechtotext.fragments

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.minoone.speechtotext.R
import java.util.*


class SpeechtoText : Fragment() {
  private val REQUEST_CODE_SPEECH_INPUT = 100
    lateinit var voice_text: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_speechto_text, container, false)

          voice_text = view.findViewById<TextView>(R.id.tv_voice)
        val btn_voice = view.findViewById<Button>(R.id.btn_voice)

        btn_voice.setOnClickListener {
            SpeechFunction()
        }




        return view
    }

    fun SpeechFunction(){
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Say something...")
        try {
            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT)
        }catch(ex: ActivityNotFoundException){
            Toast.makeText(requireContext(), "Speech Not Supported", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if(requestCode == REQUEST_CODE_SPEECH_INPUT){
            if(resultCode == RESULT_OK || null != data ){
                val res: ArrayList<String> = data!!.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)!!
                voice_text.text = res[0]!!

            }


        }
    }


















}


