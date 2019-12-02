package com.bawei.unit5_rikao2_demo.contract;

/**
 * 功能：Contract类
 * 作者：武柯耀
 * 当前日期：2019/12/2
 * 当前时间：8:44
 */
public interface Contract {
    interface Model{
        void getInfo(String url,MyCallBack myCallBack);
    }

    interface IView{
        void onSuccess(String json);
        void onError(String error);
    }

    interface Presenter{
        void onStartRequest(String url);
    }
    //封装接口
    interface MyCallBack{
        void onSuccess(String json);
        void onError(String error);
    }
}

