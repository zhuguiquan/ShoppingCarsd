package com.bw.shoppingcars.view.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.shoppingcars.R;
import com.bw.shoppingcars.model.bean.OrderFormBean;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * DateTime:2020/2/14 0014
 * author:朱贵全(Administrator)
 * function:
 */
public class OrderFromAdapter extends RecyclerView.Adapter<OrderFromAdapter.OrderFormViewHolder> {
    private List<OrderFormBean.OrderListBean> listBeans;

    public OrderFromAdapter(List<OrderFormBean.OrderListBean> listBeans) {

        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public OrderFormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_form_item, parent, false);
        return new OrderFormViewHolder(inflate);
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onBindViewHolder(@NonNull OrderFormViewHolder holder, int position) {
        OrderFormBean.OrderListBean orderListBean = listBeans.get(position);
        holder.tvOrderId.setText("订单号："+orderListBean.getOrderId());
        long orderTime = orderListBean.getOrderTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(orderTime);
        holder.tvTime.setText(format);
        int orderStatus = orderListBean.getOrderStatus();

        if(orderStatus ==1){
            holder.btnPayOrReceive.setVisibility(View.VISIBLE);
            holder.btnPayOrReceive.setText("去支付");
        }else if(orderStatus ==2){
            holder.btnPayOrReceive.setVisibility(View.VISIBLE);
            holder.btnPayOrReceive.setText("确认收货");
        }else{
            holder.btnPayOrReceive.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }


    class OrderFormViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_order_id)
        TextView tvOrderId;
        @BindView(R.id.recycler_commidity)
        RecyclerView recyclerCommidity;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.btn_pay_or_receive)
        Button btnPayOrReceive;

        public OrderFormViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
