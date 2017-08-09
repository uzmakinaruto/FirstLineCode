package com.jan.flc.firstlinecode.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.data.ChatMessage;

import java.util.List;

/**
 * Created by huangje on 17-3-10.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<ChatMessage> messages;

    public ChatAdapter(List<ChatMessage> messages) {
        this.messages = messages;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        View layoutSend;
        View layoutReceive;
        TextView sendName;
        ImageView sendImage;
        TextView sendMessage;
        TextView receiveName;
        ImageView receiveImage;
        TextView receiveMessage;

        public ViewHolder(View itemView) {
            super(itemView);
            layoutSend = itemView.findViewById(R.id.layoutSend);
            layoutReceive = itemView.findViewById(R.id.layoutReceive);
            sendName = (TextView) itemView.findViewById(R.id.sendName);
            sendImage = (ImageView) itemView.findViewById(R.id.sendImage);
            sendMessage = (TextView) itemView.findViewById(R.id.sendMessage);
            receiveName = (TextView) itemView.findViewById(R.id.receiveName);
            receiveImage = (ImageView) itemView.findViewById(R.id.receiveImage);
            receiveMessage = (TextView) itemView.findViewById(R.id.receiveMessage);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ChatMessage message = messages.get(position);
        if (message.getMessageType() == ChatMessage.MESSAGE_TYPE_SEND) {
            holder.layoutSend.setVisibility(View.VISIBLE);
            holder.layoutReceive.setVisibility(View.GONE);
            holder.sendName.setText(message.getName());
            holder.sendImage.setImageResource(message.getImageId());
            holder.sendMessage.setText(message.getMessage());
        } else if (message.getMessageType() == ChatMessage.MESSAGE_TYPE_RECEIVE) {
            holder.layoutSend.setVisibility(View.GONE);
            holder.layoutReceive.setVisibility(View.VISIBLE);
            holder.receiveName.setText(message.getName());
            holder.receiveImage.setImageResource(message.getImageId());
            holder.receiveMessage.setText(message.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
