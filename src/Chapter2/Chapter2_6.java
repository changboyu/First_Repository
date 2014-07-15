package Chapter2;

import CtCILibrary.LinkedListNode;

public class Chapter2_6 {

	public static void main(String[] args) {
		int list_length = 100;
		int k = 10;

		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}

		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];

		LinkedListNode loop = recircle(nodes[0]);
		System.out.println(nodes[0].data);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}

	}

	public static LinkedListNode recircle(LinkedListNode c) {
		LinkedListNode p1 = c;
		LinkedListNode p2 = c;
		int dis = 0;

		while (true) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == null || p2 == null) {
				return null;
			}
			if (p1 == p2) {
				break;
			}
			dis++;
		}
		System.out.println("dis =" + dis);

		p1 = c;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

}
