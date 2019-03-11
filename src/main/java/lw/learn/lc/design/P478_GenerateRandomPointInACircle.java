package lw.learn.lc.design;

import java.util.Random;

/**
 * @Author lw
 * @Date 2019-03-11 16:11:48
 **/
public class P478_GenerateRandomPointInACircle {

    class Solution {

        private double radius;
        private double x;
        private double y;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x = x_center;
            this.y = y_center;
        }

        public double[] randPoint() {
            while (true) {
                Random random = new Random();
                double rx = (x - radius) + (random.nextDouble() * (2 * radius));
                double ry = (y - radius) + (random.nextDouble() * (2 * radius));
                if ((rx - x) * (rx - x) + (ry - y) * (ry - y) <= radius * radius) {
                    return new double[]{rx, ry};
                }
            }
        }

    }

}
