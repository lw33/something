package lw.learn.nk.mock.f1.p2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt(); // day
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            if (safe(A, B, C, N)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean safe(int one, int two, int three, int days) {
        if (days == 0) {
            return true;
        }
        while (days > 0) {
            int iceCream = 6;
            while (three > 0 && iceCream >= 3) {
                iceCream -= 3;
                --three;
            }
            while (two > 0 && iceCream >= 2) {
                iceCream -= 2;
                --two;
            }
            while (one > 0 && iceCream >= 1) {
                iceCream -= 1;
                --one;
            }
            if (iceCream != 0) {
                return false;
            }
            days--;
        }
        return true;
    }
}
