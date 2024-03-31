package com.example.timer

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.timer.databinding.ActivityAlarmBinding
import java.util.*

class AlarmActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAlarmBinding.inflate(layoutInflater)
    }

    @SuppressLint("ScheduleExactAlarm")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSet.setOnClickListener {
            val hourString = binding.etHour.text.toString()
            val minuteString = binding.etMinute.text.toString()
            if (hourString.isNotEmpty() && minuteString.isNotEmpty()) {
                val hour = hourString.toInt()
                val minute = minuteString.toInt()

                val calendar = Calendar.getInstance().apply {
                    timeInMillis = System.currentTimeMillis()
                    set(Calendar.HOUR_OF_DAY, hour)
                    set(Calendar.MINUTE, minute)
                }

                val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
                val intent = Intent(this, AlarmReceiver::class.java)
                val pendingIntent =
                    PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

                Toast.makeText(this, "Alarm set for $hour:$minute", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter an hour and minute", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
