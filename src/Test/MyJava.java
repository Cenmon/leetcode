package Test;

/**
 * @author Cenmo
 * @Date 2022-03-11 2022-03-11
 */
public class MyJava {

    private static int v1;
    private static float v2;
    private static char v3;
    private static boolean v4;

    static {
        System.out.println("MyJava static run!");
    }

    MyJava(){
        System.out.println("MyJava constructor run ");
    }

    MyJava(int a){
        System.out.println("MyJava run " + a);
    }

    public void sayHello(){
        System.out.println("MyJava:hello!");
    }
}
