package com.nag.doublylinkedlist;

public class DoublyLinkedList {

	private Node first;
	private Node last;
	private int count;

	/**
	 * Will insert the given element at the start of the list
	 * 
	 * @param data
	 */
	public void insertAtTheBeginning(int data) {
		Node n = new Node(data);
		// If the list is empty,this will be the first element,even the last will point to the same element
		if (first == null) {
			first = n;
			last = n;
		} else {
			// The list has one or more than one elements.

			n.right = first;
			first.left = n;
			first = n;


		}
		count++;
	}

	/**
	 * This will insert the element at the end of the list
	 * @param data
	 */
	public void insertAtTheEnd(int data) {
		Node n = new Node(data);
		//If the list is empty, this will be the first and last element
		if(first==null) {
			first = n;
			last = n;
		}else {
			//list has one or more than one element

			last.right=n;
			n.left=last;
			last = n;
		}
		count++;
	}

	/**
	 * Inserts the data after the element in the list
	 * @param data
	 * @param element
	 */
	public void insertAfterAnElement(int data, int element) {
		if(first == null) {
			System.out.println("The list is empty, unable to insert after the given data :  "+element);
		}else {
			Node n = new Node(data);
			boolean elementFound = false;
			Node temp = first;

			while(temp!=null) {
				if(temp.data == element) {
					elementFound = true;
					count++;
					if(temp.right==null) {
						//It is the last element, or the only element present in the list.
						temp.right = n;
						n.left = temp;
						last = n;
						break;
					}else {
						//If element is present in the middle
						Node future = temp.right;
						temp.right = n;
						n.left = temp;
						n.right = future;
						future.left = n;
						break;
					}
				}else {
					temp = temp.right;
				}
			}
			if(!elementFound) {
				System.out.println("Unable to find the element,cannot insert data");
			}
		}
	}

	/**
	 * Deleting the element present first in the list
	 */
	public void deleteAtTheBeginning() {
		if(first==null) {
			System.out.println("The list is empty,deletion at the beginning is not possible");
		}else {
			if(first.right==null) {
				//There is only one element present in the list
				first = null;
				last = null;
			}else {
				Node temp = first.right;
				first.right = null;
				temp.left = null;
				first = temp;

			}
			count--;
		}
	}

	/**
	 * Deletes the element present at the end
	 */
	public void deleteAtTheEnd() {
		if(first == null) {
			System.out.println("The list is empty,deletion at the end is not possible");
		}else {
			if(first.right==null) {
				first = null;
				last = null;
			}else {
				Node temp = last.left;
				temp.right = null;
				last.left=null;
				last = temp;
			}
			count--;
		}
	}


	/**
	 * Deletes the given element in the list
	 * @param data
	 * @return
	 */
	public boolean deleteAParticularElement(int data) {
		if(first == null) {
			return false;
		}
		else {
			if(first.right == null && first.data == data) {
				//Only one element is present and that element has to be deleted.
				first = null;
				last = null;
				count--;
				return true;
			}else if( first.right!=null && first.data==data) {
				//The list has more than one element , but the first element has to be deleted.
				Node temp = first.right;
				first.right = null;
				temp.left = null;
				first = temp;
				count--;
				return true;
			}else {
				//The list has more than one element , but the element is somewhere in the middle or last
				Node temp = first;
				while(temp!=null) {
					if(temp.data == data) {

						if(temp.right!=null) {
							Node future = temp.right;
							Node prev = temp.left;
							prev.right= future;
							future.left = prev;
							temp.right=null;
							temp.left=null;
							count--;
							return true;
						}else {
							//The element is present in the last position
							Node previous = temp.left;
							previous.right = null;
							temp.left = null;
							last = previous;
							count--;
							return true;

						}
					}else {
						temp = temp.right;
					}
				}
				return false;
			}
		}
	}

	/**
	 * To search the given element and return true or false.True if the element is found and false otherwise.
	 * @param data
	 * @return
	 */
	public boolean searchAnElement(int data) {
		if(first!=null) {
			Node temp = first;
			while(temp!=null) {
				if(temp.data==data) {
					return true;
				}
				temp = temp.right;
			}
		}
		return false;
	}
	
	/**
	 * Reverse the list
	 */
	public void reverseTheList() {
		if(first == null) {
			System.out.println("The list is empty");
		}else {
			Node temp = last;
			while(temp!=null) {
				Node right = temp.right;
				Node left = temp.left;
				temp.right = left;
				temp.left = right;
				temp = temp.right;
			}
			Node lastTemp = last;
			last = first;
			first = lastTemp;
		}
	}

	/**
	 * Returns the size of the list
	 */
	public int getSize() {
		return count;
	}

	/**
	 * Displays the doubly linked list
	 */
	public void display() {
		if(first == null) {
			System.out.println("The list is empty");
		}else {
			Node temp = first;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp = temp.right;
			}
			System.out.println();
		}
	}
}
