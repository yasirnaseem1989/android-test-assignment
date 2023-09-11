package com.example.shacklehotelbuddy

import org.junit.Test
import org.koin.android.test.verify.verify
import org.koin.test.KoinTest

class CheckModulesTest : KoinTest {

    @Test
    fun checkAllModules() {
        searchHotelsModule.verify()
    }
}