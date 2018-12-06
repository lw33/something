package lw.learn.lc.easy;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-06 21:38:30
 **/
public class ArrayPairSum_561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    // todo 666
    public int arrayPairSum666(int[] nums){
        int[] a = new int[20001];
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            a[nums[i] + 10000]++;
        }

        boolean even = false;
        for(int i=0; i<a.length; i++){
            while(a[i] > 0){
                if(!even){
                    sum += i - 10000;
                }
                even = !even;
                a[i]--;
            }
        }
        return sum;
    }
}
