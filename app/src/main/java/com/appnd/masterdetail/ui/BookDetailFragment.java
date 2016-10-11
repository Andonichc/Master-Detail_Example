package com.appnd.masterdetail.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appnd.masterdetail.Constants;
import com.appnd.masterdetail.R;
import com.appnd.masterdetail.model.BookItem;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailFragment extends Fragment {

    private final static String ITEM = Constants.PACKAGE_NAME + ".item";
    private BookItem mItem;
    private ImageView mCoverImage;
    private TextView mAuthor;
    private TextView mDate;
    private TextView mDescription;
    private SimpleDateFormat sdFormat;

    public static BookDetailFragment createInstance(BookItem item) {
        BookDetailFragment fragment = new BookDetailFragment();
        fragment.mItem = item;
        return fragment;
    }

    public BookDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //if we have a saved instance (meaning we are restoring the fragment state)
        if (savedInstanceState != null && savedInstanceState.containsKey(ITEM))
            mItem = savedInstanceState.getParcelable(ITEM);

        sdFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book_detail, container, false);
        mCoverImage = (ImageView) v.findViewById(R.id.image_detail);
        mAuthor = (TextView) v.findViewById(R.id.author_detail);
        mDate = (TextView) v.findViewById(R.id.date_detail);
        mDescription = (TextView) v.findViewById(R.id.description_detail);

        //set the item
        setBookItem(mItem);
        return v;
    }

    /**
     * Handles persistence on device's orientation changes
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ITEM, mItem);
    }

    /**
     * Fills all the views with the content of a BoookItem instance
     *
     * @param item item we want to fill the views with
     */
    public void setBookItem(BookItem item) {
        Glide.with(getActivity())
                .load(item.getUrlCover())
                .placeholder(R.drawable.placeholder)
                .into(mCoverImage);

        mAuthor.setText(item.getAuthor());
        mDate.setText(sdFormat.format(item.getPublicationDate()));
        mDescription.setText(item.getDescription());
    }

}
