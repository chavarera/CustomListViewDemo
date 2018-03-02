package com.protutr.customlistviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.protutr.customlistviewdemo.MainActivity;
import com.protutr.customlistviewdemo.R;
import com.protutr.customlistviewdemo.model.RowData;

import java.util.List;

/**
 * Created by ravi on 3/2/2018.
 */

public class MyAdapter extends BaseAdapter {
    Context mainActivity;
    List<RowData> rowDatas;
    public MyAdapter(Context mainActivity, List<RowData> rowDatas) {
        this.mainActivity=mainActivity;
        this.rowDatas=rowDatas;
    }

    @Override
    public int getCount() {
        return rowDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return rowDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class MyViewHolder{

        ImageView imageView;
        TextView title,subtitle,version;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder myViewHolder=null;
        if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.row_data,null);

            myViewHolder=new MyViewHolder();
            myViewHolder.imageView=(ImageView) view.findViewById(R.id.image);
            myViewHolder.title=(TextView) view.findViewById(R.id.title);
            myViewHolder.subtitle=(TextView) view.findViewById(R.id.subtitle);
            myViewHolder.version=(TextView) view.findViewById(R.id.version);


            RowData rowData=rowDatas.get(i);
            myViewHolder.imageView.setImageResource(rowData.getImage());
            myViewHolder.title.setText(rowData.getTitle());
            myViewHolder.subtitle.setText(rowData.getSubtitle());
            myViewHolder.version.setText(rowData.getVersion());
            view.setTag(myViewHolder);
        }
        else {
            myViewHolder=(MyViewHolder) view.getTag();
        }
        return view;
    }
}
