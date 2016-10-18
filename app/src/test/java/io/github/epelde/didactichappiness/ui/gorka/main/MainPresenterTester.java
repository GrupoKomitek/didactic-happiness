package io.github.epelde.didactichappiness.ui.gorka.main;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.github.epelde.didactichappiness.business.IOracleProcessorInteractor;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Gorka on 11/10/2016.
 */

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTester {

    private static final String TEST_QUESTION = "Do I have to commite suicide?";
    private static final int TEST_ANSWER = 1;

    @Mock
    MainContract.MainView mv;
    @Mock
    IOracleProcessorInteractor iopi;

    @Test
    public void getResponseTest(){
        MainPresenter mp = new MainPresenter();
        mp.attachView(mv);
        mp.setOpi(iopi);
        when(iopi.processQuestion(TEST_QUESTION)).thenReturn(TEST_ANSWER);
        mp.oraculoClicked(TEST_QUESTION);
        verify(iopi,atLeastOnce()).processQuestion(TEST_QUESTION);
    }
}
