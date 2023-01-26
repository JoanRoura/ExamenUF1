package com.example.examenuf2.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.examenuf2.database.MoblesDatabase
import com.example.examenuf2.model.Mobles
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repositori {
    companion object {

        var moblesDatabase: MoblesDatabase? = null

        var moble: LiveData<List<Mobles>>? = null

        fun initializeDB(context: Context) : MoblesDatabase {
            return MoblesDatabase.getDatabase(context)
        }

        fun insertMoble(context: Context, moble: Mobles) {

            moblesDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                moblesDatabase!!.motorDao().addMoble(moble)
            }
        }

        fun getMobles(context: Context): LiveData<List<Mobles>>? {

            moblesDatabase = initializeDB(context)

            moble = moblesDatabase!!.motorDao().getMoblesByNom()

            return moble
        }

        fun updateMoble(context: Context, moble: Mobles) {
            moblesDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                moblesDatabase!!.motorDao().updateMoble(moble)
            }
        }

        fun deleteMoble(context: Context, moble: Mobles ) {
            moblesDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                moblesDatabase!!.motorDao().deleteMoble(moble)
            }
        }

    }
}