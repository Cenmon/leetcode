package 数据结构.map;

import java.awt.*;
import java.util.HashMap;

/**
 * @author Cenmo
 * @Date 2022-03-27 2022-03-27
 */
public class O_1级别的setAll {

    private int time = 0;
    private int all = 0;
    private int setAllTime=Integer.MIN_VALUE;
    private HashMap<Integer, Point> map = new HashMap<>();

    public void put(int key,int value){
        Point point = new Point(value, time);
        map.put(key,point);
        time++;
    }

    public int get(int key){
        Point point = map.get(key);
        if(point.y < setAllTime){
            return point.x;
        }else {
            return all;
        }
    }

    // 每个放入map的元素自带放入的时间戳，在setall之前放入的取出都为all，在setall之后放入的都为原值
    // 普通放入和setall放入都会导致时间戳加一
    public void setAll(int all){
        this.all = all;
        setAllTime = time;
        time++;
    }

    public static void main(String[] args) {
        O_1级别的setAll main = new O_1级别的setAll();

    }

}
