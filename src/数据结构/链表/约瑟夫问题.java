package 数据结构.链表;

import Utils.ListNode;

/**
 * @author Cenmo
 * @Date 2022-03-12 2022-03-12
 */
public class 约瑟夫问题 {

    public int ysf (int n, int m) { // n:1-n的数，m：叫到m则退出
        // write code here
        ListNode head = new ListNode(1);
        ListNode tail = head;
        for(int i=2;i<=n;i++){
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        tail.next = head;

        int sign=1;
        ListNode p=head,pre=tail;
        while(p.next != p){
            if(sign == m){ // 删除节点
                pre.next = p.next;
                p = p.next;
                sign = 1;
            }else{
                pre = p;
                p = p.next;
                sign ++;
            }
        }
        return p.val;
    }

    public static void main(String[] args) {
        约瑟夫问题 main = new 约瑟夫问题();

        for(int i=1;i<=30;i++)
            System.out.println("main.ysf("+i+",3) = " + main.ysf(i, 3));
    }
}
