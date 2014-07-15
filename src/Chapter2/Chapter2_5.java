package Chapter2;

import CtCILibrary.LinkedListNode;

public class Chapter2_5 {
	private static LinkedListNode addList(LinkedListNode n1, LinkedListNode n2) {
		LinkedListNode ansStart = null;
		LinkedListNode ansEnd = null;
		int k = 0, c = 0;
		while (n1 != null || n2 != null || c == 1) {
			k = 0;
			if (n1 == null && n2 != null) {
				if ((n2.data + c) >= 10) {
					k = n2.data + c - 10;
					c = 1;
				} else {
					k = n2.data + c;
					c = 0;
				}
				n2 = n2.next;
				if (ansStart == null) {
					ansStart = new LinkedListNode(k, null, null);
					ansEnd = ansStart;
				} else {
					LinkedListNode pw = new LinkedListNode(k, null, null);
					ansEnd.next = pw;
					ansEnd = pw;
				}
			}
			if (n2 == null && n1 != null) {
				if ((n1.data + c) >= 10) {
					k = n1.data + c - 10;
					c = 1;
				} else {
					k = n1.data + c;
					c = 0;
				}
				n1 = n1.next;
				if (ansStart == null) {
					ansStart = new LinkedListNode(k, null, null);
					ansEnd = ansStart;
				} else {
					LinkedListNode pw = new LinkedListNode(k, null, null);
					ansEnd.next = pw;
					ansEnd = pw;
				}
			}
			if (n1 != null && n2 != null) {
				if (n1.data + n2.data + c >= 10) {
					k = n1.data + n2.data + c - 10;
					c = 1;
				} else {
					k = n1.data + n2.data;
					c = 0;
				}
				n1 = n1.next;
				n2 = n2.next;
				if (ansStart == null) {
					ansStart = new LinkedListNode(k, null, null);
					ansEnd = ansStart;
				} else {
					LinkedListNode pw = new LinkedListNode(k, null, null);
					ansEnd.next = pw;
					ansEnd = pw;
				}
			}
			if (n1 == null && n2 == null && c == 1) {

				LinkedListNode pw = new LinkedListNode(1, null, null);
				ansEnd.next = pw;
				ansEnd = pw;
				c = 0;
			}

		}
		return ansStart;

	}

	private static LinkedListNode addLists(LinkedListNode l1,
			LinkedListNode l2, int carry) {
		if (l1 == null && l2 == null && carry == 0) {
			return null;
		}

		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if (l1 != null) {
			value += l1.data;
		}
		if (l2 != null) {
			value += l2.data;
		}
		result.data = value % 10;
		if (l1 != null || l2 != null) {
			LinkedListNode more = addLists(l1 == null ? null : l1.next,
					l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.setNext(more);
		}
		return result;
	}

	public static int length(LinkedListNode n) {
		int i = 0;
		while (n != null) {
			i++;
			n = n.next;
		}
		return i;
	}

	public static LinkedListNode pad(LinkedListNode n1, int padding) {

		LinkedListNode head = n1;
		for (int i = 0; i < padding; i++) {
			LinkedListNode n = new LinkedListNode(0, null, null);
			n.setNext(head);
			head.setPrevious(n);
			head = n;
		}
		return head;
	}
	
	public static LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data,null,null);
		if (list!=null){
			list.prev = node;
			node.next = list;
		}
		return node;
	}

	private static LinkedListNode addListsB(LinkedListNode n1,
			LinkedListNode n2) {

		int len1 = length(n1);
		int len2 = length(n2);

		if (len1 < len2) {
			n1 = pad(n1, len2 - len1);
		} else {
			n2 = pad(n2, len1 - len2);
		}

		PartialSum sum = addListsHelper(n1, n2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {	
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}

	public static PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if (l1 == null && l2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListsHelper(l1.next, l2.next);

		// Add carry to current data
		int val = sum.carry + l1.data + l2.data;

		// Insert sum of current digits
		LinkedListNode full_result = insertBefore(sum.sum, val % 10);

		// Return sum so far, and carry the value
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(2, null, null);
		LinkedListNode head = first;
		LinkedListNode c = new LinkedListNode(8, null, null);
		LinkedListNode d = new LinkedListNode(9, null, null);
		LinkedListNode e = new LinkedListNode(9, null, null);
		head.addtail(c);
		head.addtail(d);
		head.addtail(e);

		LinkedListNode head1 = new LinkedListNode(3, null, null);
		LinkedListNode a = new LinkedListNode(4, null, null);
		LinkedListNode b = new LinkedListNode(5, null, null);

		head1.addtail(a);
		head1.addtail(b);
		System.out.println(length(head));
		System.out.println(head.printForward());
		System.out.println(head1.printForward());
		System.out.println(addListsB(head,head1).printForward());
 
		System.out.println(addList(head, head1).printForward());
		System.out.println(addLists(head, head1, 0).printForward());

	}

}
