package 数据结构.队列;

import java.util.*;

/**
 * @author Cenmo
 * @Date 2022-03-03 2022-03-03
 */
public class 字符串出现次数的TopK问题_优先级队列compartor {


    public String[][] topKstrings (String[] strings, int k) {
        // write code here

        Map<String,Integer> map = new HashMap<>();
        for(String s : strings){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        Queue<Node> queue = new PriorityQueue<Node>();//优先级队列建立堆
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            Node node = new Node(entry.getKey(), entry.getValue());
            if(queue.size() < k){
                queue.offer(node);// 建立k个元素的堆
            }else if (queue.peek().compareTo(node) > 0){ //堆顶元素小于当前元素
                queue.poll();
                queue.offer(node);
            }
        }

        String[][] res = new String[k][2];
        for(int i=0;i<k;i++){
            Node node = queue.poll();
            res[i][0] = node.s;
            res[i][1] = String.valueOf(node.value);
        }
        return res;
    }

    public static void main(String[] args) {
        字符串出现次数的TopK问题_优先级队列compartor main = new 字符串出现次数的TopK问题_优先级队列compartor();

//        String[][] res =main.topKstrings(new String[]{"abcd","abcd","abcd","pwb2","abcd","pwb2","p12"},3);
//        String[][] res =main.topKstrings(new String[]{"123","123","231","32"},2);
        String[][] res =main.topKstrings(new String[]{"a","b","c","b"},2);
        for (String[] strings : res){
            System.out.println(strings[0]+","+strings[1]);
        }
    }
}

class Node implements Comparable<Node>{
    String s;
    Integer value;

    Node(){

    }

    Node(String key,Integer value){
        this.s = key;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        if(this.value > o.value) return -1;// 小于等于0顺序不变，大于0顺序交换，故为降序
        else if (this.value < o.value) return 1;
        else return this.s.compareTo(o.s); //升序，this小，o大

    }
}
