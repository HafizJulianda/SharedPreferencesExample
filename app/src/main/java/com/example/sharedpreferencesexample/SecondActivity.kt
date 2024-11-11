package com.example.sharedpreferencesexample

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferencesexample.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLoad.setOnClickListener {
            val filename = "$packageName-${MainActivity.RPL}"
            val pref = getSharedPreferences(filename,
                Context.MODE_PRIVATE)
            val firstName = pref.getString("firstName", "")
            val lastName = pref.getString("lastName", "")
            binding.tvOutput.text = "$firstName $lastName "
        }
    }
    override fun onResume() {
        super.onResume()
        binding.tvOutput.text = "Click Button Load Data"
    }
}