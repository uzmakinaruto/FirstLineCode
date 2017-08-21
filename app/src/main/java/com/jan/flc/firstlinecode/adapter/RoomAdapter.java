package com.jan.flc.firstlinecode.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.data.DYRoom;

import java.util.List;

/**
 * Created by huangje on 2017/8/21.
 */

public class RoomAdapter extends ArrayAdapter<DYRoom> {

    private Context context;
    private int layout;

    public RoomAdapter(Context context, int layout, List<DYRoom> rooms) {
        super(context, layout, rooms);
        this.context = context;
        this.layout = layout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.host = (TextView) convertView.findViewById(R.id.host);
            viewHolder.concerns = (TextView) convertView.findViewById(R.id.concerns);
            viewHolder.gifts = (TextView) convertView.findViewById(R.id.gifts);
            viewHolder.roomNumber = (TextView) convertView.findViewById(R.id.roomNumber);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        DYRoom room = getItem(position);
        viewHolder.title.setText(room.getTitle());
        viewHolder.roomNumber.setText("" + room.getRoomNumber());
        viewHolder.gifts.setText(room.getGifts() + " T");
        viewHolder.concerns.setText("" + room.getConcerns());
        viewHolder.host.setText(room.getHost());
        return convertView;
    }

    class ViewHolder {
        TextView title;
        TextView host;
        TextView gifts;
        TextView concerns;
        TextView roomNumber;
    }
}
