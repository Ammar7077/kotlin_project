package com.example.studyb

import android.content.ContentValues
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.*
import com.example.studyb.DataBaseHandler
import org.w3c.dom.Text

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        val btn:Button=findViewById(R.id.loginn)
        val UserName:EditText= findViewById(R.id.username)
        val newPassword:EditText= findViewById(R.id.newpass)
        val Image:ImageView=findViewById(R.id.imageView2)
        val txtView:TextView=findViewById(R.id.textView2)
        val txtView2:TextView=findViewById(R.id.textView3)

        //declare animation
        val ttb= AnimationUtils.loadAnimation(this, R.anim.toptobottom)

        //setting the animation
        Image.startAnimation(ttb)
        txtView.startAnimation(ttb)
        txtView2.startAnimation(ttb)
        UserName.startAnimation(ttb)
        btn.startAnimation(ttb)
        var context=this
        btn.setOnClickListener{
            try {
//                var user= User(nameInput.text.toString(), emailInput.text.toString(),usernameInput.text.toString(),passInput.text.toString(),
//                    null, phoneNumberInput.text.toString().toInt())

                var db= DataBaseHandler(context)
                var ayeshe = db.readableDatabase
                var sami= ContentValues()
                sami.put("pass",newPassword.text.toString())
                ayeshe.update("Users", sami, "email= '"+UserName.text.toString()+"'",null)

                Toast.makeText(this, "Ur password has been reset",Toast.LENGTH_LONG).show()
                startActivity(Intent(this@ForgotPasswordActivity, MainActivity::class.java))

                db.close()
            }
            catch (e: java.lang.Exception){
                Toast.makeText(context, "Failed",Toast.LENGTH_LONG).show()
            }

        }
    }
}





//updateButton.setOnClickListener {
//    try {
//        if(name.text.toString() != "" && city != "" && season != "" && nature != "" && entry.text.toString() != ""){
//            var row = ContentValues()
//            row.put("Name", name.text.toString())
//            row.put("City", city)
//            row.put("Season", season)
//            row.put("Nature", nature)
//            row.put("Entry", entry.text.toString().toInt())
//
//            val helper = Database(applicationContext)
//            val db = helper.readableDatabase
//
//
//            db.update("places", row,"id = ${placeId.text.toString().toInt()}",null)
//
//
//            db.close()
//            helper.close()
//            this.finish()
//        }
//        else{
//            Toast.makeText(this,"All fields must be filled", Toast.LENGTH_SHORT).show()
//        }
//    }
//    catch (e:Exception){
//        Toast.ma
