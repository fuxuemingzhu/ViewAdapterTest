package com.fuxuemingzhu.threaduitest.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fuxuemingzhu.threaduitest.R;
import com.fuxuemingzhu.threaduitest.adapter.NormalRecyclerViewAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class RecyclerViewActivity extends BaseActivity {

    @Bind(R.id.rv_recycleview)
    RecyclerView rv_recyclerview;

    private List<String> urls;
    private String url = "http://gank.io/api/random/data/福利/20";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        initViews();
        initEvents();
    }

    @Override
    protected void initViews() {
        rv_recyclerview.setLayoutManager(new LinearLayoutManager(this));//这里用线性显示 类似于listview
        urls = new ArrayList<>();
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(RecyclerViewActivity.this, "网络异常，请稍后重试", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(String response) {
                        if (response == null) {
                            Toast.makeText(RecyclerViewActivity.this, "网络异常，请稍后重试", Toast.LENGTH_LONG).show();
                            return;
                        }
                        display(response);
                    }
                });


    }

    private void display(String response) {
        JSONObject result = JSONObject.parseObject(response);
        JSONArray jsonArray = result.getJSONArray("results");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject temp = jsonArray.getJSONObject(i);
            urls.add(temp.getString("url"));
        }
        Log.i("urls", urls.toString());
        rv_recyclerview.setAdapter(new NormalRecyclerViewAdapter(this, urls));
    }

    @Override
    protected void initEvents() {

    }
}
