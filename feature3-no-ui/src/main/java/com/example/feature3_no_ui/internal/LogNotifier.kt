package com.example.feature3_no_ui.internal

import android.util.Log
import com.example.feature3_no_ui.api.Notifier

class LogNotifier(
    private val levelConverter: NotifierLevelConverter
) {
    fun notify(text: String, level: Notifier.Level, tag: String) {
        Log.println(levelConverter.convertToLogLevel(level), tag, text)
    }

}
