package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_start.setOnClickListener {
            if (et_name.text.toString().isEmpty()){
                Toast.makeText(this,
                "saisissez votre nom " ,Toast.LENGTH_SHORT).show()

            }else{
                val intent = Intent(this, QuizQuestion::class.java)
                intent.putExtra(Constants.User_Name,et_name.text.toString())
                startActivity(intent)
                finish()

            }

        }
    }
}