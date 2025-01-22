package com.example.demoandroidsecurepersist.screens.libcounter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import eu.anifantakis.lib.securepersist.PersistManager
import eu.anifantakis.lib.securepersist.compose.mutableStateOf


class LibCounterViewModel(
    persistManager: PersistManager
) : ViewModel() {

    // if key is unspecified, property name becomes the key

    // defaults to EncryptedSharedPreferences and key the property name
    var count1 by persistManager.sharedPrefs.mutableStateOf(1000)
        private set

    // set custom key and storage to DataStorePreferences with Encryption
    var count2 by persistManager.dataStorePrefs.mutableStateOf(
        defaultValue = 2000,
        key = "counter2Key"
    )
        private set

    // key the property name, and storage to Unencrypted DataStorePreferences
    var count3 by persistManager.dataStorePrefs.mutableStateOf(
        defaultValue = 3000,
        encrypted = false
    )
        private set

    fun increment() {
        count1++
        count2++
        count3++
    }
}