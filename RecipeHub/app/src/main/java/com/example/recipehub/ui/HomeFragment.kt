package com.example.recipehub.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.recipehub.App
import com.example.recipehub.R
import com.example.recipehub.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val myApp = this.activity?.application as App

        val userData = myApp.repository.getUserData()
        val greeting = "Welcome to RecipeHub,\n" + userData.getString("name") + "!"
        binding.greeting.text = greeting
        try {
            Glide.with(this)
                .load(userData.getString("picture"))
                .fallback(R.drawable.baseline_account_circle_24)
                .error(R.drawable.baseline_account_circle_24)
                .into(binding.profileImage)
        } catch (e: Exception) {
            Log.d("REC", e.toString())
            Log.d("REC", userData.toString())
        }
        // Inflate the layout for this fragment
        return binding.root
    }
}