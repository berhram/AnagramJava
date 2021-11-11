package com.velvet.task1;

import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;


import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    public String anagramInputTest = "Brooklyn";
    public String anagramIgnoreTest = "l";
    public String anagramOutputTest = "nykoolrB";

    @Test
    public void testUserInputScenario() {
        Espresso.onView(withId(R.id.anagramInput)).perform(typeText(anagramInputTest));
        Espresso.onView(withId(R.id.anagramIgnore)).perform(typeText(anagramIgnoreTest));
        Espresso.onView(withId(R.id.anagramOutput)).check(matches(withText(anagramOutputTest)));
    }
}