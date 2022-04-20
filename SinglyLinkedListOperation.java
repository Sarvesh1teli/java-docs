package com.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class SinglyLinkedListOperation {
	public static void main(String[] args) {
		
		SinglyLinkedListOperation list = new SinglyLinkedListOperation();
		System.out.println("----------addRearEnd_1-------------");
		list.addRearEnd_1(10);
		list.addRearEnd_1(20);
		list.addRearEnd_1(30);
		list.addRearEnd_1(40);
		list.addRearEnd_1(50);
		list.display();
		
		System.out.println("\n----------addFrontEnd_2-------------");
		list.addFrondEnd_2(60);
		list.addFrondEnd_2(70);
		list.display();
		
		System.out.println("\n----------reverseLinkedList_3-------------");
		list.reverseLinkedList_3();
		list.display();

		System.out.println("\n----------findMiddleElement_4-------------");
		list.findMiddleElement_4();
		
		System.out.println("\n----------swapAlternateNode_7-------------");
		list.swapAlternateNode_7();
		list.display();

		System.out.println("\n----------Clone-Random-------------");

		RandomPtrNode n1 =new RandomPtrNode(1);
		RandomPtrNode n2 =new RandomPtrNode(2);
		RandomPtrNode n3 =new RandomPtrNode(3);
		RandomPtrNode n4 =new RandomPtrNode(4);
		RandomPtrNode n5 =new RandomPtrNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next =n5;
		n2.random = n4;
		n4.random = n1;
		
		headclone = n1;
		list.displayrandom(headclone);
		System.out.println("----------Cloned -list-----------------");
		list.cloneList_9();
		list.displayrandom(clonedhead);
		
		
		SinglyLinkedListOperation list1 = new SinglyLinkedListOperation();
		SinglyLinkedListOperation list2 = new SinglyLinkedListOperation();
		
		Node node1 = new Node(1);
		Node node2 = new Node(1);
		Node node3 = new Node(9);
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		

		Node node4 = new Node(1);
		Node node5 = new Node(0);
		Node node6 = new Node(1);
		
		node4.next = node5;
		node5.next = node6;
		node6.next = null;

		System.out.println("-------------addtwo-numbers-------------FG");
		Node addtwo = list.addTwoNumbers(node1, node4);
		
		while(addtwo != null) {
			System.out.print(addtwo.data+" ");
			addtwo = addtwo.next;
		}

		 addtwo = list.addTwoNumbers_11(node1, node4);
		 System.out.println();
		 while(addtwo != null) {
				System.out.print(addtwo.data+" ");
				addtwo = addtwo.next;
			}
		 
		 
		 	Node node10 = new Node(1);
			Node node20 = new Node(2);
			Node node30 = new Node(4);
			node10.next = node20;
			node20.next = node30;
			node30.next = null;
			
			
		 		Node node100 = new Node(1);
				Node node200 = new Node(3);
				node100.next = node200;
				node200.next = null;
			
			
				addtwo = list.mergeTwoList_12(node10,node100);
		 
				System.out.println("mergeTwoList_12");
		 while(addtwo != null) {
				System.out.print(addtwo.data+" ");
				addtwo = addtwo.next;
			}
		 

	}
		private Node mergeTwoList_12(Node list1, Node list2) {
			
			Node result = new Node(0);
			Node result2 = result;
			while(list1!=null || list2!=null) {
				
				if(list1==null) {
					result.next = list2;
					list2= list2.next;
					
				}else if(list2==null) {
					result.next=list1;
					list1=list1.next;
				}else {
					
					if(list1.data<list2.data) {
						
						result.next=list1;
						list1=list1.next;
					}else {
						result.next = list2;
						list2=list2.next;
						
					}
					
				}
				result = result.next;
				
			}
			
			return result2;
		
		}
	static RandomPtrNode headclone;
	static RandomPtrNode clonedhead;;

	void displayrandom(RandomPtrNode head) {
		RandomPtrNode temp = head;
		while(temp != null) {
			System.out.println(temp.data+" " + ((temp.random == null) ? null:temp.random.data));
			temp = temp.next;
		}
	}
	
	Node head;
	
	void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	void addRearEnd_1(int data) {
		Node temp = new Node(data);
		Node cur = head;
		if(cur == null) {
			head = temp;
		}else {
			while(cur.next != null) {
				cur = cur.next;
			}
			cur.setNext(temp);
		}
	}
	void addFrondEnd_2(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
	}
	void reverseLinkedList_3() {
		if(head == null) {
			return;
		}
		Node cur = head;
		Node prev = null;
		Node nextptr = head.next;
		
		while(cur != null) {
			cur.next = prev ;
			prev = cur;
			cur = nextptr;
			if(nextptr != null) {
				nextptr = nextptr.next;
			}
		}
		head = prev;
	}
	
	void findMiddleElement_4() {
		
		if(head == null) {
			return;
		}
		Node slowPtr = head;
		Node fastPtr = head.next;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		System.out.println("Middle-element:"+slowPtr.data);
	}
	
	boolean isCyclicList_5() {
		if(head == null) {
			return false;
		}
		Node slowPtr = head;
		Node fastPtr = head.next;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}
	
	void findNthElement_6(int pos) {
		if(head == null)
			return;
		Node temp = head;
		
		for(int i=0;i<pos;i++) {
			temp = temp.next;
		}
		
		Node slowptr = head;
		while(temp != null) {
			slowptr = slowptr.next;
			temp = temp.next;
		}
		System.out.println("Nth element:"+slowptr.data);
	}
	
	void swapAlternateNode_7() {
		if(head == null)
			return;
		Node cur = head;
		Node newHead = head.next;
		Node prev = null;
		
		while(cur != null && cur.next != null) {
			Node firstptr = cur;
			Node secondptr = cur.next;
			firstptr.next = secondptr.next;
			secondptr.next = firstptr;
			if(prev != null) {
				prev.next = secondptr;
			}
			cur = firstptr;
			prev = cur;
			cur = cur.next;
		}
		head = newHead;
	}
	
	void getIntersectionOfLists_8() {
		
	}
	
	void cloneList_9() {
		RandomPtrNode original = headclone;
		RandomPtrNode cloned = null;
		Map<RandomPtrNode,RandomPtrNode> map = new HashMap<>();
		
		while(original != null) {
			cloned = new RandomPtrNode(original.data);
			map.put(original, cloned);
			original = original.next;
		}
		
		original = headclone;
		RandomPtrNode prev = null;

		while(original != null) {
			cloned = map.get(original);
			cloned.random = map.get(original.random);
			if(prev != null) {
				prev.next = cloned;
				prev = prev.next;
			}else {
				clonedhead = cloned;
				prev = cloned;
			}
			original = original.next;
		}
	}
	
	void checkPalindrome_10() {
		
	}
	
	private static Node addTwoNumbers_11(Node first, Node second) {
		Node result = null;
		Node temp = null;
		Node prev = null;
		int carry = 0;
        // Loop for the two lists
        while (first != null || second != null) {
        	int sum = carry+(first==null?0:first.data)+(second==null?0:second.data);
            carry = sum >= 10?1:0; 
        	sum = sum %10;
        	temp = new Node(sum);
        	if(result == null) {
        		result = temp;
        	}else {
        		prev.next = temp;
        	}
        	prev = temp;
        	if (first != null) {
            	first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
        // After the last iteration, we will check if there is carry left
        // If it's left then we will create a new node and add it
        if (carry > 0) {
            prev.next = new Node(carry);
        }
        return result;
	}

	private static Node addTwoNumbers(Node l1, Node l2) {
        // Head of the new linked list - this is the head of the resultant list
		Node head = null;
        // Reference of head which is null at this point
		Node temp = null;
        // Carry
        int carry = 0;
        // Loop for the two lists
        while (l1 != null || l2 != null) {
            // At the start of each iteration, we should add carry from the last iteration
            int sum = carry;
            // Since the lengths of the lists may be unequal, we are checking if the
            // current node is null for one of the lists
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }
            // At this point, we will add the total sum % 10 to the new node
            // in the resultant list
            Node node = new Node(sum % 10);
            // Carry to be added in the next iteration
            carry = sum / 10;
            // If this is the first node or head
            if (temp == null) {
                temp = head = node;
            }
            // For any other node
            else {
                temp.next = node;
                temp = temp.next;
            }
        }
        // After the last iteration, we will check if there is carry left
        // If it's left then we will create a new node and add it
        if (carry > 0) {
            temp.next = new Node(carry);
        }
        return head;
    }
}

class Node{
	int data;
	Node next;
	public Node(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

class RandomPtrNode{
	int data;
	RandomPtrNode next;
	RandomPtrNode random;
	public RandomPtrNode(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}