/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode previous = null;
        int aheadLen = 0;
        while(current!=null && aheadLen<k)      // 前进 aheadlen 记录前进的长度   
        {
            aheadLen++;
            previous = current;
            current = current.next;
        }
        boolean flag = aheadLen==k;           //  从head 到尾端 是否至少包含k个节点    如果是则能翻转
        if(!flag)
        {
            return head;
        }
        ListNode next = previous.next;        //  第 k+1 个节点
        
        //  准备将前k个节点翻转

        previous = head;                      // privious 标志 准备翻转节点的前向节点    current 是当前要翻转的节点  temp 保存当前翻转节点的后向节点
        current = head.next;
        ListNode temp = null;
        while(current!=next)                   // 将1 到 k 的链表翻转  当current = next（k+1节点）停止
        {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head.next = reverseKGroup(next, k);   // 原来的头是现在的尾，所以head现在已经是尾部，尾部的next是从
        return previous;                      //privious 标志 准备翻转节点的前向节点 也就是最后一个被翻转了的节点，最后一个被翻转的节点 是 现在的头！

    }
}