package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.clickForConclusion.setOnClickListener {
            callCalc()
        }

    }
   private fun calculateBill(units: Int): Int {

        if (units <= 100) {
            return units * 5
        }
        else if (units >= 101 && units<=500) {
            return (100 * 5 + (units - 100) * 8)
        }
        else if (units > 500) {
            return (100 * 5 + 100 * 8 + ((units - 200)* 10))
        }

        return 0
    }
    private fun callCalc(){
        val units=binding.entryAmount.text.toString().toInt()
        if (units!=null){
            binding.conclusion.text="Sonuç:${calculateBill(units)}"
        }


    }
}