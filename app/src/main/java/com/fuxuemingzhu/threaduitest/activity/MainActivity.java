package com.fuxuemingzhu.threaduitest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fuxuemingzhu.threaduitest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.btn_main_listview)
    Button btn_listview;

    @Bind(R.id.btn_main_recycleview)
    Button btn_recycleview;
    @Bind(R.id.btn_main_ninegridview)
    Button btn_ninegrideview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initEvents() {
        btn_listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                Toast.makeText(MainActivity.this, "ListViewActivity", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        btn_recycleview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                Toast.makeText(MainActivity.this, "RecyclerViewActivity", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        btn_ninegrideview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NineGridViewActivity.class);
                Toast.makeText(MainActivity.this, "NineGridViewActivity", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
