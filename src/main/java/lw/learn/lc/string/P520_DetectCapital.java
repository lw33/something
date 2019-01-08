package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-08 20:35:49
 **/
public class P520_DetectCapital {

    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) {
            return false;
        }
        char[] words = word.toCharArray();
        // 判断第一个是否为大写
        boolean first = isUpperCase(words[0]);
        // 是否出现小写
        boolean lower = false;
        // 是否出现大写
        boolean upper = false;
        for (int i = 1; i < words.length; i++) {
            if (isUpperCase(words[i])) {
                // 如果首字母不是大写 或者出现 小写字母
                if (!first || lower) {
                    return false;
                }
                upper = true;
            } else {
                // 不是是首字母大写
                if (upper) {
                    return false;
                }
                lower = true;
            }
        }

        return true;
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    @Test
    public void test() {
        String str = "FFFFFFFFFFFFFFFFFFFFf";
        System.out.println(this.detectCapitalUse(str));
    }
}
