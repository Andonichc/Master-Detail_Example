package com.appnd.masterdetail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import com.appnd.masterdetail.Constants;
import com.appnd.masterdetail.R;
import com.appnd.masterdetail.adapter.BookListRecyclerAdapter;
import com.appnd.masterdetail.model.BookItem;


/**
 * Main Activity which contains a list of items on phones and also on wider screens (like tablets)
 * contains a the detail of the item in a fragment
 */
public class BookListActivity extends AppCompatActivity {

    //Main List with items
    private RecyclerView mRecyclerView;

    private FrameLayout mContainer;
    private BookDetailFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        //Intiate toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.book_list);
        mRecyclerView.setAdapter(new BookListRecyclerAdapter(this, Constants.bookItems));

        //get the reference to the framelayout that would only be present in a 900dp wide or more wider devices (tablets)
        mContainer = (FrameLayout) findViewById(R.id.detail_container);
        //If it's not null it means we have the master-detail view so we can show the detail fragment
        if (mContainer != null) {
            if (mFragment == null) {
                mFragment = BookDetailFragment.createInstance(Constants.bookItems.get(0));
            }

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.detail_container, mFragment)
                    .commit();
        }
    }

    /**
     * On Click to a position of the list, I preferred to do that to avoid passing the FragmentManager and a boolean
     * to the adapter.
     * @param position position of the item.
     */
    public void onClickItem(int position) {
        if (mContainer != null) {
            mFragment.setBookItem(Constants.bookItems.get(position));
        } else {
            Intent intent = new Intent(BookListActivity.this, BookDetailActivity.class);
            intent.putExtra(BookDetailActivity.POSITION, position);
            startActivity(intent);
        }
    }

}
