package com.bw.shoppingcars.base;

/**
 * DateTime:2020/2/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public abstract class BasePresenter<V> {
    protected V view;

    public void attach(V view) {
        this.view = view;
    }
    public void detach(){
        view=null;
    }

    public BasePresenter() {
      initModel();
    }

    protected abstract void initModel();
}
