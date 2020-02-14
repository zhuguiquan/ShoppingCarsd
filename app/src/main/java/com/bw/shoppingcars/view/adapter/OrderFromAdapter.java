package com.bw.shoppingcars.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.shoppingcars.model.bean.OrderFormBean;

import java.util.List;

/**
 * DateTime:2020/2/14 0014
 * author:朱贵全(Administrator)
 * function:
 */
public class OrderFromAdapter  extends RecyclerView.Adapter<OrderFromAdapter.OrderFormViewHolder>{
    private List<OrderFormBean.OrderListBean> listBeans;

    public OrderFromAdapter(List<OrderFormBean.OrderListBean> listBeans) {

        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public OrderFormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderFormViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }



    class OrderFormViewHolder extends RecyclerView.ViewHolder {
        public OrderFormViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
