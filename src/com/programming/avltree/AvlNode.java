package com.programming.avltree;

import java.util.Iterator;

public class AvlNode<T extends Comparable<T>> {

	private T data;

	private AvlNode<T> leftChild;

	private AvlNode<T> rightChild;

	private AvlNode<T> parentChild;
	
   private int balance;

	public AvlNode(T data, AvlNode<T> parentChild) {
		super();
		this.data = data;
		this.parentChild = parentChild;
		this.rightChild = null;
		this.leftChild = null;
	}

	public AvlNode<T> insert(T newData, AvlNode<T> parentNode) {

		if (data.compareTo(this.data) < 0) {
			if (this.leftChild == null) {
				this.leftChild = new AvlNode<T>(newData, parentNode);
			} else {
				this.leftChild.insert(newData, this);
			}
		} else {
			if (this.rightChild == null) {
				this.rightChild = new AvlNode<T>(newData, parentNode);
			} else {
				this.rightChild.insert(newData, this);
			}
		}
		return parentNode;
	}

	public boolean remove(T value, AvlNode<T> parent) {

		if (value.compareTo(this.data) < 0) {
			if (this.leftChild != null) {
				return this.leftChild.remove(value, this);
			} else {
				return false;
			}
		} else if (value.compareTo(this.data) > 0) {
			if (this.rightChild != null) {
				return this.rightChild.remove(value, this);
			} else {
				return false;
			}
		} else {
			if (this.leftChild != null && this.rightChild != null) {
				this.data = this.rightChild.minValue();
				this.rightChild.remove(this.data, this);
			} else if (parent.getLeftChild() == this) {
				parent.setLeftChild((this.leftChild != null) ? leftChild : rightChild);
			} else if (parent.getRightChild() == this) {
				parent.setRightChild((this.rightChild != null) ? leftChild : rightChild);
			}
			return true;
		}
	}

	public T minValue() {
		if (this.leftChild == null) {
			return this.data;
		} else {
			return this.leftChild.minValue();
		}
	}

	public T maxValue() {
		if (this.rightChild == null) {
			return this.data;
		} else {
			return this.rightChild.maxValue();
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public AvlNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(AvlNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public AvlNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(AvlNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public AvlNode<T> getParentChild() {
		return parentChild;
	}

	public void setParentChild(AvlNode<T> parentChild) {
		this.parentChild = parentChild;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void traverse() {
		if (this.leftChild != null) {
			this.leftChild.traverse();
		}

		System.out.print(this.data + " - ");

		if (this.rightChild != null) {
			this.rightChild.traverse();
		}
	}

}
