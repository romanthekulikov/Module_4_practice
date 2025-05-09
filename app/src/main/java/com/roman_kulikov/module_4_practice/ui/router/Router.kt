package com.roman_kulikov.module_4_practice.ui.router

interface Router {
    fun open(screen: Screen, rules: OpenRules = OpenRules.QUEUED)
    fun goBack(): Boolean
}