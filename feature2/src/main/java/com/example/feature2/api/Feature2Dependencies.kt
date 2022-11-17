package com.example.feature2.api

import androidx.fragment.app.Fragment

interface Feature2Dependencies {
    val otherFeatureFragmentProvider: Feature2OtherFeatureFragmentProvider
}


interface Feature2OtherFeatureFragmentProvider {
    fun otherFeatureFragment(): Fragment
}
