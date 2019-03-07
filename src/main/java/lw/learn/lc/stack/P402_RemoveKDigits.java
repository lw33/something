package lw.learn.lc.stack;


import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-01-20 23:29:34
 **/
public class P402_RemoveKDigits {

    /**
     * 栈中数据 是递增的 可以等于
     * 当有数据 小于栈顶元素时 循环弹出栈顶
     * 如果出现 0 且最后 栈弹空了 0 不加入栈
     * 最后 如果 k 不为 0 此时 栈中的元素为 从小到大 继续弹出栈顶
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (num.length() <= k) {
            return "0";
        }
        char[] chars = num.toCharArray();
        // 双端队列 模拟栈
        LinkedList<Character> dbq = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (k == 0) {
                dbq.push(chars[i]);
                continue;
            }
            while (!dbq.isEmpty() && k > 0 && chars[i] < dbq.peek()) {
                dbq.pop();
                k--;
            }
            if (dbq.isEmpty() && chars[i] == '0') {
                continue;
            }
            dbq.push(chars[i]);
        }
        for (int i = 0; i < k; i++) {
            dbq.pop();
        }
        StringBuilder sb = new StringBuilder();
        // 因为元素为逆序 所以使用双端队列 方便弹出恢复顺序
        while (!dbq.isEmpty()) {
            sb.append(dbq.pollLast());
        }


        return sb.length() == 0 ? "0" : sb.toString();
    }

    @Test
    public void test() {
        String num = "112";
        int k = 1;
        System.out.println(this.removeKdigits(num, k));
    }
}
