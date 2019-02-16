package lw.learn.lc.array;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-02-15 13:34:15
 **/
public class P888_FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        HashSet<Integer> setB = new HashSet<>();

        for (int i : A) {
            sumA += i;
        }
        for (int i : B) {
            sumB += i;
            setB.add(i);
        }
        int end = (sumA + sumB) / 2;
        int target = end - sumA;
        for (int i : A) {
            if (setB.contains(i + target)) {
                return new int[]{i, i + target};
            }
        }
        return null;
    }
}
