package com.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class BSTOperation {
	public static void main(String[] args) {
		BSTOperation obj = new BSTOperation();
		Treenode root = new Treenode(40);

		
		  obj.insert_1(root, 20); obj.insert_1(root, 10); obj.insert_1(root, 30);
		  obj.insert_1(root, 60); obj.insert_1(root, 70); obj.insert_1(root, 50);
		  obj.insert_1(root, 5);
		 

		//obj.insert_1(root, 20);
		// Via root daimeter
		/*
		 * obj.insert_1(root, 30); obj.insert_1(root, 60); obj.insert_1(root, 55);
		 * obj.insert_1(root, 50); obj.insert_1(root, 56); obj.insert_1(root, 70);
		 */
		
		//not through root
		
		/*
		 * obj.insert_1(root, 60); obj.insert_1(root, 55); obj.insert_1(root, 50);
		 * obj.insert_1(root, 56); obj.insert_1(root, 70); obj.insert_1(root, 75);
		 */
		
		 System.out.println("\n=========Daimeter of BT===================");
		obj.daimeterOfBT(root);
		//obj.traveralSwap(root);
		//obj.inorder(root);

		
		  System.out.println("\n=========boundaryTraversalTree_19===================");
		  obj.boundaryTraversalTree_19(root);
		  
		  System.out.println("\n=========bottomView_18===================");
		  obj.bottomView_18(root,0);
		  
		  System.out.println("\n=========verticalview_17===================");
		  obj.verticalview_17(root,0);
		  
		  
		  
		  System.out.println("=========byLevel_2===================");
		  obj.byLevel_2(root);
		  
		  System.out.println("\n=========zigzag_3===================");
		  obj.zigzag_3(root);
		  
		  System.out.println("\n=========printLeafnode_4===================");
		  obj.printLeafnode_4(root);
		  
		  System.out.println("\n=========heightOfTree_5==================="); int
		  htofTree = obj.heightOfTree_5(root);
		  System.out.println("htofTree:"+htofTree);
		  
		  System.out.println(
		  "\n=========sizeOfTreeOrNumberOfNodes_6==================="); int noOfNode =
		  obj.sizeOfTreeOrNumberOfNodes_6(root);
		  System.out.println("noOfNode:"+noOfNode);
		  
		  System.out.println("\n=========printAllPaths_7==================="); int
		  path[] = new int[100]; obj.printAllPaths_7(root, path, 0);
		  
		  System.out.println("\n=========sameTree_8==================="); boolean b =
		  obj.sameTree_8(root, root); System.out.println("is-same tree:"+b);
		  
		  System.out.println("\n=========areMirror_9==================="); boolean
		  ismirror = obj.areMirror_9(root, root);
		  System.out.println("is-mirror tree:"+ismirror);
		  
		  System.out.println("\n=========isBST_10==================="); boolean isbst =
		  obj.isBST_10(root, 0, 1000); System.out.println("is-BST tree:"+isbst);
		  
		  System.out.println("\n=========leftview_11===================");
		  obj.leftview_11(root, 1);
		  
		  System.out.println("\n=========rightview_12===================");
		  obj.rightview_12(root, 1);
		  
		  System.out.println("\n=========topview_13===================");
		  obj.topview_13(root);
		  
		  System.out.println("\n=========daignoldisplay_14===================");
		  obj.daignoldisplay_14(root);
		  
		  System.out.println("\n=========leastcommonancestor_15===================");
		  Treenode lca = obj.leastcommonancestor_15(root,10,30);
		  System.out.println("lca:"+lca.data);
		 

	}

	public void insert_1(Treenode root, int data) {
		if (root.data > data) {
			if (root.left != null) {
				insert_1(root.left, data);
			} else {
				System.out.println(data + " Data inserted into left side of root-node" + root.data);
				root.left = new Treenode(data);
			}
		}

		if (root.data < data) {
			if (root.right != null) {
				insert_1(root.right, data);
			} else {
				System.out.println(root.data + "Data inserted into right side of rt-node" + data);
				root.right = new Treenode(data);
			}
		}
	}

	public void byLevel_2(Treenode root) {
		Queue<Treenode> queue = new LinkedList();
		queue.add(root);
		queue.add(null);

		while (queue.size() > 0) {
			Treenode temp = queue.poll();
			if (temp == null) {
				if (queue.size() == 0)
					return;

				System.out.println("");
				queue.add(null);

			} else {
				System.out.print(temp.data + " ");
				if (temp.getLeft() != null) {
					queue.add(temp.left);
				}
				if (temp.getRight() != null) {
					queue.add(temp.right);
				}
			}
		}
		System.out.println("=======end byLevel_2================");
	}

	public void zigzag_3(Treenode root) {
		Stack<Treenode> st1 = new Stack<Treenode>();
		st1.push(root);
		boolean flag = true;

		while (!st1.isEmpty()) {
			System.out.println("");
			Stack<Treenode> st2 = new Stack<Treenode>();

			while (!st1.isEmpty()) {
				Treenode temp = st1.pop();
				System.out.print(temp.data + " ");

				if (flag) {
					if (temp.left != null) {
						st2.push(temp.left);
					}
					if (temp.right != null) {
						st2.push(temp.right);
					}
				} else {
					if (temp.right != null) {
						st2.push(temp.right);
					}
					if (temp.left != null) {
						st2.push(temp.left);
					}
				}
			}
			st1 = st2;
			flag = !flag;
		}
	}

	public static void printLeafnode_4(Treenode root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			System.out.print(root.data + " ");
		}

		printLeafnode_4(root.left);
		printLeafnode_4(root.right);

	}

	public int heightOfTree_5(Treenode root) {
		if (root == null)
			return 0;

		int lfht = heightOfTree_5(root.left);
		int rtht = heightOfTree_5(root.right);
		return Math.max(lfht, rtht) + 1;
	}

	public int sizeOfTreeOrNumberOfNodes_6(Treenode root) {
		if (root == null)
			return 0;

		int lfht = sizeOfTreeOrNumberOfNodes_6(root.left);
		int rtht = sizeOfTreeOrNumberOfNodes_6(root.right);
		return lfht + rtht + 1;
	}

	public void printAllPaths_7(Treenode root, int path[], int len) {
		if (root == null)
			return;
		path[len++] = root.data;

		if (root.left == null && root.right == null) {
			printPath(path, len);
			return;
		}
		printAllPaths_7(root.left, path, len);
		printAllPaths_7(root.right, path, len);
	}

	private void printPath(int[] path, int len) {
		System.out.println("");
		for (int i = 0; i < len; i++) {
			System.out.print(path[i] + " ");
		}
	}

	public boolean sameTree_8(Treenode n1, Treenode n2) {

		if (n1 == null && n2 == null)
			return true;

		if (n1 == null || n2 == null)
			return false;

		return n1.data == n2.data && sameTree_8(n1.left, n2.left) && sameTree_8(n1.right, n2.right);
	}

	public boolean areMirror_9(Treenode n1, Treenode n2) {

		if (n1 == null && n2 == null)
			return true;

		if (n1 == null || n2 == null)
			return false;

		return n1.data == n2.data && areMirror_9(n1.left, n2.right) && areMirror_9(n1.right, n2.left);
	}

	public boolean isBST_10(Treenode root, int min, int max) {
		if (root == null)
			return true;

		if (root.data < min || root.data > max) {
			return false;
		}
		return isBST_10(root.left, min, root.data) && isBST_10(root.right, root.data, max);
	}

	int curLevel = 0;

	public void leftview_11(Treenode root, int nextlevel) {

		if (root == null)
			return;

		if (curLevel < nextlevel) {
			System.out.println(root.data);
			curLevel = nextlevel;
		}
		leftview_11(root.left, nextlevel + 1);
		leftview_11(root.right, nextlevel + 1);

	}

	int curlevel = 0;

	public void rightview_12(Treenode root, int nextlevel) {
		if (root == null)
			return;

		if (curlevel < nextlevel) {
			System.out.println(root.data);
			curlevel = nextlevel;
		}
		rightview_12(root.right, nextlevel + 1);
		rightview_12(root.left, nextlevel + 1);

	}

	public void topview_13(Treenode root) {

		if (root == null)
			return;

		Treenode cur = root;
		Stack<Treenode> st = new Stack();
		while (cur != null) {
			st.push(cur);
			cur = cur.left;
		}
		while (st.peek() != root) {
			System.out.print(st.pop().data + " ");
		}
		System.out.println();
		cur = root;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.right;
		}
	}

	public void daignoldisplay_14(Treenode root) {

		Queue<Treenode> q = new LinkedList<Treenode>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			Treenode temp = q.poll();
			if (temp == null) {

				if (q.size() == 0)
					return;

				System.out.println("");
				q.add(null);
			} else {

				while (temp != null) {
					System.out.print(temp.data + " ");

					if (temp.left != null) {
						q.add(temp.left);
					}
					temp = temp.right;
				}
			}
		}
	}

	public Treenode leastcommonancestor_15(Treenode root, int n1, int n2) {

		while (root != null) {
			if (root.data > n1 && root.data > n2) {
				root = root.left;
			} else if (root.data < n1 && root.data < n2) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}

	public Treenode leastcommonancestorBinaryTree_16(Treenode root, int n1, int n2) {
		if (root == null)
			return null;
		if (root.data == n1 || root.data == n2) {
			return root;
		}
		Treenode leftca = leastcommonancestorBinaryTree_16(root.left, n1, n2);
		Treenode rtca = leastcommonancestorBinaryTree_16(root.right, n1, n2);

		if (leftca != null && rtca != null) {
			return root;
		}

		return leftca != null ? leftca : rtca;
	}

	void verticalview_17(Treenode root, int hd) {

		if (root == null)
			return;

		Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(hd, root));

		while (!q.isEmpty()) {
			Pair temp = q.poll();

			if (map.containsKey(temp.hd)) {
				map.get(temp.hd).add(temp.tnode.data);
			} else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(temp.tnode.data);
				map.put(temp.hd, list);
			}

			if (temp.tnode.left != null) {
				q.add(new Pair(temp.hd - 1, temp.tnode.left));
			}

			if (temp.tnode.right != null) {
				q.add(new Pair(temp.hd + 1, temp.tnode.right));
			}
		}

		for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			List<Integer> al = entry.getValue();
			System.out.print(entry.getKey() + " : ");
			for (Integer pair : al) {
				System.out.print(pair + " ");
			}
			System.out.println();
		}

	}

	void bottomView_18(Treenode root, int hd) {
		if (root == null)
			return;

		Map<Integer, Integer> map = new TreeMap();
		Queue<Pair> q = new LinkedList();
		q.add(new Pair(hd, root));

		while (!q.isEmpty()) {
			Pair temp = q.poll();

			map.put(temp.hd, temp.tnode.data);

			if (temp.tnode.left != null) {
				q.add(new Pair(temp.hd - 1, temp.tnode.left));
			}

			if (temp.tnode.right != null) {
				q.add(new Pair(temp.hd + 1, temp.tnode.right));
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {

			System.out.println(entry.getKey() + " :" + entry.getValue());
		}
	}

	void boundaryTraversalTree_19(Treenode root) {
		left_bt(root);

		printLeafnode_4(root);
		rt_bt(root.right);

	}

	private void left_bt(Treenode root) {

		if (root == null)
			return;
		if (root.left != null) {
			System.out.print(root.data + " ");
			left_bt(root.left);
		} else if (root.right != null) {
			System.out.print(root.data + " ");
			left_bt(root.right);
		}

	}

	private void rt_bt(Treenode root) {
		if (root == null)
			return;
		if (root.right != null) {
			System.out.print(root.data + " ");
			rt_bt(root.right);
		} else if (root.left != null) {
			System.out.print(root.data + " ");
			rt_bt(root.left);
		}
	}

	void swap(Treenode root) {
		Treenode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	void traveralSwap(Treenode root) {
		if (root != null) {
			swap(root);
			traveralSwap(root.left);
			traveralSwap(root.right);
		}
	}

	void inorder(Treenode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	int daimeterOfBT(Treenode root) {
		if(root == null) {
			return 0;
		}
		int leftHt = heightOfTree_5(root.left);
		int rtHt = heightOfTree_5(root.right);
		
		int leftdaimeter = daimeterOfBT(root.left);
		int rtdaimeter = daimeterOfBT(root.right);
		
		int maxLf = Math.max(leftdaimeter,rtdaimeter);
		int fd = Math.max(leftHt+rtHt+1, maxLf);
		System.out.println("Through root:"+(leftHt+rtHt+1));
		System.out.println("Not Through root:"+maxLf);
		System.out.println("FD:"+fd);
		return  fd;
	}

}

class Pair {
	int hd;
	Treenode tnode;

	public Pair(int hd, Treenode tnode) {
		super();
		this.hd = hd;
		this.tnode = tnode;
	}

	public int getHd() {
		return hd;
	}

	public void setHd(int hd) {
		this.hd = hd;
	}

	public Treenode getTnode() {
		return tnode;
	}

	public void setTnode(Treenode tnode) {
		this.tnode = tnode;
	}

}

class Treenode {

	int data;
	Treenode left;
	Treenode right;

	public Treenode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Treenode getLeft() {
		return left;
	}

	public void setLeft(Treenode left) {
		this.left = left;
	}

	public Treenode getRight() {
		return right;
	}

	public void setRight(Treenode right) {
		this.right = right;
	}

}