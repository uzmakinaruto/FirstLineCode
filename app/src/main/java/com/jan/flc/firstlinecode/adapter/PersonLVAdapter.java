package com.jan.flc.firstlinecode.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.data.DouyuF4;

import java.util.List;

/**
 * Created by huangje on 17-3-9.
 */

public class PersonLVAdapter extends ArrayAdapter<DouyuF4> {

    private Context context;

    public PersonLVAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<DouyuF4> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        DouyuF4 person = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_person_hor, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.pic);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.image.setImageResource(person.getImageId());
        holder.name.setText(person.getName());
        return convertView;
    }

    class ViewHolder {
        TextView name;
        ImageView image;
    }
}
