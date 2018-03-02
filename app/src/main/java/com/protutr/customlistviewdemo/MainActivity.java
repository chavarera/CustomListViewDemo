package com.protutr.customlistviewdemo;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.protutr.customlistviewdemo.adapter.MyAdapter;
import com.protutr.customlistviewdemo.model.RowData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<RowData> rowDatas;
    String title[],subtitle[],version[];
    Button playstore;
    TypedArray image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);
        rowDatas=new ArrayList<RowData>();


        title=getResources().getStringArray(R.array.title);
        subtitle=getResources().getStringArray(R.array.subtitle);
        version=getResources().getStringArray(R.array.version);
        image=getResources().obtainTypedArray(R.array.image);

        for(int i=0;i<title.length;i++){

            RowData rowData=new RowData(title[i],subtitle[i],version[i],image.getResourceId(i,-1));
            rowDatas.add(rowData);
        }

        MyAdapter myAdapter=new MyAdapter(getApplicationContext(),rowDatas);
        myAdapter.notifyDataSetChanged();

        listView.setAdapter(myAdapter);

        playstore=(Button)findViewById(R.id.playstore);

        playstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.protutr.protutr"));
                startActivity(intent);
            }
        });
    }
}
