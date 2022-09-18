package 双指针.异地指针;

/**
 * @author Cenmo
 * @Date 2022-07-01 2022-07-01
 */
public class 比较版本号 {

    public int compareVersion(String version1, String version2) {
        int i=0,j=0;
        int m=version1.length(),n=version2.length();
        while(i < m || j < n){
            int v1=0;
            while(i<m && version1.charAt(i) != '.'){
                v1 = v1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            int v2=0;
            while(j<n && version2.charAt(j) != '.'){
                v2 = v2 * 10 +  version2.charAt(j) - '0';
                j++;
            }
            if(v1 != v2){
                return v1 > v2 ? 1 : -1;
            }
            i++;j++; // 跳过点
        }
        return 0;
    }

    public static void main(String[] args) {
        比较版本号 main = new 比较版本号();

        /**
         * 前导0不算值，以点隔开，隔开的部分比较版本大小
         */
        System.out.println(main.compareVersion("1.01","1.001")); // 0
        System.out.println(main.compareVersion("10.0","10.0.0")); // 0：相等
        System.out.println(main.compareVersion("0.1","1.1")); // -1：左大
    }
}
