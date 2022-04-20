package com.linkedlist;

public class PracticeList {
	static ListNode head ;
	
	public static void main(String[] args) {
	
		insertRearEnd(10);
		insertRearEnd(20);
		//display(head);
		
		ListNode listA = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		listA.setNext(node2);
		node2.setNext(node3);
		node3.setNext(null);
		
		ListNode listB = new ListNode(1);
		ListNode nodeB2 = new ListNode(3);
		ListNode nodeB3 = new ListNode(5);
		
		listB.setNext(nodeB2);
		nodeB2.setNext(nodeB3);
		nodeB3.setNext(null);
		System.out.println("---------------------------");
		display(listA);
		display(listB);
		ListNode listC = mergeTwoList(listA,listB);
		display(listC);
		System.out.println("---------------------------");
		
		
		
	}
	private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
		
		ListNode result = new ListNode(0);
		ListNode result2 = result;
		if(list1==null && list2==null) {
			return null;
		}
		while(list1 != null || list2 != null) {
			if(list1 == null) {
				result.setNext(list2);
				list2 = list2.getNext();
			}else if(list2 == null) {
				result.setNext(list1);
				list1 = list1.getNext();
			}else {
				
				if(list1.getData()<list2.getData()) {
					result.setNext(list1);
					list1 = list1.getNext();
				}else {
					
					result.setNext(list2);
					list2 = list2.getNext();
				}
				
			}
			result = result.getNext();
		}
		
		return result2;
	}
	static void insertRearEnd(int data) {
		ListNode temp = new ListNode(data);
		ListNode cur = head;
		if(cur == null) {
			head = temp;
		}else {
			while(cur.getNext()!=null) {
				cur = cur.getNext();
			}
			cur.setNext(temp);
		}
	}
	
	static void display(ListNode head) {
		ListNode cur = head;
		System.out.println("Displaying data....");
		while(cur != null) {
			System.out.println(cur.getData());
			cur = cur.getNext();
		}
	}
}

class ListNode{
	private int data;
	private ListNode next;
	
	public ListNode(int data) {
		super();
		this.data = data;
		
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
}
