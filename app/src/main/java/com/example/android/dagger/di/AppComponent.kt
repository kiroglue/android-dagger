package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.RegistrationComponent
import com.example.android.dagger.settings.SettingsActivity
import com.example.android.dagger.user.UserComponent
import com.example.android.dagger.user.UserManager
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton //kiroglue-7/1: It makes AppComponent singleton so any class can be singleton on AppComponetDaggerGraph
@Component(modules = [StorageModule::class, AppSubComponents::class])//kiroglue-5: After definition of StorageModule the error will be cleared
interface AppComponent{


    @Component.Factory
    // With @BindsInstance, we tell Dagger Context? Context is provided by the Android system
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun userManager(): UserManager

    // Subcomponents Factory that can be injected by AppComponent Component
    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent(): LoginComponent.Factory

}


/*
    kiroglue-3: Error convention:
    dagger/app/build/tmp/kapt3/stubs/debug/com/example/android/dagger/di/AppComponent.java:7: error: [Dagger/MissingBinding] com.example.android.dagger.storage.Storage cannot be provided without an @Provides-annotated method

    break it down:
        Error location: dagger/app/build/tmp/kapt3/stubs/debug/com/example/android/dagger/di/AppComponent.java:7: error:
        Error classification: [Dagger/MissingBinding]
        Error reason: com.example.android.dagger.storage.Storage cannot be provided without an @Provides-annotated method
 */