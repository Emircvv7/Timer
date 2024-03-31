package com.example.timer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.timer.databinding.ActivityTimerBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityTimerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val timeString = binding.etTime.text.toString()
            if (timeString.isNotEmpty()) {
                val countdownSeconds = timeString.toLong()
                CoroutineScope(Dispatchers.Main).launch {
                    for (i in countdownSeconds downTo 0) {
                        delay(1000L)
                        binding.tvTime.text = i.toString()
                    }
                    Toast.makeText(this@TimerActivity, "Time's up!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@TimerActivity, "Please enter a time", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
