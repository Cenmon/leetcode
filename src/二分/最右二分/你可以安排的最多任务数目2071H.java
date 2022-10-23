package 二分.最右二分;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-22 10:36
 * @Description
 */
public class 你可以安排的最多任务数目2071H {

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        // 完成任务数最小为0,最大为task.length
        int left=0,right=tasks.length;
        while(left <= right){
            int mid = left + (right-left)/2;
            // 能否完成mid件任务
            if(canComleteKTask(tasks,workers,pills,strength,mid)){
                left = mid + 1; // 试探更多的任务数
            }else{
                right = mid - 1; // 减小任务数量
            }
        }
        return right;
    }

    private boolean canComleteKTask(int[] tasks,int[] workers,int pills,int strength,int k){
        boolean[] hasTask = new boolean[workers.length]; //工人是否有工作
        for(int i=k-1,j=workers.length-1;i>=0;i--){ // k个任务必须分配完
            if(j < 0) return false;
            if(workers[j] >= tasks[i]){
                hasTask[j] = true;
                while(j>=0 && hasTask[j]) j--; //跳到下一个最大力量值且没工作的工人
                continue;
            }

            if(pills <= 0) return false;
            pills--; //使用大力丸

            // 找到第一个大于等于task[i]-strength值的下标
            int idx = search(workers,tasks[i]-strength,hasTask);
            if(idx < 0) return false; //找不到
            if(idx == j) while(j>=0 && hasTask[j]) j--;

            hasTask[idx] = true;
        }
        return true;
    }

    private int search(int[] nums,int target,boolean[] hasTask){
        int n = nums.length;
        int left=0,right=n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        if(left < 0 || left == n) return -1;

        while(left<n && hasTask[left]) left++; // 第一个没有工作的
        return left==n ? -1 : left;
    }


    public static void main(String[] args) {
        你可以安排的最多任务数目2071H main = new 你可以安排的最多任务数目2071H();

        /**
         *  给定n个任务和m个工人其对应的数组task和worker，task[i]表示完成i任务需要的力量值，work[i]表示i工人的力量值
         *  当工人力量值大于等于任务的力量值时则该任务可以被完成
         *  现有pills片大力丸，每片大力丸增加strength点力量，但一个工人最多一片大力丸
         *  请返回做多能够完成多少个任务
         */
        System.out.println(main.maxTaskAssign(new int[]{3,2,1},new int[]{0,3,3},1,1));//3
        System.out.println(main.maxTaskAssign(new int[]{5,4},new int[]{0,0,0},1,5));//1
        System.out.println(main.maxTaskAssign(new int[]{10,15,30},new int[]{0,10,10,10,10},3,10));//2
        System.out.println(main.maxTaskAssign(new int[]{5,9,8,5,9},new int[]{1,6,4,2,6},1,5));//3
        System.out.println(main.maxTaskAssign(new int[]{74,41,64,20,28,52,30,4,4,63},new int[]{38},0,68));//1
    }
}
