package 二分;

public class ReadMe {


    /**
     * 二分：主要需要考虑low,high,target的位置关系，
     * 目前有三种：low,high,target ; low(=target),high ; low(=target=high)
     * 还有两种可能：target,low,high ; low,high(=target)
     *
     * 现有规律来看：二分相等时，可设置前移或后移，如相等的条件划归到low=mid+1,则相等时右移，可得到最后一个重复数字位置
     * 但返回的是low还是high取决于相等时划归的条件，一般返回无等的一方
     */
}
