package com.example.assignment2cljm

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertTrue

@RunWith(AndroidJUnit4::class)
class MyAppUiTest {

    private val appPackage = "com.example.assignment2cljm"
    private val launchTimeout = 5000L
    private lateinit var device: UiDevice

    @Before
    fun setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
    }

    @Test
    fun assignment5Test() {
        device.wait(Until.hasObject(By.pkg(appPackage).depth(0)), launchTimeout)
        device.findObject(By.text("assignment2CLJM")).click()
        
        device.wait(Until.hasObject(By.text("Start Activity Explicitly")), launchTimeout)
        device.findObject(By.text("Start Activity Explicitly")).click()
        
        device.wait(Until.hasObject(By.text("1) Device Fragmentation")), launchTimeout)
        assertTrue(device.hasObject(By.text("1) Device Fragmentation")))
    }
}
