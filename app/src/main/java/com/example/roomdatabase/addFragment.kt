package com.example.roomdatabase

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomdatabase.databinding.FragmentAddBinding
import java.util.Calendar

class addFragment : Fragment() {
lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater,container,false)



        binding.dateBtn.setOnClickListener {
            pickdate()
        }

        binding.timeBtn.setOnClickListener {
            picktime()
        }





        return binding.root
    }

    private fun picktime() {
        val calendar = Calendar.getInstance()

        val minute = calendar.get(Calendar.MINUTE)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)

      val timePicker =   TimePickerDialog(requireActivity(),TimePickerDialog.OnTimeSetListener{view,hourOfDay, minute->

            val showTime = "$hour:$minute"


            binding.timeBtn.text = showTime
        }, hour,minute,false
        )
        timePicker.show()
    }

    private fun pickdate() {
        val calendar = Calendar.getInstance()

        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        val showdata = DatePickerDialog(
            requireActivity(),DatePickerDialog.OnDateSetListener{ view, dayOfMonth, month , year ->


                val showType = "$day/${month + 1}/$year"
                binding.dateBtn.text = showType
            },year, month, day
        )
        showdata.show()
    }


}