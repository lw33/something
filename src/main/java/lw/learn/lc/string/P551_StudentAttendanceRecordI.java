package lw.learn.lc.string;

/**
 * @Author lw
 * @Date 2019-02-11 20:47:48
 **/
public class P551_StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        char[] chars = s.toCharArray();
        int a = 0;
        int l = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                a++;
                if (a > 1) {
                    return false;
                }
            } else if (chars[i] == 'L') {
                l++;
                if (l > 2) {
                    return false;
                }
            } else {
                l = 0;
            }
        }
        return true;
    }
}
