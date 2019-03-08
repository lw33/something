package lw.learn.lc.design;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author lw
 * @Date 2019-03-08 11:42:18
 **/
public class P384_ShuffleAnArray {

    class Solution {

        private int[] original;

        public Solution(int[] nums) {
            original = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return original;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] shuffle = Arrays.copyOf(original, original.length);
            Random random = new Random();
            for (int i = original.length - 1; i >= 0; i--) {
                int sf = random.nextInt(i + 1);
                swap(shuffle, i, sf);
            }
            return shuffle;
        }

        public void swap(int[] arr, int i, int j) {

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

        }
    }

}
