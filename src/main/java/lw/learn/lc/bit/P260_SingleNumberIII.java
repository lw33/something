package lw.learn.lc.bit;

/**
 * @Author lw
 * @Date 2019-03-03 23:27:23
 **/
public class P260_SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int a = 0, b = 0;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int one = 1;
        while ((xor & 1) != 1) {
            one <<= 1;
            xor >>= 1;
        }

        for (int num : nums) {
            if ((num & one) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
