package com.example.luna_cat_notificator

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

class BasicNotificationService(
    private val context: Context
) {

    fun showNotifications() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.POST_NOTIFICATIONS
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            // İzin yoksa bildirimi gösterme
            return
        }

        val notification = NotificationCompat.Builder(context, BASIC_CHANNEL_ID)
            .setSmallIcon(R.drawable.outline_alarm_24)
            .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.kedi_ikon))
            .setContentTitle("Kedi suyu ve kumu!")
            .setContentText("Kedinin suyunu tazele, kumunu değiştir 😺")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
        val manager = NotificationManagerCompat.from(context)
        manager.notify(1, notification)
    }

    companion object {
        const val BASIC_CHANNEL_ID = "basic_channel"
    }
}