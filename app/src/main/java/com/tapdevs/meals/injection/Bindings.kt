package com.tapdevs.meals.injection

import com.tapdevs.mealsmodule.ui.MealsActivity
import com.tapdevs.mealsmodule.injections.modules.MealsModule
import com.tapdevs.base.injection.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class Bindings {

    @PerActivity
    @ContributesAndroidInjector(modules = [MealsModule::class])
    abstract fun bindMealsActivity(): MealsActivity
}