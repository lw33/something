package lw.learn.lc.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author lw
 * @Date 2019-01-14 21:35:31
 **/
public class P970_PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 18 && Math.pow(x, i) <= bound; ++i)
            for (int j = 0; j < 18 && Math.pow(y, j) <= bound; ++j) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound)
                    set.add(v);
            }

        return new ArrayList<>(set);
    }
}
