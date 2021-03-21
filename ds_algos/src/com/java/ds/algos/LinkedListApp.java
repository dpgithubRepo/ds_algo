package com.java.ds.algos;


/**
 * Single linked list implementation & general purpose functions
 */

class Node {

	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

/**
 * The Class LinkedListApp.
 */
public class LinkedListApp {
	
	/**
	 * Traverse.
	 *
	 * @param head the head
	 */
	// traverse the linked list and print the data
	public static void traverse(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * Recursive traverse.
	 *
	 * @param head the head
	 */
	// traverse the linked list and print the data recursively
	public static void recursiveTraverse(Node head) {
		if (head == null)
			return;
		System.out.println(head.data);
		recursiveTraverse(head.next);
	}

	/**
	 * Insert at begin.
	 *
	 * @param head the head
	 * @param data the data
	 * @return the node
	 */
	public static Node insertAtBegin(Node head, int data) {
		// create a new node with the data
		Node newNode = new Node(data);
		// if the head is null return new node
		if (head == null)
			return head;
		// else make the new node as the head
		newNode.next = head;
		return newNode;
	}

	/**
	 * Insert at end.
	 *
	 * @param head the head
	 * @param data the data
	 * @return the node
	 */
	public static Node insertAtEnd(Node head, int data) {
		// create a new node with the data
		Node newNode = new Node(data);
		// if the head is null return the new node
		if (head == null)
			return newNode;

		// else traverse the linked list till end
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		return head;
	}

	/**
	 * Delete head node.
	 *
	 * @param head the head
	 * @return the node
	 */
	public static Node deleteHeadNode(Node head) {

		// if the head is null just return it
		if (head == null)
			return head;
		// else return the head.next
		return head.next;
	}

	/**
	 * Delete tail node.
	 *
	 * @param head the head
	 * @return the node
	 */
	public static Node deleteTailNode(Node head) {

		// if head is null return null
		if (head == null)
			return head;

		// if only one node then return null
		if (head.next == null)
			return null;

		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
		return head;

	}
	
	/**
	 * Size.
	 *
	 * @param head the head
	 * @return the int
	 */
	public static int size(Node head) {
		int len = 0;
		while(head !=null) {
			len++;
			head = head.next;
		}
		return len;
	}
	
	/**
	 * Search.
	 *
	 * @param head the head
	 * @param data the data
	 * @return the int
	 */
	public static int search(Node head, int data) {
		int counter = 1;
		while(head !=null) {
			if(head.data == data) return counter;
			head = head.next;
			counter++;
		}
		
		return -1;
	}
	
	
	/**
	 * Insert at.
	 *
	 * @param head the head
	 * @param pos the pos
	 * @param data the data
	 * @return the node
	 */
	public static Node insertAt(Node head, int pos, int data) {
		
		Node newNode = new Node(data);
		int len = size(head);
		
		// if len = 5, position from 0 to 6 is valid..  0 means adding at first and 6 means adding at last
		if(pos>len+1 || pos<1) {
			System.out.println("Invalid position specified");
			return head;
		}
		
		if(pos==1) {
			newNode.next = head;
			return newNode;
		}
		
		Node curr = head;
		for(int i=0;i<pos-2;i++) {
			curr = curr.next;
		}
		
		newNode.next = curr.next;
		curr.next = newNode;
		return head;
	}
	
	
	/**
	 * Delete at.
	 *
	 * @param head the head
	 * @param pos the pos
	 * @return the node
	 */
	public static Node deleteAt(Node head, int pos) {
		if(head == null) return head;
		
		int len = size(head);
		if(pos<1 || pos>len) {
			System.out.println("Invalid position mentioned.....");
			return head;
		}
		
		// if position ==1 remove the head
		if(pos ==1) return head.next;
		
		//if pos == len then it means we need to remove the tail node
		if(pos ==len)return deleteTailNode(head);
		
		Node curr = head;
		for(int i=0;i<pos-2;i++) {
			curr = curr.next;
		}
		 curr.next = curr.next.next;
		return head;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Node head = new Node(10);
		Node node1 = new Node(20);
		Node node2 = new Node(30);
		Node node3 = new Node(40);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;

		System.out.println("Iterative traverse of  the linked list....");
		traverse(head);

		System.out.println("recursive traverse of  the linked list....");
		recursiveTraverse(head);

		// add new node with data as 5 at beginning

		head = insertAtBegin(head, 5);

		System.out.println("Traversing the linked list after adding the new node with data 5 at begin");
		traverse(head);

		System.out.println("Traversing the linked list after adding the new node with data 45 at end");
		head = insertAtEnd(head, 45);
		traverse(head);

		System.out.println("Traversing the linked list after deleting the head(first) node");
		head = deleteHeadNode(head);
		traverse(head);

		System.out.println("Traversing the linked list after deleting the tail(last) node");
		head = deleteTailNode(head);
		traverse(head);
		
		System.out.println("length of the linked list is " + size(head));
		
		
		System.out.println("Traversing the linked list after adding new node 35 at position 4");
		head = insertAt(head, 4, 35);
		traverse(head);
		
		System.out.println("searching the position of the data 35 in the linked list. The position is " + search(head, 35));
		System.out.println("searching the position of the data 10 in the linked list. The position is " + search(head, 10));
		System.out.println("searching the position of the data 45 in the linked list. The position is " + search(head, 45));
		System.out.println("searching the position of the data 40 in the linked list. The position is " + search(head, 40));
		
		
		System.out.println("Removing the element at specified postion of 4");
		head = deleteAt(head, 4);
		traverse(head);
		
		
		System.out.println("Removing the element at specified postion of 1");
		head = deleteAt(head, 1);
		traverse(head);
		
		
		System.out.println("Removing the element at specified postion of 3");
		head = deleteAt(head, 3);
		traverse(head);
	}
}
