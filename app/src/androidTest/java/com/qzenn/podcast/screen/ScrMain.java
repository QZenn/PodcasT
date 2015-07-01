package com.qzenn.podcast.screen;

import com.qzenn.podcast.R;
import com.qzenn.podcast.util.ScreenBase;
import com.qzenn.podcast.util.Util;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withTagValue;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;

public class ScrMain extends ScreenBase {

    public ScrMain() {
        getSolo().waitForText(getSolo().getString(R.string.openMediaPlayerButton));
        onView(withText(R.string.openMediaPlayerButton)).check(matches(isDisplayed()));
    }

    public static void openPlayer() {
        onView(withText(R.string.openMediaPlayerButton)).perform(click());
        Util.takeScreenshot();
    }

    public static void openChat() {
        onView(withContentDescription(is(getMain().getActivity().getApplication().getString(R.string.openJabberChatButton)))).perform(click());
        Util.takeScreenshot();
    }

    public static void openTwitter() {
        onView(withId(R.id.openTwitterFeed)).perform(click());
        Util.takeScreenshot();
    }

    public static ScrPlayer openPlayerViaTagObject() {
        onView(withTagValue(is((Object)
                getSolo().getCurrentActivity().getString(R.string.openMediaPlayerButton))))
                .perform(click());
        Util.takeScreenshot();
        return new ScrPlayer();
    }
}
