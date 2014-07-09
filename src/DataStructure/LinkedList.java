package DataStructure;


public class LinkedList {

	private Node firstNode;
	private Node lastNode;
	private int size;

	public LinkedList() {
		this.firstNode = new Node();
		this.lastNode = this.firstNode;
		this.size = 0;
	}

	public LinkedList(Object data) {
		this();
		this.add(data);
	}

	public void add(Object data) {
		Node node = new Node(data);

		// Make sure we cater for the case where the list is empty
		if (this.firstNode.getData() == null) {
			this.firstNode = node;
			this.lastNode = node;
		} else {
			this.lastNode.setNext(node);
			this.lastNode = node;
		}

		this.size++;
	}

	public void delete(Object data) {
		Node currentNode = this.firstNode;
		if (this.size == 0)
			return;

		if (currentNode.getData().equals(data)) {
			if (currentNode.next == null) {
				this.firstNode.setData(null);
				this.firstNode = new Node();
				this.lastNode = this.firstNode;
				this.size--;
				return;
			}
			
			currentNode.setData(null);
			
		}
		
		

	}

	private class Node {

		private Object data;
		private Node next;

		public Node() {
			this.data = null;
			this.next = null;
		}

		public Node(Object data) {
			this.data = data;
			this.next = null;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	public static void main(String[] args) {

	}

}
