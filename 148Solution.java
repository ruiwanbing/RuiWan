// 148. Sort List
 public ListNode sortList(ListNode head) {
 	// solve int O(nlogn) constant space
 	// base case
 	if (head == null || head.next == null) {
 		return head;
 	}
 	// find the middle point
 	ListNode mid = findMid(head);
 	mid.next = null;
 	// sort the left half
 	ListNode left = sortList(head);
 	// sort the right half
 	ListNode right = sortList(mid.next);
 	// merge
 	return merge(left, right);
 }
public ListNode findMid(ListNode head) {
	// slow is the mid point
	ListNode fast = head;
	ListNode slow = head;
	while (fast != null && fast.next != null) {
		fast = fast.next.next;
		slow = slow.next;
	}
	return slow;
}
public ListNode merge(ListNode left, ListNode right) {
	//dummy node to remember the location of the head
	ListNode dummy = new ListNode(0);
	ListNode head = dummy;

	// choose the smaller element
	while (left != null && right != null) {
		if (left.val < right.val) {
			head.next = left;
			left = left.next;
		} else {
			head.next = right;
			right = right.next;	
		}
		head = head.next;
	}
	// left elements
	while (left != null) {
		head.next = left;
		left = left.next;
		head = head.next;
	}
	while (right != null) {
		head.next = right;
		right = right.next;
		head = head.next;
	}
	return dummy.next;
}