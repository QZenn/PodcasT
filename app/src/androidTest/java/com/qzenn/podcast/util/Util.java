package com.qzenn.podcast.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.qzenn.podcast.data.Property;
import com.squareup.spoon.Spoon;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;

public class Util extends ScreenBase {

    private static final String LOG_TAG = Property.LOG_TAG;

    public static void log(final String message) {
        getMain().getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.i(LOG_TAG, message);
                    }
                }
        );
    }

    public static void toast(final String message) {
        getMain().getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getMain().getActivity().getApplicationContext(),
                                message, Toast.LENGTH_SHORT)
                                .show();
                    }
                }
        );
    }

    public static void openScreen(final Class<? extends Activity> activity) {
        getMain().getActivity().runOnUiThread(
                new Runnable() {
                    @Override
                    public void run() {
                        getMain().getActivity().startActivity(new Intent(getMain().getActivity(),
                                activity));
                    }
                }
        );
    }

    public static void takeScreenshot() {
        takeScreenshot(getSolo().getCurrentActivity().getLocalClassName());
    }

    public static void takeScreenshot(String title) {
        if (notEmulator()) {
            Spoon.screenshot(getSolo().getCurrentActivity(), title);
        }
    }

    private static boolean notEmulator() {
        return !Build.BRAND.contains("generic");
    }

    public static void back() {
        onView(isRoot()).perform(pressBack());
        takeScreenshot();
    }
}
