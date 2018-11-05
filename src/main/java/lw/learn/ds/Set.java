package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-04 21:56:18
 **/
public interface Set<E> {

    void add(E e);

    E remove(E e);

    boolean contains(E e);

    int size();

    boolean isEmpty();
}
