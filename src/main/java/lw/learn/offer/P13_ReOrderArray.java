package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-01 17:53:56
 * <p>
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 **/
public class P13_ReOrderArray {

    public void reOrderArray(int[] array) {

        int[] aux = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                aux[index++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 0) {
                aux[index++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = aux[i];
        }
    }

    @Test
    public void test() {

        for (int i = 0; i < 1000000000; i++) {
            //System.out.print(i + "\t" + this.isodd(i) + "\t");
            //if (i % 7 == 0) {
            //    System.out.println();
            //}
            if (!isodd(i) && isOdd(i)) {
                System.out.println(i);
            }
        }
    }

    public boolean isodd(int num) {
        return (num & 1) == 1;
    }

    public boolean isOdd(int num) {
        return num % 2 == 1;
    }
}
