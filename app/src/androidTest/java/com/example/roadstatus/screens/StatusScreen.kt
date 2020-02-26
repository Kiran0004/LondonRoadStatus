package com.example.roadstatus.screens

import android.support.test.espresso.matcher.ViewMatchers.withId
import android.view.View
import com.agoda.kakao.*
import com.example.roadstatus.R
import kotlinx.android.synthetic.main.activity_main.*
import org.hamcrest.Matcher

class StatusScreen : Screen<StatusScreen>() {

    val roadStatusName = KTextView { withId(R.id.textView_date) }
}
