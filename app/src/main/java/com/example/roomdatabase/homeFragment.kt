package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.roomdatabase.databinding.FragmentHomeBinding


class homeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var dataBase: NoteDataBase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding = FragmentHomeBinding.inflate(inflater,container,false)
        dataBase = Room.databaseBuilder(requireActivity(),NoteDataBase::class.java,"Ntoe_DB")
            .allowMainThreadQueries().build()

     var notes: List<Note> =   dataBase.getNoteDao().getAllData()

        var ad = NoteAdapter()
        ad.submitList(notes)

        binding.recyclerview.adapter= ad



        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addFragment)
        }



        return binding.root
    }


}