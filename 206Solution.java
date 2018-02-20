 //1. iterative 
 public ListNode reverseList(ListNode head) {
 	ListNode newHead = null;
 	while (head != null) {
	 	//1. 找到next
	 	ListNode next = head.next;
	 	//2. head指向newHead
	 	head.next = newHead;
	 	//3. newHead变成head
	 	newHead = head;
	 	//4. head变成head.next
	 	head = next;
 	}
 	return newHead;
 }
 //2. recursive
 public ListNode reverseList(ListNode head) {
 	return reverse(head, null);
 }
 private ListNode reverse(ListNode head, ListNode newHead) {
 	if (head == null) {
 		return newHead;
 	}
 	ListNode next = head.next;
 	head.next = newHead;
 	return reverse(next, head);
 }