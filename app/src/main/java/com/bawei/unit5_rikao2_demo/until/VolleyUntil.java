package com.bawei.unit5_rikao2_demo.until;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.unit5_rikao2_demo.app.MyApp;

/**
 * 功能：VolleyUntil类
 * 作者：武柯耀
 * 当前日期：2019/12/2
 * 当前时间：8:39
 */
public class VolleyUntil {

    private final RequestQueue queue;

    private VolleyUntil() {
        queue = Volley.newRequestQueue(MyApp.mContext);
    }

    private static class VolleyHolder{
        static VolleyUntil volleyUntil = new VolleyUntil();
    }

    public static VolleyUntil getInstance() {
        return VolleyHolder.volleyUntil;
    }

//封装get请求
    public void getInfo(String url, final VolleyCallBack volleyCallBack){
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               volleyCallBack.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallBack.onError(error.getMessage());
            }
        });
        queue.add(request);
    }
    //封装接口
    public interface VolleyCallBack{
        void onSuccess(String json);
        void onError(String error);
    }
}
