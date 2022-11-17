package com.example.multimoduleappexample.di

import android.content.Context
import com.example.feature3_no_ui.api.Notifier
import com.example.feature3_no_ui.api.NotifierDependencies
import com.example.feature3_no_ui.api.NotifierInteractivityProvider
import com.example.feature3_no_ui.internal.di.NotifierComponentImpl

class NotifierFeature3Module(override val context: Context) : NotifierDependencies {

    override val notifierInteractivityProvider: NotifierInteractivityProvider = object : NotifierInteractivityProvider {
        override val interactivity = Notifier.Interactivity.Both(logTag = "Main")
    }
    val notifier = NotifierComponentImpl(this).notifier
}
