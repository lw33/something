package lw.learn.lc.easy;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2018-12-28 01:05:13
 **/
public class P933_NumberOfRecentCalls {

    static class RecentCounter {

        private LinkedList<Integer> dbQueue;

        public RecentCounter() {
            dbQueue = new LinkedList<>();
        }

        public int ping(int t) {
            int res = 0;
            // 弹出间隔大于 3000 的 ping
            while (!dbQueue.isEmpty()) {
                if (dbQueue.peekFirst() + 3000 < t) {
                    dbQueue.pollFirst();
                } else {
                    res = dbQueue.size();
                    break;
                }
            }
            ++res;
            dbQueue.add(t);
            return res;
        }
    }

    public static void main(String[] args) {
        //["RecentCounter", "ping", "ping", "ping", "ping"]
        //[[],[1],[100],[3001],[3002]]
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
