package Utils;

/**
 * @author Cenmo
 * @Date 2022-03-03 2022-03-03
 */
public class MapNode {
    public int key;
    public int value;
    public MapNode next;

    MapNode(){
        this.next = null;
    }

    MapNode(int key,int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
