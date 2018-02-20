// 203.Remove Linked List Elements
 public ListNode removeElements(ListNode head, int val) {
 	//set dummy node pointing to head
 	ListNode dummy = new ListNode(-1);
 	//set pre pointing the previous node
 	ListNode pre = dummy;
 	ListNode cur = head;
 	while (cur != null) {
 		if (cur.val == val) {
 			//skip one node
 			pre.next = cur.next;
 		} else {
 		    pre = pre.next;
 		}
 		cur = cur.next;
 	}
 	return dummy.next;
 }