package lw.learn.lc.bit;

/**
 * @Author lw
 * @Date 2019-03-04 14:50:09
 **/
public class P318_MaximumProductOfWordLengths {

    public int maxProductII(String[] words) {

        final int n = words.length;
        int res = 0;
        int[] len = new int[n];
        int[] bitMap = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = words[i].length();
            for (int j = 0; j < len[i]; j++) {
                bitMap[i] |= (1 << words[i].charAt(j) - 'a');
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp;
                if ((bitMap[i] & bitMap[j]) == 0 && (tmp = len[i] * len[j]) > res) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    public int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (notContains(words[i], words[j])) {
                    res = Math.max(words[i].length() * words[j].length(), res);
                }
            }
        }
        return res;
    }

    public boolean notContains(String str1, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            if (str1.contains(String.valueOf(str2.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
