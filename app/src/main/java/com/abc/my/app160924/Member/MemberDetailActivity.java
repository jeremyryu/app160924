package com.abc.my.app160924.Member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abc.my.app160924.R;
import com.abc.my.app160924.Util.Phone;

public class MemberDetailActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_id, tv_name, tv_pw, tv_email, tv_addr, tv_phone;
    MemeberService service;
    Button bt_call, bt_map, bt_update, bt_list;
    MemberDTO member;
    Phone phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
        member = new MemberDTO();
        phone = new Phone(this, this);

        Log.d("11111111111111", "111111");

        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member.setId(id);

        Log.d("!!! id", member.getId());

        member = service.getOne(member);


        tv_id = (TextView) findViewById(R.id.tv_id);
        tv_pw = (TextView) findViewById(R.id.tv_pw);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_email = (TextView) findViewById(R.id.tv_email);
        tv_addr = (TextView) findViewById(R.id.tv_addr);
        tv_phone = (TextView) findViewById(R.id.tv_phone);

        bt_call = (Button) findViewById(R.id.bt_call);
        bt_map = (Button) findViewById(R.id.bt_map);
        bt_update = (Button) findViewById(R.id.bt_update);
        bt_list = (Button) findViewById(R.id.bt_list);

        bt_call.setOnClickListener(this);
        bt_map.setOnClickListener(this);
        bt_update.setOnClickListener(this);
        bt_list.setOnClickListener(this);

        tv_id.setText(member.getId());
        tv_pw.setText(member.getPw());
        tv_name.setText(member.getName());
        tv_email.setText(member.getEmail());
        tv_addr.setText(member.getAddr());
        tv_phone.setText(member.getPhone());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_call :
                phone.dial(member.getPhone());
                //phone.directCall(member.getPhone());

                break;
            case R.id.bt_map :
                break;
            case R.id.bt_update :
                Intent intent = new Intent(MemberDetailActivity.this, MemberUpdateActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
                break;
            case R.id.bt_list :
                //startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                startActivity(new Intent(MemberDetailActivity.this, ListActivity.class));
                break;

        }

    }
}
