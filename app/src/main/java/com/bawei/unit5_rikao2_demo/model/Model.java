package com.bawei.unit5_rikao2_demo.model;

import com.bawei.unit5_rikao2_demo.contract.Contract;
import com.bawei.unit5_rikao2_demo.until.VolleyUntil;

/**
 * 功能：Model类
 * 作者：武柯耀
 * 当前日期：2019/12/2
 * 当前时间：8:46
 */
public class Model implements Contract.Model {
    @Override
    public void getInfo(String url, final Contract.MyCallBack myCallBack) {
        VolleyUntil.getInstance().getInfo(url, new VolleyUntil.VolleyCallBack() {
            @Override
            public void onSuccess(String json) {
                myCallBack.onSuccess(json);
            }

            @Override
            public void onError(String error) {
                myCallBack.onError(error);
            }
        });
    }
}
