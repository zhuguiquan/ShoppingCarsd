package com.bw.shoppingcars.contract;

import com.bw.shoppingcars.model.bean.OrderFormBean;

/**
 * DateTime:2020/2/14 0014
 * author:朱贵全(Administrator)
 * function:
 */
public interface OrderFormContract {
    interface  IView{
        void onOrderFormSuccess(OrderFormBean orderFormBean);
        void onOrderFormFailure(Throwable throwable);

    }
    interface  IPresenter{
        void getOrderFormData(int userId, String sessionId, int status, int page, int count );

    }
    interface  IModel{
        void getOrderFormData(int userId, String sessionId, int status, int page, int count ,IModelCallBack iModelCallBack);
        interface  IModelCallBack{
            void onOrderFormSuccess(OrderFormBean orderFormBean);
            void onOrderFormFailure(Throwable throwable);

        }
    }

}
