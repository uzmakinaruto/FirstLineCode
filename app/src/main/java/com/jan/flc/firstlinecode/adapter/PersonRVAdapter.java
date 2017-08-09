package com.jan.flc.firstlinecode.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.data.DouyuF4;

import java.util.List;

/**
 * Created by huangje on 17-3-10.
 */

public class PersonRVAdapter extends RecyclerView.Adapter<PersonRVAdapter.ViewHolder> {

    private List<DouyuF4> persons;
    private int layout;

    class ViewHolder extends RecyclerView.ViewHolder {
        View root;
        ImageView image;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            image = (ImageView) itemView.findViewById(R.id.pic);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }

    public PersonRVAdapter(List<DouyuF4> persons, int layout) {
        this.persons = persons;
        this.layout = layout;
    }

    @Override
    public PersonRVAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Toast.makeText(parent.getContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(), holder.name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DouyuF4 person = persons.get(position);
        holder.image.setImageResource(person.getImageId());
        holder.name.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}
