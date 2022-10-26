package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-26 18:36
 * @Description
 */
public class H指数二275M {

    public int hIndex(int[] citations) {
        int left=0,right=citations.length,n=citations.length;
        while(left <= right){
            int mid = left + (right-left)/2;
            // 计数大于等于mid的个数
            if(n - lower_search(citations,mid) >= mid){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }

    private int lower_search(int[] nums,int value){
        int left=0,right=nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] >= value){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        H指数二275M main = new H指数二275M();

        /**
         * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，
         * citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
         *
         * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指
         * 他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
         * 且其余的 n - h 篇论文每篇被引用次数 不超过 h 次。
         *
         * 提示：如果 h 有多种可能的值，h 指数 是其中最大的那个。
         * 请你设计并实现对数时间复杂度的算法解决此问题。
         */
        System.out.println(main.hIndex(new int[]{0,1,3,5,6})); // 3
        System.out.println(main.hIndex(new int[]{1,2,100})); // 2
    }
}
