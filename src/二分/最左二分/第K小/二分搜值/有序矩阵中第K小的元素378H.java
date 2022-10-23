package 二分.最左二分.第K小.二分搜值;

/**
 * @Author Cenmo
 * @Date 2022-10-23 19:48
 * @Description
 */
public class 有序矩阵中第K小的元素378H {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left=matrix[0][0],right=matrix[n-1][n-1];
        while(left <= right){
            int mid = left + (right - left) / 2;

            if(countLessOrEqual(matrix,mid,n) >= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private int countLessOrEqual(int[][] matrix,int value,int n){
        int count = 0;
        int i = 0,j = n-1; // 右上角
        while(i<n && j>=0){ // 左下角之前
            if(matrix[i][j] <= value){
                count += j+1;
                i++;
            }else{
                j--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        有序矩阵中第K小的元素378H main = new 有序矩阵中第K小的元素378H();

        /**
         * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
         * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
         *
         * 你必须找到一个内存复杂度优于 O(n2) 的解决方案。
         */

        System.out.println(main.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8)); // 13
        System.out.println(main.kthSmallest(new int[][]{{-5}},1)); // -5
    }
}
