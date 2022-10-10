package 二分;

/**
 * @author Cenmo
 * @Date 2022-03-09 2022-03-09
 */
public class 山峰数组中查找目标值 {

    public int searchPeak(int[] arr){
        int low=0,high=arr.length-1;
        int mid = -1;
        while(low < high){
            mid = low + (high-low)/2;
            if(arr[mid] < arr[mid+1]){ //最少两个元素，由于下取整，mid为左边元素，故mid+1不会报错
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public int searchPeak2(int[] arr){
        int low=0,high=arr.length-1;
        int mid;
        while(low <= high){
            mid = low + (high-low)/2;
            if(arr[mid] < arr[mid+1]){ //最少两个元素，由于下取整，mid为左边元素，故mid+1不会报错
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        山峰数组中查找目标值 main = new 山峰数组中查找目标值();

        System.out.println(main.searchPeak2(new int[]{1,2,3,7,6,5})); // index of peek value is 3
    }
}
