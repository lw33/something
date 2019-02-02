package lw.learn.lc.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-02 20:14:45
 **/
public class P830_PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {

        List<List<Integer>> res = new ArrayList<>();
        char[] chars = S.toCharArray();
        int len = 1;
        int start = 0;
        int end;

        int i = 1;
        for (; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                len++;
            } else {
                if (len >= 3) {
                    end = i - 1;
                    res.add(Arrays.asList(start, end));
                }
                len = 1;
            }
            if (len == 3) {
                start = i - 2;
            }
        }

        if (len >= 3) {
            end = i - 1;
            res.add(Arrays.asList(start, end));
        }
        return res;
    }

    @Test
    public void test() {
        String s = "abcdddeeeeaabbbcd";
        System.out.println(this.largeGroupPositions(s));
    }
}
