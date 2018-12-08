package lw.learn.lc.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-08 13:35:49
 **/
public class LetterCasePermutation_784 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null || S.equals("")) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        letterCasePermutation(S, sb, 0, res);
        return res;
    }

    // 回溯法 类似递归遍历树 最后回到出发点 进行判断
    private void letterCasePermutation(String s, StringBuilder sb, int index, List<String> res) {
        if (s.length() == index) {
            res.add(sb.toString());
            return;
        }

        sb.append(s.charAt(index));
        letterCasePermutation(s, sb, index + 1, res);
        sb.deleteCharAt(sb.length() - 1);
        if (Character.isAlphabetic(s.charAt(index))) {
            if (Character.isLowerCase(s.charAt(index))) {
                sb.append(Character.toUpperCase(s.charAt(index)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(index)));
            }
            letterCasePermutation(s, sb, index + 1, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    @Test
    public void test() {
        String s = "a1b2";
        List<String> strings = this.letterCasePermutation(s);
        System.out.println(strings);
    }

}
