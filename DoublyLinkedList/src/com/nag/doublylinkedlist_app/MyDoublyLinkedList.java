package com.nag.doublylinkedlist_app;

import java.util.Scanner;

import com.nag.doublylinkedlist.DoublyLinkedList;


public class MyDoublyLinkedList {
	private static DoublyLinkedList doublyLinkedList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doublyLinkedList= new DoublyLinkedList();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println("Menu:");
			System.out.println("1.Insert at the beiginning");
			System.out.println("2.Insert at the end");
			System.out.println("3.Insert after an element");
			System.out.println("4.Delete at the beginning");
			System.out.println("5.Delete at the end");
			System.out.println("6.Delete a particular element");
			System.out.println("7.Search a particular element in the list");
			System.out.println("8.Reverse the list");
			System.out.println("9.Display the list");
			System.out.println("10.Get the size of the list");
			System.out.println("11.Exit");

			System.out.println("\nEnter the chioce");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the element to be inserted");
				int data = sc.nextInt();
				doublyLinkedList.insertAtTheBeginning(data);
				break;
			case 2:
				System.out.println("Enter the element to be inserted");
				int dataAtEnd = sc.nextInt();
				doublyLinkedList.insertAtTheEnd(dataAtEnd);
				break;
			case 3:
				System.out.println("Enter the element to be inserted");
				int dataToBeInserted = sc.nextInt();
				System.out.println("Enter the element after which the data should be inserted");
				int element = sc.nextInt();
				doublyLinkedList.insertAfterAnElement(dataToBeInserted, element);
				break;
			case 4:
				doublyLinkedList.deleteAtTheBeginning();
				break;
			case 5:
				doublyLinkedList.deleteAtTheEnd();
				break;
			case 6:
				System.out.println("Enter the element to be deleted");
				int dataToBeDeleted = sc.nextInt();
				boolean deleted = doublyLinkedList.deleteAParticularElement(dataToBeDeleted);
				if(deleted) {
					System.out.println("The value"+dataToBeDeleted+" is successfully deleted from the list");
				}else {
					System.out.println("The value"+dataToBeDeleted+" cannot be deleted from the list");
				}
				break;
			case 7:
				System.out.println("Enter the element to be searched");
				int dataTobeSearched = sc.nextInt();
				boolean found = doublyLinkedList.searchAnElement(dataTobeSearched);
				if(found) {
					//Send to server
					System.out.println("The element"+dataTobeSearched+"is present in the list");
				}else {
					//Don't send it to server
					System.out.println("The element"+dataTobeSearched+"is not present in the list");

				}
				break;
			case 8:
				doublyLinkedList.reverseTheList();
				break;
			case 9:
				doublyLinkedList.display();
				break;
			case 10:
				int size = doublyLinkedList.getSize();
				System.out.println("The size of the list is "+size);
				break;
			case 11:
				sc.close();
				System.exit(0);
			default:
				System.out.println("Choice not available");
			}
		}
		

	}
}
