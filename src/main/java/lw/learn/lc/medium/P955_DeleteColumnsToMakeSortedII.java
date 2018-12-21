package lw.learn.lc.medium;


/**
 * @Author lw
 * @Date 2018-12-20 14:03:55
 **/
public class P955_DeleteColumnsToMakeSortedII {

    public int minDeletionSize(String[] A) {
        int len = A[0].length();//记录单个个词语的长度
        int rows = A.length;//记录有多少个词语
        int count = 0;//记录需要删除的列
        boolean[] sorted = new boolean[rows];//标记该词汇是否已经有序
        int i, j;
        for(j = 0; j < len; j++){
            for(i = 0; i < rows - 1; i++){
                if(!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)){
                    count++;
                    break;
                }
            }
            if(i < rows -1){
                continue;
            }
            for(i = 0; i < rows - 1; i++){
                if(A[i].charAt(j) < A[i+1].charAt(j)){
                    sorted[i] = true;
                }
            }
        }
        return count;
    }
}
