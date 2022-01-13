package com.example.studyb

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.studyb.DataBaseHandler
import org.w3c.dom.Text
//import com.facebook.FacebookSdk;
//import com.facebook.appevents.AppEventsLogger;
//import com.facebook.login.widget.LoginButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forgot: TextView = findViewById(R.id.tvForgotPassword)
        val logBtn: Button = findViewById(R.id.login2)
        val faceBtn: Button = findViewById(R.id.btnFacebook)
        val pass: EditText = findViewById(R.id.password)
        val signUp: TextView = findViewById(R.id.sign_up)
        val UsernameInput: EditText = findViewById(R.id.username)
        val ORtv: TextView = findViewById(R.id.textView12)
        val VieLine: View = findViewById(R.id.view)
        val VieLine2: View = findViewById(R.id.view2)
        val VieLine3: View = findViewById(R.id.view3)
        val fbLogin: Button = findViewById(R.id.login_button)
        val DontHaveAcc: TextView = findViewById(R.id.textView10)
        // val ArabicSwitch:Switch=findViewById(R.id.switch1)


        //declare the animation
        val ttb = AnimationUtils.loadAnimation(this, R.anim.toptobottom)
        val stb = AnimationUtils.loadAnimation(this, R.anim.smalltobig)
        val btt = AnimationUtils.loadAnimation(this, R.anim.bottomtotop)

        val mainTitle: TextView = findViewById(R.id.maintextView)
        val AccInfo: TextView = findViewById(R.id.tvAccInfo)

        getSupportActionBar()?.hide()
        // set the animation
        mainTitle.startAnimation(ttb)
        AccInfo.startAnimation(ttb)
        UsernameInput.startAnimation(stb)
        pass.startAnimation(stb)
        logBtn.startAnimation(stb)
        forgot.startAnimation(stb)
        ORtv.startAnimation(btt)
        VieLine.startAnimation(btt)
        VieLine2.startAnimation(btt)
        VieLine3.startAnimation(btt)
        fbLogin.startAnimation(btt)
        DontHaveAcc.startAnimation(btt)
        signUp.startAnimation(btt)
        //ArabicSwitch.startAnimation(btt)


        signUp.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }
        val context = this

        logBtn.setOnClickListener {
            if (UsernameInput.text.toString().isNotEmpty() && pass.text.toString().isNotEmpty()) {

                var db = DataBaseHandler(context)
                var ayeshe = db.readableDatabase
                var statement: String ="SELECT pass FROM Users WHERE email= '"+ UsernameInput.text.toString() + "'"
                var currentPass = ayeshe.rawQuery(statement, null)

                currentPass.moveToNext()
//                Toast.makeText(this, currentPass.getString(0), Toast.LENGTH_LONG).show()
                if (currentPass.getString(0) == pass.text.toString()) {
                    startActivity(Intent(this, Inside::class.java))
                } else
                    Toast.makeText(this, "Wrong password, please try again", Toast.LENGTH_LONG).show()
                db.close()
            } else Toast.makeText(this, "Please enter data", Toast.LENGTH_LONG).show()
        }

        faceBtn.setOnClickListener{
            val url="facebook.com"
//            val i=Intent(this, MainActivity::class.java)
//            i.setData(Uri.parse(url))
//            startActivity(i)
        }





        forgot.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
    }
}