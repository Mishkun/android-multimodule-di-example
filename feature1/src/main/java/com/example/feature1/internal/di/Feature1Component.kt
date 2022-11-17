package com.example.feature1.internal.di

import com.example.feature1.api.Feature1Dependencies

class Feature1ComponentImpl(deps: Feature1Dependencies) : Feature1Dependencies by deps
