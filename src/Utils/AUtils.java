package Utils;

/**
 * @author Cenmo
 * @Date 2022-06-26 2022-06-26
 */
public class AUtils {

    public static int biSearch(int[] arr,int target){ // 二分查找
        int low = 0,high = arr.length - 1;
        int mid = 0;
        while(low <= high){
            mid = low + ((high - low) >> 1);
            if(target < arr[mid]) high = mid - 1;
            else if(target > arr[mid]) low = mid + 1;
            else return mid;
        }
        return low;
    }

    public static int biSearch(int[] arr,int target,int start,int end){
        int low = start,high = end - 1; // 数组下标从0开始，故减1
        int mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(target < arr[mid]) high = mid - 1;
            else if(target > arr[mid]) low = mid+1;
            else return mid;
        }
        return low; // 目标值应该在数组中的所在位置
    }

    public static void quickSort(int[] arr,int start,int end){
        if(start < end){
            int low = start,high = end;
            int pivot = arr[low];
            while(low < high){
                while(low < high && arr[high] >= pivot) high--;
                arr[low] = arr[high];
                while(low < high && arr[low] <= pivot) low++;
                arr[high] = arr[low];
            }
            arr[low] = pivot;

            quickSort(arr,start,low - 1);
            quickSort(arr,low + 1,end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,1,4,4,6,5};
        quickSort(arr,0,arr.length-1);
        ArrayUtils.print(arr);
    }
}
