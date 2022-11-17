package com.example.feature3_no_ui.internal

import com.example.feature3_no_ui.api.Notifier
import com.example.feature3_no_ui.api.NotifierInteractivityProvider

internal class NotifierImpl(
    private val deps: Dependencies
) : Notifier {
    override fun notify(text: String, level: Notifier.Level) = when (val interactivity = deps.notifierInteractivityProvider.interactivity) {
        is Notifier.Interactivity.Log -> deps.logNotifier.notify(text = text, level, tag = interactivity.tag)
        Notifier.Interactivity.Toast -> deps.toasterNotifier.notify(text, level)
        is Notifier.Interactivity.Both -> {
            deps.toasterNotifier.notify(text, level)
            deps.logNotifier.notify(text = text, level, tag = interactivity.logTag)
        }
    }

    internal interface Dependencies {
        val notifierInteractivityProvider: NotifierInteractivityProvider
        val logNotifier: LogNotifier
        val toasterNotifier: ToasterNotifier
    }
}
