package com.pts80.framework.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.pts80.framework.adapter.MainAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private List<String> titles;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        titles = Arrays.asList(getResources().getStringArray(R.array.titles));
        adapter = new MainAdapter(this, R.layout.item_list_act_main, titles);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0://CircleImageView
                startActivity(new Intent(this, ItemActivity1.class));
                break;
            case 1://RoundedImageView
                startActivity(new Intent(this, ItemActivity2.class));
                break;
            case 2://Android-ConvenientBanner
//                startActivity(new Intent(this, ItemActivity3.class));
                Toast.makeText(this, "demo有问题", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
