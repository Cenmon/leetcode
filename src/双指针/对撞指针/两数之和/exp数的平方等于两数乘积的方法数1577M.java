package 双指针.对撞指针.两数之和;

import java.util.Arrays;

public class exp数的平方等于两数乘积的方法数1577M {

    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = 0;
        for(int x : nums1){
            ans += twoMultiply(nums2,(long)x*x);// 防止数据溢出,int*long=long
        }
        for(int x : nums2){
//            System.out.println(x*x);
            ans += twoMultiply(nums1,(long)x*x); // 防止数据溢出,int*long=long
        }
        return ans;
    }

    // 两数之和的完成考虑版本
    private int twoMultiply(int[] num,long target){
        int left=0,right=num.length-1,count=0;
        while(left < right){
            // 解决数据溢出问题：int*int的结果还是int，但int*long的结果是long
            long mult = (long)num[left] * num[right];
            if(mult > target){
                right--;
            }else if(mult < target){
                left++;
            }else{
                // 首尾两端相同时：left+1和left，right-1和right同样能构成结果，故不能直接移动
                // 当首尾相同时，意味着中间也想通，可采用组合的思想
                if(num[left] == num[right]){
                    // 数组以排序，当两端相等，中间必定也相等，即从right-left+1个数里面抽取两个数
                    // 组合数Cn2 = n*(n-1)/2
                    count += (right-left+1)*(right-left)/2;
                    break;
                }
                // 数组有重复值时：无法确定是右移还是左移
                int count1=1,count2=1;
                while(left+1<right && num[left]==num[left+1]) {left++;count1++;}
                while(left<right-1 && num[right]==num[right-1]) {right--;count2++;}
                count += count1 * count2;
                left++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        exp数的平方等于两数乘积的方法数1577M main = new exp数的平方等于两数乘积的方法数1577M();

        /**
         *
         */

        System.out.println(main.numTriplets(new int[]{7,4},new int[]{5,2,8,9}));  // 1
        System.out.println(main.numTriplets(new int[]{1,1},new int[]{1,1,1})); // 9
        System.out.println(main.numTriplets(new int[]{7,7,8,3},new int[]{1,2,9,7})); // 2
        System.out.println(main.numTriplets(new int[]{4,7,9,11,23},new int[]{3,5,1024,12,18})); // 0
        System.out.println(main.numTriplets(new int[]{3,1,2,2},new int[]{1,3,4,4})); // 4
        System.out.println(main.numTriplets(new int[]{4,1,4,1,12},new int[]{3,2,5,4})); // 5
        System.out.println(main.numTriplets(new int[]{43024,99908},new int[]{1864})); // 0
    }
}
