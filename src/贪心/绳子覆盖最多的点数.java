package 贪心;

/**
 * @author Cenmo
 * @Date 2022-03-26 2022-03-26
 */
public class 绳子覆盖最多的点数 {

    public int maxPoint_greedy(int[] arr,int L){
        int max=1;
        int n=arr.length;
        for(int i=1;i<n;i++){
            int index = searchTarget(arr,0,i,arr[i]-L); // 在当前位置的前面找到满足L
//            System.out.print(arr[i]+" ");
//            System.out.println(arr[index]);
            max = Math.max(max,i-index+1);
        }
        return max;
    }

    public int searchTarget(int[] arr,int start,int end,int target){
        int low=start,high=end;
        int mid;
        while (low <= high){
            mid = low + (high-low) / 2;
            if(arr[mid] == target) return mid;
            else if(target < arr[mid]) high=mid-1;
            else low=mid+1;
        }
        return low;
    }

    public int maxPoint(int[] arr,int L){
        int max=0;
        int n=arr.length;
        int left=0,right=0;
        while (right<n){
            while (arr[right]-arr[left] > L){
                left++;
            }
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }

    /**
     * 给定一个有序数组arr，代表坐落在X轴上的点，给定一个正数K，代表绳子的长度，返回绳子最多压中几个点。
     */
    public static void main(String[] args) {
        绳子覆盖最多的点数 main = new 绳子覆盖最多的点数();

        System.out.println(main.maxPoint_greedy(new int[] {1,4,5,6,9,10,12,17},4)); // 3
        System.out.println(main.maxPoint(new int[] {1,4,5,6,9,10,12,17},4)); // 3
    }
}
