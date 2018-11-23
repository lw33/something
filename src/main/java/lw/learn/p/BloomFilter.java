package lw.learn.p;

/**
 * @Author lw
 * @Date 2018-11-22 23:55:23
 **/
public class BloomFilter {

    private long size;
    private double probability;
    public static final long G = 1024 * 1024 * 1024 * 8;

    /**
     *
     */
    public BloomFilter(int size, boolean greedy) {
        this.size = size * G;
        throw new IllegalArgumentException("");
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(0, false);
    }
}
