package com.abc.my.app160924.Member;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.abc.my.app160924.R;

public class ListActivity extends AppCompatActivity {
    ListView lv_memberlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
    }
}
