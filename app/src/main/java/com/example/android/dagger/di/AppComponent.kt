package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.registration.RegistrationActivity
import dagger.BindsInstance
import dagger.Component


@Component(modules = [StorageModule::class])//kiroglue5: After definition of StorageModule the error will be cleared
interface AppComponent{


    @Component.Factory
    // With @BindsInstance, we tell Dagger Context? Context is provided by the Android system
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity:RegistrationActivity)

}


/*
    kiroglue3: Error convention:
    dagger/app/build/tmp/kapt3/stubs/debug/com/example/android/dagger/di/AppComponent.java:7: error: [Dagger/MissingBinding] com.example.android.dagger.storage.Storage cannot be provided without an @Provides-annotated method

    break it down:
        Error location: dagger/app/build/tmp/kapt3/stubs/debug/com/example/android/dagger/di/AppComponent.java:7: error:
        Error classification: [Dagger/MissingBinding]
        Error reason: com.example.android.dagger.storage.Storage cannot be provided without an @Provides-annotated method
 */