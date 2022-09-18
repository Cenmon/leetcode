package 数据结构.链表.交换节点;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-03-14 2022-03-14
 */
public class 划分链表 {

    public ListNode partition (ListNode head, int x) {
        // write code here
        // 小于x的划到左边，大于等于的划在右边，且顺序不变
        ListNode downHead = new ListNode(-1);
        ListNode upHead = new ListNode(-1);
        ListNode down=downHead,up=upHead,r;
        ListNode p = head;
        while( p != null ){
            r = p.next;
            if(p.val < x){
                p.next = down.next;
                down.next = p;
                down = down.next;
            }else{
                p.next = up.next;
                up.next = p;
                up = up.next;
            }
            p = r;
        }
        down.next = upHead.next;
        return downHead.next;
    }

    public static void main(String[] args) {
        划分链表 main = new 划分链表();

        ListUtils listUtils = new ListUtils();
        ListNode head = listUtils.create(new int[]{1, 4, 3, 2, 5, 2});
//        ListNode head = listUtils.create(new int[]{1,2,3,4,1});
        listUtils.print(head);
        ListNode res = main.partition(head, 3); // {1,2,2,4,3,5}
//        ListNode res = main.partition(head, 5); //{1,2,3,4,1}
        listUtils.print(res);
    }
}
