package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestion : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition:Int = 1
    private var mQuestionsList : ArrayList<Question> ? =null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUsername:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        mUsername =intent.getStringExtra(Constants.User_Name)
        mQuestionsList = Constants.getQuestions()
        setQuestions()
        btn_ans1.setOnClickListener(this)
        btn_ans2.setOnClickListener(this)
        btn_ans3.setOnClickListener(this)
        btn_ans4.setOnClickListener(this)
        btn_cfrm.setOnClickListener(this)
    }
    private fun setQuestions(){
        val question = mQuestionsList!![mCurrentPosition-1]
        defaultOptionsView()
        if(mCurrentPosition == mQuestionsList!!.size) {
            btn_cfrm.text = "FIN"
        }else{
            btn_cfrm.text ="Question suivante"
        }
        ProgressBar.progress =mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + ProgressBar.max
        tv_question.text = question!!.question
        btn_ans1.text   = question.optionone
        btn_ans2.text   = question.optiontwo
        btn_ans3.text   = question.optionthree
        btn_ans4.text   = question.optionfour
    }
    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,btn_ans1)
        options.add(1,btn_ans2)
        options.add(2,btn_ans3)
        options.add(3,btn_ans4)
        for (option in options){
            option.setTextColor(Color.parseColor("#FFFFFF"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.custom_button
            )

        }

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_ans1 ->{
                selectedOptionView(btn_ans1,1)
            }
            R.id.btn_ans2 ->{
                selectedOptionView(btn_ans2,2)
            }
            R.id.btn_ans3 ->{
                selectedOptionView(btn_ans3,3)
            }
            R.id.btn_ans4 ->{
                selectedOptionView(btn_ans4,4)
            }
            R.id.btn_cfrm ->{
                btn_ans1.setEnabled(false)
                btn_ans2.setEnabled(false)
                btn_ans4.setEnabled(false)
                btn_ans3.setEnabled(false)
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestions()
                            btn_ans1.setEnabled(true)
                            btn_ans2.setEnabled(true)
                            btn_ans4.setEnabled(true)
                            btn_ans3.setEnabled(true)
                            btn_cfrm.text= "Questions suivante"
                        }else ->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.User_Name,mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.Total_questions,mQuestionsList!!.size)
                            startActivity(intent)
                        }

                    }
                }else {
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctanswer != mSelectedOptionPosition){
                        answerview(mSelectedOptionPosition ,R.drawable.wrong)
                    }else{
                        mCorrectAnswers++
                    }
                    answerview(question.correctanswer, R.drawable.correct)
                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btn_cfrm.text = "FIN"
                    }else{
                        btn_cfrm.text= "Question suivante"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }

    }
    private fun answerview(answer:Int,drawbleView:Int){
        when(answer){
            1->{
                btn_ans1.background = ContextCompat.getDrawable(this,drawbleView)
            }
            2->{
                btn_ans2.background = ContextCompat.getDrawable(this,drawbleView)
            }
            3->{
                btn_ans3.background = ContextCompat.getDrawable(this,drawbleView)
            }
            4->{
                btn_ans4.background = ContextCompat.getDrawable(this,drawbleView)
            }

        }

    }
    private fun selectedOptionView(button: Button,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        button.setTextColor(Color.parseColor("#8F8E8E"))
        button.setTypeface (button.typeface,Typeface.BOLD)
        button.background = ContextCompat.getDrawable(
            this, R.drawable.selectbtn)
        btn_cfrm.text= "Confirmer"

    }
}