package lw.learn.lc.uf;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-09 21:04:28
 **/
public class P547_FriendCircles {

    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int n = M.length;

        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count();
    }

    public class UF {

        int[] ids;
        int count;

        public UF(int size) {
            ids = new int[size];
            for (int i = 0; i < ids.length; i++) {
                ids[i] = i;
            }
            count = size;
        }


        public void union(int i, int j) {
            int ip = find(i);
            int jp = find(j);
            if (ip != jp) {
                --count;
                ids[ip] = ids[jp];
            }
        }

        public int find(int i) {

            if (ids[i] != i) {
                ids[i] = find(ids[i]);
            }
            return ids[i];
        }

        public int count() {
            return count;
        }
    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[1,1,0],[1,1,0],[0,0,1]]");
        System.out.println(this.findCircleNum(arr));
    }
}
