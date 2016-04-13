package com.fred.zeus;

/**
 * @author Fred Liu(liuxiaokun@lvmama.com)
 * @version 5.0
 * @since 2015/10/16
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WdV extends RelativeLayout {

    private Context mContext;
    private Button mButtonLeft;
    private TextView mTextViewTitle;
    private Button mButtonRight;

    public WdV(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public WdV(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public WdV(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }

    private void init() {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        inflater.inflate(R.layout.wd, this);

        mButtonLeft = (Button) findViewById(R.id.head_left);
        mButtonLeft.setClickable(false);

        mTextViewTitle = (TextView) findViewById(R.id.head_title);

        mButtonRight = (Button) findViewById(R.id.head_right);
        mButtonRight.setClickable(false);
    }


    public void setLeftListener(OnClickListener listener) {

        mButtonLeft.setOnClickListener(listener);
        mButtonLeft.setClickable(true);
    }

    public void setRightListener(OnClickListener listener) {

        mButtonRight.setOnClickListener(listener);
        mButtonRight.setClickable(true);
    }


    public void setLeftText(String text) {
        mButtonLeft.setText(text);
    }

    public void setLeftClickable(boolean flag) {
        mButtonLeft.setClickable(flag);
    }

    public void setTitleText(String text) {
        mTextViewTitle.setText(text);
    }

    public void setRightText(String text) {
        mButtonRight.setText(text);
    }

    public void setRightClickable(boolean flag) {
        mButtonRight.setClickable(flag);
    }


}
