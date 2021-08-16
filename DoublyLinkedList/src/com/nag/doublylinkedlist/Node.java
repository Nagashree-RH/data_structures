package com.nag.doublylinkedlist;

public class Node {

	protected int data;
	protected Node right;
	protected Node left;
	
	public Node(int data) {
		this.data = data;
		this.right = null;
		this.left = null;
	}
}
