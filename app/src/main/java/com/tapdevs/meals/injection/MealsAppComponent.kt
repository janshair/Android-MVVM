package com.tapdevs.meals.injection

import android.app.Application
import com.tapdevs.base.injection.BaseModule
import com.tapdevs.base.network.injection.NetworkModule
import com.tapdevs.meals.MealsApp
import dagger.BindsInstance
import dagger.android.AndroidInjectionModule
import com.tapdevs.base.injection.scopes.PerApplication
import dagger.Component

@PerApplication
@Component(modules = [
AndroidInjectionModule::class,
Bindings::class,
BaseModule::class,
NetworkModule::class
])
interface MealsAppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MealsAppComponent
    }

    fun inject(app: MealsApp)
}