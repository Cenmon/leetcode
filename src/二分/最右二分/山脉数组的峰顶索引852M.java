package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-12 22:14
 * @Description 数组分成两个区间，左区间单增，右区间单减
 */
public class 山脉数组的峰顶索引852M {

    public int peakIndexInMountainArray(int[] arr) {
        int left=0,right=arr.length-1;
        // 最右二分
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(mid == 0 || arr[mid] > arr[mid-1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        山脉数组的峰顶索引852M main = new 山脉数组的峰顶索引852M();

        /**
         * 给定山脉数组arr,返回峰顶最大值所在索引下标
         */
        System.out.println(main.peakIndexInMountainArray(new int[]{0,1,0})); // 1
        System.out.println(main.peakIndexInMountainArray(new int[]{0,2,1,0})); // 1
        System.out.println(main.peakIndexInMountainArray(new int[]{0,10,5,2})); // 1
    }
}
