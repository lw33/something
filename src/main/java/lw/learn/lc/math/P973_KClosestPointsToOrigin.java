package lw.learn.lc.math;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2019-01-15 12:54:53
 **/
public class P973_KClosestPointsToOrigin {

    class Point implements Comparable<Point>{
        int index;
        int distance;

        public Point() {
        }

        public Point(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(o.distance, this.distance);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> priorityQueue = new PriorityQueue<>(K);
        for (int i = 0; i < points.length; i++) {
            int distance = distance(points[i][0], points[i][1]);
            if (priorityQueue.size() < K) {
                priorityQueue.add(new Point(i, distance));
            } else {
                if (priorityQueue.peek().distance > distance) {
                    priorityQueue.poll();
                    priorityQueue.add(new Point(i, distance));
                }
            }
        }
        int[][] res = new int[K][];
        for (int i = 0; i < K; i++) {
            res[i] = points[priorityQueue.poll().index];
        }
        return res;
    }

    public int distance(int x, int y) {
        return x * x + y * y;
    }

    @Test
    public void test() {
        int[][] ints = JSON2Java.json2int2Array("[[3,3],[5,-1],[-2,4]]");
        int[][] ints1 = this.kClosest(ints, 2);
        System.out.println(Arrays.deepToString(ints1));
    }
}
