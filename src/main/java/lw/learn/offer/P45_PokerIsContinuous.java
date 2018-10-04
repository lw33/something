package lw.learn.offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author lw
 * @Date 2018-10-03 13:19:23
 *
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 *
 **/
public class P45_PokerIsContinuous {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 2 || numbers.length > 14) {
            return false;
        }
        Arrays.sort(numbers);
        int zeroCount = 0;
        for (; zeroCount < numbers.length; zeroCount++) {
            if (numbers[zeroCount] != 0) {
                break;
            }
        }
        int low = zeroCount;
        int high = numbers.length - 1;
        int interval = 0;
        while (high > low) {
            if (numbers[low] == numbers[low + 1]) {
                return false;
            }
            interval += numbers[low + 1] - numbers[low] - 1;
            low++;
        }
        return interval <= zeroCount ? true : false;
    }
    
    @Test
    public void test() {

        int count = 1000;
        int[] pokers = new int[14];

        for (int i = 0; i < count; i++) {
            Arrays.fill(pokers, 4);
            pokers[0] = 2;
            int pokerCount = new Random().nextInt(14) + 1;
            int[] poker = new int[pokerCount];
            for (int j = 0; j < pokerCount;) {
                int genPoker = new Random().nextInt(14);
                if (pokers[genPoker] == 0) {
                    continue;
                }
                poker[j] = genPoker;
                pokers[genPoker]--;
                j++;
            }
            int[] tmp = Arrays.copyOf(poker, pokerCount);
            if (this.isContinuous(poker)) {
                System.out.print(Arrays.toString(tmp) + " ");
                System.out.println(this.isContinuous(poker));
                System.out.println(Arrays.toString(poker));
                System.out.println("============================");
            }
          /*  System.out.print(Arrays.toString(poker) + " ");
            System.out.println(this.isContinuous(poker));
            System.out.println(Arrays.toString(poker));
            System.out.println("============================");*/
        }
    }

}
