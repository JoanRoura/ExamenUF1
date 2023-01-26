package com.example.examenuf2.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examenuf2.R
import com.example.examenuf2.databinding.FragmentLlistatMoblesBinding
import com.example.examenuf2.model.Mobles
import com.example.examenuf2.view.recylerView.MoblesAdapter
import com.example.examenuf2.view.recylerView.RecyclerClickListener
import com.example.examenuf2.viewmodel.MoblesViewModel
import com.example.examenuf2.viewmodel.SharedViewModel

class LlistatMobles : Fragment() {
    private lateinit var adapter: MoblesAdapter
    private lateinit var binding: FragmentLlistatMoblesBinding
    private lateinit var moblesViewModel: MoblesViewModel
    private lateinit var moblesSharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentLlistatMoblesBinding>(
            inflater,
            R.layout.fragment_llistat_mobles,
            container,
            false
        );

        moblesViewModel = ViewModelProvider(this).get(MoblesViewModel::class.java)

        setRecyclerView()
        observeMoble()

        binding.buttonGoInsertarMoble.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_llistatMobles_to_insertarMobles2);
        }

        return binding.root
    }

    private fun setRecyclerView() {

        val moblesRecyclerView = binding.recyclerView

        moblesSharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        moblesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        moblesRecyclerView.setHasFixedSize(true)
        adapter = MoblesAdapter()
        adapter.setItemListener(object : RecyclerClickListener {

            override fun onItemClick(position: Int) {
                val mobleList = adapter.currentList.toMutableList()
                Toast.makeText(requireContext(),"Moble: ${mobleList[position].nom} , Preu: ${mobleList[position].preu} " , Toast.LENGTH_SHORT).show()

                moblesSharedViewModel.moble.value = mobleList[position]

                view?.findNavController()?.navigate(R.id.action_llistatMobles_to_editarMobles2);
            }
        })

        moblesRecyclerView.adapter = adapter
    }

    private fun observeMoble() {
        moblesViewModel.getMobles(requireContext())!!.observe(viewLifecycleOwner, Observer { llistatMobles ->
            adapter.submitList(llistatMobles)
        })
    }
}