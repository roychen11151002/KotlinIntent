package com.example.kotlinintent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val name = intent.extras.getString("name", "Hello")
        val age = intent.extras.getInt("age", 0)
        val height = intent.extras.getDouble("height", 0.0)
        val weight = intent.extras.getDouble("weight", 0.0)
        val bmi = weight / (height * height / 10000)
        Log.d(Kotlin, "name: $name, age: $age")
        Log.d(Kotlin, "height: $height, height: $weight, BMI: $bmi")

        btnResult.setOnClickListener {
            val bundle = Bundle()
            bundle.putDouble("bmi", bmi)
            intent.putExtras(bundle)
            setResult(101, intent)
            finish()
        }
    }
}
