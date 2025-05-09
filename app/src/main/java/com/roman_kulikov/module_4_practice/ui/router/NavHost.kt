package com.roman_kulikov.module_4_practice.ui.router

import androidx.fragment.app.Fragment
import kotlin.reflect.KClass

class NavHost {
    val navMap: MutableMap<KClass<*>, Fragment> = mutableMapOf()

    inline fun <reified T: Screen> add(fragment: Fragment) {
        navMap[T::class] = fragment
    }

}