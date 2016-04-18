package com.qzenn.podcast.util;

import android.support.test.InstrumentationRegistry;

import com.qzenn.podcast.ActMain;
import com.robotium.solo.Solo;

public class ScreenBase {

    private static ActivityRule<ActMain> main;
    private static Solo solo;

    public static ActivityRule<ActMain> getMain() {
        synchronized (ActivityRule.class) {
            if (main == null) {
                main = new ActivityRule<>(ActMain.class);
            }
        }
        return main;
    }

    public static Solo getSolo() {
        synchronized (Solo.class) {
            if (solo == null) {
                solo = new Solo(InstrumentationRegistry.getInstrumentation(), main.getActivity());
            }
        }
        return solo;
    }

    public void setUp() {
        Util.log("Start application");
        getMain();
        getSolo();
        getSolo().unlockScreen();
    }

    public void tearDown() {
        Util.log("Close application");
        getSolo().finishOpenedActivities();
        solo = null;
        main = null;
    }
}
