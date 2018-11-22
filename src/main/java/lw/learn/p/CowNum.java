package lw.learn.p;

/**
 * @Author lw
 * @Date 2018-11-22 21:52:44
 **/
public class CowNum {

    public int cowNum(int year) {
        if (year < 3) {
            return year;
        }
        return cowNum(year - 1) + cowNum(year - 3);
    }

}
