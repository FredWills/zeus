package com.fred.zeus.util;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * @author Fred Liu (liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2016/04/15 14:27s
 */
public class KeyboardUtil {

    private KeyboardUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void openKeybord(EditText mEditText, Context mContext) {

        InputMethodManager inputMethodManager = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static void closeKeybord(EditText mEditText, Context mContext) {

        InputMethodManager inputMethodManager = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
