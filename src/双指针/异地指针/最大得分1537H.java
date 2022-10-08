package 双指针.异地指针;

/**
 * @Author Cenmo
 * @Date 2022-10-08 11:46
 * @Description
 */
public class 最大得分1537H {

    public int maxSum(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int m=nums1.length,n=nums2.length;
        long score1=0,score2=0;
        while(i<m || j<n){
            if(i == m){
                score2 += nums2[j++];
            }else if(j == n){
                score1 += nums1[i++];
            }else if(nums1[i] < nums2[j]){
                score1 += nums1[i++];
            }else if(nums2[j] < nums1[i]){
                score2 += nums2[j++];
            }else{
                score1 = Math.max(score1,score2) + nums1[i];
                score2 = score1;
                i++;j++;
            }
        }
        return (int)(Math.max(score1,score2) % 1000000007);
    }


    public static void main(String[] args) {
        最大得分1537H main = new 最大得分1537H();

        /**
         * 给定有序无重复元素数组nums1,nums2,
         * 规定从下标0开始往右遍历，当遇到两个数组元素相同时可以传送到另一个数组形成新的路径
         * 返回最大路径元素总和，结果膜除10e9+7
         */
        System.out.println(main.maxSum(new int[]{2,4,5,8,10},new int[]{4,6,8,9})); // 30
        System.out.println(main.maxSum(new int[]{1,3,5,7,9},new int[]{3,5,100})); // 109
        System.out.println(main.maxSum(new int[]{1,2,3,4,5},new int[]{6,7,8,9,10})); // 40
        System.out.println(main.maxSum(new int[]{1,4,5,8,9,11,19},new int[]{2,3,4,11,12})); // 61
    }
}
