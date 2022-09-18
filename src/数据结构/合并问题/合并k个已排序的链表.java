package 数据结构.合并问题;

import Utils.ListNode;
import Utils.ListUtils;

import java.util.ArrayList;

/**
 * @author Cenmo
 * @Date 2022-03-14 2022-03-14
 */
public class 合并k个已排序的链表 {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0) return null;
        return merge(lists,0,lists.size()-1);
    }

    private ListNode merge(ArrayList<ListNode> lists, int start, int end) {
        if(start == end) return lists.get(start);

        int mid = (start+end)/2;
        ListNode p = merge(lists,start,mid);
        ListNode q = merge(lists,mid+1,end);

        ListNode res = new ListNode(-1);
        ListNode tail = res;
        while(p!=null && q!=null){
            if(p.val < q.val){
                tail.next = p;
                p = p.next;
            }else {
                tail.next = q;
                q = q.next;
            }
            tail=tail.next;
        }
        tail.next = null;
        if(p != null) tail.next = p;
        if(q != null) tail.next = q;
        return res.next;
    }

    public static void main(String[] args) {
        合并k个已排序的链表 main = new 合并k个已排序的链表();
        ListUtils listUtils = new ListUtils();

        ArrayList<ListNode> list = new ArrayList<>();
        list.add(listUtils.create(new int[]{1,2,3}));
        list.add(listUtils.create(new int[]{4,7}));
        list.add(listUtils.create(new int[]{5,6}));

        ListNode head = main.mergeKLists(list);
        listUtils.print(head);


    }
}
