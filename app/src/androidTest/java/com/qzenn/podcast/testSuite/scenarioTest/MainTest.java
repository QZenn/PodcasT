package com.qzenn.podcast.testSuite.scenarioTest;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.test.suitebuilder.annotation.LargeTest;

import com.qzenn.podcast.R;
import com.qzenn.podcast.screen.ScrMain;
import com.qzenn.podcast.util.ScreenBase;
import com.qzenn.podcast.util.Util;

import android.support.test.uiautomator.UiDevice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainTest extends ScreenBase {

    @Before
    @Override
    public void setUp() {
        super.setUp();
    }

    @After
    @Override
    public void tearDown() {
        super.tearDown();
    }

    @Test
    public void firstTest() {

        new ScrMain();

        ScrMain.openPlayer();
        Util.back();

        ScrMain.openTwitter();
        Util.back();

        ScrMain.openChat();
        Util.back();

        ScrMain.openPlayerViaTagObject();
        Util.back();

        new ScrMain();
    }

    @Test
    public void testResumeActivty() throws UiObjectNotFoundException {
        new ScrMain();
        onView(withId(R.id.editText)).perform(clearText(), typeText("reaaly?"));
        Util.takeScreenshot();

        Util.toast("I'll be back!");

        UiDevice mDevice;
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//        mDevice = UiDevice.getInstance(getMain().getInstrumentation());
        mDevice.pressHome();
        mDevice.wait(Until.hasObject(By.pkg(getLauncherPackageName()).depth(0)), 5000);

        Util.toast("Do you hear me?");

        mDevice.findObject(new UiSelector().descriptionContains("Apps")).click();

        // Launch the blueprint app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage("com.qzenn.podcast");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);//resume
//       Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);
        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg("com.qzenn.podcast").depth(0)), 5000);

        Util.toast("I'm back!!!");
        onView(withId(R.id.editText)).check(matches(withText("reaaly?")));
        new ScrMain();
    }

    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }
}
