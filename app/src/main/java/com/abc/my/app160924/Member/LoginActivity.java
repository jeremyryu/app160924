package com.abc.my.app160924.Member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abc.my.app160924.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_login, bt_join;
    EditText et_id, et_pw;
    MemeberService service;
//    MemberService service = new MemberServiceImpl();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new MemberServiceImpl(this.getApplicationContext());

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_join = (Button) findViewById(R.id.bt_join);
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);

        bt_login.setOnClickListener(this);
        bt_join.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = et_id.getText().toString();
        String pw = et_pw.getText().toString();
        MemberDTO param = new MemberDTO();
        MemberDTO result = new MemberDTO();

        switch (v.getId()) {
            case R.id.bt_login:

                param.setId(id);
                param.setPw(pw);
                result = service.login(param);

                if(result.getId().equals("NONE")){
                    Toast.makeText(LoginActivity.this,
                            "존재하지 않는 아이디입니다.",
                            Toast.LENGTH_LONG).show();
                }
                else if(result.getId().equals("NO_MATCH")){
                    Toast.makeText(LoginActivity.this,
                            "비밀번호가 일치하지 않습니다.",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(LoginActivity.this,
                            "환영합니다. " + result.getName(),
                            Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, ListActivity.class));
                }

                break;
            case R.id.bt_join:

                startActivity(new Intent(LoginActivity.this, JoinActivity.class));
                break;
        }
    }
}
