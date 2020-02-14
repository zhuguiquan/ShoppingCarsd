package com.bw.shoppingcars.view.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.shoppingcars.R;
import com.bw.shoppingcars.base.BaseFragment;
import com.bw.shoppingcars.contract.OrderFormContract;
import com.bw.shoppingcars.model.bean.OrderFormBean;
import com.bw.shoppingcars.presenter.OrderFormPresenter;
import com.bw.shoppingcars.view.adapter.OrderFromAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFormFragment extends BaseFragment<OrderFormPresenter> implements OrderFormContract.IView {


    @BindView(R.id.recycle)
    RecyclerView recycle;
    private int status;
    List<OrderFormBean.OrderListBean> listBeans=new ArrayList<>();
    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            status = arguments.getInt("status");
        }
        mpresenter.getOrderFormData(27970, "158166535298227970", status, 1, 10);

    }

    @Override
    protected void initView(View inflate) {

    }

    @Override
    protected OrderFormPresenter providePresenter() {
        return new OrderFormPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_order_form;
    }

    public static OrderFormFragment getInstance(int status) {
        OrderFormFragment orderFormFragment = new OrderFormFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("status", status);
        orderFormFragment.setArguments(bundle);
        return orderFormFragment;
    }

    @Override
    public void onOrderFormSuccess(OrderFormBean orderFormBean) {
        Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
        List<OrderFormBean.OrderListBean> orderList = orderFormBean.getOrderList();
        listBeans.addAll(orderList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycle.setLayoutManager(linearLayoutManager);
        OrderFromAdapter orderFromAdapter = new OrderFromAdapter(listBeans);
        recycle.setAdapter(orderFromAdapter);

    }

    @Override
    public void onOrderFormFailure(Throwable throwable) {
        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();

    }
}
