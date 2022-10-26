package 二分.最左二分.第K小.二分搜值;

/**
 * @Author Cenmo
 * @Date 2022-10-25 19:40
 * @Description
 */
public class 有序矩阵中的第k个最小数组和1439H {

    public int kthSmallest(int[][] mat, int k) {
        int left=0,right=0,n=mat[0].length;
        for(int[] arr : mat){
            left += arr[0];
            right += arr[n-1];
        }
        int sum = left;
        while(left <= right){
            int mid = left+(right-left)/2;
            // 深搜计数数组和小于等于mid的个数是否大于等于k
            if(dfs(mat,mid,0,sum,k) >= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private int dfs(int[][] mat,int value,int row,int sum,int k){
        if(sum > value) return 0;
        if(row == mat.length) return 1;

        int count = 0;
        for(int j=0,n=mat[0].length;j<n;j++){
            if(sum - mat[row][0] + mat[row][j] <= value){
                count += dfs(mat,value,row+1,sum - mat[row][0] +mat[row][j],k);
                if(count >= k) break; // 剪枝
            }else{
                break;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        有序矩阵中的第k个最小数组和1439H main = new 有序矩阵中的第k个最小数组和1439H();

        /**
         * 给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
         *
         * 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
         */
        System.out.println(main.kthSmallest(new int[][]{{1,3,11},{2,4,6}},5));// 7
        System.out.println(main.kthSmallest(new int[][]{{1,3,11},{2,4,6}},9));// 17
        System.out.println(main.kthSmallest(new int[][]{{1,10,10},{1,4,5},{2,3,6}},7));// 9
        System.out.println(main.kthSmallest(new int[][]{
                {13,88,148,211,300,330,399},
                {71,123,163,229,289,346,357},
                {45,47,49,75,202,241,283},
                {45,48,146,231,243,372,400},
                {40,192,271,279,285,308,368},
                {128,137,173,221,344,361,368},
                {67,107,119,281,372,384,396},
                {2,6,78,102,230,265,355},
                {2,69,97,134,157,331,392},
                {77,147,175,213,248,336,355},
                {7,58,202,275,283,339,366},
                {74,101,158,162,330,363,371},
                {78,138,177,177,197,204,379}},50));// 691
    }
}
