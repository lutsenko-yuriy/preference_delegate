package com.yurich.preferencedelegate

import android.content.Context
import android.content.SharedPreferences
import java.lang.UnsupportedOperationException
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Preference delegate
 */
class PreferenceDelegate<in R: Context, T>(val sharedPreferences: SharedPreferences) : ReadWriteProperty<R, T> {
    override fun getValue(thisRef: R, property: KProperty<*>): T {
        TODO("Implement")
//        return getData(sharedPreferences, T::class.java)
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: T) {
        val editor = sharedPreferences.edit()
        when (value) {
            is Boolean -> editor.putBoolean(property.name, value)
            is Float -> editor.putFloat(property.name, value)
            is Int -> editor.putInt(property.name, value)
            is Long -> editor.putLong(property.name, value)
            is String -> editor.putString(property.name, value)
//            is Set<*> -> editor.putStringSet(property.name, value)
            else -> throw UnsupportedOperationException("Cannot set data of undeclared type")
        }
        editor.apply()
    }
}

fun <T> getData(sharedPreferences: SharedPreferences, clazz: Class<T>): T {
    when (clazz) {
        Boolean::class.java -> TODO("Implement")
        Float::class.java -> TODO("Implement")
        Int::class.java -> TODO("Implement")
        Long::class.java -> TODO("Implement")
        String::class.java -> TODO("Implement")
//        Set<String>::class.java -> TODO("Implement")
        else -> TODO("Implement")
    }
}