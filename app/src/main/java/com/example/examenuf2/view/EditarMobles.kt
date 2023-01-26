package com.example.examenuf2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.examenuf2.R
import com.example.examenuf2.databinding.FragmentEditarMoblesBinding
import com.example.examenuf2.viewmodel.MoblesViewModel
import com.example.examenuf2.viewmodel.SharedViewModel

class EditarMobles : Fragment() {
    private lateinit var binding: FragmentEditarMoblesBinding
    private lateinit var moblesViewModel: MoblesViewModel
    private lateinit var moblesSharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentEditarMoblesBinding>(
            inflater,
            R.layout.fragment_editar_mobles,
            container,
            false
        );

        moblesViewModel =  ViewModelProvider(this).get(MoblesViewModel::class.java)

        moblesSharedViewModel =  ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)


        moblesSharedViewModel.moble.observe(viewLifecycleOwner, Observer { mobles ->
//            binding.editTextNomMoble.text.toString() = mobles.nom
//            binding.editTextPreuMoble.text.toString() = mobles.preu

        })


        binding.buttonDeleteMoble.setOnClickListener {
            moblesViewModel


        }

        binding.buttonUpdateMoble.setOnClickListener {

        }



        return binding.root

    }

}