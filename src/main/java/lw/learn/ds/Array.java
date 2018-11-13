package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-04 17:37:21
 **/

public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public Array() {
        data = (E[]) new Object[10];
    }

    // 增
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;

    }

    public void addLast(E e) {

        add(size, e);

    }


    public void addFirst(E e) {
        add(0, e);
    }

    // 删
    public E remove(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        E del = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        //if (size == data.length / 4 && data.length / 2 != 0)
        if (size == data.length / 4)
            resize(data.length / 2);
        return del;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeElement(E e) {
        int index = find(e);
        if (index == -1) {
            return null;
        }
        return remove(index);
    }

    // 改
    public void set(int index, E e) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        data[index] = e;

    }

    // 查
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");

        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int capacity() {
        return data.length;
    }


    private void ensureCapacity() {

        if (size == data.length)
            resize(2 * size);
    }

    private void resize(int newCapacity) {
        if (newCapacity > size) {

            E[] e = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                e[i] = data[i];
            }
            data = e;
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        E tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array[");
        if (!isEmpty()) {
            int i = 0;
            for (; i < size - 1; i++) {
                sb.append(data[i] + ", ");
            }
            sb.append(data[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Array<String> stringArray = new Array<>();
      /*  stringArray.addFirst("java");
        stringArray.addFirst("java");
        stringArray.addFirst("java");
        stringArray.addFirst("java");
        stringArray.addFirst("java");
        stringArray.addFirst("java");
        stringArray.addFirst("java");
        stringArray.addFirst("java");
        System.out.println(stringArray);
        stringArray.removeFirst();
        System.out.println(stringArray);
        stringArray.removeLast();
        System.out.println(stringArray);
        stringArray.set(1, "555");*/
        System.out.println(stringArray);
    }
}

