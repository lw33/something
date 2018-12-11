package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-08 13:52:37
 **/
public class P22_GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n, 0, 0, sb, res);
        return res;
    }

    // 记录当前字符串中左右括号的数量 当右括号比左括号多时 才能放左括号
    public void generateParenthesis(int n, int open, int close, StringBuilder sb, List<String> res) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            generateParenthesis(n, open + 1, close, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            generateParenthesis(n, open, close + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(this.generateParenthesis(3));
    }
}
