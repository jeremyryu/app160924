package com.abc.my.app160924.Member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.abc.my.app160924.R;

public class MemberUpdateActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_pw, et_name, et_email, et_addr, et_phone;
    TextView tv_id;
    Button bt_submit, bt_cancel;
    MemeberService service;
    MemberDTO member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_update);

        service = new MemberServiceImpl(this.getApplicationContext());
        member = new MemberDTO();

        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member.setId(id);

        member = service.getOne(member);


        tv_id = (TextView) findViewById(R.id.tv_id);

        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_phone = (EditText) findViewById(R.id.et_phone);

        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);

        tv_id.setText(member.getId());

        et_pw.setHint(member.getPw());
        et_name.setHint(member.getName());
        et_email.setHint(member.getEmail());
        et_addr.setHint(member.getAddr());
        et_phone.setHint(member.getPhone());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_submit :
                MemberDTO param = new MemberDTO();
                param.setId(tv_id.getText().toString());

                param.setPw( (et_pw.getText().toString().equals("")) ? member.getPw() : et_pw.getText().toString()  );
                param.setName( (et_name.getText().toString().equals("")) ? member.getName() : et_name.getText().toString() );
                param.setEmail( (et_email.getText().toString().equals("")) ? member.getEmail() : et_email.getText().toString() );
                param.setAddr( et_addr.getText().toString().equals("") ? member.getAddr() : et_addr.getText().toString());
                param.setPhone(et_phone.getText().toString().equals("") ? member.getPhone() : et_phone.getText().toString());

                service.update(param);

                Intent intent2 = new Intent(MemberUpdateActivity.this, MemberDetailActivity.class);
                intent2.putExtra("id", member.getId());
                startActivity(intent2);

                break;
            case R.id.bt_cancel :
                Intent intent3 = new Intent(MemberUpdateActivity.this, MemberDetailActivity.class);
                intent3.putExtra("id", member.getId());
                startActivity(intent3);
                break;
        }

    }
}
