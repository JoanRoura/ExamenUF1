package com.example.examenuf2.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.examenuf2.model.Mobles
import com.example.examenuf2.repository.Repositori

class MoblesViewModel : ViewModel() {

    var moble: LiveData<List<Mobles>>? = null;

    fun newMoble(context: Context, nom: String, preu: Int) {
        val moble = Mobles(nom, preu);
        Repositori.insertMoble(context, moble);
    }

    fun getMobles(context: Context): LiveData<List<Mobles>>? {
        moble = Repositori.getMobles(context);
        return moble
    }

    fun updateMoble(context: Context, nom: String, preu: Int) {
        val moble = Mobles(nom, preu);
        Repositori.updateMoble(context, moble);
    }

    fun deleteMoble(context: Context, nom: String, preu: Int) {
        val moble = Mobles(nom, preu);
        Repositori.deleteMoble(context, moble);
    }


}