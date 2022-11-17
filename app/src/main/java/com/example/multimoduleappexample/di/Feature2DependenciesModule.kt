package com.example.multimoduleappexample.di

import androidx.fragment.app.Fragment
import com.example.feature1.api.Feature1Fragment
import com.example.feature2.api.Feature2Dependencies
import com.example.feature2.api.Feature2OtherFeatureFragmentProvider

class Feature2DependenciesModule : Feature2Dependencies {
    override val otherFeatureFragmentProvider: Feature2OtherFeatureFragmentProvider = object : Feature2OtherFeatureFragmentProvider {
        override fun otherFeatureFragment(): Fragment = Feature1Fragment()
    }
}
