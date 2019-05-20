package com.programming.linkedlist;

import java.util.Iterator;

public class CustomLinkedList<T extends Comparable<T>> implements Iterator<T>, Iterable<T> {

	private LinkedListNode<T> head;

	private int size;

	private LinkedListNode<T> loopTemp;

	public void add(T data) {

		if (head == null) {
			head = new LinkedListNode<T>(data, null);
		} else {
			LinkedListNode<T> currentNode = head;
			while (currentNode.getNextElement() != null) {
				currentNode = currentNode.getNextElement();
			}
			currentNode.setNextElement(new LinkedListNode<T>(data, null));
		}
		size++;
	}

	public boolean remove(T data) {

		if (head != null) {

			LinkedListNode<T> currentNode = head;
			LinkedListNode<T> prevNode = null;

			while (currentNode.getData().compareTo(data) != 0 && currentNode.getData() != null) {
				prevNode = currentNode;
				currentNode = currentNode.getNextElement();
			}
			if (currentNode != null) {
				prevNode.setNextElement(currentNode.getNextElement());
				currentNode = null;
				this.size--;
				return true;
			}
		}
		return false;

	}

	public T get(T data) {

		if (head != null) {
			LinkedListNode<T> currentNode = head;

			while (currentNode.getData().compareTo(data) != 0 && currentNode != null) {
				currentNode = currentNode.getNextElement();
			}
			return currentNode.getData();
		}
		return null;

	}

	@Override
	public boolean hasNext() {
		loopTemp = loopTemp.getNextElement();
		return (loopTemp != null ? true : false);
	}

	@Override
	public T next() {
		return loopTemp.getData();
	}

	@Override
	public Iterator<T> iterator() {
		if (loopTemp == null) {
			loopTemp = head;
		}
		return this;
	}

}
