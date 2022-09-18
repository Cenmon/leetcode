package 数据结构.链表.交换节点;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-06-30 2022-06-30
 */
public class 分隔链表 {

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1) , more = new ListNode(-1);
        ListNode lessTail = less,moreTail = more;

        ListNode p = head;
        while(p != null){
            if(p.val < x){
                lessTail.next = p;
                lessTail = lessTail.next;
            }else{
                moreTail.next = p;
                moreTail = moreTail.next;
            }
            p = p.next;
        }
        lessTail.next = more.next;
        moreTail.next = null;
        return less.next;
    }

    public static void main(String[] args) {
        分隔链表 main = new 分隔链表();

        /**
         * 把小于x的值全放到链表一侧，大于等于x的值放到另一侧
         */
        ListUtils.print(main.partition(ListUtils.create(new int[]{1,4,3,2,5,2}),3));
        ListUtils.print(main.partition(ListUtils.create(new int[]{2,1}),2));
        ListUtils.print(main.partition(ListUtils.create(new int[]{1,1}),2));
    }
}
