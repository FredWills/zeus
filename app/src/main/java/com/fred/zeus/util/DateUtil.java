package com.fred.zeus.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Fred Liu (liuxiaokun@lvmama.com)
 * @version v1.0.0
 * @since 2016/04/15 14:27s
 */
public class DateUtil {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    public static String getDefaultCurrentDateTime() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);

        return simpleDateFormat.format(new Date());

    }

    public static String getDateTime(Long million) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.CHINA);

        return simpleDateFormat.format(new Date(million));

    }

}
