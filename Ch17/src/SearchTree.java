

// HOMEWORK BY MATT KOENIG

// QUIZ BY MATT KOENIG 
// MARCH 4, 2019
// CS 211


// SOURCES: class by W.P. Iverson - Bellevue College, November 2015
// Homework methods come from BJP "Practice-It" exercises and BJP PPT slides
// Remove and getMin class programmed with assistance from BJP PPT slides, but customized for E rather than int

import java.util.NoSuchElementException; // added for the getMin class added (with guidance from the ppt slides)
import java.util.*; // for quiz method

public class SearchTree<E extends Comparable<E>> {
	
	private SearchTreeNode<E> overallRoot; // root of overall tree

	// post: constructs an empty search tree
	public SearchTree() {
		overallRoot = null;
	}

	// QUIZ METHOD
	// Turns a search tree into an array list 
	// compares those two array lists and returns the number of same elements
	
	public int countSameData(SearchTree other) {
		int same = 0;
		int thisLength = 0;
		int otherLength = 0;
		ArrayList<E> temp1 = new ArrayList<E>();
		ArrayList<E> temp2 = new ArrayList<E>();

		temp1 = this.toArray();
		temp2 = other.toArray();
		
		temp1.retainAll(temp2);
		same = temp1.size();	
		return same;
	}
	
	public ArrayList<E> toArray() {
	    ArrayList<E> result = new ArrayList<E>();
	    toArrayList(overallRoot, result);
	    return result;
	}

	private void toArrayList(SearchTreeNode root, ArrayList<E> result) {
	    if (root == null) {
	        return;
	    }
	    toArrayList(root.left, result); 
	    result.add((E) root.data); 
	    toArrayList(root.right, result); 
	}
	

	
	
	// HOMEWORK METHODS

	// This method recursively removes leaves from the search tree every time it is
	// invoked
	public void removeLeaves() {
		overallRoot = removeLeaves(overallRoot);
	}

	// Helper method
	private SearchTreeNode<E> removeLeaves(SearchTreeNode<E> root) {

		if (root == null) {
			return null; // base case, root is null
		} else if (root.left == null && root.right == null) {
			return null; // other base case, children are null

		} else {
			root.left = removeLeaves(root.left); // recurse and replace left with null
			root.right = removeLeaves(root.right); // recurse and replace right with null
			return root; // return null after recursing
		}
	}

	// This method recursively determines if a search tree is full
	public boolean isFull() {
		if(overallRoot == null) {
			return overallRoot == null;
		} else {
		return isFull(overallRoot);
		}
	}

	// Helper method
	private boolean isFull(SearchTreeNode<E> root) {
		if (root == null) { // base case, root is null, tree is full
			return true;
		}

		if (root.right != null && root.left == null || root.right == null && root.left != null) {
			return false; // children are mismatched, tree is not full
		}

		return isFull(root.right) && isFull(root.left); // recurse as needed
	}

	// This method recursively determines if two search trees are equal
	public boolean equals(SearchTree<E> anotherRoot) {
		return equals(overallRoot, anotherRoot.overallRoot);
	}

	// Helper method
	private boolean equals(SearchTreeNode<E> root1, SearchTreeNode<E> root2) {
		if (root1 == null && root2 == null) { // base case, both null and thus equal
			return true;
		}

		if (root1 != null && root2 == null || root1 == null && root2 != null) {
			return false; // roots mismatched, thus do not equal
		}

		return equals(root1.left, root2.left) && equals(root1.right, root2.right) && root1.data == root2.data; // recurse as needed
																												// --
																												// this triple && statements solution
																												// has been derived from solution posted by ramak
																												// on Github
	}
	// This method removes a node from a search tree
	public void remove(E temp) {
		overallRoot = remove(overallRoot, temp);
	}

	// Helper method
	private SearchTreeNode<E> remove(SearchTreeNode<E> root, E temp2) { // evaluates based on logic set forth in BJP ch. 17 ppt slides
		if (root == null) { // root is null, remove nothing
			return null;
		} else if (root.data.compareTo(temp2) > 0) { // root data is larger than desired remove element, recurse left
			root.left = remove(root.left, temp2);
		} else if (root.data.compareTo(temp2) < 0) { // root data is less than desired remove element, recurse right
			root.right = remove(root.right, temp2);
		} else if (root.data.compareTo(temp2) == 0) { // root data and desired remove element are the same, implements logic for right-most removal
			if (root.left == null) { // one child null, return other
				return root.right;
			} else if (root.right == null) { // one child null, return other
				return root.left;
			} else if (root.right != null && root.left != null) { // both children are present, remove lowest on right
				root.data = getMin(root.right);
				root.right = remove(root.right, root.data);
			}

		}
		return root;
	}

	// Required based on logic for remove class set forth by BJP ch. 17 ppt slides, adapted for <E>, returns lowest left node
	public E getMin() { 
		if (overallRoot == null) { // if root is null and program is seeking min then throw exception
			throw new NoSuchElementException();
		}
		return getMin(overallRoot);
	}

	// Helper method
	private E getMin(SearchTreeNode<E> root) {
		if (root.left == null) {
			return root.data;
		} else {
			return getMin(root.left);
		}
	}

	// post: value added to tree so as to preserve binary search tree
	public void add(E value) {
		overallRoot = add(overallRoot, value);
	}

	// post: value added to tree so as to preserve binary search tree
	private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
		if (root == null) {
			root = new SearchTreeNode<E>(value);
		} else if (root.data.compareTo(value) > 0) {
			root.left = add(root.left, value);
		} else if (root.data.compareTo(value) < 0) {
			root.right = add(root.right, value);
		}
		return root;
	}

	// post: returns true if tree contains value, returns false otherwise
	public boolean contains(E value) {
		return contains(overallRoot, value);
	}

	// post: returns true if given tree contains value, returns false otherwise
	private boolean contains(SearchTreeNode<E> root, E value) {
		if (root == null) {
			return false;
		} else {
			int compare = value.compareTo(root.data);
			if (compare == 0) {
				return true;
			} else if (compare < 0) {
				return contains(root.left, value);
			} else { // compare > 0
				return contains(root.right, value);
			}
		}
	}

	// post: prints the data of the tree, one per line
	public void print() {
		printInorder(overallRoot);
	}

	// post: prints the data of the tree using an inorder traversal
	private void printInorder(SearchTreeNode<E> root) {
		if (root != null) {
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}

	private static class SearchTreeNode<E> {
		public E data; // data stored in this node
		public SearchTreeNode<E> left; // left subtree
		public SearchTreeNode<E> right; // right subtree

		// post: constructs a leaf node with given data
		public SearchTreeNode(E data) {
			this(data, null, null);
		}

		// post: constructs a node with the given data and links
		public SearchTreeNode(E data, SearchTreeNode<E> left, SearchTreeNode<E> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
