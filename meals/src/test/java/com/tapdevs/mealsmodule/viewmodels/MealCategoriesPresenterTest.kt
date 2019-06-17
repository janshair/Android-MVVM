package com.tapdevs.mealsmodule.viewmodels

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.tapdevs.base.BasePresenterTest
import com.tapdevs.base.network.model.meal.category.MealCategoryList
import com.tapdevs.base.network.rest.RestClientMealCategory
import com.tapdevs.mealsmodule.viewmodels.mealsCategory.MealCategoriesPresenter
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MealCategoriesPresenterTest : BasePresenterTest<MealCategoriesPresenter, MealCategoriesPresenter.View>() {

    private val publishSubject: PublishSubject<Any> = PublishSubject.create<Any>()

    private val restClientMealCategory: RestClientMealCategory = mock()

    override fun createPresenter(): MealCategoriesPresenter =
        MealCategoriesPresenter(
            restClientMealCategory,
            Schedulers.trampoline(),
            Schedulers.trampoline()
        )

    override fun createView(): MealCategoriesPresenter.View {
        val view: MealCategoriesPresenter.View = mock()
        whenever(view.onRetryClick()).thenReturn(publishSubject)
        return view
    }

    @Test
    fun onRetryClick_OnSuccess_Verify() {
        presenterOnViewAttached()
        verify(presenter).fetchAlbums()
    }

    @Test
    fun onRetryClick_OnError_Verify() {
        val throwable: Throwable = mock()
        whenever(view.onRetryClick()).thenReturn(Observable.error(throwable))
        presenterOnViewAttached()
        verify(view).showOfflineLayout(true)
        verify(view).showErrorMessage()
    }

    @Test
    fun fetchAlbums_OnSuccess_Verify() {
        val albumList: MealCategoryList = mock()
        whenever(restClientMealCategory.mealCategoriesList()).thenReturn(Single.just(albumList))
        presenterOnViewAttached()
        verify(view).showOfflineLayout(false)
        verify(view).updateList(albumList.categories)
    }

    @Test
    fun fetchAlbums_OnError_Verify() {
        val throwable: Throwable = mock()
        whenever(restClientMealCategory.mealCategoriesList()).thenReturn(Single.error(throwable))
        presenterOnViewAttached()
        verify(view).showOfflineLayout(true)
        verify(view).showErrorMessage()
    }
}