package 递归.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author Cenmo
 * @Date 2022-03-07 2022-03-07
 */
public class 有重复项数字的全排列_回溯 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        int len = num.length;
        boolean[] visit = new boolean[len];
        Stack<Integer> stack = new Stack<>();

        Arrays.sort(num);
        ArrayList<Integer> repeat = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(visit[i] == false && !repeat.contains(num[i])){ //前者保证全排列，后者保证宽度优先节点不重复
                func(num,visit,i,len,1,stack);
                repeat.add(num[i]);
            }
        }
        return res;
    }

    /**
     * 深度优先+回溯
     * @param num
     * @param visit
     * @param index
     * @param len
     * @param cur：递归层数
     * @param stack
     */
    public void func(int[] num,boolean[] visit,int index,int len,int cur,Stack<Integer> stack){
        visit[index] = true;
        stack.push(num[index]);
        if( cur == len ){
            res.add(new ArrayList<Integer>(stack));
        }
        ArrayList<Integer> repeat = new ArrayList<>();
        for(int i=0;i<len;i++){
            if(visit[i] == false && !repeat.contains(num[i])){ //前者保证全排列，后者保证宽度优先节点不重复
                func(num,visit,i,len,cur+1,stack);
                repeat.add(num[i]);
            }
        }
        stack.pop();
        visit[index] = false;
    }

    public static void main(String[] args) {
        有重复项数字的全排列_回溯 main = new 有重复项数字的全排列_回溯();

        int[] arr =new int[]{1,1,2};
//        int[] arr =new int[]{0,1};
        ArrayList<ArrayList<Integer>> arrayLists = main.permuteUnique(arr);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList.toString());
        }
    }
}
