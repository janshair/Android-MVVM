package com.tapdevs.mealsmodule.viewmodels.mealsCategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tapdevs.mealsmodule.repository.MealCategoryRepository
import javax.inject.Inject

class MealCategoryViewModelFactory @Inject constructor(
    private val mealCategoryRepository: MealCategoryRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MealCategoryViewModel(mealCategoryRepository) as T
    }
}