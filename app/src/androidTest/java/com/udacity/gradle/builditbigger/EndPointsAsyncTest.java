package com.udacity.gradle.builditbigger;

import android.content.Context;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by SegunFrancis
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class EndPointsAsyncTest {

    private Context appContext;

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void useAppContext() {
        assertEquals("com.udacity.gradle.builditbigger.free", appContext.getPackageName());
    }

    @Test
    public void testEndpointTask() throws ExecutionException, InterruptedException {
        onView(withId(R.id.joke_button)).perform(click());
        String result = new EndPointsAsync().execute(rule.getActivity()).get();
        assertNotNull(result);
        assertNotEquals(result, "error");
        assertTrue(result.length() > 0);
    }
}