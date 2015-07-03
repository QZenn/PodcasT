package com.qzenn.podcast.screen;

import com.qzenn.podcast.R;
import com.qzenn.podcast.util.ScreenBase;
import com.qzenn.podcast.util.Util;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ScrTwitter extends ScreenBase {

    public ScrTwitter() {
        onView(withText(R.string.hello_world)).check(matches(isDisplayed()));
        Util.takeScreenshot();
    }
}
