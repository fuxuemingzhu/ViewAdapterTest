/*
 * Copyright 2015 XiNGRZ <chenxingyu92@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fuxuemingzhu.threaduitest.adapter;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.fuxuemingzhu.threaduitest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private final Context context;
    private final LayoutInflater inflater;
    private List<String> urls;

    public ListViewAdapter(Context context, List<String> urls) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.urls = urls;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int i) {
        return urls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        view = inflater.inflate(
                R.layout.item_image, null);
        viewHolder = new ViewHolder();
        viewHolder.imageView = (ImageView) view.findViewById(R.id.picture);
        String url = urls.get(i);

        Log.i("url", url);

        Picasso.with(context)
                .load(url)
                .into(viewHolder.imageView);

        ViewCompat.setTransitionName(viewHolder.imageView, url);
        return view;
    }


    public class ViewHolder {

        public ImageView imageView;


    }

}
