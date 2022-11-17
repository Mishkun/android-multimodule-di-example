package com.example.multimoduleappexample.di

import android.content.Context
import com.example.feature1.api.Feature1Dependencies
import com.example.feature2.api.Feature2Dependencies
import com.example.feature3_no_ui.api.Notifier
import com.example.feature3_no_ui.api.NotifierDependencies
import com.example.feature3_no_ui.api.NotifierInteractivityProvider
import com.example.multimoduleappexample.Feature1CaptionProviderImpl
import com.example.multimoduleappexample.MainActivity

class MainActivityComponentImpl(
    override val context: Context,
    notifierModule: NotifierFeature3Module = NotifierFeature3Module(context),
    private val feature1DependenciesModule: Feature1DependenciesModule = Feature1DependenciesModule(notifierModule.notifier),
) : Feature1Dependencies by feature1DependenciesModule,
    Feature2Dependencies by Feature2DependenciesModule(),
    NotifierDependencies by notifierModule,
    MainActivity.Dependencies {
    override val notifierInteractivityProvider: NotifierInteractivityProvider = object : NotifierInteractivityProvider {
        override val interactivity = Notifier.Interactivity.Both(logTag = "Main")
    }
    override val feature1CaptionProviderImpl: Feature1CaptionProviderImpl get() = feature1DependenciesModule.feature1CaptionProviderImpl
}
