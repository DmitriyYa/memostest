package kz.yakovlev.memos.test.helpers;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class GenerateDate {
    private static Date date;

    public static String getDateInFormat() {
        date = new Date();
        SimpleDateFormat format3 = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        return format3.format(date);
    }
}
