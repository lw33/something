package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-02 23:02:27
 **/
public class ReverseWords_557 {

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseWord(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverseWord(chars, start, chars.length - 1);
        return new String(chars);
    }

    public void reverseWord(char[] str, int start, int end) {
        while (end > start) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            end--;
            start++;
        }
    }
}
