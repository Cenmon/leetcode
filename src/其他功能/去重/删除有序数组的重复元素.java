package 其他功能.去重;

/**
 * @author Cenmo
 * @Date 2022-03-09 2022-03-09
 */
public class 删除有序数组的重复元素 {

    public int[] deleteDuplicate(int[] arr){
        int id = 0; // id指向未重复元素，且是最大的未重复元素
        for(int i=1;i<arr.length;i++){
            if(arr[i] != arr[id]){ //若未重复，id自增，再将未重复元素复制到id位置
                id++;
                arr[id] = arr[i];
            }// else {若重复，则直接i++下一个}
        }
        int[] res = new int[id + 1];
        for(int i=0;i<=id;i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        删除有序数组的重复元素 main = new 删除有序数组的重复元素();
    }
}
