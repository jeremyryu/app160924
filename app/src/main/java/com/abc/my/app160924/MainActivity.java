package com.abc.my.app160924;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.abc.my.app160924.Calc.CalcActivity;
import com.abc.my.app160924.Member.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt_calc, bt_contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_calc = (Button) findViewById(R.id.bt_calc);
        bt_contacts = (Button) findViewById(R.id.bt_contacts);

        bt_calc.setOnClickListener(this);
        bt_contacts.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.bt_calc :

                startActivity(new Intent(MainActivity.this, CalcActivity.class));

                break;
            case R.id.bt_contacts :

                Toast.makeText(MainActivity.this, "Link to MemberList", Toast.LENGTH_LONG).show();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;

        }
    }
}
