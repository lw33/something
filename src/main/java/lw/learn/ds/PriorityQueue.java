package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-05 22:23:19
 **/
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void offer(E e) {
        maxHeap.add(e);
    }

    @Override
    public E poll() {
        return maxHeap.extractMax();
    }

    @Override
    public E peek() {
        return maxHeap.max();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
