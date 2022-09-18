package 二分;

public class 求平方根 {

	public int sqrt (int x) {
        // write code here
        int low = 1,high = x;
        int mid;
        
        while(low <= high){
            mid = low + (high-low)/2;
            if(x/mid < mid) high = mid-1;//x/mid<mid => x<mid*mid => 根号x<mid
            else if(x/mid > mid) low = mid+1;
            else return mid;
        }
        return high;
    }
    
    public int sqrt2(int x) {//连续n个奇数相加的结果一定是平方数。如：9=1+3+5；16=1+3+5+7；
        int i = 1;
        int res = 0;
        while (x >= 0) {
            x -= i;
            res++;
            i += 2;
        }
        return res - 1;
    }

	public static void main(String[] args){
		求平方根 main = new 求平方根();

		System.out.println( main.sqrt(2143195649) ); //46294
		System.out.println( main.sqrt(8) ); //46294
	}

}