package com.tapdevs.mealsmodule.repository

import androidx.lifecycle.MutableLiveData
import com.tapdevs.base.injection.qualifiers.NamedDispatcher
import com.tapdevs.base.network.api.MealCAtegoryApi
import com.tapdevs.base.network.model.meal.category.MealCategory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MealCategoryRepository @Inject constructor(
    private val mealCategoryApi: MealCAtegoryApi,
    @NamedDispatcher(NamedDispatcher.DispatcherType.IO) private val backgroundDispatcher: CoroutineDispatcher,
    @NamedDispatcher(NamedDispatcher.DispatcherType.UI) private val uiDispatcher: CoroutineDispatcher
) {

    private var mutableLiveData = MutableLiveData<List<MealCategory>>()

    fun getMealCategories(): MutableLiveData<List<MealCategory>> {
        CoroutineScope(backgroundDispatcher).launch {
            val request = mealCategoryApi.getMealCategory()
            withContext(uiDispatcher) {
                try {
                    val response = request.await()
                    val categoryList = response.categories
                    if (categoryList != null) {
                        mutableLiveData.value = categoryList
                    }
                } catch (e: Throwable) {
                    Timber.e(e)
                }
            }
        }
        return mutableLiveData
    }
}