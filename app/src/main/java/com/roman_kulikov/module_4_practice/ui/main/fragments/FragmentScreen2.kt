package com.roman_kulikov.module_4_practice.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.roman_kulikov.module_4_practice.ui.main.MainActivity
import com.roman_kulikov.module_4_practice.databinding.Fragment2Binding
import com.roman_kulikov.module_4_practice.ui.router.Screen1
import com.roman_kulikov.module_4_practice.ui.router.Screen3

class FragmentScreen2 : Fragment() {
    private lateinit var binding: Fragment2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = Fragment2Binding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener {
            MainActivity.router.open(Screen1)
        }

        binding.buttonForward.setOnClickListener {
            MainActivity.router.open(Screen3)
        }

        return binding.root
    }
}