package com.bw.shoppingcars.view.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.shoppingcars.R;
import com.bw.shoppingcars.base.BaseActivity;
import com.bw.shoppingcars.base.BasePresenter;
import com.bw.shoppingcars.view.fragment.OrderFormFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderFormActivity extends BaseActivity {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
List<Fragment> fragmentList=new ArrayList<>();
List<String>title=new ArrayList<>();
    @Override
    protected void initData() {
        title.add("全部订单");
        title.add("支付");
        title.add("收货");
        title.add("评价");
        title.add("完成");
        //1、构造5个fragment
        OrderFormFragment instance0 = OrderFormFragment.getInstance(0);
        OrderFormFragment instance1 = OrderFormFragment.getInstance(1);
        OrderFormFragment instance2 = OrderFormFragment.getInstance(2);
        OrderFormFragment instance3 = OrderFormFragment.getInstance(3);
        OrderFormFragment instance9 = OrderFormFragment.getInstance(9);
        //2、添加到fragment集合
        fragmentList.add(instance0);
        fragmentList.add(instance1);
        fragmentList.add(instance2);
        fragmentList.add(instance3);
        fragmentList.add(instance9);
        //3、给vp设置适配器
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            //4、给tablayout设置标题
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });
        //5.关联
        tab.setupWithViewPager(vp);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_order_form;
    }


}
