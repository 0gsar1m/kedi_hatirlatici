package com.example.luna_cat_notificator

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NotificationWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val service = BasicNotificationService(applicationContext)
        service.showNotifications()
        return Result.success()
    }
}
