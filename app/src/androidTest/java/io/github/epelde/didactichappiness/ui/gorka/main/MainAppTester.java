package io.github.epelde.didactichappiness.ui.gorka.main;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import javax.inject.Inject;

import io.github.epelde.didactichappiness.DidacticApp;
import io.github.epelde.didactichappiness.R;
import io.github.epelde.didactichappiness.di.component.ApplicationMockComponent;

/**
 * Created by Gorka on 05/10/2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainAppTester {


    private static final String FIRST_CHAR = "a";


    @Rule
    public ActivityTestRule<MainActivity> mGActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void whenStartTypingActivityTest() {

        // Comenzamos a escribir en la caja de texto.
        Espresso.onView(ViewMatchers.withId(R.id.oracle_text_consulta))
                .perform(ViewActions.closeSoftKeyboard(), ViewActions.typeText(FIRST_CHAR), ViewActions.closeSoftKeyboard());

        // Miramos si el texto de bienvenida ha cambiado.
        Espresso.onView(ViewMatchers.withId(R.id.oracle_text_welcome))
                .check(ViewAssertions.matches(ViewMatchers.withText(R.string.text_writing_user)));
    }


}
