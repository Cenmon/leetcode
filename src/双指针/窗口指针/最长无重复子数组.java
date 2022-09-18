package 双指针.窗口指针;

import java.util.*;

public class 最长无重复子数组{

	public int maxLength (int[] arr) { // hashmap记录字符及其下标
        // write code here
        // （连续子串）滑动窗口解：窗口内有重复字母，则缩小窗口，增大窗口无重复，则增大窗口
        if(arr == null || arr.length ==0) return 0;
        
        Map<Integer,Integer> ValueAndlastCurrence = new HashMap<>();//上次出现的值的下标
        int left=0,right=0;//滑动窗口边界
        int max=0;
        while(right < arr.length){ // right遍历数组
            if( !ValueAndlastCurrence.containsKey(arr[right]) ){//值不在窗口内
                ValueAndlastCurrence.put(arr[right],right);//扩大窗口
            }else{//值在窗口内
                /**
                 * 左端点始终递增，因为前面的子串已经扫描过
                 */
                left = Math.max(left,ValueAndlastCurrence.get(arr[right])+1); 
                ValueAndlastCurrence.put(arr[right],right);//更新值的最新索引位置
            }
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }

    public int maxLength2 (int[] arr) { // 数组形式记录字符char及其下标关系，也可记录其出现次数，仅限于字母等
	    int len = arr.length;
	    int left=0,right=0;
	    int[] map = new int[256];//新版ASCII码有256个字符
        Arrays.fill(map,-1);
	    int res=0;
	    while(right < len){
	        int c = arr[right];
	        if( map[c] == -1 ){ //arr[right]未出现在窗口中
	            map[c] = right;// 记录字符arr[right]出现的位置
            }else{ // 出现在窗口中
	            left = Math.max(left,map[c]+1);
	            map[c] = right;
            }
	        res = Math.max(res,right-left+1);
	        right++;
        }

	    return res;
    }

	public static void main(String[] args){
		最长无重复子数组 array = new 最长无重复子数组();

		int[] arr = new int[]{3,3,2,1,3,3,3,1}; // 3 {321}
		System.out.println(array.maxLength2(arr));
	}

}