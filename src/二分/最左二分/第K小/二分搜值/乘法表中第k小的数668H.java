package 二分.最左二分.第K小.二分搜值;

/**
 * @Author Cenmo
 * @Date 2022-10-23 22:24
 * @Description
 */
public class 乘法表中第k小的数668H {

    public int findKthNumber(int m, int n, int k) {
        // 第k小最小为1，最大为m*n
        int left=1,right=m*n;
        if (m > n) {
            m ^= n ^ (n = m); // 交换m,n,保证m小于n
        }
        while(left <= right){
            int mid = left + (right-left)/2;
            // 计数小于等于mid的个数
            if(countLessOrEqual(m,n,mid) >= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private int countLessOrEqual2(int m,int n,int value){
        int i=1,j=n,count = 0;
        while(i<=m && j>=0){
            if(i*j <= value){
                count += j;
                i++;
            }else{
                j--;
            }
        }
        return count;
    }

    private int countLessOrEqual(int m,int n,int value){
        int count = 0;
        for(int i=1;i<=m;i++){
            count += Math.min(value/i,n); // 利用乘法结果的序列关系
        }
        return count;
    }


    public static void main(String[] args) {
        乘法表中第k小的数668H main = new 乘法表中第k小的数668H();

        /**
         * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第 k 小的数字吗？
         *
         * 乘法表是大小为 m x n 的一个整数矩阵，其中 mat[i][j] == i * j（下标从 1 开始）。
         *
         * 给你三个整数 m、n 和 k，请你在大小为 m x n 的乘法表中，找出并返回第 k 小的数字。
         */
//        System.out.println(main.findKthNumber(3,3,5)); // 3
//        System.out.println(main.findKthNumber(2,3,6)); // 6
        System.out.println(main.findKthNumber(29999,16854,5348)); // 784
    }
}
