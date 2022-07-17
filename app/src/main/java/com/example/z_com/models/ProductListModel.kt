package com.example.z_com.models

import android.os.Parcel
import android.os.Parcelable

data class ProductListModel (
    val name: String?,
    val image: String?,
    val totalInCart : String?,
    var menus: List<Menus?>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(Menus)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(image)
        parcel.writeString(totalInCart)
        parcel.writeTypedList(menus)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductListModel> {
        override fun createFromParcel(parcel: Parcel): ProductListModel {
            return ProductListModel(parcel)
        }

        override fun newArray(size: Int): Array<ProductListModel?> {
            return arrayOfNulls(size)
        }
    }
}

data class Menus (
    val name: String?,
    val price: Float?,
    val url: String?,
    var totalInCart : Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readString(),
        (parcel.readValue(Int::class.java.classLoader) as? Int)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(price)
        parcel.writeString(url)
        parcel.writeValue(totalInCart)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Menus> {
        override fun createFromParcel(parcel: Parcel): Menus {
            return Menus(parcel)
        }

        override fun newArray(size: Int): Array<Menus?> {
            return arrayOfNulls(size)
        }
    }
}

