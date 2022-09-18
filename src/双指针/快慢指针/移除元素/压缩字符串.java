package 双指针.快慢指针.移除元素;

/**
 * @author Cenmo
 * @Date 2022-07-01 2022-07-01
 */
public class 压缩字符串 {

    public int compress(char[] chars) {
        int left=0,right=0;
        int count=0;
        while(right < chars.length){
            if(chars[left] == chars[right]){
                count++;
            }else{
                if(count > 1){
                    for(char num : String.valueOf(count).toCharArray()){
                        chars[++left] = num;
                    }
                }
                chars[++left] = chars[right];
                count = 1;
            }
            right++;
        }
        if(count > 1){ // 处理最后一个重复字符
            for(char num : String.valueOf(count).toCharArray()){
                chars[++left] = num;
            }
        }
        return left+1; //left是数组下标，left+1是长度
    }

    public static void main(String[] args) {
        压缩字符串 main = new 压缩字符串();


        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        int compress = main.compress(chars);
        for(int i=0;i<compress;i++){
            System.out.print(chars[i]+","); //a,2,b,2,c,3,
        }
        System.out.println();

        char[] chars2 = new char[]{'a'};
        int compress2 = main.compress(chars2);
        for(int i=0;i<compress2;i++){
            System.out.print(chars2[i]+","); // a,
        }
        System.out.println();

        char[] chars3 = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int compress3 = main.compress(chars3);
        for(int i=0;i<compress3;i++){
            System.out.print(chars3[i]+","); // a,b,1,2,
        }
        System.out.println();

    }
}
