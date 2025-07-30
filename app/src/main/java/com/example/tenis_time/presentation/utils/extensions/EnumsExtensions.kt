package com.example.tenis_time.presentation.utils.extensions

inline fun <reified T> T.nextEnum(): T where T : Enum<T> {
    val all = enumValues<T>()
    return all[(ordinal + 1) % all.size]
}