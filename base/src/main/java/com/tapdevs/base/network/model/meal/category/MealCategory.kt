package com.tapdevs.base.network.model.meal.category

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class MealCategory(
    @PrimaryKey @SerializedName("idCategory")
    val categoryId: String,

    @SerializedName("strCategory")
    val category: String,

    @SerializedName("strCategoryThumb")
    val categoryThumb: String,

    @SerializedName("strCategoryDescription")
    val categoryDescription: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(categoryId)
        parcel.writeString(category)
        parcel.writeString(categoryThumb)
        parcel.writeString(categoryDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MealCategory> {
        override fun createFromParcel(parcel: Parcel): MealCategory {
            return MealCategory(parcel)
        }

        override fun newArray(size: Int): Array<MealCategory?> {
            return arrayOfNulls(size)
        }
    }
}