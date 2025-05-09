package com.roman_kulikov.module_4_practice.ui

import androidx.fragment.app.FragmentManager
import com.roman_kulikov.module_4_practice.ui.main.fragments.FragmentScreen1
import com.roman_kulikov.module_4_practice.ui.main.fragments.FragmentScreen2
import com.roman_kulikov.module_4_practice.ui.main.fragments.FragmentScreen3
import com.roman_kulikov.module_4_practice.ui.router.AppRouter
import com.roman_kulikov.module_4_practice.ui.router.Screen1
import com.roman_kulikov.module_4_practice.ui.router.Screen2
import com.roman_kulikov.module_4_practice.ui.router.Screen3

fun appRouter(fragmentManager: FragmentManager, containerId: Int) = AppRouter(fragmentManager, containerId) {
    add<Screen1>(FragmentScreen1())
    add<Screen2>(FragmentScreen2())
    add<Screen3>(FragmentScreen3())
}