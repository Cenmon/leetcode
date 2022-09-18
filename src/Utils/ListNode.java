package Utils;

/**
 * @author Cenmo
 * @Date 2022-03-03 2022-03-03
 */
public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(){

    }

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
