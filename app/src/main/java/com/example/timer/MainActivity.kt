package com.example.timer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.Stopwatch.setOnClickListener {
            startActivity(Intent(this, StopwatchActivity::class.java))
        }

        binding.Timer.setOnClickListener {
            startActivity(Intent(this, TimerActivity::class.java))
        }

        binding.Alarm.setOnClickListener {
            startActivity(Intent(this, AlarmActivity::class.java))
        }
    }
}