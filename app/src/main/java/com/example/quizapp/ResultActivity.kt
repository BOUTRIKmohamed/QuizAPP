package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_result.*
class ResultActivity : AppCompatActivity() {
    private var id=""
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database= FirebaseDatabase.getInstance();
        reference=database.getReference("Participants")
        setContentView(R.layout.activity_result)
        val username = intent.getStringExtra(Constants.User_Name)
        tv_Username.text = username
        val totalquestions =intent.getIntExtra(Constants.Total_questions,0)
        val correctanswers =intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        tv_Score.text = "Votre score est $correctanswers sur $totalquestions"
        btn_finish.setOnClickListener{
            reference.child(username.toString()).setValue(correctanswers)
            this.finishAffinity();
        }
    }
}