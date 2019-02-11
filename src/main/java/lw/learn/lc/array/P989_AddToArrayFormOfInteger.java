package lw.learn.lc.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-11 21:05:36
 **/
public class P989_AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] A, int K) {

        LinkedList<Integer> res = new LinkedList<>();
        int carry = 0;

        for (int i = A.length - 1; i >= 0; i--) {
            int digit = K % 10 + A[i] + carry;
            if (digit >= 10) {
                carry = digit / 10;
                digit %= 10;
            } else {
                carry = 0;
            }
            K /= 10;
            res.addFirst(digit);
        }
        while (K > 0) {
            int digit = K % 10 + carry;
            if (digit >= 10) {
                carry = digit / 10;
                digit %= 10;
            } else {
                carry = 0;
            }
            res.addFirst(digit);
            K /= 10;
        }
        if (carry > 0) {
            res.addFirst(carry);
        }
        return res;
    }
}
