package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-27 14:19:55
 **/
public class P917_ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int length = 0;
        char[] newChars = new char[chars.length];
        for (char aChar : chars) {
            if ((aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z')) {
                newChars[length++] = aChar;
            }
        }
        if (length < 2) {
            return S;
        }
        int start = 0;
        int end = length - 1;
        while (end > start) {
            char tmp = newChars[start];
            newChars[start++] = newChars[end];
            newChars[end--] = tmp;
        }
        start = 0;
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z')) {
                chars[i] = newChars[start++];
            }
        }
        return new String(chars);
    }
}
