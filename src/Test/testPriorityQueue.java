package Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Cenmo
 * @Date 2022-03-03 2022-03-03
 */
public class testPriorityQueue {

    public static void main(String[] args) {
        Queue<Node> queue = new PriorityQueue<Node>();
        queue.offer(new Node("cenmo",23));
        queue.offer(new Node("mosui",24));
        queue.offer(new Node("limo",20));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

class Node implements Comparable<Node>{
    String key;
    int value;
    Node next;
    Node(){
        this.next = null;
    }

    Node(String key,int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    @Override
    public int compareTo(Node o) {
//        return o.key.compareTo(this.key);//降序
//        System.out.println("this.key.compareTo(o.key) = " + this.key.compareTo(o.key));
//        return this.key.compareTo(o.key);//升序
        return this.value - o.value;

//        if(this.value > o.value) return -1;
//        else if (this.value < o.value) return 1;//正数往后放，降序？
//        else return this.key.compareTo(o.key);

        //compare(x,y):x表示自己，y表示另一个，且x在左

//        return -1;//倒序-1，原序0,1
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
