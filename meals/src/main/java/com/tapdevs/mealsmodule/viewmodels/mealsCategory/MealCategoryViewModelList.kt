package com.tapdevs.mealsmodule.viewmodels.mealsCategory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tapdevs.base.network.model.meal.category.MealCategory
import com.tapdevs.mealsmodule.repository.MealCategoryRepository
import javax.inject.Inject

class MealCategoryViewModelList @Inject constructor(
    private val mealCategoryRepository: MealCategoryRepository
) : ViewModel() {

    val moviesListLiveData: MutableLiveData<List<MealCategory>>
        get() = mealCategoryRepository.getMealCategories()
}