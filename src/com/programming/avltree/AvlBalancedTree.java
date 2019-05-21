package com.programming.avltree;

public class AvlBalancedTree<T extends Comparable<T>> {

	private AvlNode<T> root;

	public void insert(T newData) {

		AvlNode<T> parentNode = this.root;

		if (this.root == null) {
			parentNode = this.root = new AvlNode<T>(newData, null);
		} else {
			parentNode = this.root.insert(newData, root);
		}
		rebelanceTree(parentNode);
	}

	public boolean remove(T newData) {
		if (root == null) {
			return false;
		} else {
			if (root.getData().compareTo(newData) == 0) {
				AvlNode<T> auxRoot = new AvlNode<T>(null, null);
				auxRoot.setLeftChild(root);
				boolean result = root.remove(newData, auxRoot);
				root = auxRoot.getLeftChild();
				return result;
			} else {
				return root.remove(newData, null);
			}
		}
	}

	public T getMin() {
		if (this.root != null) {
			return this.root.minValue();
		} else {
			return null;
		}
	}

	public T getMax() {
		if (this.root != null) {
			return this.root.maxValue();
		} else {
			return null;
		}
	}

	private void rebelanceTree(AvlNode<T> parentNode) {
		setBalance(parentNode);

		if (parentNode.getBalance() < -1) {
			if (height(parentNode.getLeftChild().getLeftChild()) >= height(parentNode.getLeftChild().getRightChild())) {
				parentNode = rotateRight(parentNode);
			} else {
				parentNode = rotateLeftRight(parentNode);
			}
		} else if (parentNode.getBalance() > 1) {
			if (height(parentNode.getRightChild().getRightChild()) >= height(
					parentNode.getRightChild().getLeftChild())) {
				parentNode = rotateLeft(parentNode);
			} else {
				parentNode = rotateRightLeft(parentNode);
			}
		}

		if (parentNode.getParentChild() != null) {
			rebelanceTree(parentNode.getParentChild());
		} else {
			this.root = parentNode;
		}
	}

	private AvlNode<T> rotateLeft(AvlNode<T> node) {
		AvlNode<T> b = node.getRightChild();
		b.setParentChild(node.getParentChild());

		node.setRightChild(b.getLeftChild());
		if (node.getRightChild() != null)
			node.getRightChild().setParentChild(node);

		b.setLeftChild(node);
		node.setParentChild(b);
		if (b.getParentChild() != null) {
			if (b.getParentChild().getRightChild() == node) {
				b.getParentChild().setRightChild(b);
			} else {
				b.getParentChild().setLeftChild(b);
			}
		}

		setBalance(node);
		setBalance(b);
		return b;
	}

	private AvlNode<T> rotateRight(AvlNode<T> node) {

		AvlNode<T> b = node.getLeftChild();
		b.setParentChild(node.getParentChild());
		node.setLeftChild(b.getRightChild());

		if (node.getLeftChild() != null) {
			node.getLeftChild().setParentChild(node);
		}

		b.setRightChild(node);
		node.setParentChild(b);

		if (b.getParentChild() != null) {
			if (b.getParentChild().getRightChild() == node) {
				b.getParentChild().setRightChild(b);
			} else {
				b.getParentChild().setLeftChild(b);
			}
		}
		setBalance(node);
		setBalance(b);
		return b;

	}

	private AvlNode<T> rotateLeftRight(AvlNode<T> node) {
		node.setLeftChild(rotateLeft(node.getLeftChild()));
		return rotateRight(node);
	}

	private AvlNode<T> rotateRightLeft(AvlNode<T> node) {
		node.setRightChild(rotateRight(node.getRightChild()));
		return rotateLeft(node);
	}

	private void setBalance(AvlNode<T> node) {
		node.setBalance(height(node.getRightChild()) - height(node.getLeftChild()));
	}

	private int height(AvlNode<T> node) {
		if (node == null) {
			return -1;
		}

		return 1 - Math.max(height(node.getLeftChild()), height(node.getRightChild()));
	}

	public void traverse() {
		if (this.root != null) {
			this.root.traverse();
		}
	}

}
