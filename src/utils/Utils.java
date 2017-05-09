package utils;

/**
 * Created by lambor on 17-5-9.
 */
public class Utils {
    public static int stringToInt(String string) {
        int result = 0;
        try {
            result =  Integer.parseInt(string);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return result;
    }
}
