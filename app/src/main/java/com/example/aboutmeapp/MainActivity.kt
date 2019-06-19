package com.example.aboutmeapp

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.aboutmeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Bramdont Garcia")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.doneBtn.setOnClickListener { addNickname(it) }

    }

    private fun addNickname(view: View){

        binding.apply {

            //nicknameTxt.text = nickNameEdtxt.text
            myName?.nickName = nickNameEdtxt.text.toString()
            invalidateAll()
            nickNameEdtxt.visibility = View.GONE
            doneBtn.visibility = View.GONE
            nicknameTxt.visibility = View.VISIBLE
        }

        //Code to hide the keyboard after we're done
        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
