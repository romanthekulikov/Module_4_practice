package com.roman_kulikov.module_4_practice.ui.router

import androidx.fragment.app.FragmentManager
import java.util.Stack

class AppRouter(
    private val fragmentManager: FragmentManager,
    private val containerId: Int,
    navHost: NavHost.() -> Unit
) : Router {
    private val routerNavHost = NavHost().also(navHost)
    private val stack: Stack<Screen> = Stack()

    override fun open(screen: Screen, rules: OpenRules) {
        val fragment = routerNavHost.navMap[screen::class] ?: return

        if (rules == OpenRules.QUEUED) stack.push(screen)

        fragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun goBack(): Boolean {
        if (stack.size > 1) {
            stack.pop()
            val screen = stack.peek()
            val fragment = routerNavHost.navMap[screen::class] ?: return false

            fragmentManager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(null)
                .commit()

            return true
        }
        return false
    }

}