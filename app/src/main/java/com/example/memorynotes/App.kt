package com.example.memorynotes

import android.app.Activity
import android.app.Application
import com.example.mapbox_provider.R
import com.example.memorynotes.framework.di.AppInjector
import com.mapbox.mapboxsdk.Mapbox
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)

        Mapbox.getInstance(this, getString(R.string.mapbox_access_token))

    }

    override fun activityInjector() = dispatchingAndroidInjector

}