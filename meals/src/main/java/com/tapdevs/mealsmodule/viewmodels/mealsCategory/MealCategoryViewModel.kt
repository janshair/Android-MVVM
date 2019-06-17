package com.tapdevs.mealsmodule.viewmodels.mealsCategory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tapdevs.base.network.model.meal.category.MealCategory
import com.tapdevs.mealsmodule.repository.MealCategoryRepository
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class MealCategoryViewModel @Inject constructor(
    private val mealCategoryRepository: MealCategoryRepository
) : ViewModel() {

    val moviesListLiveData = MutableLiveData<List<MealCategory>>()

    fun load() {
        Timber.d("")
        viewModelScope.launch {
            mealCategoryRepository.getMeals().categories
        }
    }
}