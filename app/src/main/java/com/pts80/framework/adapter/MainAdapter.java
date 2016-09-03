package com.pts80.framework.adapter;

import android.content.Context;

import com.pts80.framework.demo.R;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

/**
 * MainActivity的Adapter
 * Created by VichanHo on 2016/9/3.
 */
public class MainAdapter extends CommonAdapter<String> {
    public MainAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder viewHolder, String title, int position) {
        viewHolder.setText(R.id.tv_title, title);
    }
}
