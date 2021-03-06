package lw.learn.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2018-10-04 01:32:35
 *
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 **/
public class P64_MaxOfSlidingWindow {


    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> res = new ArrayList<>();
        if (num.length < size || size < 1) {
            return res;
        }

        LinkedList<Integer> dbQueue = new LinkedList<>();

        for (int i = 0; i < num.length; i++) {
            while (!dbQueue.isEmpty() && num[dbQueue.peekLast()] <= num[i]) {
                dbQueue.pollLast();
            }
            dbQueue.offerLast(i);

            if (i - size == dbQueue.peekFirst()) {
                dbQueue.pollFirst();
            }

            if (i >= size - 1) {
                res.add(num[dbQueue.peekFirst()]);
            }

        }
        return res;

    }
}
