package io.github.epelde.didactichappiness.ui.gorka.main;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.github.epelde.didactichappiness.R;

/**
 * Created by Gorka on 05/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTester {

    private static final String FIRST_CHAR = "a";

    @Rule
    public ActivityTestRule<MainActivity> mGActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void whenStartTypingTest() {

        // Comenzamos a escribir en la caja de texto.
        Espresso.onView(ViewMatchers.withId(R.id.oracle_text_consulta))
                .perform(ViewActions.closeSoftKeyboard(), ViewActions.typeText(FIRST_CHAR), ViewActions.closeSoftKeyboard());

        // Miramos si el texto de bienvenida ha cambiado.
        Espresso.onView(ViewMatchers.withId(R.id.oracle_text_welcome))
                .check(ViewAssertions.matches(ViewMatchers.withText(R.string.text_writing_user)));
    }
}
