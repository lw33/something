package lw.learn.p.z.recursion;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2018-11-26 17:05:40
 **/
// TODO: 2018/11/27 待实现
public class ExpressionCompute {

    public int compute(String expression) {
        if (expression == null || expression.length() == 0) {
            return 0;
        }

        return compute(expression.toCharArray(), 0)[0];
    }

    private int[] compute(char[] expression, int i) {

        LinkedList<String> queue = new LinkedList<>();
        int pre = 0;
        while (i < expression.length && expression[i] != ')') {
            if (expression[i] >= '0' && expression[i] <= '9') {
                pre = pre * 10 + expression[i++] - '0';
            } else if (expression[i] != '(') {
                addNum(queue, pre);
                queue.addLast(String.valueOf(expression[i++]));
                pre = 0;
            } else {
                int[] sub = compute(expression, i + 1);
                pre = sub[0];
                i = sub[1] + 1;
            }
        }

        addNum(queue, pre);
        return new int[]{calculate(queue), i};
    }

    private int calculate(LinkedList<String> queue) {
        int res = 0;
        while (queue.size() != 1) {
            int num1 = Integer.parseInt(queue.pollFirst());
            String s = queue.pollFirst();
            int num2 = Integer.parseInt(queue.pollFirst());
            res = s.equals("+") ? num1 + num2 : num1 - num2;
            queue.addFirst(String.valueOf(res));
        }
        return res;
    }

    private void addNum(LinkedList<String> queue, int num) {
        if (!queue.isEmpty()) {
            String symbol = queue.pollLast();
            if ("+".equals(symbol) || "-".equals(symbol)) {
                queue.addLast(symbol);
            } else {
                int pre = Integer.parseInt(queue.pollLast());
                num = "*".equals(symbol) ? pre * num : pre / num;
            }
        }
        queue.addLast(String.valueOf(num));
    }

    @Test
    public void test() throws ScriptException {
        String exp = "45*(6+8)+5-98/2+4*8";
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine javascript = engineManager.getEngineByName("Nashorn");
        System.out.println(javascript.eval(exp));
        System.out.println(this.compute(exp));
    }
}
