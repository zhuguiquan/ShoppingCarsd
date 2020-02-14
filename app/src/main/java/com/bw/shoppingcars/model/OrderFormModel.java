package com.bw.shoppingcars.model;

import com.bw.shoppingcars.contract.OrderFormContract;
import com.bw.shoppingcars.model.bean.OrderFormBean;
import com.bw.shoppingcars.util.NetUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * DateTime:2020/2/14 0014
 * author:朱贵全(Administrator)
 * function:
 */
public class OrderFormModel implements OrderFormContract.IModel {
    @Override
    public void getOrderFormData(int userId, String sessionId, int status, int page, int count, IModelCallBack iModelCallBack) {
        NetUtil.getInstance().getApi().getOrderData(userId,sessionId,status,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OrderFormBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OrderFormBean orderFormBean) {
                        if ("0000".equals(orderFormBean.getStatus())) {
                            iModelCallBack.onOrderFormSuccess(orderFormBean);
                        }else{
                            iModelCallBack.onOrderFormFailure(new Throwable(orderFormBean.getMessage()));
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        iModelCallBack.onOrderFormFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
