/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)
        return head;
        int n=0;
        ListNode temp=head;
    
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        k=k%n;
        if(k==0)return head;
        temp=head;
        for(int i=1;i<n;i++){
            temp=temp.next;
        }
        temp.next=head;
        int steps=n-k;
            ListNode newTail=head;

            for(int j=1;j<steps;j++){
                newTail=newTail.next;
            }
            ListNode newHead=newTail.next;
            newTail.next=null;
                return newHead;
            
    
        
    }
}
