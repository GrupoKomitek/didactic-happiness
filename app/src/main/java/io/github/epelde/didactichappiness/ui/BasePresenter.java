package io.github.epelde.didactichappiness.ui;


/**
 * Created by Gorka on 27/09/2016.
 *
 * Base Presenter
 */
public abstract class BasePresenter<T>  {

    public T view;

    public BasePresenter(T view){
        attachView(view);
    }

    /**
     * Attaches the related view
     * @param view
     */
    public void attachView(T view){
        this.view = view;
    }

    /**
     * Detaches the related view
     */
    public void detachView(){
        this.view=null;
    };
}
