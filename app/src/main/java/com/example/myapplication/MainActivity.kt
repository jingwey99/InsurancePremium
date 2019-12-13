package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity() {


   // private lateinit var mPref : SharedPreferences

    lateinit var premiumData : PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mPref = getPreferences(Context.MODE_PRIVATE)
//        val editor : SharedPreferences.Editor = mPref.edit()
//
//        if(mPref.contains("total_premium")) {
//
//            totalPremium.text = mPref.getString("total_premium", "")
//
//        }

        premiumData = ViewModelProviders.of(this).get(PremiumModel::class.java)

        display()

       btnCalculate.setOnClickListener {

                premiumData.premiumAmount = getPremium()
           display()


       }

        btnReset.setOnClickListener {

            spinnerAge.setSelection(0)
            radGroup.clearCheck()
            checkBoxSmoker.isChecked = false
            totalPremium.text = ""

        }


    }

    fun display() {

        totalPremium.text = premiumData.premiumAmount.toString()

    }

    fun getPremium(): Double{

         return when(spinnerAge.selectedItemPosition) {

            0 -> 60.0
            1 -> 70.0 + (if(radBtnMale.isChecked) 50.00 else 0.0) + (if (checkBoxSmoker.isChecked) 100.00 else 0.0)
            2 -> 90.0 + (if(radBtnMale.isChecked) 100.00 else 0.0) + (if (checkBoxSmoker.isChecked) 150.00 else 0.0)
            3 -> 120.0 + (if(radBtnMale.isChecked) 150.00 else 0.0) + (if (checkBoxSmoker.isChecked) 200.00 else 0.0)
            4 -> 150.0 + (if(radBtnMale.isChecked) 200.00 else 0.0) + (if (checkBoxSmoker.isChecked) 250.00 else 0.0)
            else -> 150.0 + (if(radBtnMale.isChecked) 200.00 else 0.0) + (if (checkBoxSmoker.isChecked) 300.00 else 0.0)

        }


    }
}
