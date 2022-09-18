package 双指针.模拟.分三段;

public class 删除最短的子数组使剩余数组有序1574M {

    // @Cenmo:分段问题：单调性分段
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length,left=0,right=n-1;
        // 分三段，[0,left],[left+1,right-1],[right,n-1],第一段和第三段均单调递增
        /**
         * 确定单调性边界
         */
        while(left+1<n && arr[left] <= arr[left+1]) left++;
        while(right-1>=0 && arr[right-1] <= arr[right]) right--;

        // left指向n-1,数组单调递增
        if(left == n-1) return 0;

        // 删除[left+1,n-1]或[0,right-1]子数组的最小长度
        int ans = Math.min(n-left-1,right);

        // 在第一段和第三段中各选一个点，保证两端有序，中间的则是可以删除的子数组，选择最小值
        int i=0,j=right;
        while(i<=left && j<n){
            if(arr[i] <= arr[j]){ // 保证i左端与j右端有序
                ans = Math.min(ans,j-i-1);
                i++;
            }else{
                j++;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        删除最短的子数组使剩余数组有序1574M main = new 删除最短的子数组使剩余数组有序1574M();

        /**
         * 给出数组arr,计算删除数组中的某个子数组，使得剩余部分非递减（递增或相等）
         * 返回删除的子数组最小长度
         */

        System.out.println(main.findLengthOfShortestSubarray(new int[]{1,2,3,10,4,2,3,5})); // 3 [10,4,2]
        System.out.println(main.findLengthOfShortestSubarray(new int[]{5,4,3,2,1})); // 4 [4,3,2,1]
        System.out.println(main.findLengthOfShortestSubarray(new int[]{1,2,3})); // 0
        System.out.println(main.findLengthOfShortestSubarray(new int[]{2,2,2,1,1,1})); // 3 [2,2,2]
    }
}
