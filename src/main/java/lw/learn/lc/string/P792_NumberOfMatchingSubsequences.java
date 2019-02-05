package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-05 19:05:17
 **/
public class P792_NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String S, String[] words) {
        char[] chars = S.toCharArray();

        int res = 0;
        for (String word : words) {
            if (isSubseq(chars, word.toCharArray())) {
                res++;
            }
        }
        return res;
    }

    public boolean isSubseq(char[] str, char[] subseq) {

        int subIndex = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == subseq[subIndex]) {
                subIndex++;
            }
            if (subIndex == subseq.length) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void test() {
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(this.numMatchingSubseq(S, words));
    }

}
