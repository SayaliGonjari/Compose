package com.plcoding.navigationdrawercompose.model

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.plcoding.navigationdrawercompose.extension.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class StoreUserData(val context: Context) {
    companion object{
        val USER_NAME_KEY = stringPreferencesKey("user_name")
    }

    val getuserName: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[USER_NAME_KEY] ?: "FirstLast@gmail.com"
    }

    suspend fun saveUserName(name:String){
        context.dataStore.edit { preferences ->
            preferences[USER_NAME_KEY] = name
        }
    }

}