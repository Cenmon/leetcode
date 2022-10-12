package 二分.最右二分;

/**
 * @Author Cenmo
 * @Date 2022-10-12 22:42
 * @Description
 */
public class 山脉数组中查找目标值1095H {

    public int findInMountainArray(int[] arr, int target) {
        // 先找峰值
        int n=arr.length,left=0,right=n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(mid == 0 || arr[mid] > arr[mid-1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        // 再两侧分别二分
        int leftIdx = BSearch(arr,target,0,right,true); // true:0-right值单增
        if(leftIdx != -1) return leftIdx;
        int rightIdx = BSearch(arr,target,right+1,n-1,false); // false:rigth+1~n-1 值单减
        if(rightIdx != -1) return rightIdx;
        return -1;
    }

    private int BSearch(int[] arr,int target,int left,int right,boolean isASC){
        while(left <= right){
            int mid = left + (right-left)/2;
            int value = arr[mid];
            if(value == target){
                return mid;
            }else if(value > target){
                if(isASC) right = mid - 1;
                else left = mid + 1;
            }else{
                if(isASC) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        山脉数组中查找目标值1095H main = new 山脉数组中查找目标值1095H();

        /**
         * 山峰数组中找目标值的下标，找不到则返回-1，若有重复值可返回最前的下标
         */
        System.out.println(main.findInMountainArray(new int[]{1,2,3,4,5,3,1},3)); // 2
        System.out.println(main.findInMountainArray(new int[]{0,1,2,4,2,1},3)); // -1
        System.out.println(main.findInMountainArray(new int[]{0,5,3,1},1)); // 3
    }
}
