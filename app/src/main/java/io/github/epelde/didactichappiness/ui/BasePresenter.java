package io.github.epelde.didactichappiness.ui;

import android.view.View;

/**
 * Created by Gorka on 27/09/2016.
 */
public abstract class BasePresenter<T>  {

    public T view;

    void attachView(T view){
        this.view = view;
    }
    void detachView(){
        this.view=null;
    };
}
