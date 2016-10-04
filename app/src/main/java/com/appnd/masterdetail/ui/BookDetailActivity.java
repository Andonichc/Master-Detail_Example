package com.appnd.masterdetail.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.appnd.masterdetail.Constants;
import com.appnd.masterdetail.R;

public class BookDetailActivity extends AppCompatActivity {

    public static final String DETAIL_ITEM = Constants.PACKAGE_NAME + ".detail_item";

    private String mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        //set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //check if we have the detail item from the intent
        if (getIntent().hasExtra(DETAIL_ITEM)) {
            mItem = getIntent().getStringExtra(DETAIL_ITEM);
        } else {
            finish();
        }
        BookDetailFragment mFragment = BookDetailFragment.createInstance(mItem);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_book_detail, mFragment)
                .commit();

        setTitle(getString(R.string.item_num, mItem));
    }

}
