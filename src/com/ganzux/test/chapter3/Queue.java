package com.ganzux.test.chapter3;

public class Queue {

	Node first, last;

	void enqueue(int item) {
		if (first == null) {
			last = new Node(item);
			first = last;
		} else {
			last.next = new Node(item);
			last = last.next;
		}
	}

	Object dequeue(){
		if (first != null) {
			Object item = first.data;
			first = first.next;
			return item;
		}
		return null;
	}

}