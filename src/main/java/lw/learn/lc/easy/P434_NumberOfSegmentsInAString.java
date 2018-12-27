package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-27 00:27:29
 **/
public class P434_NumberOfSegmentsInAString {

    public int countSegments(String s) {

        char[] chars = s.toCharArray();
        int count = 0;
        char pre = ' ';
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == ' ' && pre != ' ') {
                ++count;
            }
            pre = chars[i];
        }
        if (pre != ' ') {
            ++count;
        }

        return count;
    }
}
