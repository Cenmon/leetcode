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

        Map<Integer,Integer> map = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();

        Stack<Integer> stack = new Stack<>();

        List<List<Integer>> list = new ArrayList<>();


        int n = 4131564;
        int p = 95426843;
        long l = 126060114513456L;
        Object value = (n-2)*10000000000L;
        System.out.println("value = " + value);
        System.out.println(value.getClass());
        Object value2 = (p + l) / ( n-1 );
        System.out.println(value2.getClass() + " , value2 = " + value2);
//        for(int i=11;i<20;i++){
//            value *= 10;
//            System.out.println("i = "+ i + " , "+ value);
//        }

//        System.out.println("value = " + value);
    }

}

