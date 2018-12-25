package lw.learn.lc.easy;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-25 00:37:41
 **/
public class P605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0)
            return true;
        for (int i = 0; i < flowerbed.length; i++) {
            int left = i == 0 ? 0 : i - 1;
            int right = i + 1 == flowerbed.length ? i : i + 1;
            if (flowerbed[i] == 0 && flowerbed[left] == 0 && flowerbed[right] == 0) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        //[1,0,1,0,1,0,1]
        //1
        int[] arr = JSON2Java.json2intArray("[1,0,1,0,1,0,1]");
        System.out.println(this.canPlaceFlowers(arr, 1));
    }
}
