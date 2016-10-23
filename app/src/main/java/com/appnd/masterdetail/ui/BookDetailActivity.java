package com.appnd.masterdetail.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.appnd.masterdetail.Constants;
import com.appnd.masterdetail.R;
import com.appnd.masterdetail.model.BookItem;

public class BookDetailActivity extends AppCompatActivity {

    public static final String POSITION = Constants.PACKAGE_NAME + ".position";

    private BookItem mItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        //set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //check if we have the detail item from the intent
        if (getIntent().hasExtra(POSITION)) {
            int position = getIntent().getIntExtra(POSITION, -1);
            mItem = Constants.bookItems.get(position);
        } else {
            // if for some reason we are starting the activity without a position we finish it to avoid crashes
            finish();
        }

        //load the fragment
        BookDetailFragment mFragment = BookDetailFragment.createInstance(mItem);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_book_detail, mFragment)
                .commit();


        setTitle(mItem.getTitle());

        //Add the return button to the BookListActivity to the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
