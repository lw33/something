package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-11 22:11:27
 **/
public class P42_TrappingRainWater {


    public int trap666(int[] height) {

        if (height.length < 3) {
            return 0;
        }

        int res = 0;

        int l = 0;
        int r = height.length - 1;

        for (int i = 1; i < height.length - 1; i++) {

        }
        return 0;
    }


    /**
     * 求出当前位置左边最大值与右边最大值 比较得出当前位置积水量
     * @param height
     * @return
     */
    public int trap(int[] height) {

        if (height.length < 3) {
            return 0;
        }
        int res = 0;
        // 一个数组 装当前位置左边的最大值
        int[] lMax = new int[height.length];
        // 0位置
        lMax[0] = height[0];
        // 一个数组 装当前位置右边的最大值
        int[] rMax = new int[height.length];
        int j = height.length - 1;
        // 最后一个
        rMax[j] = height[j];

        // 遍历 填充数组
        for (int i = 1; i < height.length; i++) {
            --j;
            lMax[i] = lMax[i - 1] < height[i] ? height[i] : lMax[i - 1];
            rMax[j] = rMax[j + 1] < height[j] ? height[j] : rMax[j + 1];
        }

        // 遍历 使用当前位置与左右中最小的高度比较 得出当前位置的结果
        for (int i = 1; i < height.length -1 ; i++) {
            int min = lMax[i] < rMax[i] ? lMax[i] : rMax[i];
            res += height[i] >= min ? 0 : min - height[i];
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = JSON2Java.json2intArray("[0,1,0,2,1,0,1,3,2,1,2,1]");
        System.out.println(this.trap(arr));
    }
}
