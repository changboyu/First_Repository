package Chapter2;

import java.util.Hashtable;

import CtCILibrary.LinkedListNode;

public class Chapter2_1 {

	public static void deleteDupsA(LinkedListNode head) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		LinkedListNode current = null;
		while (head != null) {
			if (table.containsKey(head.data)) {
				current.next = head.next;
			} else {
				table.put(head.data, true);
				current = head;
			}
			head = head.next;
		}

	}

	public static void deleteDupsC(LinkedListNode head) {
		if (head == null)
			return;
		LinkedListNode current = head;

		while (current != null) {
			LinkedListNode pointer = current.next;
			while (pointer != null) {
				if (pointer.data != current.data) {
					pointer = pointer.next;
				} else {

					current.next = pointer.next;
					pointer = pointer.next;
				}
			}
			current = current.next;
		}

	}

	public static void main(String[] args) {
		LinkedListNode first = new LinkedListNode(0, null, null); // AssortedMethods.randomLinkedList(1000,
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
		LinkedListNode clone = head.clone();
		deleteDupsA(head);
		System.out.println(head.printForward());
		deleteDupsC(clone);
		System.out.println(head.printForward());
	}
}
