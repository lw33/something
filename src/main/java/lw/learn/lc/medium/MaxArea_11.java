package lw.learn.lc.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-09 00:17:52
 **/
public class MaxArea_11 {


    public int maxArea666(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        int area;
        while (r > l) {
            area = Math.min(height[r], height[l]) * (r - l);
            max = Math.max(area, max);
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int len = height.length - 1;
        int r = len;
        int max = 0;
        int area;
        for (int i = 0; i < height.length; i++) {
            while (r > i) {
                area = Math.min(height[r], height[i]) * (r - i);
                max = Math.max(area, max);
                if (height[r] > height[i]) {
                    break;
                }
                r--;
            }
            r = len;
        }
        return max;
    }

    @Test
    public void test() {
        //[1,8,6,2,5,4,8,3,7]
        //输出: 49
        int[] arr = {4, 4, 2, 11, 0, 11, 5, 11, 13, 8};
        System.out.println(this.maxArea666(arr));
    }
}
