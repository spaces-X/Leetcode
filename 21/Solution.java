/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1cur = l1;
        ListNode l2cur = l2;
        ListNode ahead = new ListNode(-1);
        ListNode result = ahead;
        while(l1cur!=null && l2cur!=null)
        {
            if (l1cur.val<l2cur.val) {
                result.next = l1cur;
                l1cur=l1cur.next;
            }
            else{
                result.next = l2cur;
                l2cur=l2cur.next;
            }
            result = result.next;
        }
        while(l1cur!=null)
        {
            result.next = l1cur;
            l1cur=l1cur.next;
            result = result.next;
        }
        while(l2cur!=null)
        {
            result.next = l2cur;
            l2cur=l2cur.next;
            result = result.next;
        }
        return ahead.next;


    }
    
}