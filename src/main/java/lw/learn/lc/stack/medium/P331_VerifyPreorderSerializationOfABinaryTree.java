package lw.learn.lc.stack.medium;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-04 18:58:40
 **/
public class P331_VerifyPreorderSerializationOfABinaryTree {

    /**
     * 设置一个计数器 初始值为1 遇到 # 减去1 遇到数加 1 如果中间出现了 0 则为 false
     * 最后判断结果是否为 0
     * 以为 满二叉树的叶子节点数比非叶节点多1
     * 前序遍历 如果中间出现了 计数为零的情况 则证明树已经终止了 如果还有节点 那就说明不是个树
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 1 && preorder.charAt(0) == '#') {
            return true;
        }
        if (preorder.length() < 3) {
            return false;
        }
        char[] chars = preorder.toCharArray();
        int cnt = 1;
        for (int i = 0; i < chars.length; i++) {
            if (cnt == 0) {
                return false;
            }
            if (chars[i] == ',') {
                continue;
            }
            if (chars[i] == '#') {
                --cnt;
            } else {
                ++cnt;
                while (i < chars.length && chars[i] != ',') {
                    i++;
                }
            }
        }
        return cnt == 0;
    }
    
    @Test
    public void test() {
        String str = "91,13,14,#,#,10";
        System.out.println(this.isValidSerialization(str));
    }
}
