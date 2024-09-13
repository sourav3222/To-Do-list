package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.databinding.FragmentHomeBinding


class homeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.addBtn.setOnClickListener {

            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }



        return binding.root
    }


}