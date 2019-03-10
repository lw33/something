package lw.learn.lc.recursion;

/**
 * @Author lw
 * @Date 2019-03-10 11:43:00
 **/
public class P779_KThSymbolInGrammar {

    public int kthGrammar(int N, int K) {
        if (N < 2) {
            return 0;
        }
        //return kthGrammar(N)[K - 1];

        for (int i = 0; i < N; i++) {
            //K /= 2;
            K = (K + 1) / 2;
        }

        return K;
    }

    private int[] kthGrammar(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        int[] arr = kthGrammar(n - 1);
        int[] nArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                nArr[2 * i] = 0;
                nArr[2 * i + 1] = 1;
            } else {
                nArr[2 * i] = 1;
                nArr[2 * i + 1] = 0;
            }
        }
        return nArr;
    }

    public int kthGrammarII(int N, int K) {
        if (N < 2) {
            return 0;
        }
        int[] arr = new int[(int) Math.pow(2, N - 1)];
        kthGrammarII(N, arr);
        return arr[K - 1];
    }

    private int kthGrammarII(int n, int[] arr) {
        if (n == 0) {
            return 1;
        }
        int i = kthGrammarII(n, arr);
        int len = i * 2;
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] == 0) {
                arr[2 * j] = 0;
                arr[2 * j + 1] = 1;
            } else {
                arr[2 * j] = 1;
                arr[2 * j + 1] = 0;
            }
        }
        return len;
    }

    public int kthGrammarIII(int N, int K) {
        if (N <= 2) {
            return K - 1;
        }
        int n = kthGrammarIII(N - 1, (K + 1) / 2);
        return n == 1 ? K & 1 : (K + 1) & 1;
    }
}
