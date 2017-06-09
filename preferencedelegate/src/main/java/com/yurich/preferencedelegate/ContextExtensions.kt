package com.yurich.preferencedelegate

import android.content.Context

/**
 * Created by yurich on 09.06.17.
 */

fun <T> Context.preference(prefsName: String? = null, mode: Int = Context.MODE_PRIVATE): PreferenceDelegate<Context, T> {
    return PreferenceDelegate(getSharedPreferences(prefsName, mode))
}