

import java.util.List;
import java.util.Set;
class Solution {
    
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        // Set<Integer> isEnd = new Set();
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        boolean []isEnd = new boolean[lists.length];
        int isEndSum = 0;
        for (int i = 0; i < lists.length; i++) {
            if(list[i]==null)
            {
                isEnd[i] = true;
                isEndSum++;
            }
        }
        while(isEndSum<lists.length){
            int min_index=-1;
            int min=Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if(isEndSum==lists.length-1)
                {
                    break;
                }
                if(lists[i]==null&&!isEnd[i])
                {
                    isEnd[i]=true;
                    isEndSum++;
                }
                if(!isEnd[i] && (min>lists[i].val))
                {
                    min_index = i;
                    min = lists[i].val;
                }
            }
            if(min_index!=-1)
            {
                curr.next = new ListNode(min);
                lists[min_index] = lists[min_index].next;
                curr = curr.next;
            }
            if(isEndSum==lists.length-1)
            {
                for (int i = 0; i < lists.length; i++) {
                    if(!isEnd[i])
                    {
                        ListNode tmp = lists[i];
                        while(tmp!=null)
                        {
                            curr.next = tmp;
                            tmp = tmp.next;
                            curr = curr.next;

                        }
                        isEndSum++;
                        break;
                    }
                    
                }
            }

        }
        return result.next;
    }
    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(5);
        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(4);
        ListNode h3 = new ListNode(2);
        h3.next = new ListNode(6);
        ListNode[] lists = {h1,h2,h3};
        ListNode result = mergeKLists(lists);
        while(result!=null)
        {
            System.out.println(result.val);
            result =result.next;
        }

    }


}