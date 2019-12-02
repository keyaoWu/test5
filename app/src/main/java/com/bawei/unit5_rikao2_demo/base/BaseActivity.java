package com.bawei.unit5_rikao2_demo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.unit5_rikao2_demo.contract.Contract;

/**
 * 功能：BaseActivity类
 * 作者：武柯耀
 * 当前日期：2019/12/2
 * 当前时间：8:49
 */
public abstract class BaseActivity <P extends BasePresenter> extends AppCompatActivity implements Contract.IView {
    public P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (providerLayoutId()!=0){
            setContentView(providerLayoutId());
            initView();
            initData();
            mPresenter = initPresenter();
            if (mPresenter!=null){
                mPresenter.onAttachView(this);
            }
            startCoding();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.onDeattchView();
        }
    }

    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int providerLayoutId();
}
