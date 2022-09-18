package 数据结构.单调栈;

import Utils.ArrayUtils;

import java.util.Stack;

/**
 * @author Cenmo
 * @Date 2022-03-14 2022-03-14
 */
public class 单调栈 {

    public int[][] foundMonotoneStackNoRepeat (int[] nums) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int[] tempArr = new int[nums.length+2];
        System.arraycopy(nums,0,tempArr,1,nums.length);
        tempArr[0] = -1;
        tempArr[tempArr.length-1] = -1;
        new ArrayUtils().print(tempArr);

        int[][] res = new int[nums.length][2];
        for(int i=0;i<tempArr.length;i++){
            while(!stack.isEmpty() && tempArr[stack.peek()] > tempArr[i]){
                int index = stack.pop()-1;
                res[index][0] = stack.peek()-1;
                res[index][1] = i==tempArr.length-1?-1:i-1;
            }
            stack.push(i);// push坐标
        }
        return res;
    }

    public int[][] foundMonotoneStack (int[] nums) { // 包含连续重复项
        // write code here
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;

        int[][] res = new int[n][2];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                res[stack.pop()][1] = i;
            }
            stack.push(i);// push坐标
        }
        while(!stack.isEmpty()) res[stack.pop()][1] = -1;
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                res[stack.pop()][0] = i;
            }
            stack.push(i);// push坐标
        }
        while(!stack.isEmpty()) res[stack.pop()][0] = -1;
        return res;
    }

    public static void main(String[] args) {
        单调栈 main = new 单调栈();

        int[] ints = {3,4,1,5,6,2,7}; //不含重复项 [[-1,2],[0,2],[-1,-1],[2,5],[3,5],[2,-1],[5,-1]]
//        int[] ints = {1,1,1,1}; //含连续重复项 [[-1,-1],[-1,-1],[-1,-1],[-1,-1]]
        int[][] res = main.foundMonotoneStack(ints);
        for(int i=0;i<res.length;i++){
            System.out.print("["+res[i][0]+","+res[i][1]+"],");
        }
        System.out.println();
        new ArrayUtils().print(res);

    }
}
