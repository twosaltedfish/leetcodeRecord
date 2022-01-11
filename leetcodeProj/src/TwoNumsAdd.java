import java.util.List;

/**
 * @Description TODO
 * @Author Lce
 * @Create 2022-01-11
 */
public class TwoNumsAdd {

    public static void main(String[] args) {
        int[] n1 = {2, 4, 3};
        int[] n2 = {5, 6, 4};
        ListNode node1 = new ListNode(n1);
        ListNode node2 = new ListNode(n2);
        getAddNode(node1, node2);
    }

    public static ListNode getAddNode(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode temp = node;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            //和相除就是进位值
            carry=sum/10;
            //求余（进位）
            temp.val = sum % 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (l1 != null || l2 != null) {
                temp = temp.next = new ListNode(0);
            }
        }
        //计算之后若果最后进位为1，则当前链表最后一个数为1
        if (carry == 1) {
            temp = temp.next = new ListNode(1);
        }
        temp.next = null;
        return node;
    }
}

/**
 * 单向链表
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return next != null ? (val + " " + next.toString()) : "" + val;
    }

    ListNode(int[] x) {
        val = x[0];
        if (x.length == 1) {
            return;
        }
        ListNode node = null;
        ListNode temp = null;
        val = x[0];
        for (int i = 1; i < x.length; i++) {
            if (node == null) {
                node = new ListNode(x[i]);
                temp = node;
            } else {
                temp = temp.next = new ListNode(x[i]);
            }
        }
        next = node;
    }
}