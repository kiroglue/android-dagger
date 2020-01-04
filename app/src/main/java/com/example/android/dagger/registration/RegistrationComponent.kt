package com.example.android.dagger.registration

import com.example.android.dagger.di.ActivityScope
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import dagger.Subcomponent

// Scope annotation that the RegistrationComponent uses
// Classes annotated with @ActivityScope will have a unique instance in this Component
@ActivityScope
@Subcomponent
interface RegistrationComponent{

    @Subcomponent.Factory
    interface Factory{
        fun create(): RegistrationComponent
    }

    fun inject(activity:RegistrationActivity)
    fun inject(fragment: TermsAndConditionsFragment)
    fun inject(fragment: EnterDetailsFragment)

}