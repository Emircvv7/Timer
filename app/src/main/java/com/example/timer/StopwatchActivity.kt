package com.example.timer

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.timer.databinding.ActivityStopwatchBinding

class StopwatchActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityStopwatchBinding.inflate(layoutInflater)
    }
    private var startTime = 0L
    private var handler = Handler()
    private var runnable = object : Runnable {
        override fun run() {
            val elapsedTime = System.currentTimeMillis() - startTime
            binding.tvTime.text = (elapsedTime / 1000).toString()
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            startTime = System.currentTimeMillis()
            handler.postDelayed(runnable, 0)
        }

        binding.btnStop.setOnClickListener {
            handler.removeCallbacks(runnable)
        }
    }
}
