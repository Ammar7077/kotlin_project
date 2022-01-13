package com.example.studyb

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.*
import com.example.studyb.DataBaseHandler
import java.lang.Exception

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val signUpBtn:Button=findViewById(R.id.signupbtn)
        val Countryspin: Spinner = findViewById(R.id.spinner)
        var country= arrayOf("Palestine","Jordan","Lebanon","Saudi Arabia","United Arab Emirates","Syria","Egypt")
        Countryspin.adapter=ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country)

        val context=this
        //animation declaration
        val stb= AnimationUtils.loadAnimation(this, R.anim.smalltobig)

        //declare used items in animation
        val nameTxt:TextView=findViewById(R.id.textView4)
        val emailTxt:TextView=findViewById(R.id.textView8)
        val usernameTxt:TextView=findViewById(R.id.textView14)
        val passTxt:TextView=findViewById(R.id.textView13)
        val countryTxt:TextView=findViewById(R.id.textView15)
        val phoneNumberTxt:TextView=findViewById(R.id.textView9)
        //inputs
        val nameInput:EditText=findViewById(R.id.editTextTextPersonName5)
        val emailInput:EditText=findViewById(R.id.editTextTextEmailAddress)
        val usernameInput:EditText=findViewById(R.id.editTextTextPersonName6)
        val passInput:EditText=findViewById(R.id.editTextTextPassword)
        val phoneNumberInput:EditText=findViewById(R.id.editTextNumber)

        signUpBtn.setOnClickListener{
            try {
//                var user= User(nameInput.text.toString(), emailInput.text.toString(),usernameInput.text.toString(),passInput.text.toString(),
//                    null, phoneNumberInput.text.toString().toInt())

                var db= DataBaseHandler(context)
                var ayeshe = db.readableDatabase
                var sami= ContentValues()
                sami.put("name",nameInput.text.toString())
                sami.put("email",emailInput.text.toString())
                sami.put("pass",passInput.text.toString())
                sami.put("username",usernameInput.text.toString())
                sami.put("number",phoneNumberInput.text.toString())
                ayeshe.insert("Users",null,sami)
//                db.insertData(user)
                startActivity(Intent(this, MainActivity::class.java))
                Toast.makeText(context, "Success",Toast.LENGTH_LONG).show()
                db.close()
            }
            catch (e: Exception){
                Toast.makeText(context, "Failed",Toast.LENGTH_LONG).show()
            }

        }


        nameTxt.startAnimation(stb)
        emailTxt.startAnimation(stb)
        usernameTxt.startAnimation(stb)
        passTxt.startAnimation(stb)
        countryTxt.startAnimation(stb)
        phoneNumberTxt.startAnimation(stb)
        nameInput.startAnimation(stb)
        emailInput.startAnimation(stb)
        usernameInput.startAnimation(stb)
        passInput.startAnimation(stb)
        Countryspin.startAnimation(stb)
        phoneNumberInput.startAnimation(stb)
        signUpBtn.startAnimation(stb)

    }
}