package lw.learn.lc.stack;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-02-12 19:24:45
 **/
public class P682_BaseballGame {

    public int calPoints(String[] ops) {

        LinkedList<Integer> scoreStack = new LinkedList<>();

        for (String op : ops) {
            switch (op) {
                case "+":
                    Integer top = scoreStack.pop();
                    Integer peek = scoreStack.peek();
                    scoreStack.push(top);
                    scoreStack.push(top + peek);
                    break;
                case "D":
                    scoreStack.push(2 * scoreStack.peek());
                    break;
                case "C":
                    scoreStack.pop();
                    break;
                default:
                    scoreStack.push(Integer.parseInt(op));
            }
        }

        int res = 0;
        while (!scoreStack.isEmpty()) {
            res += scoreStack.poll();
        }
        return res;
    }

    @Test
    public void test() {
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(this.calPoints(strs));
    }
}
