package com.example.msgshareapp.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.AppConstants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString(AppConstants.USER_MSG_KEY)
        if (msg != null) {
            showToast(msg)
        }
        // Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        val txvUserMessage = findViewById<TextView>(R.id.txvUserMessage)
        txvUserMessage.text = msg
    }


    //var txvUserMessage: TextView? = findViewById<TextView>(R.id.txvUserMessage) as TextView


}