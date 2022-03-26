package com.pourkazemi.mahdi.maktab_hw9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.pourkazemi.mahdi.maktab_hw9.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)
        var female:Boolean= binding.checkbox.isChecked
        binding.checkbox2.isChecked = !binding.checkbox.isChecked
        binding.checkbox.setOnCheckedChangeListener { compoundButton, b ->
            binding.checkbox2.isChecked=!b
            female=!b
        }
        binding.checkbox2.setOnCheckedChangeListener { compoundButton, b ->
            binding.checkbox.isChecked=!b
            female=!b
        }
        val mList = mutableListOf<String>()
        binding.register.setOnClickListener {

            mList.addAll(
                listOf<String>(
                    binding.fullNameEdit.text.toString(),
                    binding.userNameEdit.text.toString(),
                    binding.emailEdit.text.toString(),
                    binding.passwordEdit.text.toString()
                    )
            )
            val action=FirstFragmentDirections
                .actionFirstFragmentToSecondFragment(data = mList.toTypedArray(),female=female)
            it.findNavController().navigate(action)
        }
    }
}