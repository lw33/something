package lw.learn.lc.math;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-03-26 14:23:59
 **/
public class P1006_ClumsyFactorial {

    public static String[] opts = {"*", "/", "+", "-"};

    /**
     * 比较挫的实现
     *
     * @param N
     * @return
     */
    public int clumsy(int N) {
        if (N < 2) {
            return N;
        }
        LinkedList<String> queue = new LinkedList<>();
        int optIndex = 0;
        for (int i = N; i > 1; i--) {
            boolean flag = true;
            if (!queue.isEmpty()) {
                String opt = queue.peekLast();
                if (opt.equals("*") || opt.equals("/")) {
                    flag = false;
                    queue.removeLast();
                    String num1 = queue.removeLast();
                    String res = "";
                    switch (opt) {
                        case "*":
                            res = String.valueOf(Integer.parseInt(num1) * i);
                            break;
                        case "/":
                            res = String.valueOf(Integer.parseInt(num1) / i);
                            break;
                    }
                    queue.addLast(res);
                }
            }

            if (flag) {
                queue.addLast(String.valueOf(i));
            }
            queue.addLast(opts[optIndex]);
            ++optIndex;
            optIndex %= opts.length;
        }
        String opt = queue.peekLast();
        if (opt.equals("*") || opt.equals("/")) {
            queue.removeLast();
            String num1 = queue.removeLast();
            String res = String.valueOf(Integer.parseInt(num1));
            queue.addLast(res);
        } else {
            queue.addLast("1");
        }
        return addNum(queue);
    }

    private int addNum(LinkedList<String> queue) {
        while (queue.size() != 1) {
            int num1 = Integer.parseInt(queue.removeFirst());
            String opt = queue.removeFirst();
            int num2 = Integer.parseInt(queue.removeFirst());
            if (opt.equals("+")) {
                queue.addFirst(String.valueOf(num1 + num2));
            } else {
                queue.addFirst(String.valueOf(num1 - num2));
            }
        }
        return Integer.parseInt(queue.peek());
    }


    @Test
    public void test() {
        System.out.println(clumsy(2));
    }
}
