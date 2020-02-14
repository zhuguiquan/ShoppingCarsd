package com.bw.shoppingcars.presenter;

import com.bw.shoppingcars.base.BasePresenter;
import com.bw.shoppingcars.contract.RegistAndLoginContract;
import com.bw.shoppingcars.model.RegistAndLoginModel;
import com.bw.shoppingcars.model.bean.LoginBean;
import com.bw.shoppingcars.model.bean.RegistBean;

/**
 * DateTime:2020/2/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public class RegistAndLoginPresenter extends BasePresenter<RegistAndLoginContract.IView> implements RegistAndLoginContract.IPresenter {

    private RegistAndLoginModel registAndLoginModel;

    @Override
    protected void initModel() {
        registAndLoginModel = new RegistAndLoginModel();
    }

    @Override
    public void getRegistData(String phone, String pwd) {
        registAndLoginModel.getRegistData(phone, pwd, new RegistAndLoginContract.IModel.IModelCallBack() {
            @Override
            public void onRegistSuccess(RegistBean registBean) {
                view.onRegistSuccess(registBean);
            }

            @Override
            public void onRegistFailure(Throwable throwable) {
                view.onRegistFailure(throwable);
            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);

            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);

            }
        });

    }

    @Override
    public void getLoginData(String phone, String pwd) {
        registAndLoginModel.getLoginData(phone, pwd, new RegistAndLoginContract.IModel.IModelCallBack() {
            @Override
            public void onRegistSuccess(RegistBean registBean) {
                view.onRegistSuccess(registBean);
            }

            @Override
            public void onRegistFailure(Throwable throwable) {
                view.onRegistFailure(throwable);
            }

            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                view.onLoginSuccess(loginBean);

            }

            @Override
            public void onLoginFailure(Throwable throwable) {
                view.onLoginFailure(throwable);

            }
        });

    }
}
