package com.appnd.masterdetail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.appnd.masterdetail.Constants;
import com.appnd.masterdetail.R;
import com.appnd.masterdetail.adapter.BookListAdapter;


/**
 * Main Activity which contains a list of items on phones and also on wider screens (like tablets)
 * contains a the detail of the item in a fragment
 */
public class BookListActivity extends AppCompatActivity {

    //Main List with items
    private ListView mList;

    private FrameLayout mContainer;
    private BookDetailFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        //Intiate toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mList = (ListView) findViewById(R.id.book_list);
        mList.setAdapter(new BookListAdapter(Constants.items));

        mContainer = (FrameLayout) findViewById(R.id.detail_container);

        //If it's not null it means we have the master-detail view so we can show the detail fragment
        if (mContainer != null){
            mFragment = BookDetailFragment.createInstance(Constants.items.get(0));

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_container, mFragment)
                    .commit();
        }

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = Constants.items.get(position);
                if (mContainer != null) {
                    mFragment.setDetailText(item);
                }else{
                    Intent intent = new Intent(BookListActivity.this, BookDetailActivity.class);
                    intent.putExtra(BookDetailActivity.DETAIL_ITEM, String.valueOf(position + 1));
                    startActivity(intent);
                }
            }
        });
    }

}
