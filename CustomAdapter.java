package com.awake.addressbook;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Business> data;
    public CustomAdapter(Context context, ArrayList<Business> data) {
        this.mContext = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();// # of items in your arraylist
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual item
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.list_item_layout, parent,false);
            viewHolder = new ViewHolder();
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvEmail = (TextView) convertView.findViewById(R.id.tvEmail);
            viewHolder.tvPhone = (TextView) convertView.findViewById(R.id.tvContact);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Business biz = data.get(position);
        viewHolder.tvEmail.setText(biz.getEmail());
        viewHolder.tvPhone.setText(biz.getPhone());
        viewHolder.tvName.setText(biz.getName());

        return convertView;
    }
    static class ViewHolder {
        TextView tvName;
        TextView tvEmail;
        TextView tvPhone;

    }

}