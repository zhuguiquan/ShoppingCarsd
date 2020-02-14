package com.bw.shoppingcars;

import com.bw.shoppingcars.model.bean.LoginBean;
import com.bw.shoppingcars.model.bean.OrderFormBean;
import com.bw.shoppingcars.model.bean.RegistBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * DateTime:2020/2/13 0013
 * author:朱贵全(Administrator)
 * function:
 */
public interface Api {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegistBean>getRegistData(@Field("phone") String phone,@Field("pwd") String pwd);
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginBean>getLoginData(@Field("phone") String phone, @Field("pwd") String pwd);
    @GET("small/order/verify/v1/findOrderListByStatus")
    Observable<OrderFormBean>getOrderData(@Header("userId") int userId,@Header("sessionId") String sessionId,
                                          @Query("status") int status,
                                          @Query("page") int page, @Query("count") int count);
}
