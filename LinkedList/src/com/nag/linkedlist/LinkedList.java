package com.nag.linkedlist;

public class LinkedList {
	private Node first;
	private int count;

	/**
	 * Inserts the data at the beginning of the linked list.
	 * 
	 * @param data
	 */
	public void insertAtBeginning(int data) {
		Node n = new Node(data);
		if (first == null) {
			first = n;
		} else {
			n.next = first;
			first = n;
		}
		count++;
	}

	/**
	 * To display the linkedlist
	 */
	public void display() {
		if (first == null) {
			System.out.println("The list is empty");
		}else {
			Node temp = first;
			while (temp != null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	/**
	 * Inserts the data at the end of the list
	 * 
	 * @param data
	 */
	public void insertAtEnd(int data) {

		Node n = new Node(data);

		if(first==null) {
			first =n;
		}else {
			Node temp = first;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}
		count++;


	}

	/**
	 * It will insert the given data after the mentioned element in the list
	 * 
	 * @param data
	 * @param element
	 */
	public void insertAfterAnElement(int data, int element) {
		if(first == null) {
			System.out.println("List is empty,unable to insert");
		}else {
			Node temp = first;
			Node n = new Node(data);
			boolean elementFound = false;

			// Iterating through each element
			while (temp != null) {

				if (temp.data == element) {
					elementFound = true;
					// if the current element is the last element in the list
					if (temp.next == null) {
						temp.next = n;
						count++;
						break;
					} else {
						// Current element is not the last element in the list
						Node nextElement = temp.next;
						temp.next = n;
						n.next = nextElement;
						count++;
						break;
					}
				}
				temp = temp.next;

			}
			if (!elementFound) {
				System.out.println("The given element does not exist in the list");
			}
		}
	}

	/**
	 * It will delete the first element in the list
	 */
	public void deleteAtTheBeginning() {
		if (first != null) {
			if (first.next == null) {
				// Only one element is present ,so removing that first elements gives us empty list
				first = null;
			} else {
				// More than one element is present
				Node temp = first.next;
				first.next = null;
				first = temp;
			}
			count--;
		} else {
			System.out.println("List is empty");
		}

	}

	/**
	 * Deletes the element present at the end of the list
	 */
	public void deleteAtTheEnd() {

		if (first != null) {
			Node temp = first;

			//If there is only one element 
			if (first.next == null) {
				first = null;
			}
			else {
				//There is more than one element

				while (temp.next.next != null) {
					temp = temp.next;
				}
				temp.next = null;
			}
			count--;

		} else {
			System.out.println("The list is empty");
		}
	}

	/**
	 * Delete the given element from the list
	 * @param data
	 */
	public boolean deleteAPaticularElement(int data) {
		if(first ==null) {
			return false;
		}
		else {
			//Only one element present and that has the entered data
			if(first.next==null && first.data == data) 
			{
				first = null;
				count--;
				return true;

			}
			else if(first.next!=null && first.data ==data)
			{
				//If the element is present in first position
				Node tmp = first.next;
				first.next = null;
				first = tmp;
				count--;
				return true;
			}
			else 
			{
				//More than one element is present in the list and definetely the element is not present in the first position
				Node temp = first.next;
				Node node = first;
				while(temp!=null) {
					if(temp.data == data) {
						node.next = temp.next;
						temp.next = null;
						count--;
						return true;

					}else {             
						node = temp;
						temp = temp.next;	
					}

				}
			}
			return false;
		}
	}

	/**
	 * To search the given element
	 * @param data
	 * @return 
	 */
	public boolean linearSearch(int data) {
		if (first != null) {
			Node temp = first;
			// Iterating through each element
			while (temp != null) {

				if (temp.data == data) {
					return true;
				} 
				temp = temp.next;
			}

		}
		return false;
	}

	/**
	 * Reversing the list
	 */
	public void reverseTheList() {
		if(first!=null) {
			if(first.next!=null) { 
				Node temp = first;
				first = first.next;
				temp.next = null;

				while(first!=null) {
					Node tempAdd = first.next;
					first.next = temp;
					temp = first;
					first = tempAdd;
				}
				first = temp;
			}else {
				System.out.println("The list contains only one element,cannot reverse");
			}
		}else {
			System.out.println("The list is empty,cannot reverse");
		}
	}


	/**
	 * Returns the size of the list
	 */
	public int getSize() {
		return count;
	}

	//TODO : Sort is remaining



}
