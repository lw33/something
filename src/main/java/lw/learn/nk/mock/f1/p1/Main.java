package lw.learn.nk.mock.f1.p1;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int f = in.nextInt();
        int d = in.nextInt();
        int p = in.nextInt();
        if (d / x <= f) {
            System.out.println(d / x);
        } else {
            System.out.println(f + ((d - f * x) / (x + p)));
        }
    }
}
