package ru.qzenn.radiot;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by QZen on 22/05/15.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainTest {

    @Rule
    public ActivityTestRule<RadiotMainActivity> mActivityRule = new ActivityTestRule(RadiotMainActivity.class);

    @Test
    public void firstTest() {
        onView(withText(R.string.openMediaPlayerButton)).perform(click());
        onView(isRoot()).perform(pressBack());
        onView(withText(R.string.openMediaPlayerButton)).check(matches(isDisplayed()));
    }
}
