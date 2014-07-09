package Chapter2;

import CtCILibrary.LinkedListNode;

public class Chapter2_3 {
	public static void deleteNodeA(LinkedListNode head, int k) {
		if (head == null) {
			return;
		}
		while (head.next != null) {
			if (head.next.data == k) {
				head.next = head.next.next;
			}
			head = head.next;
		}
	}

	public static boolean deleteNodeB(LinkedListNode n) {
		if (n == null || n.next == null) {
			return false;
		}
		LinkedListNode next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
	}

	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(0, null, null);
		// 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 20; i++) {
			second = new LinkedListNode(i % 9, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		System.out.println(head.printForward());
		deleteNodeB(head.next.next.next.next);
		//LinkedListNode clone = head.clone();

		System.out.println(head.printForward());

	}
}
