package com.example.dogssearchengine.screens

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.common.views.KView
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.example.dogssearchengine.R
import org.hamcrest.Matcher

open class TestDogSearchScreen : Screen<TestDogSearchScreen>(){
    val content: KView = KView { withId(R.id.content) }

    val dogRecyclerView: KRecyclerView =
        KRecyclerView({withId(R.id.recycler_view)} , itemTypeBuilder = {
        itemType(::MainItem)

        })

        class MainItem(parent: Matcher<View>) : KRecyclerItem<MainItem>(parent) {

            val image = KImageView(parent) { withId(R.id.image_view) }
            val textViewUserName = KImageView(parent) { withId(R.id.text_view_user_name) }
            val textViewLikes = KImageView(parent) { withId(R.id.text_view_likes) }


        }
    }

