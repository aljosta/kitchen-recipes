package com.example.recipesapp.utils

import android.widget.ImageView
import coil.load
import coil.request.ImageRequest
import java.text.NumberFormat
import java.util.*

fun String?.value(default: String = "") = this ?: default

fun emptyString(): String = ""

fun <T> List<T>?.value(default: List<T> = emptyList()) = this ?: default

fun Int?.value(default: Int = 0) = this ?: default

fun Float?.value(default: Float = 0f) = this ?: default

fun Boolean?.value(default: Boolean = false) = this ?: default

fun Double?.value(default: Double = 0.0) = this ?: default

fun ImageView.loadSvgFromUrl(image: String, builder: ImageRequest.Builder.() -> Unit = {}) =
    load(image) {
        builder()
    }

fun Int.asColombianCurrency(): String =
    NumberFormat.getCurrencyInstance(Locale("es", "co")).apply {
        minimumFractionDigits = 0
        maximumFractionDigits = 0
    }.format(this)

fun Int.asDiscountRateFrom(originalPrice: Int): Int =
    if (originalPrice <= 0 || this == originalPrice) {
        0
    } else {
        (originalPrice - this).times(100).div(originalPrice)
    }
