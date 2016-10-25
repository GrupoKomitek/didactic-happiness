package io.github.epelde.didactichappiness;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by Gorka on 25/10/2016.
 */
public class DidacticTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, DidacticTestApp.class.getName(), context);
    }
}
