import java.util.PriorityQueue;
// tc = o(nlogk)
// sc = o(k)
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode head : lists){
            if(head != null){
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;
            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }
}