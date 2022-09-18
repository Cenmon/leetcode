package 递归.回溯;

import java.util.ArrayList;

/**
 * @author Cenmo
 * @Date 2022-03-12 2022-03-12
 */
public class 字符串的排列_回溯 {

    ArrayList<String> res = new ArrayList<String>();
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0) return res;
        StringBuilder sb = new StringBuilder();
        boolean[] visit = new boolean[str.length()];
        doHelper(0,0,str.length(),str,sb,visit);
        return res;
    }

    public void doHelper(int index,int cur,int length,String str,StringBuilder sb,boolean[] visit){
        if(cur >= length) {
            res.add(sb.toString());
        }else{
            ArrayList<Character> repeat = new ArrayList<Character>();
            for(int i=0;i<length;i++){
                sb.append(str.charAt(i));
                if(visit[i]==false && !repeat.contains(str.charAt(i))){
                    visit[i] = true;
                    doHelper(i,cur+1,length,str,sb,visit);
                    repeat.add(str.charAt(i));
                    visit[i] = false;
                }
                sb.deleteCharAt(cur);
            }
        }
    }

    public static void main(String[] args) {
        字符串的排列_回溯 main = new 字符串的排列_回溯();

        ArrayList<String> res = main.Permutation("ab"); // ["ab","ba"]
//        ArrayList<String> res = main.Permutation("aab"); // ["aab","aba","baa"]
//        ArrayList<String> res = main.Permutation("abc"); // ["abc","acb","bac","bca","cab","cba"]
//        ArrayList<String> res = main.Permutation(""); // []
        System.out.println("res.toString() = " + res.toString());
    }
}
