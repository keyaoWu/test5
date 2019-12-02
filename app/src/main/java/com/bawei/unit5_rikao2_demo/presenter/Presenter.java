package com.bawei.unit5_rikao2_demo.presenter;

import com.bawei.unit5_rikao2_demo.base.BasePresenter;
import com.bawei.unit5_rikao2_demo.contract.Contract;
import com.bawei.unit5_rikao2_demo.model.Model;

/**
 * 功能：Presenter类
 * 作者：武柯耀
 * 当前日期：2019/12/2
 * 当前时间：8:46
 */
public class Presenter extends BasePresenter {
    private Contract.Model model;

    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void onStartRequest(String url) {
        model.getInfo(url, new Contract.MyCallBack() {
            @Override
            public void onSuccess(String json) {
                getView().onSuccess(json);
            }

            @Override
            public void onError(String error) {
                getView().onError(error);
            }
        });
    }
}
