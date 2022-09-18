package 二分;

public class 二分查找2{

	public int binarySearch(int nums[],int target){
		if(nums == null || nums.length == 0) return -1;
		int low=0,high=nums.length-1,mid;
		while(low<=high){
			mid=(low+high)/2;
			if(nums[mid] == target) return mid;
			else if(target < nums[mid]) high=mid-1;
			else low=mid+1;
		}
		return -1;
	}


    public boolean Find(int target, int [][] array) {//BM18 二维矩阵中的查找
        if(array == null) return false;
        if(array[0].length == 0) return false;
        
        int row=0,column=array[0].length-1;
        
        while(row <= array.length-1 && column >=0){
            if(array[row][column] == target) return true;
            else if(target < array[row][column] ){
                column--;
            }else{
                row++;
            }
        }
        return false;
    }

	public static void main(String[] args){
		二分查找2 binary = new 二分查找2();
		int[] nums = new int[]{1,1,2,4,4,5,6};
		int res = binary.binarySearch(nums,2);
		System.out.println(res);
	}

}