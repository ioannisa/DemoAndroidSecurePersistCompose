package com.example.demoandroidsecurepersist.screens.libcounter

import KVault
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import eu.anifantakis.kvault.compose.mutableStateOf
import eu.anifantakis.lib.securepersist.PersistManager
import eu.anifantakis.lib.securepersist.compose.mutableStateOf
import invoke


class LibCounterViewModel(
    persistManager: PersistManager,
    kvault: KVault
) : ViewModel() {

    // if key is unspecified, property name becomes the key

    // defaults to EncryptedSharedPreferences and key the property name
    var count1 by mutableIntStateOf(1000)
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


    var count4 by kvault.mutableStateOf(
        defaultValue = 4000
    )
        private set

    var count5 by kvault(10)
    var count6 by kvault(20)

    init {
        println("count 5 at startup: $count5")
        println("count 6 at startup: $count6")
    }

    fun increment() {
        println("count 5 before increment: $count5")
        println("count 6 before increment: $count6")

        count1++
        count2++
        count3++
        count4++
        count5++
        count6++
    }

    var countWithoutState by persistManager.sharedPrefs.preference(0)

    init {
        println(countWithoutState)
        countWithoutState += 100
        println(countWithoutState)
    }
}