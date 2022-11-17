package com.example.multimoduleappexample.di

import com.example.feature1.api.Feature1CaptionProvider
import com.example.feature1.api.Feature1Dependencies
import com.example.feature1.api.Feature1Logger
import com.example.feature3_no_ui.api.Notifier
import com.example.multimoduleappexample.Feature1CaptionProviderImpl

class Feature1DependenciesModule(notifier: Notifier) : Feature1Dependencies {
    override val feature1Logger: Feature1Logger = object : Feature1Logger {
        override fun log(text: String) {
            notifier.notify(text, Notifier.Level.DEFAULT)
        }
    }
    val feature1CaptionProviderImpl = Feature1CaptionProviderImpl(notifier)
    override val feature1CaptionProvider: Feature1CaptionProvider = feature1CaptionProviderImpl
}
