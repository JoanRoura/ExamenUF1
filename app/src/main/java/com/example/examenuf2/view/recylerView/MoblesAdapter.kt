package com.example.examenuf2.view.recylerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.examenuf2.R
import com.example.examenuf2.model.Mobles

class MoblesAdapter : ListAdapter<Mobles, MoblesAdapter.MoblesHolder>(DiffCallback()) {

    class MoblesHolder(view: View) : RecyclerView.ViewHolder(view)

    private lateinit var listener: RecyclerClickListener

    fun setItemListener(listener: RecyclerClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoblesHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        val mobleHolder = MoblesHolder(v)


        val moble = mobleHolder.itemView.findViewById<CardView>(R.id.item_recyclerView)
        moble.setOnClickListener {
            listener.onItemClick(mobleHolder.adapterPosition)
        }

        return mobleHolder
    }

    override fun onBindViewHolder(holder: MoblesHolder, position: Int) {
        val currentItem = getItem(position)

        val nom = holder.itemView.findViewById<TextView>(R.id.recyclerViewNomMoble)
        nom.text = currentItem.nom.toString()

        val preu = holder.itemView.findViewById<TextView>(R.id.recyclerViewPreuMoble)
        preu.text = currentItem.preu.toString()

    }

    class DiffCallback : DiffUtil.ItemCallback<Mobles>() {
        override fun areItemsTheSame(oldItem: Mobles, newItem: Mobles) =
            oldItem.nom == newItem.nom

        override fun areContentsTheSame(oldItem: Mobles, newItem: Mobles) =
            oldItem == newItem
    }

}