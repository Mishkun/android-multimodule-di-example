package com.example.feature3_no_ui.internal.di

import com.example.feature3_no_ui.api.Notifier
import com.example.feature3_no_ui.api.NotifierDependencies
import com.example.feature3_no_ui.api.NotifierComponent
import com.example.feature3_no_ui.internal.LogNotifier
import com.example.feature3_no_ui.internal.NotifierImpl
import com.example.feature3_no_ui.internal.NotifierLevelConverter
import com.example.feature3_no_ui.internal.ToasterNotifier

class NotifierComponentImpl(deps: NotifierDependencies) :
    NotifierDependencies by deps,
    NotifierComponent,
    NotifierImpl.Dependencies {
    override val logNotifier: LogNotifier get() = LogNotifier(NotifierLevelConverter())
    override val toasterNotifier: ToasterNotifier get() = ToasterNotifier(context, NotifierLevelConverter())
    override val notifier: Notifier = NotifierImpl(this)
}
