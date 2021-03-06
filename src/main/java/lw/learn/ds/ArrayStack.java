package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-04 17:45:18
 **/
public class ArrayStack<E> implements Stack<E>{

    private Array<E> stack;

    public ArrayStack(int capacity) {

        stack = new Array<>(capacity);

    }

    public ArrayStack() {

        this.stack = new Array<>();

    }

    @Override
    public void push(E e) {
        stack.addFirst(e);
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            E e = stack.removeFirst();
            return e;
        }
        return null;
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return stack.get(0);
        }
        return null;
    }

    @Override
    public int search(E e) {
        return stack.find(e);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        String s = stack.toString();
        return s.replace("Array", "Stack");
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        stack.push(132);
        stack.push(234);
        stack.push(1234);
        stack.push(344);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
