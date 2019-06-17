package com.tapdevs.mealsmodule.repository

import com.tapdevs.base.network.api.MealCAtegoryApi
import com.tapdevs.base.network.model.meal.category.MealCategoryList
import javax.inject.Inject

class MealCategoryRepository @Inject constructor(
    private val mealCategoryApi: MealCAtegoryApi
) {

    suspend fun getMeals(): MealCategoryList = mealCategoryApi.getMealCategory()
}