package com.qzenn.podcast.screen;

import com.qzenn.podcast.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ScrPlayer {

    public ScrPlayer() {
        onView(withText(R.string.hello_world)).check(matches(isDisplayed()));
    }
}
