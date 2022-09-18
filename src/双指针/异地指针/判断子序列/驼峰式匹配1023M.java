package 双指针.异地指针.判断子序列;

import Utils.JavaUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-08-24 23:34
 * @Description 子序列问题：某个字符串的子序列是否等于另一个字符串
 */
public class 驼峰式匹配1023M {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for(String query : queries){
            ans.add(isSubsequence(pattern,query));
        }
        return ans;
    }

    private boolean isSubsequence(String pattern,String query){
        int i=0,j=0,m=pattern.length(),n=query.length();
        while( j < n ){
            if(i<m && pattern.charAt(i) == query.charAt(j)){
                i++;
            }else if(isUpperCase(query.charAt(j))) {
                break;
            }
            j++;
        }
        return i>=m && j>=n;
    }

    private boolean isUpperCase(char ch){
        if('A' <= ch && ch <= 'Z') return true;
        return false;
    }


    public static void main(String[] args) {
        驼峰式匹配1023M main = new 驼峰式匹配1023M();
        JavaUtils.print(main.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FB"));
        //[true,false,true,true,false]
        JavaUtils.print(main.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FoBa"));
        //[true,false,true,false,false]
        JavaUtils.print(main.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"},"FoBaT"));
        //[false,true,false,false,false]
    }
}
