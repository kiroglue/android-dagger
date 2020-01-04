package com.example.android.dagger.di

import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.registration.RegistrationComponent
import dagger.Module

//kiroglue-8 We created a subcomponent because we needed to share the same instance of RegistrationViewModel between the Activity and Fragments.
@Module(subcomponents = [RegistrationComponent::class,LoginComponent::class])
class AppSubComponents


/*
Scoping rules:

When a type is marked with a scope annotation, it can only be used by Components that are annotated with the same scope.
When a Component is marked with a scope annotation, it can only provide types with that annotation or types that have no annotation.
A subcomponent cannot use a scope annotation used by one of its parent Components.
Components also involve subcomponents in this context.
 */