package com.tapdevs.base.network.api

import com.tapdevs.base.network.model.meal.category.MealCategoryWrapper
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MealCAtegoryApi {

    @GET("categories.php")
    fun getMealCategory(): Deferred<MealCategoryWrapper>
}