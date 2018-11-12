package lw.learn.ds;

import lw.learn.utils.Merger;

/**
 * @Author lw
 * @Date 2018-11-06 14:11:48
 **/
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];

        buildSegmentTree(0, 0, data.length - 1);
    }

    // start ... end
    private void buildSegmentTree(int index, int start, int end) {
        if (start == end) {
            tree[index] = data[start];
            return;
        }

        int left = left(index);
        int right = right(index);

        int mid = start + ((end - start) >> 1);
        buildSegmentTree(left, start, mid);
        buildSegmentTree(right, mid + 1, end);
        tree[index] = merger.merge(tree[left], tree[right]);
    }

    public int size() {
        return data.length;
    }

    public E query(int start, int end) {
        if (start < 0 || start >= size() || end < 0 || end >= size() || start > end) {
            throw new IllegalArgumentException("index is illegal");
        }
        return query(0, 0, data.length - 1,start, end);
    }


    public void set(int index, E e) {

        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int i, int l, int r, int index, E e) {

        if (l == r) {
            tree[i] = e;
            return;
        }
        int mid = l + ((r - l) >> 1);

        int left = left(i);
        int right = right(i);

        if (index >= mid + 1) {
            set(right, mid + 1, r, index, e);
        } else {
            set(left, l, mid, index, e);
        }
        tree[i] = merger.merge(tree[left], tree[right]);
    }

    private E query(int index, int l, int r, int start, int end) {
        if (l == start && r == end) {
            return tree[index];
        }

        int mid = l + ((r - l) >> 1);
        int left = left(index);
        int right = right(index);
        if (start >= mid + 1) {
            return query(right, mid + 1, r, start, end);
        } else if (end <= mid) {
            return query(left, l, mid, start, end);
        } else {

            E leftQ = query(left, l, mid, start, mid);
            E rightQ = query(right, mid + 1, r, mid + 1, end);
            return merger.merge(leftQ, rightQ);
        }
    }


    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("index is illegal");
        }
        return data[index];
    }

    private int left(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("index is illegal");
        }

        return 2 * index + 1;
    }

    private int right(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException("index is illegal");
        }
        return 2 * index + 2;
    }
}
