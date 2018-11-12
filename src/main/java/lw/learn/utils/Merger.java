package lw.learn.utils;

/**
 * @Author lw
 * @Date 2018-11-06 14:32:47
 **/
@FunctionalInterface
public interface Merger<E> {

    E merge(E e1, E e2);
}
