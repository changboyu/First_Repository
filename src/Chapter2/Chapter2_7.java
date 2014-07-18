package Chapter2;

import CtCILibrary.LinkedListNode;

public class Chapter2_7 {

	public static LinkedListNode reverseListRecursive(LinkedListNode list) {

		if (list == null) {
			return null;
		}

		if (list.next == null) {
			return list;
		}

		LinkedListNode secondItem = list.next;
		list.next = null;

		LinkedListNode reverseSet = reverseListRecursive(secondItem);

		// reverseSet.addtail(list);
		secondItem.next = list;

		return reverseSet;
	}

	public static LinkedListNode reverseListIterate(LinkedListNode list) {
		LinkedListNode nextNode = null;
		LinkedListNode previous = null;
		while (list != null) {
			// save the next node
			nextNode = list.next;

			// update the value of "next"
			list.next = previous;

			// shift the pointer
			previous = list;
			list = nextNode;
		}
		return previous;
	}

	public static void main(String[] args) {
		int list_length = 4;

		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}

		// Create loop;
		// nodes[list_length - 1].next = nodes[list_length - k];

		System.out.println(nodes[0].printForward());
		System.out.println(reverseListRecursive(nodes[0]).printForward());
		System.out.println(reverseListIterate(nodes[3]).printForward());
	}

}
