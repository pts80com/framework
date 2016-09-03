/*
* Copyright (C) 2014 Vincent Mi
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.pts80.framework.demo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.TextView;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

public class PicassoFragment extends Fragment {

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_rounded, container, false);

    PicassoAdapter adapter = new PicassoAdapter(getActivity());
    ((ListView) view.findViewById(R.id.main_list)).setAdapter(adapter);

    adapter.add(new PicassoItem("https://img.alicdn.com/tps/TB1EiFqNXXXXXbsXFXXXXXXXXXX-520-280.jpg", ScaleType.CENTER));
    adapter.add(new PicassoItem("https://aecpm.alicdn.com/simba/img/TB17sn0MVXXXXc8XpXXSutbFXXX.jpg", ScaleType.CENTER_CROP));
    adapter.add(new PicassoItem("https://aecpm.alicdn.com/tps/i1/TB1r4h8JXXXXXXoXXXXvKyzTVXX-520-280.jpg", ScaleType.CENTER_INSIDE));
    adapter.add(new PicassoItem("https://aecpm.alicdn.com/tps/i2/TB10vPXKpXXXXacXXXXvKyzTVXX-520-280.jpg", ScaleType.FIT_CENTER));
    adapter.add(new PicassoItem("https://img.alicdn.com/tps/TB1gIpyNXXXXXcuXFXXXXXXXXXX-520-280.jpg", ScaleType.FIT_END));
    adapter.add(new PicassoItem("http://img11.360buyimg.com/da/jfs/t3088/76/1203867157/117483/49bef4e8/57c7ec02N2181e00f.jpg", ScaleType.FIT_START));
    adapter.add(new PicassoItem("http://img30.360buyimg.com/da/jfs/t3109/267/1065110986/100229/2d3166f/57c63cccNbc26bd85.jpg", ScaleType.FIT_XY));

    return view;
  }

  static class PicassoItem {
    final String mUrl;

    final ScaleType mScaleType;
    PicassoItem(String url, ScaleType scaleType) {
      this.mUrl = url;
      mScaleType = scaleType;
    }

  }

  class PicassoAdapter extends ArrayAdapter<PicassoItem> {
    private final LayoutInflater mInflater;
    private final Transformation mTransformation;

    public PicassoAdapter(Context context) {
      super(context, 0);
      mInflater = LayoutInflater.from(getContext());
      mTransformation = new RoundedTransformationBuilder()
          .cornerRadiusDp(30)
          .borderColor(Color.BLACK)
          .borderWidthDp(3)
          .oval(false)
          .build();
    }

    @Override public View getView(int position, View convertView, @NonNull ViewGroup parent) {
      ViewGroup view;
      if (convertView == null) {
        view = (ViewGroup) mInflater.inflate(R.layout.picasso_item, parent, false);
      } else {
        view = (ViewGroup) convertView;
      }

      PicassoItem item = getItem(position);

      ImageView imageView = ((ImageView) view.findViewById(R.id.imageView1));
      imageView.setScaleType(item.mScaleType);

      Picasso.with(getContext())
          .load(item.mUrl)
          .fit()
          .transform(mTransformation)
          .into(imageView);

      ((TextView) view.findViewById(R.id.textView3)).setText(item.mScaleType.toString());
      return view;
    }
  }
}
