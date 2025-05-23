package com.example.demoandroidsecurepersist.di

import com.example.demoandroidsecurepersist.screens.libcounter.LibCounterViewModel
import eu.anifantakis.lib.kvault.KVault
import eu.anifantakis.lib.securepersist.PersistManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module


val libraryModule = module {
    viewModelOf(::LibCounterViewModel)

    single<PersistManager> {
        PersistManager(androidContext())
    }

    single<KVault>{
        KVault(androidContext())
    }
}