package lw.learn.utils;

/**
 * @Author lw
 * @Date 2018-12-10 12:34:52
 **/
public class StringHelper {
    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (end > start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome(char[] str, int start, int end) {
        while (end > start) {
            if (str[start] != str[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
