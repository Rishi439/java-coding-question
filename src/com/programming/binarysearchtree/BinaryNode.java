package com.programming.binarysearchtree;

import java.util.List;

public class BinaryNode<T extends Comparable<T>> {

	private T data;
	private BinaryNode<T> leftNode;
	private BinaryNode<T> rightNode;

	public BinaryNode(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public BinaryNode<T> getLeftNode() {
		return leftNode;
	}

	public BinaryNode<T> getRightNode() {
		return rightNode;
	}

	public void setLeftNode(BinaryNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public void setRightNode(BinaryNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	public void insert(T newData) {
		if (newData.compareTo(data) < 0) {
			if (this.leftNode != null) {
				this.leftNode.insert(newData);
			} else {
				this.leftNode = new BinaryNode<T>(newData);
			}
		} else {
			if (this.rightNode != null) {
				this.rightNode.insert(newData);
			} else {
				this.rightNode = new BinaryNode<T>(newData);
			}
		}
	}

	public boolean remove(T removeData, BinaryNode<T> parent) {
		if (data.compareTo(removeData) < 0) {
			if (this.leftNode != null) {
				return this.leftNode.remove(removeData, this);
			} else {
				return false;
			}
		} else if (data.compareTo(removeData) > 0) {
			if (this.rightNode != null) {
				return this.rightNode.remove(removeData, this);
			} else {
				return false;
			}
		} else {
			if (this.leftNode != null && this.rightNode != null) {
				this.data = this.rightNode.getMinValue();
				this.rightNode.remove(this.data, this);
			} else if (parent.getLeftNode() == this) {
				BinaryNode<T> node = (leftNode != null) ? leftNode : rightNode;
				parent.setLeftNode(node);
			} else if (parent.getRightNode() == this) {
				BinaryNode<T> node = (leftNode != null) ? leftNode : rightNode;
				parent.setRightNode(node);
			}
		}

		return true;
	}

	public T getMinValue() {
		if (this.leftNode != null) {
			return this.leftNode.getMinValue();
		} else {
			return this.data;
		}
	}

	public T getMaxValue() {
		if (this.rightNode != null) {
			return this.rightNode.getMaxValue();
		} else {
			return this.data;
		}
	}

	public void traverse(List<T> list) {
		if (this.leftNode != null) {
			this.leftNode.traverse(list);
		}

		list.add(data);

		if (this.rightNode != null) {
			this.rightNode.traverse(list);
		}
	}

}
