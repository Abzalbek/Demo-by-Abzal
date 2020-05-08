package com.example.abzalbekissabekov.sunnyvale_app;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private ViewInteraction editText = onView(withId(R.id.editText));
    private ViewInteraction button = onView(withId(R.id.button));
    private ViewInteraction textView = onView(withId(R.id.textView));

    String helloWorld = "Hello Sunnyvale!";

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * Assesrtion existing view and widgets
     */
    @Test
    public void assertionTest() {
        editText.check(matches(isCompletelyDisplayed()));
        button.check(matches(isCompletelyDisplayed()));
        textView.check(matches(not(isDisplayed())));
    }

    /**
     * Action test
     */
    // gggg
    @Test
    public void actionTest() {
        editText.perform(clearText());
        editText.perform(typeText(helloWorld));
        closeSoftKeyboard();
        button.perform(click());
        textView.check(matches(allOf(isDisplayed(), withText(helloWorld))));
    }
}
