package com.abc.my.app160924.Member;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.abc.my.app160924.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    ListView lv_memberlist;
    MemeberService service;
    final String[] arr = new String[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
        service = new MemberServiceImpl(this.getApplicationContext());
        ArrayList<MemberDTO> list = service.getList();
        Log.d("서비스에서 불러온 데이터 갯수 : ", String.valueOf(list.size()));
        lv_memberlist.setAdapter(new MemberAdapter(this, list));

        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                //startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                //Object o = lv_memberlist.getItemAtPosition(i);
                MemberDTO member = (MemberDTO) lv_memberlist.getItemAtPosition(i);
                //Toast.makeText(ListActivity.this, "선택한 이름" + member.getName(), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ListActivity.this, MemberDetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);

            }
        });

        lv_memberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                MemberDTO member = (MemberDTO) lv_memberlist.getItemAtPosition(i);
                arr[0] = member.getId();
                new AlertDialog.Builder(ListActivity.this).setTitle("삭제 OK ?").setMessage("정말로 삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                service.unregist(arr[0]);
                                startActivity(new Intent(ListActivity.this, ListActivity.class));

                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                return true;
            }
        });
    }
}
