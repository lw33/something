package lw.learn.lc.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-12 19:51:17
 **/
public class P500_KeyboardRow {

    public String[] findWords(String[] words) {

        String[] keyboards = {
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };
        int[] hash = new int[26];
        for (int i = 0; i < keyboards.length; i++) {
            char[] chars = keyboards[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                hash[chars[j] - 'a'] = i;
            }
        }

        List<String> tmp = new ArrayList<>(words.length);

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            int line = 0;
            boolean flag = false;
            boolean yes = true;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] >= 'A' && chars[j] <= 'Z') {
                    chars[j] = (char) (chars[j] + 32);
                }
                if (!flag) {
                    line = hash[chars[j] - 'a'];
                    flag = true;
                }
                if (line != hash[chars[j] - 'a']) {
                    yes = false;
                    break;
                }
            }
            if (yes) {
                tmp.add(words[i]);
            }
        }
        String[] res = new String[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        String[] str = {"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(this.findWords(str)));
    }
}
