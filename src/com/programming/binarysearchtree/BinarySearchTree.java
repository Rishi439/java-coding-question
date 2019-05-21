package com.programming.binarysearchtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

	private BinaryNode<T> rootNode;

	public void insert(T data) {
		if (this.rootNode != null) {
			this.rootNode.insert(data);
		} else {
			this.rootNode = new BinaryNode<T>(data);
		}
	}

	public T getMin() {
		return this.rootNode.getMinValue();
	}

	public T getMax() {
		return this.rootNode.getMaxValue();
	}

	public boolean remove(T valueRemoved) {
		if (rootNode == null) {
			return false;
		} else {
			if (rootNode.getData() == valueRemoved) {
				BinaryNode<T> tempNode = new BinaryNode<T>(null);
				tempNode.setLeftNode(rootNode);
				boolean result = rootNode.remove(valueRemoved, tempNode);
				rootNode = tempNode.getLeftNode();
				return result;
			} else {
				return rootNode.remove(valueRemoved, null);
			}
		}
	}

	public Iterator<T> iterator() {
		List<T> nodeList = new ArrayList<T>();
		rootNode.traverse(nodeList);
		return nodeList.iterator();
	}
}
