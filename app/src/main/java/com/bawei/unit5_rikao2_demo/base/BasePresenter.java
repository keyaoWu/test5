package com.bawei.unit5_rikao2_demo.base;

import com.bawei.unit5_rikao2_demo.contract.Contract;

import java.lang.ref.WeakReference;

/**
 * 功能：BasePresenter类
 * 作者：武柯耀
 * 当前日期：2019/12/2
 * 当前时间：8:46
 */
public abstract class BasePresenter <V extends Contract.IView> implements Contract.Presenter {
    private WeakReference<V> mWeak;

    public BasePresenter() {
        initModel();
    }

    abstract protected void initModel();

    public void onAttachView(V view){
        mWeak = new WeakReference<>(view);
    }

    public void onDeattchView(){
        if (mWeak!=null){
            mWeak.clear();
            mWeak=null;
        }
    }

    public V getView(){
        return  mWeak.get();
    }
}
