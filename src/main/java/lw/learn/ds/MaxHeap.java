package lw.learn.ds;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @Author lw
 * @Date 2018-11-05 17:50:52
 **/
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capactiy) {
        data = new Array<>(capactiy);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(E e) {
        data.addLast(e);
        shifUp(size() - 1);
    }
    private void shifUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E max() {
        return data.getFirst();
    }

    public E extractMax() {
        E res = max();
        data.swap(0, data.size() - 1);
        data.removeLast();
        shiftDown(0);
        return res;
    }

    private void shiftDown(int index) {

        while (size() > left(index)) {
            int j = left(index);
            if (j + 1 < size() && data.get(j).compareTo(data.get(j + 1)) < 0) {
                j++;
            }
            if (data.get(j).compareTo(data.get(index)) <= 0)
                break;
            data.swap(j, index);
            index = j;
        }

    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;


    }
}
