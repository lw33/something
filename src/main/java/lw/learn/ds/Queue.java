package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-04 18:00:03
 **/
public interface Queue<E> {


    void offer(E e);


    E poll();


    E peek();

    int size();

    boolean isEmpty();
}
