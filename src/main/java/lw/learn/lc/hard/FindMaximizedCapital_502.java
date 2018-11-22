package lw.learn.lc.hard;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2018-11-22 17:32:47
 **/
public class FindMaximizedCapital_502 {

    class Node {
        int cost;
        int profits;

        public Node(int cost, int profits) {
            this.cost = cost;
            this.profits = profits;
        }
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Node> minPriorityQueue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        PriorityQueue<Node> maxPriorityQueue = new PriorityQueue<>((a, b) -> b.profits - a.profits);
        for (int i = 0; i < Profits.length; i++) {
            minPriorityQueue.add(new Node(Capital[i], Profits[i]));
        }
        for (int i = 0; i < k; i++) {
            while (!minPriorityQueue.isEmpty() && minPriorityQueue.peek().cost <= W) {
                maxPriorityQueue.add(minPriorityQueue.poll());
            }

            if (maxPriorityQueue.isEmpty())
                return W;

            W += maxPriorityQueue.poll().profits;
        }
        return W;
    }

    @Test
    public void test() {
        /*
        2
        0
        [1,2,3]
        [0,1,1]
        */
        int[] profits = {1, 2, 3};
        int[] costs = {0, 1, 1,};
        int k = 2;
        int w = 0;
        System.out.println(this.findMaximizedCapital(k, w, profits, costs));
    }
}
