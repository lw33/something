package lw.learn.lc.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-14 22:02:38
 **/
public class LetterCombinations_17 {

    private static String[] num2word = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        combination(digits, 0,"", res);

        return res;
    }

    private void combination(String digits, int index, String s, List<String> res) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String word = num2word[c];
        for (int i = 0; i < word.length(); i++) {
            combination(digits, index + 1, s+word.charAt(i), res);
        }
    }
}
