package com.qzenn.podcast;

import android.support.test.espresso.Espresso;
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
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withTagValue;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainTest {

    @Rule
    public ActivityTestRule<ActMain> mActivityRule = new ActivityTestRule(ActMain.class);

    @Test
    public void firstTest() {
        onView(withText(R.string.openMediaPlayerButton)).perform(click());
        onView(isRoot()).perform(pressBack());

        onView(withId(R.id.openTwitterFeed)).perform(click());
        onView(isRoot()).perform(pressBack());

        onView(withContentDescription(is(mActivityRule.getActivity().getApplication().getString(R.string.openJabberChatButton)))).perform(click());
        onView(isRoot()).perform(pressBack());

        onView(withTagValue(is((Object)
                mActivityRule.getActivity().getString(R.string.openMediaPlayerButton))))
                .perform(click());
        Espresso.pressBack();

        onView(withText(R.string.openMediaPlayerButton)).check(matches(isDisplayed()));

    }
}
