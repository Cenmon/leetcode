package 动态规划.自上而下分解.入门;

public class 跳台阶{

	public int jumpFloor(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        return jumpFloor(target-1)+jumpFloor(target-2);
    }

    public int jumpFloor2(int target){
    	int[] dp = new int[target+1];
    	dp[1]=1;dp[2]=2;
    	for(int i=3;i<=target;i++){
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	return dp[target];
    }

    public int jumpFloor3(int target){
    	
    	if(target == 1 || target == 2) return target; 
		int one=1,two=2,tmp;
    	for(int i=target-2;i>0;i--){
    		tmp = two;
    		two = one + two;
    		one = tmp;
    	}
    	return two;
    }

	public static void main(String[] args){
		跳台阶 jump = new 跳台阶();

		int res = jump.jumpFloor2(7);
		System.out.println(res);
	}

}