package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-22 22:51:47
 **/
public class P292_NimGame {

    public boolean canWinNim(int n) {
        if(n % 4 == 0)
            return false;
        return true;
    }

}
