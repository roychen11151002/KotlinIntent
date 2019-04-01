package com.example.kotlinintent

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

const val Kotlin = "kotlinTest"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOrder.setOnClickListener {
            val orderIt = Intent(this, OrderActivity::class.java)
            val bundle = Bundle()
            bundle.putString("name", "Roychen")
            bundle.putInt("age", 48)
            bundle.putDouble("height", 171.5)
            bundle.putDouble("weight", 72.5)
            orderIt.putExtras(bundle)
            startActivityForResult(orderIt, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d(Kotlin, "requestCode: $requestCode, resultCode: $resultCode")
        if(resultCode == 101) {
            val bmi = data!!.extras.getDouble("bmi", 0.0)
            Log.d(Kotlin, "My BMI: $bmi")
        }
    }
}
