package com.example.dogssearchengine.ui.Search

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen
import com.example.dogssearchengine.DogSearchActivity
import com.example.dogssearchengine.screens.TestDogSearchScreen

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TestSearchActivityTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(DogSearchActivity::class.java)

    @Test
    fun shouldShowContents_whenLaunchingMoviesActivity() {
        Screen.onScreen<TestDogSearchScreen> {
            content {
                isVisible()
            }
        }
    }

    @Test
    fun testContentItemsRecyclerView() {
        Screen.onScreen<TestDogSearchScreen> {
            dogRecyclerView {
                isVisible()
            }
        }
    }
}