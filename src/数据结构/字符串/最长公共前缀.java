package 数据结构.字符串;

public class 最长公共前缀 {

	public String longestCommonPrefix (String[] strs) {
        // write code here
        return longestPrefix(strs ,0,strs.length-1);
    }
    
    public String longestPrefix(String[] strs,int start,int end){// 递归分治
        if(start == end) return strs[start];
        
        int mid = (start + end)/2;
        String s1 = longestPrefix(strs,start,mid);
        String s2 = longestPrefix(strs,mid+1,end);
        
        int length = Math.min(s1.length(),s2.length());//横向扫描
        int index = 0;
        while(index < length && s1.charAt(index) == s2.charAt(index))
            index++;
        return s1.substring(0,index);
    }

    public String longestCommonPrefix2 (String[] strs) {//纵向扫描
        // write code here
    	if(strs.length == 0 || strs == null) return "";

    	int m = strs.length;//字符串数组长度
    	int n = strs[0].length();//第一个字符串的长度，作为扫描基字符

    	for(int i=0;i<n;i++){ //前缀的右下标i
    		char prefix = strs[0].charAt(i);

    		for(int j=0;j<m;j++){//试探每一个字符串
    			if( strs[j].length() < i+1 || strs[j].charAt(i) != prefix ){//此处的小于等于！！
    				// strs[j].length():字符串的长度，i+1:前缀的长度
    				return strs[0].substring(0,i);
    			}
    		}
    	}

        return strs[0];
    }

	public static void main(String[] args){
		最长公共前缀 main = new 最长公共前缀();
		// ListUtils listUtil = new Utils();
		// ArrayUtils arrayUtil = new ArrayUtils();

		String[] strs = new String[] {"abca","abc","abca","abc","abcc"};//"abc"
		// String[] strs = new String[] {"abc"};//"abc"

		System.out.println( main.longestCommonPrefix(strs) );
		System.out.println( main.longestCommonPrefix2(strs) );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
	}

}