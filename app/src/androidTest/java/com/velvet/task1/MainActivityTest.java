package com.velvet.task1;

import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;


import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityActivityScenarioRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void testUserInputScenario() {

        String[] input = new String[]{"London","Manchester", "Lancaster", "Marsh St., Innsmouth", "11.11.2021", "X Æ A-12","Mongolia"};
        String[] ignored = new String[]{"n","ae", "Lr", ".,", "1", "12",""};
        String[] output = new String[]{"odnoLn","ratshecneM", "Letsacnar", "hsraM tS., htuomsnnI", "1121102..1", "X Æ -A12","ailognoM"};
        for (int i = 0; i < 6; i++) {
            Espresso.onView(withId(R.id.anagramInput)).perform(replaceText(input[i]));
            Espresso.onView(withId(R.id.anagramIgnore)).perform(replaceText(ignored[i]));
            Espresso.onView(withId(R.id.anagramOutput)).check(matches(withText(output[i])));
        }
    }
}