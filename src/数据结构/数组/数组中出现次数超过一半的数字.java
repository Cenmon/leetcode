package 数据结构.数组;

/**
 * @author Cenmo
 * @Date 2022-03-18 2022-03-18
 * https://www.bilibili.com/video/BV1Ey4y1n7hb?from=search&seid=11416769065268497828&spm_id_from=333.337.0.0
 */
public class 数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int [] array) {
        int vote = 1;// 记录元素出现次数
        int ans = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i] == ans){ //ans元素出现次数
                vote++;
            }else{ // 与ans不同的元素则抵消一次出现
                vote--;
                if(vote == 0){ // 当出现为0次时，更换ans
                    vote = 1;
                    ans = array[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        数组中出现次数超过一半的数字 main = new 数组中出现次数超过一半的数字();

        System.out.println(main.MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2})); //2
        System.out.println(main.MoreThanHalfNum_Solution(new int[]{3,3,3,3,2,2,2})); //3
        System.out.println(main.MoreThanHalfNum_Solution(new int[]{1}));//1
    }
}
