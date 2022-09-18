package 双指针.快慢指针.左边or右边;

public class 接雨水42 {

	public long maxWater (int[] arr) {

		int left = 0,right = arr.length-1;
		int lMax = arr[left],rMax = arr[right];
		int water = 0;

		while(left < right){
			if(lMax < rMax){
				water += lMax - arr[left];
				left++;
				lMax = Math.max(lMax,arr[left]);
			}else{
				water += rMax - arr[right];
				right--;
				rMax = Math.max(rMax,arr[right]);
			}
		}

		return water;
	}

	public long maxWater2 (int[] arr) { // 左右扫一遍
		long water = 0;
		int lMax=Integer.MIN_VALUE,rMax=Integer.MIN_VALUE,n=arr.length;
		int[] waters = new int[n];
		for(int i=0;i<n;i++){
			if(arr[i] > lMax) lMax = arr[i];
			waters[i] = lMax - arr[i];
		}
		for(int i = n-1;i>=0;i--){
			if(arr[i] > rMax) rMax = arr[i];
			water += Math.min(waters[i],rMax-arr[i]);
		}
		return water;
	}

	public long violence(int[] arr){
		int water = 0;
		int length = arr.length;

		for(int i=0;i<length;i++){
			int lMax = arr[0];//arr[i]左边最大值
			for(int j=1;j<i;j++)
				if(arr[j] > lMax) lMax = arr[j];

			int rMax = arr[i];//arr[i]右边最大值
			for(int j=i+1;j<length;j++)
				if(arr[j] > rMax) rMax = arr[j];

			water += Math.min(lMax,rMax) - arr[i];//左右最大值的短板减木板高度 得该木板的蓄水量
		}
		return water;
	}

	public static void main(String[] args){
		接雨水42 main = new 接雨水42();

		/**
		 * 给出一排柱形图，所有柱子围成的凹坑最多蓄水
		 * 左最大值 or 右最大值
		 */
		System.out.println(main.maxWater(new int[]{3,1,2,5,2,4}));//5
		System.out.println(main.maxWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));//6
		System.out.println(main.maxWater(new int[]{4,5,1,3,2}));//2
		System.out.println(main.maxWater(new int[]{4,2,0,3,2,5}));//9
		// System.out.println(main.violence(new int[]{3,1,2,5,2,4}));

	}

}