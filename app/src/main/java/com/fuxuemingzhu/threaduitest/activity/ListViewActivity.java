package com.fuxuemingzhu.threaduitest.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fuxuemingzhu.threaduitest.R;
import com.fuxuemingzhu.threaduitest.adapter.ListViewAdapter;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class ListViewActivity extends BaseActivity {

    private static final String TAG = "ListViewActivity";

    private List<String> urls;

    private String url = "http://gank.io/api/random/data/福利/20";

    @Bind(R.id.content)
    ListView content;


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listview);
        ButterKnife.bind(this);

        initViews();
        initEvents();

        urls = new ArrayList<>();
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(ListViewActivity.this, "网络异常，请稍后重试", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(String response) {
                        if (response == null) {
                            Toast.makeText(ListViewActivity.this, "网络异常，请稍后重试", Toast.LENGTH_LONG).show();
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
        adapter = new ListViewAdapter(ListViewActivity.this, urls);
        Log.i("urls", urls.toString());
        content.setAdapter(adapter);
    }

    @Override
    protected void initViews() {
        toolbar.setTitle("ListView");
    }

    @Override
    protected void initEvents() {

    }

}
