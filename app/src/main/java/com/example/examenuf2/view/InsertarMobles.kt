package com.example.examenuf2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.examenuf2.R
import com.example.examenuf2.databinding.FragmentInsertarMoblesBinding
import com.example.examenuf2.databinding.FragmentLlistatMoblesBinding
import com.example.examenuf2.viewmodel.MoblesViewModel

class InsertarMobles : Fragment() {

    private lateinit var binding: FragmentInsertarMoblesBinding
    private lateinit var moblesViewModel: MoblesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentInsertarMoblesBinding>(
            inflater,
            R.layout.fragment_insertar_mobles,
            container,
            false
        );

        moblesViewModel = ViewModelProvider(this).get(MoblesViewModel::class.java)

        binding.buttonInsertMoble.setOnClickListener {
            val nom = binding.editTextNomMoble.text.toString()
            val preu = binding.editTextTextPreuMoble.text.toString()

            if (nom.isNotEmpty() && preu.isNotEmpty()) {
                moblesViewModel.newMoble(requireContext(), nom, preu.toInt())

                Toast.makeText(context,"S'ha creat el moble", Toast.LENGTH_SHORT).show()

                view?.findNavController()?.navigate(R.id.action_insertarMobles2_to_llistatMobles);
            } else {
                Toast.makeText(context,"No s'ha pogut crear el moble", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}