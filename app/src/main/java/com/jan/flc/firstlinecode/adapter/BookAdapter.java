package com.jan.flc.firstlinecode.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.data.Book;

import java.util.List;

/**
 * Created by huangje on 2017/7/4.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    private Context context;

    public BookAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_book, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.sn = (TextView) convertView.findViewById(R.id.sn);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.author = (TextView) convertView.findViewById(R.id.author);
            viewHolder.price = (TextView) convertView.findViewById(R.id.price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Book book = getItem(position);
        viewHolder.sn.setText("" + (position + 1));
        viewHolder.name.setText(book.getName());
        viewHolder.author.setText(book.getAuthor());
        viewHolder.price.setText("$ " + book.getPrice());
        return convertView;
    }

    class ViewHolder {
        TextView sn;
        TextView name;
        TextView price;
        TextView author;
    }
}
