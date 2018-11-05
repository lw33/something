package lw.learn.ds;

import java.util.Random;

/**
 * @Author lw
 * @Date 2018-11-04 19:38:26
 **/
public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int size;
    private int front;
    private int tail;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void offer(E e) {
        ensureCapacity();
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void ensureCapacity() {
        if ((tail + 1) % data.length == front) {
            resize(capacity() * 2);
        }
    }

    private void resize(int capacity) {
        E[] e = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            e[i] = data[(i + front) % data.length];
        }
        data = e;
        front = 0;
        tail = size;
    }

    @Override
    public E poll() {

        if (isEmpty()) {
            return null;
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == capacity() / 4 && capacity() / 2 != 0) {
            resize(capacity() / 2);
        }
        return res;
    }

    @Override
    public E peek() {

        if (isEmpty()) {
            return null;
        }
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    public int capacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoopQueue[");
        if (!isEmpty()) {
            int i = front;
            for (; i != tail; i = (i + 1) % data.length) {
                sb.append(data[i]);
                if ((i + 1) % data.length != tail)
                    sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++)
            q.offer(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < opCount ; i ++)
            q.poll();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 10000000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }
}
