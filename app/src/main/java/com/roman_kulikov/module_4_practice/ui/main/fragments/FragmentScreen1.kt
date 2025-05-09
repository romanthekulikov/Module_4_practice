package com.roman_kulikov.module_4_practice.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.roman_kulikov.module_4_practice.ui.main.MainActivity
import com.roman_kulikov.module_4_practice.databinding.Fragment1Binding
import com.roman_kulikov.module_4_practice.ui.router.Screen2

class FragmentScreen1 : Fragment() {
    private lateinit var binding: Fragment1Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = Fragment1Binding.inflate(inflater, container, false)

        binding.buttonForward.setOnClickListener {
            MainActivity.router.open(Screen2)
        }

        return binding.root
    }
}