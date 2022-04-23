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
        // 初始化一个头结点
        ListNode node = new ListNode(0);
        // 初始化一个指针，指向头结点，为了后面操作
        ListNode result = node;
        // 初始化一个进位，相加大于10的时候，进位为1
        int d = 0;
        // 当两个链表都不为空或者存在进位的时候，继续操作
        while (l1 != null || l2 != null || d == 1) {
            // 执行相加操作
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + d;
            // 计算进位
            d = sum / 10;
            // 将结果赋值给当前结点的下个节点
            node.next = new ListNode(sum % 10);
            // 将当前结点后移
            node = node.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        // 返回结果，去掉头结点
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
