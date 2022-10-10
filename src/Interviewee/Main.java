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

    public static void main(String[] args) {

        Main main = new Main();

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(5);
        set.add(3);
        for(int num : set)
            System.out.println(num);
//        Map<Integer,Integer> map = new HashMap<>();
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        Stack<Integer> stack = new Stack<>();
//
//        List<List<Integer>> list = new ArrayList<>();
//        System.out.println(1^2);

        System.out.println((2>1) == (3>2));
        System.out.println((0>1) == (1>2));

    }

}

