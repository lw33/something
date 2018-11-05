package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-04 18:01:20
 **/
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> queue;

    public ArrayQueue(int capacity) {
        queue = new Array<>(capacity);
    }

    public ArrayQueue() {
        queue = new Array<>();
    }

    @Override
    public void offer(E e) {
        queue.addLast(e);
    }


    @Override
    public E poll() {
        return queue.removeFirst();
    }



    @Override
    public E peek() {
        return queue.getFirst();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        String s = queue.toString();
        return s.replace("Array", "Queue");
    }

    public static void main(String[] args) {
        Queue<String> queue = new ArrayQueue<>();
        queue.offer("java");
        queue.offer("javac");
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);
    }

}
