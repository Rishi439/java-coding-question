package com.programming.redblacktree;

import com.programming.redblacktree.RedBlackTreeUtility;
import com.programming.redblacktree.RedBlackTreeUtility.RED_BLACK_TREE_COLOR;
import com.programming.redblacktree.RedBlackTreeUtility.RED_BLACK_TREE_NODE_DIRECTION;

public class RedBlackTreeNode<T extends Comparable<T>> {

	private T data;

	private RED_BLACK_TREE_NODE_DIRECTION direction;

	private RED_BLACK_TREE_COLOR color = RED_BLACK_TREE_COLOR.BLACK;

	private RedBlackTreeNode<T> rightNode;

	private RedBlackTreeNode<T> leftNode;

	private RedBlackTreeNode<T> parentNode;

	public RedBlackTreeNode(T data) {
		this.data = data;
		this.color = RED_BLACK_TREE_COLOR.RED;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RED_BLACK_TREE_NODE_DIRECTION getDirection() {
		return direction;
	}

	public void setDirection(RED_BLACK_TREE_NODE_DIRECTION direction) {
		this.direction = direction;
	}

	public RED_BLACK_TREE_COLOR getColor() {
		return color;
	}

	public void setColor(RED_BLACK_TREE_COLOR color) {
		this.color = color;
	}

	public RedBlackTreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(RedBlackTreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	public RedBlackTreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(RedBlackTreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public RedBlackTreeNode<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(RedBlackTreeNode<T> parentNode) {
		this.parentNode = parentNode;
	}

	public RedBlackTreeNode<T> insert(T newData) {
		if (newData.compareTo(data) < 0) {
			if (this.getLeftNode() == null) {
				this.setLeftNode(new RedBlackTreeNode<T>(newData));
				this.getLeftNode().setDirection(RED_BLACK_TREE_NODE_DIRECTION.LEFT);
				return this;
			} else {
				this.getLeftNode().insert(newData);
			}
		} else if (newData.compareTo(data) > 0) {
			if (this.getRightNode() == null) {
				this.setRightNode(new RedBlackTreeNode<T>(newData));
				this.getRightNode().setDirection(RED_BLACK_TREE_NODE_DIRECTION.RIGHT);
				return this;
			} else {
				this.getRightNode().insert(newData);
			}
		}
		return null;
	}

	public void delete(T removeData) {

	}

	public RedBlackTreeNode<T> getGrandParent() {

		if (this != null && this.getParentNode() != null) {
			return this.getParentNode().getParentNode();
		} else {
			return null;
		}
	}

	public RedBlackTreeNode<T> getUncleNode() {
		RedBlackTreeNode<T> grandParentNode = getGrandParent();
		if (grandParentNode == null) {
			return null;
		}
		if (this.getParentNode() == grandParentNode.getLeftNode()) {
			return grandParentNode.getRightNode();
		} else {
			return grandParentNode.getLeftNode();
		}
	}

}
