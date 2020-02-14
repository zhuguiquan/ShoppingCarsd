package com.bw.shoppingcars.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.bw.shoppingcars.R;
import com.bw.shoppingcars.base.BaseActivity;
import com.bw.shoppingcars.contract.RegistAndLoginContract;
import com.bw.shoppingcars.model.bean.LoginBean;
import com.bw.shoppingcars.model.bean.RegistBean;
import com.bw.shoppingcars.presenter.RegistAndLoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<RegistAndLoginPresenter> implements RegistAndLoginContract.IView {


    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_pwd)
    EditText edtPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected RegistAndLoginPresenter providePresenter() {
        return new RegistAndLoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onRegistSuccess(RegistBean registBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegistFailure(Throwable throwable) {
        Toast.makeText(this, "注册失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    startActivity(new Intent(MainActivity.this,OrderFormActivity.class));
    finish();
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        Toast.makeText(this, "登录失败"+throwable.getMessage(), Toast.LENGTH_SHORT).show();

    }


    @OnClick({R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String phone1 = edtPhone.getText().toString();
                String pwd1 = edtPwd.getText().toString();
                String s = EncryptUtils.encryptMD5ToString(pwd1);
                String substring1 = s.substring(0, 6);
                mpresenter.getLoginData(phone1,substring1);
                break;
            case R.id.btn_register:
                String phone2 = edtPhone.getText().toString();
                String pwd2 = edtPwd.getText().toString();
                String s2 = EncryptUtils.encryptMD5ToString(pwd2);
                String substring = s2.substring(0, 6);
                mpresenter.getRegistData(phone2,substring);
                break;
        }
    }
}
