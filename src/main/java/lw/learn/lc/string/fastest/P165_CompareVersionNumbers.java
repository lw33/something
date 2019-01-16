package lw.learn.lc.string.fastest;

/**
 * @Author lw
 * @Date 2019-01-16 18:05:58
 **/

// FIXME 2019/1/16  666
public class P165_CompareVersionNumbers {

    class Solution {
        public int compareVersion(String version1, String version2) {
            int temp1, temp2, i = 0, j = 0;
            while (i < version1.length() || j < version2.length()) {
                temp1 = temp2 = 0;
                while (i < version1.length() && '.' != version1.charAt(i))
                    temp1 = temp1 * 10 + (version1.charAt(i++) - '0');
                i++;
                while (j < version2.length() && '.' != version2.charAt(j))
                    temp2 = temp2 * 10 + (version2.charAt(j++) - '0');
                j++;
                if (temp1 > temp2) return 1;
                if (temp1 < temp2) return -1;
            }
            return 0;
        }
    }

}
