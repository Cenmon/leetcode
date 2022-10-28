package Interviewee;

import java.util.*;

public class Main {

    public int minAbsDifference(int[] nums, int goal) {
        Arrays.sort(nums);
        int left=0,right=0,n=nums.length;
        int sum = 0,ans=Integer.MAX_VALUE;
        while(left < n){
            while(right < n && sum + nums[right] < goal){
                sum += nums[right++];
            }
            System.out.println(right +" , " + sum);
            ans = Math.min(ans,Math.abs(sum - goal));
            sum -= nums[left++];
        }
        return ans;
    }

    public int[][] findContinuousSequence(int target) {
        int left=1,right=2;
        int sum = left+right;
        List<int[]> ans = new ArrayList<>();
        while(right < target){
            if(sum < target){
                right++;
                sum += right;
            }else if(sum > target){
                sum -= left;
                left++;
            }else{
                List<Integer> list = new ArrayList<>();
                for(int i=left;i<=right;i++){
                    list.add(i);
                }
//                list.toArray(new int[list.size()]);
//                ans.add();
                left++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    private int countGreaterAndEqual(int[] citations,int h){
        int left=0,right=citations.length-1;
        // 最左二分
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(citations[mid] >= h){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println("left = " + left);
        return citations.length - left;
    }

    public static void main(String[] args) {

        Main main = new Main();

        Set<Integer> set = new HashSet<>();

//        Map<Integer,Integer> map = new HashMap<>();
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        Stack<Integer> stack = new Stack<>();
//
        List<Integer> list = new ArrayList<>();
//        System.out.println(1^2);
//        list.add(0);

        list.add(1,1);
        System.out.println(list.toString());




    }

}

