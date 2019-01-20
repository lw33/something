package lw.learn.lc.queue;


import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-01-05 23:34:22
 **/
// FIXME 2019/1/5  待实现
public class P621_TaskScheduler {

    public int leastIntervalOp(char[] tasks, int n) {
        int[] hash = new int[26];
        int count = tasks.length;
        int res = 0;
        for (char task : tasks) {
            hash[task - 'A']++;
        }

        int unique = 0;
        int i = 0;
        while (count > 0) {
            int length = 0;
            unique = 0;
            for (; length != hash.length; i = (i + 1) % hash.length) {
                length++;
                if (hash[i] != 0) {
                    ++unique;
                    hash[i]--;
                    --count;
                    if (unique == n + 1) {
                        break;
                    }
                }
            }

            if (count <= 0) {
                break;
            }
            res += n + 1;
        }
        res += unique;
        return res;
    }

    public int leastInterval(char[] tasks, int n) {
        Integer[] hash = new Integer[26];
        Arrays.fill(hash, 0);
        int count = tasks.length;
        int res = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (char task : tasks) {
            hash[task - 'A']++;
        }

        int unique = 0;
        while (count > 0) {
            unique = 0;
            for (int i = 0; i < hash.length; i++) {

                if (hash[i] != 0) {
                    ++unique;
                    hash[i]--;
                    --count;
                    if (unique == n + 1) {
                        break;
                    }
                }
            }
            if (count <= 0) {
                break;
            }
            Arrays.sort(hash, (a, b) -> -Integer.compare(a, b));
            res += n + 1;
        }
        res += unique;
        return res;
    }

    @Test
    public void test() {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        //int n = 4;
        //char[] tasks = {'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'};
        System.out.println(this.leastInterval(tasks, n));
        System.out.println(this.leastIntervalOp(tasks, n));
    }
}
