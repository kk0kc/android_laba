package com.example.androidlab

import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlab.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var alarmManager: AlarmManager? = null
    private var notificationProvider: NotificationProvider? = null
    private var sharedPreferences: SharedPreferences? = null
    var cal: Calendar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notificationProvider = NotificationProvider(this)
        notificationProvider?.createChannel()
        sharedPreferences = applicationContext.getSharedPreferences("currentTime", Context.MODE_PRIVATE)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        binding?.run {
            tvTime.setOnClickListener {
                cal = Calendar.getInstance()
                val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                    cal?.set(Calendar.HOUR_OF_DAY, hour)
                    cal?.set(Calendar.MINUTE, minute)
                    tvTime.text = SimpleDateFormat("HH:mm").format(cal?.time)
                }
                sharedPreferences?.edit()?.putLong("timeInMillis", cal!!.timeInMillis)?.apply()
                sharedPreferences?.edit()?.putInt("HOUR_OF_DAY", cal!!.get(Calendar.HOUR_OF_DAY))?.apply()
                sharedPreferences?.edit()?.putInt("MINUTE", cal!!.get(Calendar.MINUTE))?.apply()
                TimePickerDialog(this@MainActivity, timeSetListener, cal!!.get(Calendar.HOUR_OF_DAY), cal!!.get(Calendar.MINUTE), true).show()
            }
            tvDate.setOnClickListener {
                cal = Calendar.getInstance()
                val dateSetListener = DatePickerDialog.OnDateSetListener { datePicker, year, monthOfYear, dayOfMonth ->
                    cal?.set(Calendar.YEAR, year)
                    cal?.set(Calendar.MONTH, monthOfYear)
                    cal?.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    tvDate.text = SimpleDateFormat("dd/MM/yyyy").format(cal?.time)
                }
                sharedPreferences?.edit()?.putLong("timeInMillis", cal!!.timeInMillis)?.apply()
                sharedPreferences?.edit()?.putInt("YEAR", cal!!.get(Calendar.YEAR))?.apply()
                sharedPreferences?.edit()?.putInt("DAY_OF_MONTH", cal!!.get(Calendar.DAY_OF_MONTH))?.apply()
                sharedPreferences?.edit()?.putInt("MONTH", cal!!.get(Calendar.MONTH))?.apply()
                DatePickerDialog(this@MainActivity, dateSetListener, cal!!.get(Calendar.YEAR), cal!!.get(Calendar.MONTH),cal!!.get(Calendar.DAY_OF_MONTH)).show()
            }
            btnStart.setOnClickListener {
//                notificationProvider?.showNotification()
                if(binding?.tvTime?.text != "тыкни чтобы установить время"
                    && binding?.tvDate?.text != "тыкни чтобы установить дату"){
//               alarmSet(cal!!)
                    val intent = Intent(this@MainActivity, MyReceiver::class.java)
                    val pendingIntent = PendingIntent.getBroadcast(this@MainActivity, 0, intent, 0)
                    alarmManager?.set(AlarmManager.RTC_WAKEUP, cal!!.timeInMillis, pendingIntent)
                }
            }
            btnStop.setOnClickListener {
                val intent = Intent(this@MainActivity, MyReceiver::class.java)
                val pendingIntent = PendingIntent.getBroadcast(this@MainActivity, 0, intent, 0)
                if (alarmManager == null) {
                    alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
                }
                alarmManager?.cancel(pendingIntent)
                cal = null
                binding?.tvTime?.text = "тыкни чтобы установить дату"
                binding?.tvDate?.text = "тыкни чтобы установить время"
            }
        }

    }
    fun alarmSet(cal: Calendar){
        val intent = Intent(this, MyReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        alarmManager?.set(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pendingIntent)
    }
    override fun onDestroy() {
        super.onDestroy()
        notificationProvider = null
        binding = null
    }
}
