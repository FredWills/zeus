package com.fred.zeus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * @author Fred Liu (liuxiaokun@lvmama.com)
 * @version 5.0
 * @since 2016/3/22 14:09
 */
public class ZeusA extends Activity implements View.OnClickListener {

    private EditText mUser;
    private EditText mPwd;
    private EditText mDeviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zeus);
        mUser = (EditText) findViewById(R.id.user_name);
        mPwd = (EditText) findViewById(R.id.password);
        mDeviceId = (EditText) findViewById(R.id.device_id);
        findViewById(R.id.login).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.login:
                login(mUser.getText().toString(), mPwd.getText().toString());
                break;

            default:
                break;
        }
    }


    private void login(String name, String pwd) {

        if ("admin".equals(name) && "123456".equals(pwd)) {
            startActivity(new Intent(this, DrA.class));
        }
    }
}
