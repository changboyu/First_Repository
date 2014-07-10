package Chapter2;

import CtCILibrary.LinkedListNode;

public class Chapter2_5 {
	public static LinkedListNode addList(LinkedListNode n1, LinkedListNode n2) {
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

	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(2, null, null);
		LinkedListNode head = first;
		LinkedListNode c = new LinkedListNode(8, null, null);
		LinkedListNode d = new LinkedListNode(9, null, null);
		LinkedListNode e = new LinkedListNode(9, null, null);
		head.addtail(c);
		head.addtail(d);
		head.addtail(e);
		// LinkedListNode second = first;
		// for (int i = 1; i < 4; i++) {
		// second = new LinkedListNode(i % 9, null, null);
		// first.setNext(second);
		// second.setPrevious(first);
		// first = second;
		// }

		LinkedListNode head1 = new LinkedListNode(3, null, null);
		LinkedListNode a = new LinkedListNode(4, null, null);
		LinkedListNode b = new LinkedListNode(5, null, null);

		head1.addtail(a);
		head1.addtail(b);
		System.out.println(head.printForward());
		System.out.println(head1.printForward());

		System.out.println(addList(head, head1).printForward());

	}

}
