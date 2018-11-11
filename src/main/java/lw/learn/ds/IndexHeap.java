package lw.learn.ds;

import lw.learn.algorithm.sort.SortUtil;

import java.util.Comparator;

/**
 * @Author lw
 * @Date 2018-11-11 19:22:53
 **/
public class IndexHeap<Item> {

    private Item[] data;
    private int[] indexes;
    private int[] reverse;

    private int size;
    private int capacity;

    private Comparator<Item> comparator;

    public static final int DEFAULT_QUEUE_SIZE = 10;


    public IndexHeap(int capacity, Comparator<Item> comparator) {
        this.capacity = capacity;
        this.comparator = comparator;
        indexes = new int[capacity];
        reverse = new int[capacity];
        data = (Item[]) new Object[DEFAULT_QUEUE_SIZE];
    }

    public IndexHeap(Comparator<Item> comparator) {
        this(DEFAULT_QUEUE_SIZE, comparator);
    }

    public void add(int index, Item item) {

        ensureCapacity();
        data[index] = item;
        indexes[size] = index;
        reverse[index] = size;
        shifUp(size);
        size++;

    }

    public void push(Item item) {
        add(size, item);
    }

    public Item pop() {
        Item item;
        item = data[indexes[0]];
        size--;
        SortUtil.swap(indexes, size, 0);
        SortUtil.swap(reverse, indexes[size], indexes[0]);
        indexes[0] = indexes[size];
        shifDown(0);
        return item;
    }

    public Item peek() {
        return data[indexes[0]];
    }
    public void change(int index, Item item) {

        data[index] = item;
        shifUp(reverse[index]);
        shifDown(reverse[index]);

    }


    private void shifUp(int k) {

        while (k > 0 && comparator.compare(data[indexes[k]], data[indexes[parent(k)]]) > 0) {
            int parent = parent(k);
            SortUtil.swap(indexes, k, parent);
            SortUtil.swap(reverse, indexes[k], indexes[parent]);
            k = parent;
        }

    }

    private void shifDown(int k) {

        while (2 * k <= size) {

            int i = left(k);
            int j = i + 1;
            if (j <= size && comparator.compare(data[indexes[i]], data[indexes[j]]) < 0)
                i = j;

            if (comparator.compare(data[indexes[i]], data[indexes[k]]) <= 0)
                break;

            SortUtil.swap(indexes, i, k);
            SortUtil.swap(reverse, indexes[i], indexes[k]);
            k = i;
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
        IndexHeap<Integer> integerIndexHeap = new IndexHeap<>((a, b) -> b - a);
        for (int i = 0; i < 10; i++) {
            integerIndexHeap.push(i);
        }
        integerIndexHeap.change(9, -1);
        System.out.println(integerIndexHeap.peek());
    }

}
