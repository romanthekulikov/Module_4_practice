package com.roman_kulikov.module_4_practice.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.roman_kulikov.module_4_practice.ui.main.MainActivity
import com.roman_kulikov.module_4_practice.databinding.Fragment3Binding
import com.roman_kulikov.module_4_practice.ui.router.Screen2

class FragmentScreen3 : Fragment() {
    private lateinit var binding: Fragment3Binding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = Fragment3Binding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener {
            MainActivity.router.open(Screen2)
        }

        return binding.root
    }
}