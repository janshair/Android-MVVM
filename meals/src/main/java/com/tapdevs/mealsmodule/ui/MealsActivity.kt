package com.tapdevs.mealsmodule.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.tapdevs.base.network.model.meal.category.MealCategory
import com.tapdevs.base.ui.BaseActivity
import com.tapdevs.mealsmodule.R
import com.tapdevs.mealsmodule.ui.adapter.MealCategoriesAdapter
import com.tapdevs.mealsmodule.viewmodels.mealsCategory.MealCategoryViewModel
import kotlinx.android.synthetic.main.activity_meal.*
import kotlinx.android.synthetic.main.view_offline.*
import javax.inject.Inject

class MealsActivity : BaseActivity() {

    @Inject lateinit var mealCategoryViewModel: MealCategoryViewModel

    override val layoutResourceId: Int
        get() = R.layout.activity_meal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        mealCategoryViewModel.moviesListLiveData.observe(this, Observer {
                updateList(it)



        })
    }

    fun showErrorMessage() {
        offlineText.text = getString(R.string.error_message)
    }
//
    fun updateList(mealCategoryList: List<MealCategory>) {
        rvMeals.adapter = MealCategoriesAdapter().apply { setItems(mealCategoryList) }
    }
//
//    override fun onRetryClick() = RxView.clicks(offlineActionButton)
//
    fun showOfflineLayout(show: Boolean) {
        if (show) {
            rvMeals.visibility = View.GONE
            offlineLayout.visibility = View.VISIBLE
        } else {
            rvMeals.visibility = View.VISIBLE
            offlineLayout.visibility = View.GONE
        }
    }
}