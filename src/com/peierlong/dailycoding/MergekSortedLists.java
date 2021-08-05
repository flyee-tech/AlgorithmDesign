package com.peierlong.dailycoding;

/**
 * #956 [Medium] Merge k Sorted Lists
 *
 * @author peiel
 * @version V1.0
 * @date 2021/8/5
 */
public class MergekSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (isEmpty(lists)) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        do {
            int minIdx = getMinListNodeIdx(lists);
            result = result.next = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;
        } while (!isEmpty(lists));
        return head.next;
    }

    /**
     * 返回 listNode 中最小的值
     *
     * @return 最小的列表的索引
     */
    public static int getMinListNodeIdx(ListNode[] lists) {
        int minIdx = 0;
        ListNode cln = new ListNode(Integer.MAX_VALUE);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (lists[i].val < cln.val) {
                cln.val = lists[i].val;
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static boolean isEmpty(ListNode[] lists) {
        boolean b = true;
        for (ListNode ln : lists) {
            b = b && ln == null;
        }
        return b;
    }

    public static void main(String[] args) {

        ListNode ln1 = new ListNode(1);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(5);
        ListNode ln2 = new ListNode(1);
        ln2.next = new ListNode(3);
        ln2.next.next = new ListNode(4);
        ListNode ln3 = new ListNode(2);
        ln3.next = new ListNode(6);

        ListNode[] lists = {ln1, ln2, ln3};

        ListNode result = mergeKLists(lists);

        printListNode(result);

    }

    /**
     * 打印会改变listNode
     */
    public static void printListNode(ListNode listNode) {
        System.out.print(listNode != null ? listNode.val : "");
        while (listNode != null && listNode.next != null) {
            System.out.print(" -> " + listNode.next.val);
            listNode.next = listNode.next.next;
        }
    }

}
