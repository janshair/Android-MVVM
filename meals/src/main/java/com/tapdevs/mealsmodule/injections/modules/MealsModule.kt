package com.tapdevs.mealsmodule.injections.modules

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.tapdevs.base.injection.qualifiers.ForActivity
import com.tapdevs.base.injection.scopes.PerActivity
import com.tapdevs.mealsmodule.ui.MealsActivity
import com.tapdevs.mealsmodule.ui.adapter.MealCategoriesAdapter
import com.tapdevs.mealsmodule.viewmodels.mealsCategory.MealCategoryViewModelList
import com.tapdevs.mealsmodule.viewmodels.mealsCategory.MealCategoryViewModelFactory
import dagger.Module
import dagger.Provides

@Module(includes = [MealsModule.View::class,
MealsModule.ViewModel::class])
class MealsModule {

    @Module
    class View {
        @Provides
        @PerActivity
        @ForActivity
        fun provideContext(activity: MealsActivity): Context = activity
        }

    @Module
    class ViewModel {
        @Provides
        @PerActivity
        fun provideOverviewViewModel(activity: MealsActivity, factory: MealCategoryViewModelFactory): MealCategoryViewModelList =
            ViewModelProviders.of(activity, factory).get(MealCategoryViewModelList::class.java)

        @Provides
        @PerActivity
        fun provideTracksAdapter(): MealCategoriesAdapter = MealCategoriesAdapter()
    }
}