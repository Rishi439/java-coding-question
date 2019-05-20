package com.programming.linkedlist;

/*
 * For doubly linkedList
 */
public class LinkdedListNode1<T extends Comparable<T>> {

	private T data;

	private LinkdedListNode1<T> nextNode;

	private LinkdedListNode1<T> prevNode;

	public LinkdedListNode1(T data, LinkdedListNode1<T> prevNode) {
		super();
		this.data = data;
		this.prevNode = prevNode;
	}

	public LinkdedListNode1<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkdedListNode1<T> nextNode) {
		this.nextNode = nextNode;
	}

	public LinkdedListNode1<T> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(LinkdedListNode1<T> prevNode) {
		this.prevNode = prevNode;
	}

	public T getData() {
		return data;
	}
	
	

}
