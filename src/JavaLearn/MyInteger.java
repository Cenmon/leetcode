package JavaLearn;

/**
 * @Author Cenmo
 * @Date 2022-10-09 11:39
 * @Description
 */
public class MyInteger {

    // https://blog.csdn.net/weixin_42092787/article/details/106607426?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-106607426-blog-80252241.t0_edu_mix&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-106607426-blog-80252241.t0_edu_mix&utm_relevant_index=2
    public int bitCount(int i) { // 计数i的二进制表示中比特1的个数
        // 0x55555555   ->	01 01 01 01 01 01 01 01 01 01 01 01 01 01 01 01
        // 对11来说，右移一位再与01(0x55555555)按位与运算即可得到第二位上的比特值(01)
        // 用原数11减去右移并按位与后的结果(01),即可得到10(2)，也就是每两位的二进制中1的个数
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }


    public static void main(String[] args) {
        MyInteger main = new MyInteger();

        System.out.println(main);
    }
}
