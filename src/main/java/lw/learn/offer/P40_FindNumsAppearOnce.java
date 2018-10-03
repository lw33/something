package lw.learn.offer;

/**
 * @Author lw
 * @Date 2018-10-02 23:05:02
 * <p>
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 **/
public class P40_FindNumsAppearOnce {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        if (array == null || array.length % 2 == 1) {
            return;
        }

        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            num ^= array[i];
        }

        
    }

}
