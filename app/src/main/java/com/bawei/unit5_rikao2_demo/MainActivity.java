package com.bawei.unit5_rikao2_demo;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.unit5_rikao2_demo.base.BaseActivity;
import com.bawei.unit5_rikao2_demo.base.BasePresenter;
import com.bawei.unit5_rikao2_demo.bean.Bean;
import com.bawei.unit5_rikao2_demo.presenter.Presenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.name)
    TextView name;
     String url = "http://172.17.8.100/small/commodity/v1/bannerShow";
     private List<Bean.ResultBean> mList = new ArrayList<>();


    @Override
    protected void startCoding() {
        mPresenter.onStartRequest(url);

    }

    @Override
    protected BasePresenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initView() {

    }

    @Override
    protected int providerLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(String json) {
        List<Bean.ResultBean> result = new Gson().fromJson(json, Bean.class).getResult();
        mList.addAll(result);

        Toast.makeText(this, ""+mList, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String error) {

    }


}
