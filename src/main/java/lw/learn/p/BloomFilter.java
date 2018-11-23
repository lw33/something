package lw.learn.p;

/**
 * @Author lw
 * @Date 2018-11-22 23:55:23
 **/
public class BloomFilter {

    private long size;
    public static final long G = 1024 * 1024 * 1024 * 8;

    /**
     *
     */
    public BloomFilter(int size) {
        this.size = size * G;
    }
}
