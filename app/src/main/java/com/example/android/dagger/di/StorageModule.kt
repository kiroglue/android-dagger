package com.example.android.dagger.di

import com.example.android.dagger.storage.SharedPreferencesStorage
import com.example.android.dagger.storage.Storage
import dagger.Binds
import dagger.Module


//kiroglue-4:The way we tell Dagger how to provide Storage is different because Storage is an interface. We need to tell Dagger what implementation of Storage we want to use: SharedPreferencesStorage.
//Another way to tell Dagger how to provide instances of a type is with information in Dagger Modules.
//Use @Binds to tell Dagger which implementation it needs to use when providing an interface.
@Module
abstract class StorageModule {

    //With the code above, we linked the interface Storage with the SharedPreferencesStorage implementation.
    @Binds
    abstract fun provideStorage(sharedPreferencesStorage: SharedPreferencesStorage):Storage

}