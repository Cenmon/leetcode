package 递归.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Cenmo
 * @Date 2022-03-14 2022-03-14
 */
public class 加起来和为目标值的组合二_回溯 {

    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(num);
        doHelper(num,target,stack,-1);
        return arrayLists;
    }

    private void doHelper(int[] num, int target, Stack<Integer> stack,int index) {
        if(target == 0) arrayLists.add(new ArrayList<>(stack));
        else{
            ArrayList<Integer> repeat = new ArrayList<>();
            for(int i=index+1;i<num.length;i++){
                if(target - num[i] >= 0 && !repeat.contains(num[i])){
                    stack.push(num[i]);
                    doHelper(num,target-num[i],stack,i);
                    stack.pop();
                    repeat.add(num[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        加起来和为目标值的组合二_回溯 main = new 加起来和为目标值的组合二_回溯();

        //[[10,10,60],[10,20,50],[10,70],[20,60]]
        ArrayList<ArrayList<Integer>> arrayLists = main.combinationSum2(new int[]{100,10,20,70,60,10,50}, 80);
//        ArrayList<ArrayList<Integer>> arrayLists = main.combinationSum2(new int[]{2}, 1);
        System.out.println("arrayLists = " + arrayLists);
    }
}
