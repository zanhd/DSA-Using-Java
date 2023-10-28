package LinkedList;

/* 
 * Notes : 
 * You can delete an object in Java by removing the reference to it by assigning
 * null. After that, it will be automatically deleted by the Garbage Collector.
 */

public class SinglyLinkedList implements LinkedList {
	private Integer data;
	private SinglyLinkedList next;

	private SinglyLinkedList head;
	private SinglyLinkedList tail;

	public SinglyLinkedList() {

	}

	public SinglyLinkedList(Integer data) {
		this();
		this.data = data;
		this.next = null;
	}

	@Override
	public void pushBack(Integer data) {
		SinglyLinkedList node = new SinglyLinkedList(data);

		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	@Override
	public void popBack() {
		if (head == null) {
			System.out.println("UnderFlow!!!");
			return;
		}

		if (head == tail) {
			head = tail = null;
			return;
		}

		SinglyLinkedList itr = head;
		while (itr.next != tail) {
			itr = itr.next;
		}
		itr.next = null;
		tail = itr;
	}

	@Override
	public void pushFront(Integer data) {
		SinglyLinkedList node = new SinglyLinkedList(data);

		if (head == null) {
			head = tail = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	@Override
	public void popFront() {
		if (head == null) {
			System.out.println("UnderFlow!!!");
			return;
		}

		if (head == tail) {
			head = tail = null;
			return;
		}

		head = head.next;
	}

	@Override
	public void print() {
		System.out.print("SinglyLinkedList : ");
		SinglyLinkedList itr = head;
		while (itr != null) {
			System.out.print(itr.data + " -> ");
			itr = itr.next;
		}

		System.out.println("null");
	}

}
