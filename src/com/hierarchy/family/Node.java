package com.hierarchy.family;

import java.util.ArrayList;

import java.util.List;

public class Node<T> {

	private T data = null;

	private List<Node<T>> children = new ArrayList<>();

	private Node<T> parent = null;

	private boolean root;

	public Node(T data) {

		this.data = data;

	}

	public Node<T> addChild(Node<T> child) {

		child.setParent(this);

		this.children.add(child);

		return child;

	}
	
	public List<Node<T>> getChildren() {

		return children;

	}

	public T getData() {

		return data;

	}

	public void setData(T data) {

		this.data = data;

	}

	private void setParent(Node<T> parent) {

		this.parent = parent;

	}

	public Node<T> getParent() {

		return parent;

	}

	public boolean isRoot() {

		return root;

	}

	public void setRoot(boolean root) {

		this.root = root;

	}

	@Override
	public String toString() {

		return "Node [data=" + data + ", children=" + children + ", parent="
				+ parent + ", root=" + root + "]";

	}

}
