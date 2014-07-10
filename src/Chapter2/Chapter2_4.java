package Chapter2;

import CtCILibrary.LinkedListNode;

public class Chapter2_4 {
	public static LinkedListNode partition(LinkedListNode node, int k) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;

		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < k) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		if (beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart;
	}

	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(0, null, null);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 20; i++) {
			second = new LinkedListNode(i % 9, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		// head.addtail(n);
		// head.addtail(n1);
		System.out.println(partition(head, 3).printForward());
	}

}
