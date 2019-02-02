package lw.learn.lc.string;

/**
 * @Author lw
 * @Date 2019-02-01 20:55:47
 **/
public class P521_LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return a.length() >= b.length() ? a.length() : b.length();
    }

}
