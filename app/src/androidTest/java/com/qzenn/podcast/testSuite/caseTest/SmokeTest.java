package com.qzenn.podcast.testSuite.caseTest;

import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.qzenn.podcast.screen.ScrMain;
import com.qzenn.podcast.util.ScreenBase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SmokeTest extends ScreenBase {

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
    public void launchTest() {
        new ScrMain();
    }
}
