package JavaLearn.多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Cenmo
 * @Date 2022-03-29 2022-03-29
 */
public class 创建进程 {

    public static void main(String[] args) {
        myThread1 myThread1 = new myThread1(); // 子类创建
        myThread1.start();

        myThread2 runAbleThread = new myThread2();
        Thread myThread2 = new Thread(runAbleThread,"mythread2"); // Runable接口创建
        myThread2.start();
        myThread2.stop(); // 调用该方法，啥也没有

        Thread myThread3 = new Thread(runAbleThread, "mythread3"); // 与2共用同一个Runnable接口实现类
        myThread3.start();

        Thread myThread4 = new Thread(new FutureTask<String>(new myThread3())); // Callable接口创建
        myThread4.start();
    }
}

class myThread1 extends Thread{
    @Override
    public void run() {
        System.out.println(this.getName());
    }
}

class myThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class myThread3 implements Callable<String> { // 泛型即call()方法的返回值

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return Thread.currentThread().getName()+"ok!";
    }
}

