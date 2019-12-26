package com.peierlong.leetcode;

/**
 * @author Peiel
 * @version V1.0
 * @date 2019/12/24
 */
public class AddTwoNumbers {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        int d = 0;
        while (l1 != null || l2 != null || d == 1) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + d;
            d = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return result.next;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);

        ListNode node2 = new ListNode(9);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(node, node2);

        out(result);

    }

    private static void out(ListNode result) {
        StringBuilder sb = new StringBuilder();
        sb.append(result.val);
        while (result.next != null) {
            sb.append(" -> ");
            sb.append(result.next.val);
            result = result.next;
        }
        System.out.println(sb.toString());
    }

}
