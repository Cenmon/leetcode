package 双指针.对撞指针.两数之和;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 两数之和 {

	public int[] twoSum (int[] numbers, int target) {
        // write code here
        int length = numbers.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<length;i++)
            map.put(numbers[i],i);
        
        for(int i=0;i<length;i++){
            Integer key = target-numbers[i];
            Integer value = map.get(key);//target-numbers[i]的下标
            if(value != null && value != i){//target-number[i]存在 且 不是本身(value != i)
                if(value < i){
                    res[0]=value+1; res[1]=i+1;
                }else{
                    res[0]=i+1; res[1]=value+1;
                }
                break;
            }
        }
        return res;
    }

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> twoSum2 (int[] num, int target) { // num数组有序：对撞双指针
	    int left = 0,right = num.length - 1;
	    while(left < right){
	        int sum = num[left] + num[right];
	        if(sum == target){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num[left]);
                list.add(num[right]);
                ans.add(list);

                /**
                 * 加循环去重，如；num全0的情况
                 */
	            do {
	                left++; // 匹配下一对
                }while (left<num.length && num[left] == num[left-1]); // left<num.length保证数组不越界
            }else if(sum < target){
	            left++;
            }else{
	            right--;
            }
        }
	    return ans;
    }

	public static void main(String[] args){
		两数之和 main = new 两数之和();

		// int[] res =  main.twoSum(new int[] {3,2,4},6 );//2,3
		int[] res =  main.twoSum(new int[] {20,70,110,150},90 );//1,2
        List<List<Integer>> lists = main.twoSum2(new int[]{20,20, 70, 110, 150}, 90);
        for (List<Integer> list : lists) {
            System.out.println("list = " + list);
        }

        ArrayUtils.print(res);

		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
	}

}