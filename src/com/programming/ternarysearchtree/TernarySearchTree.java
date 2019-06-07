package com.programming.ternarysearchtree;

import java.util.HashMap;
import java.util.Map;

public class TernarySearchTree<T> {

	private Map<String, T> ternaryHashMap;

	private TSTNode<T> rootNode;

	public TernarySearchTree() {
		super();
		this.ternaryHashMap = new HashMap<>();
	}

	public void insert(String key, T value) {
		ternaryHashMap.put(key, value);
		if (rootNode == null) {
			rootNode = new TSTNode<>(key.charAt(0));
			rootNode.insert(key, value, 0 + 1);
		} else {
			rootNode.insert(key, value, 0);
		}

	}

	public T getValue(String key) {
		System.out.println("Hash Map Value : " + ternaryHashMap.get(key));
		return rootNode.getValue(key, 0);

	}

}
