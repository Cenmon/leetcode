package 数据结构.set;

import java.util.LinkedList;

/**
 * @author Cenmo
 * @Date 2022-03-27 2022-03-27
 */
public class 设计哈希集合 {

    public static void main(String[] args) {
        设计哈希集合 main = new 设计哈希集合();
    }
}

class MyHashSet {

    private int BASE = 666;
    private LinkedList[] hs;

    public MyHashSet() {
        hs = new LinkedList[BASE];
        for(int i=0;i<BASE;i++){
            hs[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = getHash(key);
        if(!contains(key)){
            hs[hash].addLast(key);
        }
    }

    public void remove(int key) {
        int hash = getHash(key);
        if(contains(key)){
            hs[hash].remove((Integer)key);
        }
    }

    public boolean contains(int key) {
        int hash = getHash(key);
        if(hs[hash].size() == 0){
            return false;
        }else{
            return hs[hash].contains(key);
        }
    }

    public int getHash(int key){
        return key % BASE ;
    }
}
