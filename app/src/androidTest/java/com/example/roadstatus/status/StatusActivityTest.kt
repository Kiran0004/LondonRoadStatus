package com.example.roadstatus.status

import android.support.test.rule.ActivityTestRule
import com.example.roadstatus.screens.StatusScreen
import org.junit.Rule
import org.junit.Test

class StatusActivityTest {

    @JvmField
    @Rule
    val testRule = ActivityTestRule<StatusActivity>(StatusActivity::class.java)

    private val statusScreen = StatusScreen()

    @Test
    fun textViewShouldBeDisplayedCorrectly() {
        statusScreen.roadStatusName {
            hasText("Road Status Checker") }
                }
            }



