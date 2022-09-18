package JavaLearn.多线程;

/**
 * @author Cenmo
 * @Date 2022-03-29 2022-03-29
 */
public class 实现线程同步 {
    public static void main(String[] args) {
        myThread runable = new myThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<100;i++)
                    runable.printa();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<100;i++)
                    runable.printl();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<100;i++)
                    runable.printi();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}

class myThread implements Runnable{
    int seq = 0;
//    Lock lock = new ReentrantLock(); /*lock.lock()  ;   lock.unlock()    ; tryLock()     ;   tryLock(time,unit（单位))*/
    myThread(){}

    @Override
    public void run() {
        try {
            for(int i=0;i<100;i++){
                printa();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printa() throws InterruptedException {
        while(seq % 3 != 0){ // 在互斥的条件下实现同步
            this.wait();
        }
        System.out.print('a');
        seq++;
        this.notifyAll();
    }

    public synchronized void printl() throws InterruptedException {
        while(seq % 3 != 1){
            this.wait();
        }
        System.out.print('l');
        seq++;
        this.notifyAll();
    }

    public synchronized void printi() throws InterruptedException {
        while(seq % 3 != 2){
            this.wait();
        }
        System.out.print('i');
        seq++;
        this.notifyAll();
    }
}
