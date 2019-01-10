package batterymonitor.dev.com.batterchargemonitor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateHelper {

    public static Date getDateWithServerTimeStamp(String str) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getDefault());

        try {
            return dateFormat.parse(str);
        } catch (ParseException var4) {
            return null;
        }
    }

    public static String getDateStr( Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getDefault());

        return dateFormat.format(date);
    }


}