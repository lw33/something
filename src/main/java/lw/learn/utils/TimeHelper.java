package lw.learn.utils;

import java.util.function.BiConsumer;

/**
 * @Author lw
 * @Date 2018-11-07 19:35:57
 **/
public class TimeHelper {

    public static<T, U> long duration(BiConsumer<T, U> consumer, T t, U u) {

        long start = System.currentTimeMillis();
        consumer.accept(t, u);
        long end = System.currentTimeMillis();
        return end - start;
    }



}
