/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        if(cur==null)
        {
            return null;
        }
        if(cur.next==null)
        {
            return cur;
        }
        ListNode tmp = cur.next;
        
        cur.next = swapPairs(tmp.next);
        tmp.next = cur;
        return tmp;
    }
}