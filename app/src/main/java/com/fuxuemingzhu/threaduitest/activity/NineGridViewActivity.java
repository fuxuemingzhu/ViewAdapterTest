package com.fuxuemingzhu.threaduitest.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fuxuemingzhu.threaduitest.R;
import com.jaeger.ninegridimageview.NineGridImageView;
import com.jaeger.ninegridimageview.NineGridImageViewAdapter;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

public class NineGridViewActivity extends BaseActivity {

    @Bind(R.id.ngiv_nine_grid)
    NineGridImageView<String> nine_grid;


    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private String url = "http://gank.io/api/random/data/福利/8";
    private List<String> urls_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine_grid_view);
        ButterKnife.bind(this);
        initViews();
        initEvents();
    }

    @Override
    protected void initViews() {
        urls_list = new ArrayList<>();
        toolbar.setTitle("NineGridView");
    }

    @Override
    protected void initEvents() {

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Toast.makeText(NineGridViewActivity.this, "网络异常，请稍后重试", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(String response) {
                        if (response == null) {
                            Toast.makeText(NineGridViewActivity.this, "网络异常，请稍后重试", Toast.LENGTH_LONG).show();
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
            urls_list.add(temp.getString("url"));
        }
        Log.i("urls_list", urls_list.toString());
        nine_grid.setAdapter(mAdapter);
        nine_grid.setImagesData(urls_list);
    }

    private NineGridImageViewAdapter<String> mAdapter = new NineGridImageViewAdapter<String>() {
        @Override
        protected void onDisplayImage(Context context, ImageView imageView, String url) {
            Picasso.with(context)
                    .load(url)
                    .into(imageView);
        }

        @Override
        protected ImageView generateImageView(Context context) {
            return super.generateImageView(context);
        }

        @Override
        protected void onItemImageClick(Context context, int index, List list) {
            super.onItemImageClick(context, index, list);
        }

    };

}
