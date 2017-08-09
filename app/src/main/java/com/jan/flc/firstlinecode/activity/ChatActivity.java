package com.jan.flc.firstlinecode.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.adapter.ChatAdapter;
import com.jan.flc.firstlinecode.data.ChatMessage;
import com.jan.flc.firstlinecode.data.DouyuF4;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends BaseActivity {

    private List<ChatMessage> messages = new ArrayList<>();
    private ChatAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_ui_chat);
        recyclerView = (RecyclerView) findViewById(R.id.chatList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new ChatAdapter(messages);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        final EditText inputText = (EditText) findViewById(R.id.inputText);
        Button sendBtn = (Button) findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(inputText.getText())) {
                    ChatMessage message = new ChatMessage();
                    message.setMessageType(ChatMessage.MESSAGE_TYPE_SEND);
                    message.setMessage(inputText.getText().toString());
                    message.setImageId(R.drawable.my);
                    message.setName("我");
                    messages.add(message);

                    int random = (int) (Math.random() * 4);
                    ChatMessage message1 = new ChatMessage();
                    message1.setMessageType(ChatMessage.MESSAGE_TYPE_RECEIVE);
                    message1.setMessage(inputText.getText().toString());
                    message1.setImageId(DouyuF4.IMAGES[random]);
                    message1.setName(DouyuF4.NAMES[random]);
                    messages.add(message1);

                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(messages.size()-1);

                }
            }
        });
    }
}
