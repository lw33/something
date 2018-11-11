package lw.learn.ds;

import lw.learn.algorithm.sort.SortUtil;

import java.util.Comparator;

/**
 * @Author lw
 * @Date 2018-11-10 20:16:29
 **/
public class IndexHeap1<Item> {

    private Item[] data;
    private int[] indexes;

    private int size;
    private int capacity;

    private Comparator<Item> comparator;

    public static final int DEFAULT_QUEUE_SIZE = 10;

    public IndexHeap1(int capacity, Comparator<Item> comparator) {
        this.capacity = capacity;
        this.comparator = comparator;
        indexes = new int[capacity];
        data = (Item[]) new Object[DEFAULT_QUEUE_SIZE];
    }

    public IndexHeap1(Comparator<Item> comparator) {
        this(DEFAULT_QUEUE_SIZE, comparator);
    }

    public void add(int index, Item item) {

        ensureCapacity();
        data[index] = item;
        indexes[size] = index;
        shifUp(size);
        size++;
    }

    public Item pop() {

        Item item = data[indexes[0]];
        //data[indexes[0]] = null;
        size--;
        indexes[0] = indexes[size];
        //indexes[size] = -1;
        shifDown(0);
        return item;
    }

    public void push(Item item) {
        add(size, item);
    }


    public Item peek() {
        return data[indexes[0]];
    }

    public int peekIndex() {
        return indexes[0];
    }

    public void change(int i, Item item) {
        data[i] = item;
        for (int j = 0; j < size; j++) {
            if (indexes[j] == i) {
                shifUp(j);
                shifDown(j);
                return;
            }
        }
    }



    private void shifUp(int k) {

        while (k > 0 && comparator.compare(data[indexes[k]], data[indexes[parent(k)]]) > 0) {
            SortUtil.swap(indexes, k, (k - 1) / 2);
            k = parent(k);
        }

    }


    private void shifDown(int k) {

        while (2 * k <= size) {

            int left = left(k);
            int right = left + 1;
            if (right <= size && comparator.compare(data[indexes[left]], data[indexes[right]]) < 0)
                left = right;

            if (comparator.compare(data[indexes[k]], data[indexes[left]]) >= 0)
                return;

            SortUtil.swap(indexes, k, left);
            k = left;

        }
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == capacity)
            return;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public static void main(String[] args) {

        IndexHeap1<Integer> integerIndexHeap1 = new IndexHeap1<>((a, b) -> b - a);
        for (int i = 0; i < 10; i++) {
            integerIndexHeap1.push(i);
        }
        integerIndexHeap1.change(9, -1);
        System.out.println(integerIndexHeap1.peek());
    }

}
