package com.programming.linkedlist;

import java.util.Iterator;

public class LinkedList1<T extends Comparable<T>> implements Iterator<T>, Iterable<T> {

	private LinkdedListNode1<T> head;

	private int size;

	private LinkdedListNode1<T> loopTemp;

	public void add(T data) {

		if (head == null) {
			head = new LinkdedListNode1<T>(data, null);
		}
		LinkdedListNode1<T> currentNode = head;

		while (currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
		}
		currentNode.setNextNode(new LinkdedListNode1<T>(data, currentNode));
		size++;
	}

	public boolean remove(T data) {
		if (head.getData().compareTo(data) == 0) {
			LinkdedListNode1<T> currentNode = head.getNextNode();
			currentNode.setPrevNode(null);
			head = currentNode;
			size--;
			return true;
		}
		LinkdedListNode1<T> currentNode = head;

		while (currentNode.getData().compareTo(data) == 0 && currentNode != null) {
			currentNode = currentNode.getNextNode();
		}

		if (currentNode != null) {
			currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
			currentNode = null;
			size--;
			return true;
		}
		return false;

	}

	@Override
	public Iterator<T> iterator() {
		if (loopTemp == null) {
			loopTemp = head;
		}
		return this;
	}

	@Override
	public boolean hasNext() {
		loopTemp = loopTemp.getNextNode();
		return (loopTemp != null ? true : false);
	}

	@Override
	public T next() {
		return loopTemp.getData();
	}

	public int getSize() {
		return size;
	}

}
