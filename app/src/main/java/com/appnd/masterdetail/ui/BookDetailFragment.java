package com.appnd.masterdetail.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appnd.masterdetail.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailFragment extends Fragment {

    private TextView mDetailText;
    private String mItem;

    public static BookDetailFragment createInstance(String item){
        BookDetailFragment fragment = new BookDetailFragment();
        fragment.mItem = item;
        return fragment;
    }

    public BookDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book_detail, container, false);
        mDetailText = (TextView) v.findViewById(R.id.detail_text);
        setDetailText(mItem);
        return v;
    }

    public void setDetailText(String item) {
        mDetailText.setText(getString(R.string.details_about, item));
    }

}
