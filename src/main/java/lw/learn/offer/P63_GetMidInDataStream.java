package lw.learn.offer;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2018-10-03 23:35:40
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 **/
public class P63_GetMidInDataStream {

    private PriorityQueue<Double> min = new PriorityQueue<>();
    private PriorityQueue<Double> max = new PriorityQueue<>((a, b) -> (int) (b - a));
    private int size = 0;

    public void Insert(Integer num) {

        double haha = num;
        if ((size & 1) == 0) {
            if (!min.isEmpty() && min.peek() < haha) {
                Double poll = min.poll();
                min.offer(haha);
                haha = poll;
            }
            max.offer(haha);
        } else {
            if (!max.isEmpty() && max.peek() > haha) {
                Double poll = max.poll();
                max.offer(haha);
                haha = poll;
            }
            min.offer(haha);
        }
        size++;
    }

    public Double GetMedian() {

        return (size & 1) == 0 ? (min.peek() + max.peek()) /2 : max.peek() ;
    }

    @Test
    public void test() {
        P63_GetMidInDataStream mid = new P63_GetMidInDataStream();
        mid.Insert(5);
        mid.Insert(2);
        mid.Insert(3);
        mid.Insert(4);
        mid.Insert(1);
        mid.Insert(6);
        mid.Insert(7);
        mid.Insert(0);
        mid.Insert(8);
        System.out.println(mid.GetMedian());
    }
}
