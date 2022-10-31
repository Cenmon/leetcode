package 数据结构.哈希.数组作map;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-10-29 17:25
 * @Description
 */
public class 相似字符串组839H {

    // hash法：惨败！太多情况需要考虑，想了一个下午，最后一个用例始终通不过
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int[] map = new int[strs.length]; // 第i个strs属于第map[i]个相似字符串组type
        int type=0,repeat=0;
        for(int i=0;i<n;i++){
            // if(map[i] > 0) continue;
            // 往后扫描，是否有相似，扫描到i+k时，前面的i都扫过后面，后面不用再扫
            for(int j=0;j<n;j++){
                if(i == j) continue;
                if(isSimilar(strs[i],strs[j])){
                    // 一旦i和j相似，则i，j属于同一个相似字符串组
                    if(map[i]>0 && map[j]>0){
                        if(map[i] != map[j]) {
                            repeat++;
                            for(int k=0;k<n;k++){
                                if(map[k] == map[j]){
                                    map[k] = map[i];
                                }
                            }
                        }
                    }else if(map[j] > 0){
                        map[i] = map[j];
                    }else if(map[i] > 0){
                        map[j] = map[i];
                    }else{
                        map[i] = map[j] = ++type;
                    }
                }
            }
            // 后面没有相似的，只能自成一派
            if(map[i] == 0) map[i] = ++type;
        }

        // for(int i=0;i<n;i++){
        //     // 往后扫描，是否有相似，扫描到i+k时，前面的i都扫过后面，后面不用再扫
        //     for(int j=0;j<n;j++){
        //         if(isSimilar(strs[i],strs[j])){
        //             System.out.println(i+","+j + " : similar , " + type);
        //         }else{
        //             System.out.println(i+","+j + " : unsimilar , " + type);
        //         }
        //     }
        // }
        System.out.println(Arrays.toString(map));
        System.out.println("type = " + type + " , repeat = " + repeat);
        return type-repeat/2;
    }

    private boolean isSimilar(String s,String t){
        int diff = 0;
        for(int i=0,n=s.length();i<n;i++){
            if(s.charAt(i) != t.charAt(i)){
                diff++;
            }
        }
        return diff <= 2;
    }


    public static void main(String[] args) {
        相似字符串组839H main = new 相似字符串组839H();

        System.out.println(main.numSimilarGroups(new String[]{"tars","rats","arts","star"})); // 2
        System.out.println(main.numSimilarGroups(new String[]{"omv","ovm"})); // 1
        System.out.println(main.numSimilarGroups(new String[]{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"})); // 5
        System.out.println(main.numSimilarGroups(new String[]{"ajdidocuyh","djdyaohuic","ddjyhuicoa","djdhaoyuic","ddjoiuycha","ddhoiuycja","ajdydocuih","ddjiouycha","ajdydohuic","ddjyouicha"})); // 2
    }
}
