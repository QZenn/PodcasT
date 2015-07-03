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
        Util.takeScreenshot();
    }

    public static ScrPlayer openPlayer() {
        Util.log("Open Player");
        onView(withText(R.string.openMediaPlayerButton)).perform(click());
        return new ScrPlayer();
    }

    public static ScrChat openChat() {
        Util.log("Open Chat");
        onView(withContentDescription(is(getMain().getActivity().getApplication().getString(R.string.openJabberChatButton)))).perform(click());
        return new ScrChat();
    }

    public static ScrTwitter openTwitter() {
        Util.log("Open Twitter");
        onView(withId(R.id.openTwitterFeed)).perform(click());
        return new ScrTwitter();
    }

    public static ScrPlayer openPlayerViaTagObject() {
        Util.log("Open Player2");
        onView(withTagValue(is((Object)
                getSolo().getCurrentActivity().getString(R.string.openMediaPlayerButton))))
                .perform(click());
        return new ScrPlayer();
    }
}
