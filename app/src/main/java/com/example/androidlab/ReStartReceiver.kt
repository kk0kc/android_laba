package com.example.androidlab

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import java.util.*

class ReStartReceiver : BroadcastReceiver() {

    private var cal: Calendar? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent != null) {
            if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
                val sharedPreferences =
                    context?.getSharedPreferences("currentTime", Context.MODE_PRIVATE)
                cal = Calendar.getInstance()
                if (sharedPreferences != null) {
                    cal?.timeInMillis = sharedPreferences.getLong("timeInMillis", 0)
                    cal?.set(Calendar.HOUR_OF_DAY, sharedPreferences.getInt("HOUR_OF_DAY", 0))
                    cal?.set(Calendar.MINUTE, sharedPreferences.getInt("MINUTE", 0))
                    cal?.set(Calendar.SECOND, 0)
                    cal?.set(Calendar.MILLISECOND, 0)
                    cal?.set(Calendar.YEAR, sharedPreferences.getInt("YEAR", 0))
                    cal?.set(Calendar.DAY_OF_MONTH, sharedPreferences.getInt("DAY_OF_MONTH", 0)
                    )
                    cal?.set(Calendar.MONTH, sharedPreferences.getInt("MONTH", 0))
                }
                if (context != null && cal != null)
                    MainActivity().alarmSet(cal!!)
            }
        }
    }
}