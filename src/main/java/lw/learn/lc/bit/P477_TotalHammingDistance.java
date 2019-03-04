package lw.learn.lc.bit;

/**
 * @Author lw
 * @Date 2019-03-03 23:40:02
 **/
public class P477_TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                res += swar(xor);
            }
        }
        return res;
    }

    public static int swar(int num) {
        num = (num & 0x55555555) + ((num >> 1) & 0x55555555);
        num = (num & 0x33333333) + ((num >> 2) & 0x33333333);
        num = (num & 0x0f0f0f0f) + ((num >> 4) & 0x0f0f0f0f);
        num = (num * 0x01010101) >> 24;
        return num;
    }
}
