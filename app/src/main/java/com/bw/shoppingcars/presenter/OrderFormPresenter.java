package com.bw.shoppingcars.presenter;

import com.bw.shoppingcars.base.BasePresenter;
import com.bw.shoppingcars.contract.OrderFormContract;
import com.bw.shoppingcars.model.OrderFormModel;
import com.bw.shoppingcars.model.bean.OrderFormBean;

/**
 * DateTime:2020/2/14 0014
 * author:朱贵全(Administrator)
 * function:
 */
public class OrderFormPresenter extends BasePresenter<OrderFormContract.IView> implements OrderFormContract.IPresenter {

    private OrderFormModel orderFormModel;

    @Override
    protected void initModel() {
        orderFormModel = new OrderFormModel();
    }

    @Override
    public void getOrderFormData(int userId, String sessionId, int status, int page, int count) {
        orderFormModel.getOrderFormData(userId, sessionId, status, page, count, new OrderFormContract.IModel.IModelCallBack() {
            @Override
            public void onOrderFormSuccess(OrderFormBean orderFormBean) {
                view.onOrderFormSuccess(orderFormBean);
            }

            @Override
            public void onOrderFormFailure(Throwable throwable) {
                view.onOrderFormFailure(throwable);
            }
        });
    }
}
