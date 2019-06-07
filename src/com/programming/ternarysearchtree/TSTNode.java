package com.programming.ternarysearchtree;

public class TSTNode<T> {

	private char key;

	private TSTNode<T> leftNode;

	private TSTNode<T> rightNode;

	private TSTNode<T> middleNode;

	private T value;

	public TSTNode(char key) {
		super();
		this.key = key;
	}

	public Character getKey() {
		return key;
	}

	public void setKey(Character key) {
		this.key = key;
	}

	public TSTNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TSTNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public TSTNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TSTNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	public TSTNode<T> getMiddleNode() {
		return middleNode;
	}

	public void setMiddleNode(TSTNode<T> middleNode) {
		this.middleNode = middleNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void insert(String keyString, T value, int index) {
		if (index < keyString.length()) {
			char keyChar = keyString.charAt(index);
			if (this.getKey() == keyChar) {
				if (this.getMiddleNode() != null) {
					this.getMiddleNode().insert(keyString, value, index);
				} else {
					this.setMiddleNode(new TSTNode<>(keyChar));
					this.getMiddleNode().insert(keyString, value, index + 1);
				}
			} else if (this.getKey() > keyChar) {
				if (this.getLeftNode() != null) {
					this.getLeftNode().insert(keyString, value, index);
				} else {
					this.setLeftNode(new TSTNode<>(keyChar));
					this.getLeftNode().insert(keyString, value, index + 1);
				}
			} else if (this.getKey() < keyChar) {
				if (this.getRightNode() != null) {
					this.getRightNode().insert(keyString, value, index);
				} else {
					this.setRightNode(new TSTNode<>(keyChar));
					this.getRightNode().insert(keyString, value, index + 1);
				}
			}

		} else if (index == keyString.length()) {
			this.setValue(value);
		}
	}

	public T getValue(String keyString, int index) {
		if (index < keyString.length()) {
			char keyChar = keyString.charAt(index);
			if (this.getKey() == keyChar) {
				if (this.getMiddleNode() != null) {
					return this.getMiddleNode().getValue(keyString, index + 1);
				}
			} else if (this.getKey() > keyChar) {
				if (this.getLeftNode() != null) {
					return this.getLeftNode().getValue(keyString, index + 1);
				}
			} else if (this.getKey() < keyChar) {
				if (this.getRightNode() != null) {
					return this.getRightNode().getValue(keyString, index + 1);
				}
			}
		} else if (index == keyString.length()) {
			return this.getValue();
		}
		return getValue(keyString, index + 1);
	}

	private int getValue(char c) {
		return (int) c;
	}

}
