package com.programming.linkedlist;

public class LinkedListNode<T extends Comparable<T>> {

	private T data;

	private LinkedListNode<T> nextElement;

	public LinkedListNode(T data, LinkedListNode<T> nextElement) {
		super();
		this.data = data;
		this.nextElement = nextElement;
	}

	public T getData() {
		return data;
	}

	public LinkedListNode<T> getNextElement() {
		return nextElement;
	}

	public void setNextElement(LinkedListNode<T> nextElement) {
		this.nextElement = nextElement;
	}

	@Override
	public String toString() {
		return "LinkedListNode [data=" + data + "]";
	}

}
