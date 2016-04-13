package com.fred.zeus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * @author Fred Liu (liuxiaokun@lvmama.com)
 * @version 5.0
 * @since 2016/3/23 15:05
 */
public class PomA extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pom);

        WdV wd = (WdV) findViewById(R.id.wd);
        wd.setTitleText("设备控制");
        wd.setLeftText("返回");
        wd.setLeftListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PomA.this.finish();
            }
        });
    }
}
