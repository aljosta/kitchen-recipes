package com.example.core.utils

fun String?.value(default: String = "") = this ?: default

fun <T> List<T>?.value(default: List<T> = emptyList()) = this ?: default

fun Float?.value(default: Float = 0f) = this ?: default
