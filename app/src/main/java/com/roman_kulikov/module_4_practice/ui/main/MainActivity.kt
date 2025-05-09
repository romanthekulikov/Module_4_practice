package com.roman_kulikov.module_4_practice.ui.main

import android.content.Context
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.roman_kulikov.module_4_practice.R
import com.roman_kulikov.module_4_practice.databinding.ActivityMainBinding
import com.roman_kulikov.module_4_practice.requestNotificationPermission
import com.roman_kulikov.module_4_practice.ui.appRouter
import com.roman_kulikov.module_4_practice.ui.router.AppRouter
import com.roman_kulikov.module_4_practice.ui.router.OpenRules
import com.roman_kulikov.module_4_practice.ui.router.Screen1
import com.roman_kulikov.module_4_practice.workers.ChargingNotificationWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var router: AppRouter
    }
    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (!router.goBack()) finish()
        }
    }
        private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        router = appRouter(supportFragmentManager, R.id.fragment_container)
        enableEdgeToEdge()

        router.open(Screen1, OpenRules.QUEUED)

        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        requestNotificationPermission(this)
        scheduleChargingWorker()
    }

    fun scheduleChargingWorker() {
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val request = PeriodicWorkRequestBuilder<ChargingNotificationWorker>(
            15, TimeUnit.MINUTES
        )
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "charging_notification_work",
            ExistingPeriodicWorkPolicy.KEEP,
            request
        )
    }

}