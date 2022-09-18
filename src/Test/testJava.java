package Test;


/**
 * @author Cenmo
 * @Date 2022-03-05 2022-03-05
 */
public class testJava extends MyJava implements interface1,interface2,interface3{

    private static int v1;
    private static float v2;
    private static char v3;
    private static boolean v4;
    private static testJava v5;
//    private testJava v10 = new testJava();

    static {
        System.out.println("testJava static run!");
    }

    testJava(){
        System.out.println("testJava:constructor run!");
    }

    public void sayHello(){
        System.out.println("testJava:hello!");
    }

    public void sayBye(){
        System.out.println("testJava:byebye!");
    }

    @Override
    public void sayHello1() {

    }

    @Override
    public void sayHello2() {

    }

    @Override
    public void sayHello3() {

    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }


    public static void main(String args[]) {

    }



}
