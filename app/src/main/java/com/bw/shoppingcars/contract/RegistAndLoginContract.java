package com.bw.shoppingcars.contract;

import com.bw.shoppingcars.model.bean.LoginBean;
import com.bw.shoppingcars.model.bean.RegistBean;

/**
 * DateTime:2020/2/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public interface RegistAndLoginContract {
    interface IView{
        void onRegistSuccess(RegistBean registBean);
        void onRegistFailure(Throwable throwable);
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable throwable);

    }
    interface IPresenter{
        void getRegistData(String phone,String pwd);
        void getLoginData(String phone,String pwd);
    }
    interface IModel{
        void getRegistData(String phone,String pwd,IModelCallBack iModelCallBack);
        void getLoginData(String phone,String pwd,IModelCallBack iModelCallBack);
        interface IModelCallBack{
            void onRegistSuccess(RegistBean registBean);
            void onRegistFailure(Throwable throwable);
            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable throwable);

        }
    }
}
