package com.fred.zeus.util;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2016/04/15 14:27s
 */
public class StringUtil {

    public static final String SPACE = " ";
    public static final String EMPTY = "";
    public static final String COMMA = ",";

    public static boolean isEmpty(CharSequence charSequence) {

        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {

        return !isEmpty(charSequence);
    }
}
