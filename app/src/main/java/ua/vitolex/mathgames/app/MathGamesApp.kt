package ua.vitolex.mathgames.app

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.HiltAndroidApp
import io.paperdb.Paper

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = " settings ")

@HiltAndroidApp
class MathGamesApp : Application(){

    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }
}
