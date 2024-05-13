package utils.common_utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
    public static String getCurrentTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
