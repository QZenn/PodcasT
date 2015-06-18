package com.qzenn.podcast;

import android.support.test.espresso.Espresso;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

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
    public ActivityRule<ActMain> mActivityRule = new ActivityRule(ActMain.class);

    @Test
    public void firstTest() {
//        Solo solo = new Solo(mActivityRule.instrumentation(), mActivityRule.getActivity());
//        Spoon.screenshot(mActivityRule.getActivity(), "Main_Screen");
        onView(withText(R.string.openMediaPlayerButton)).perform(click());
//        Spoon.screenshot(solo.getCurrentActivity(), "Media_Player");
        onView(isRoot()).perform(pressBack());
//        Spoon.screenshot(solo.getCurrentActivity(), "Main_Screen");

        onView(withId(R.id.openTwitterFeed)).perform(click());
//        Spoon.screenshot(solo.getCurrentActivity(), "Twitter_Feed");
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
