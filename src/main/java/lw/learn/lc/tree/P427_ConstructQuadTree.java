package lw.learn.lc.tree;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-30 22:24:54
 **/
public class P427_ConstructQuadTree {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

    int n = 0;

    public Node construct(int[][] grid) {
        n = grid.length;
        Node root = dfs(grid, 0, 0, n, n);
        return root;
    }

    /**
     * 左上角 右下角
     *
     * @param grid
     * @param ti
     * @param tj
     * @param bi
     * @param bj
     * @return
     */
    private Node dfs(int[][] grid, int ti, int tj, int bi, int bj) {
        int hi = (bi + ti) / 2;
        int hj = (bj + tj) / 2;
        if (bi - ti == 1) {
            return new Node(grid[ti][tj] == 1 ? true : false, true, null, null, null, null);
        }
        Node topL = dfs(grid, ti, tj, hi, hj);
        Node topR = dfs(grid, ti, hj, hi, bj);
        Node bottomL = dfs(grid, hi, tj, bi, hj);
        Node bottomR = dfs(grid, hi, hj, bi, bj);
        if (topL.isLeaf && topR.isLeaf && bottomL.isLeaf && bottomR.isLeaf) {
            if (topL.val == topR.val && topR.val == bottomL.val && bottomL.val == bottomR.val) {
                return new Node(topL.val, topL.isLeaf, null, null, null, null);
            }
        }
        return new Node(true, false, topL, topR, bottomL, bottomR);
    }

    @Test
    public void test() {
        int[][] grid = JSON2Java.json2int2Array("[[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]");
        Node construct = this.construct(grid);

    }
}
