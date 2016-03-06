package com.fuxuemingzhu.threaduitest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fuxuemingzhu.threaduitest.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 包名：com.fuxuemingzhu.threaduitest.adapter
 * 类描述：
 * 创建人：fuxuemingzhu
 * 邮箱：fuxuemingzhu@163.com
 * 创建时间：2016/3/6 15:56
 * <p/>
 * 修改人：fuxuemingzhu
 * 修改时间：2016/3/6 15:56
 * 修改备注：
 *
 * @version 1.0
 */
public class NormalRecyclerViewAdapter extends RecyclerView.Adapter<NormalRecyclerViewAdapter.NormalImageHolder> {
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<String> list;

    public NormalRecyclerViewAdapter(Context context, List<String> urls) {
        this.list = urls;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public NormalImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalImageHolder(mLayoutInflater.inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(NormalImageHolder holder, int position) {
        Picasso.with(mContext)
                .load(list.get(position))
                .into(holder.mPicture);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class NormalImageHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.picture)
        ImageView mPicture;

        NormalImageHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
                }
            });
        }
    }
}