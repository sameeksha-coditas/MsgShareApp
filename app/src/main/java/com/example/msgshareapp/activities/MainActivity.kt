package com.example.msgshareapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.AppConstants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        //  val btnShowToast=findViewById(R.id.btnShowToast) as Button
        btnShowToast.setOnClickListener {
            showToast("You clicked me.")
            // Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

        // val btnSendMsgToNextActivity=findViewById(R.id.btnSendMsgToNextActivity) as Button
        btnSendMsgToNextActivity.setOnClickListener {


            //val etUserMessage=findViewById(R.id.etUserMessage) as EditText
            val message: String = etUserMessage.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(AppConstants.USER_MSG_KEY, message)
            startActivity(intent)

        }

        //val btnShareToOtherApps=findViewById(R.id.btnShareToOtherApps) as Button
        btnShareToOtherApps.setOnClickListener {
            val etUserMessage = findViewById<EditText>(R.id.etUserMessage)
            val message: String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to :"))
        }
        // val btnRecyclerViewDemo=findViewById(R.id.btnRecyclerViewDemo) as Button
        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }

    }
}
