package com.jan.flc.firstlinecode.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jan.flc.firstlinecode.R;
import com.jan.flc.firstlinecode.adapter.BookAdapter;
import com.jan.flc.firstlinecode.data.Book;
import com.jan.flc.firstlinecode.utils.MySQLiteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangje on 2017/7/4.
 */

public class SqliteActivity extends BaseActivity {

    private ListView lv;
    private BookAdapter adapter;
    private MySQLiteHelper sqLiteHelper;
    private SQLiteDatabase database;
    private List<Book> books = new ArrayList<>();

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        lv = (ListView) findViewById(R.id.lv);
        adapter = new BookAdapter(this, R.layout.item_book, books);
        lv.setAdapter(adapter);
        sqLiteHelper = new MySQLiteHelper(this, "FirstLineCode.db", null, 1);
        database = sqLiteHelper.getWritableDatabase();
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showlongClickDialog(position);
                return false;
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                queryAll();
            }
        }).start();
    }

    public void insert(View view) {
        if (database != null) {
            showInsertDialog(-1);
        }
    }

    /*public void query(View view) {
        if (database != null) {
            queryAll();
        }
    }*/

    private void queryAll() {
        if (database != null) {
            Cursor cursor = database.query("Book", null, null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                books.clear();
                do {
                    Book book = new Book();
                    book.setName(cursor.getString(cursor.getColumnIndex("name")));
                    book.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
                    book.setPrice(cursor.getFloat(cursor.getColumnIndex("price")));
                    book.setId(cursor.getInt(cursor.getColumnIndex("id")));
                    books.add(book);
                } while (cursor.moveToNext());
                mHandler.sendEmptyMessage(0);
            }
        } else {
            Toast.makeText(this, "初始化失败", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void showInsertDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View root = LayoutInflater.from(this).inflate(R.layout.dialog_insert_book, null);
        final EditText inputName = (EditText) root.findViewById(R.id.name);
        final EditText inputAuthor = (EditText) root.findViewById(R.id.author);
        final EditText inputPrice = (EditText) root.findViewById(R.id.price);
        if (position != -1) {
            inputName.setText(books.get(position).getName());
            inputAuthor.setText(books.get(position).getAuthor());
            inputPrice.setText("" + books.get(position).getPrice());
        }
        builder.setNegativeButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = inputName.getText().toString();
                String author = inputAuthor.getText().toString();
                String priceText = inputPrice.getText().toString();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(author) && !TextUtils.isEmpty(priceText)) {
                    float price = Float.valueOf(priceText);
                    ContentValues value = new ContentValues();
                    value.put("name", name);
                    value.put("author", author);
                    value.put("price", price);
                    if (position == -1) {
                        int id = (int) database.insert("Book", null, value);
                        if (id != -1) {
                            Book book = new Book();
                            book.setPrice(price);
                            book.setName(name);
                            book.setAuthor(author);
                            book.setId(id);
                            books.add(book);
                            adapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(SqliteActivity.this, "插入失败", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        int id = books.get(position).getId();
                        int count = database.update("Book", value, "id = ?", new String[]{"" + id});
                        if (count > 0) {
                            books.get(position).setName(name);
                            books.get(position).setAuthor(author);
                            books.get(position).setPrice(price);
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
        builder.setView(root).create().show();
    }

    public void showlongClickDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(new String[]{"更新", "删除"}, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    showInsertDialog(position);
                } else {
                    int id = books.get(position).getId();
                    int count = database.delete("Book", "id = ?", new String[]{"" + id});
                    if (count > 0) {
                        books.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }).create().show();
    }
}
