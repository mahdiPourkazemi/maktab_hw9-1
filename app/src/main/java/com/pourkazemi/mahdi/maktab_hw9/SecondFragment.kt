package com.pourkazemi.mahdi.maktab_hw9

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.pourkazemi.mahdi.maktab_hw9.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)

        val shared= this.activity?.getSharedPreferences("myShared", Context.MODE_PRIVATE)

        binding.saveButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_secondFragment_to_firstFragment)

        }
        var mList = arrayOf<String>()
        var gender:Boolean=false
        arguments?.let {
            val mSafeArgs = SecondFragmentArgs.fromBundle(it)
             mList = mSafeArgs.data
             gender = mSafeArgs.female
            shared?.edit()?.apply {
                putString("fullname",mList[0])
                putString("username",mList[1])
                putString("email",mList[2])
                putString("password",mList[3])
                putBoolean("gender",gender)
            }
        }

        binding.showFullName.text=mList[0]
        binding.showUserName.text=mList[1]
        binding.showEmail.text=mList[2]
        binding.showPassword.text=mList[3]
        if (gender) binding.showGender.text="female"
        else binding.showGender.text="male"

    }
}