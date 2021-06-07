package com.minoone.speechtotext.fragments

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.minoone.speechtotext.R
import java.util.*

class TexttoSpeech : Fragment(),TextToSpeech.OnInitListener{
    lateinit var textToSpeech: TextToSpeech
    lateinit var edt_text: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_textto_speech, container, false)
        edt_text = view.findViewById<EditText>(R.id.edt_speak)
        val btn = view.findViewById< Button>(R.id.btn_speak)
        textToSpeech = TextToSpeech(requireContext(),this)



        btn.setOnClickListener {
              if(edt_text.text.isNotEmpty()) {
                 convertToInterVoice()
              }
        }


        return view
    }
  fun convertToInterVoice(){

       val text2 = edt_text.text.toString()
      textToSpeech.speak(text2,TextToSpeech.QUEUE_FLUSH,null)
  }


    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            val res: Int = textToSpeech.setLanguage(Locale.US)
            if(res == TextToSpeech.LANG_MISSING_DATA || res == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(requireContext(), "Something is wrong", Toast.LENGTH_SHORT).show()
            }else{
                convertToInterVoice()

            }
        }
    }

    override fun onDestroy() {
            textToSpeech.stop()
            textToSpeech.shutdown()

        super.onDestroy()



    }


}