package com.example.studyb

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Inside : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inside)
        val physics: ImageView = findViewById(R.id.imgPhysics)
        val math: ImageView = findViewById(R.id.imgMath)
        val physTv: TextView = findViewById(R.id.tvPhysics)
        val mathTv: TextView = findViewById(R.id.tvMath)
        val FirstFragment = FirstFragment()
        val PhysicsFragment = PhysicsFragment()
        val MathFragment = MathFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.Flfragment, FirstFragment)
            addToBackStack(null)
            commit()
        }
        physics.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.Flfragment, PhysicsFragment)
                addToBackStack(null)
                commit()
            }
        }

        physTv.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.Flfragment, PhysicsFragment)
                addToBackStack(null)
                commit()
            }
        }

        math.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.Flfragment, MathFragment)
                addToBackStack(null)
                commit()
            }
        }

        mathTv.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.Flfragment, MathFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}