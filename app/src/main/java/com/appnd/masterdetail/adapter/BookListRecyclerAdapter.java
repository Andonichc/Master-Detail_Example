package com.appnd.masterdetail.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appnd.masterdetail.R;
import com.appnd.masterdetail.model.BookItem;
import com.appnd.masterdetail.ui.BookListActivity;

import java.util.List;


public class BookListRecyclerAdapter extends RecyclerView.Adapter<BookListRecyclerAdapter.ViewHolder> {

    private static final int EVEN = 0;
    private static final int ODD = 1;
    private List<BookItem> mItems;
    private BookListActivity mActivity;

    public BookListRecyclerAdapter(BookListActivity activity, List<BookItem> mItems) {
        this.mItems = mItems;
        this.mActivity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = viewType == EVEN ?
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_even, parent, false) :
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_odd, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mItems.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return (position % 2 == 0) ? EVEN : ODD;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitle;
        private TextView mAuthor;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title_text);
            mAuthor = (TextView) itemView.findViewById(R.id.author_text);
            itemView.setOnClickListener(this);
        }

        public void bind(BookItem item){
            mTitle.setText(item.getTitle());
            mAuthor.setText(item.getAuthor());
        }

        @Override
        public void onClick(View v) {
            mActivity.onClickItem(getAdapterPosition());
        }
    }
}
