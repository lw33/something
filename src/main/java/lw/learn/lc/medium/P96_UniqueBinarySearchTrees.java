package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-12-24 01:11:24
 **/
public class P96_UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int count=0;

        if(n<2) return 1;
        if(2==n) return n;

        for(int i=0; i<n; ++i)
            count += numTrees(i) * numTrees(n-i-1);

        return count;
    }
}
