package com.tapdevs.base.network.api

import com.tapdevs.base.network.model.meal.category.MealCategoryList
import retrofit2.http.GET

interface MealCAtegoryApi {

    @GET("categories.php")
    suspend fun getMealCategory(): MealCategoryList
}