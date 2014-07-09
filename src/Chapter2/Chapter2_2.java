package Chapter2;

import CtCILibrary.LinkedListNode;

public class Chapter2_2 {
	public static Object nthToLastA(LinkedListNode head, int k) {
		int i = 0;
		LinkedListNode current = head;
		while (current != null) {
			current = current.next;
			++i;
		}

		LinkedListNode item = head;
		if (i > k) {
			for (int j = 0; j < i - k; j++) {
				item = item.next;
			}

			return item.data;
		} else {

			return null;
		}
	}
	
	public static int nthToLastRecursive(LinkedListNode head, int k){
		if (head == null){
			return 0;
		}
		int i = nthToLastRecursive(head.next,k)+1;
		if (i == k){
			System.out.println(head.data);
		}
		
		return i;
		
	}
	public static LinkedListNode nthToLastC(LinkedListNode head, int n) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		if (n <= 0) return null;
		
		// Move p2 n nodes into the list.  Keep n1 in the same position.
		for (int i = 0; i < n - 1; i++) { 
			if (p2 == null) {
				return null; // Error: list is too small.
			}
			p2 = p2.next;
		}
		if (p2 == null) { // Another error check.
			return null;
		}
		
		// Move them at the same pace.  When p2 hits the end, 
		// p1 will be at the right element.
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
	  	}
	  	return p1;
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
		System.out.println(nthToLastA(head,1));
		LinkedListNode clone = head.clone();
		System.out.println(clone.printForward());
		nthToLastRecursive(clone,1);
	}
}
