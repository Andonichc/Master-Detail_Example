package com.appnd.masterdetail.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.appnd.masterdetail.R;

import java.util.List;

public class BookListAdapter extends BaseAdapter {

    private List<String> mItems;

    public BookListAdapter(List<String> mItems) {
        this.mItems = mItems;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_list, null);
        //set the content to the view
        ((TextView) convertView.findViewById(R.id.index_text)).setText(String.valueOf(position + 1));
        ((TextView) convertView.findViewById(R.id.name_text)).setText(mItems.get(position));
        //return the inflated view
        return convertView;
    }


}
