package com.tapdevs.base.network.rest

import com.tapdevs.base.network.api.MealCAtegoryApi
import retrofit2.Retrofit

class RestClientMealCategory(retrofit: Retrofit, private val errorMapper: ErrorMapper) {

    private val mealCAtegoryApi: MealCAtegoryApi = retrofit.create(MealCAtegoryApi::class.java)

//    fun mealCategoriesList(): Single<MealCategoryList> {
//        return mealCAtegoryApi.mealCategories
//            .onErrorResumeNext { throwable ->
//                Single.error(errorMapper.mapErrorToException(throwable))
//            }
//    }
}