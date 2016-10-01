package com.abc.my.app160924.Member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abc.my.app160924.MainActivity;
import com.abc.my.app160924.R;
import com.abc.my.app160924.Util.Retval;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_id, et_pw, et_name, et_email, et_addr, et_phone;
    Button bt_submit, bt_cancel;
    MemeberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        service = new MemberServiceImpl(this.getApplicationContext());

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_phone = (EditText) findViewById(R.id.et_phone);

        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        MemberDTO member = new MemberDTO();
        member.setId(et_id.getText().toString());
        member.setPw(et_pw.getText().toString());
        member.setName(et_name.getText().toString());
        member.setEmail(et_email.getText().toString());
        member.setAddr(et_addr.getText().toString());
        member.setPhone(et_phone.getText().toString());

        switch(v.getId()){
            case R.id.bt_submit :
                Retval val = service.join(member);

                if(val.getMessage().equals("SUCCESS")){
                    Toast.makeText(JoinActivity.this,
                            "회원가입성공...로그인 바랍니다.",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(JoinActivity.this,
                            "회원가입실패...재시도 바랍니다.",
                            Toast.LENGTH_LONG).show();
                }

                startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                break;
            case R.id.bt_cancel :
                startActivity(new Intent(JoinActivity.this, MainActivity.class));
                break;
        }

    }
}
