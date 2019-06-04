package com.programming.redblacktree;

import com.programming.redblacktree.RedBlackTreeUtility.RED_BLACK_TREE_COLOR;
import com.programming.redblacktree.RedBlackTreeUtility.RED_BLACK_TREE_NODE_DIRECTION;
import com.programming.redblacktree.RedBlackTreeUtility.RED_BLACK_TREE_VIOLATION;

/*
 Rules of RedBlack Tree
1) The color of a node is either black or red.
2) The color of root node is always black.
3) All leaf nodes are of black color.
4) Every red node has both children of black color.
5) Every path from a node to its leaf nodes contains equal 
   number of black nodes.
6) The longest path from the root node to any leaf node is no more than 
   twice as long as the shortest path from the root to 
   any other leaf in that tree.
   
   
Rules to check if its RBTree

  1) Its is binary search tree
  2) Each Node is Red/Black
  3) Head Node is black
  4) Nil Node is black
  5) Red Node has only black children
  6) black nodes path to leaves must be equal 
  
  
   Red Black Tree Insertion
        Points to remember for insertion
        1) Z is always red during insertion.
        2) After operation new Z is the lowest node in violation.
        3) Priority is given to parent than child during rotation of attachment. 
        
   Case 1 : 
   -> Z is head always black
   
   Rest of cases depends upon uncles mood
   
     Case 2 : 
     -> Uncle is red = Change color of Z.Parent , Z.Uncle , Z.GrandParent.
 
     Case 3 : 
     -> Z.Uncle is black and Z makes a triangle = Rotate Z.parent in opposite direction
     
     Case 4: 
     -> Z.Uncle is black and Z makes a line = Rotate Z.GrandParent in opposite direction , 
        Exchange colors of Z.GrandParent and Z.Parent.
     
          
           
*/

public class RedBlackTree<T extends Comparable<T>> {

	private RedBlackTreeNode<T> head;

	public RedBlackTree() {
	}

	public void insert(T newData) {
		RedBlackTreeNode<T> newInsertedNode;
		if (this.head == null) {
			this.head = new RedBlackTreeNode<T>(newData);
			newInsertedNode = this.head;
		} else {
			newInsertedNode = this.head.insert(newData);
		}
		maintainBalance(newInsertedNode);
	}

	public boolean delete(T newData) {
		return false;
	}

	private void maintainBalance(RedBlackTreeNode<T> node) {
		RED_BLACK_TREE_VIOLATION violationCase = identifyViolation(node);
		switch (violationCase) {
		case CASE_1: // Z is head always black
			node.setColor(RED_BLACK_TREE_COLOR.BLACK);
			maintainBalance(node);
			break;
		case CASE_2: // Uncle is red = Change color of Z.Parent , Z.Uncle , Z.GrandParent.
			node.getGrandParent().setColor(RED_BLACK_TREE_COLOR.RED);
			node.getUncleNode().setColor(RED_BLACK_TREE_COLOR.BLACK);
			node.getParentNode().setColor(RED_BLACK_TREE_COLOR.BLACK);
			maintainBalance(node);
			break;
		case CASE_3: // Z.Uncle is black and Z makes a triangle = Rotate Z.parent in opposite
						// direction && Parent (P) is red but uncle(U) is black, new node (n) is
						// inserted as the right child of P, P is the left child of G:
			

			break;
		case CASE_4:// Z.Uncle is black and Z makes a line = Rotate Z.GrandParent in opposite
					// direction ,
					// Exchange colors of Z.GrandParent and Z.Parent.

			break;
		case NULL:
			return;
		default:
			break;
		}

	}

	private RED_BLACK_TREE_VIOLATION identifyViolation(RedBlackTreeNode<T> node) {

		if (node.getParentNode() == null && node.getColor().equals(RED_BLACK_TREE_COLOR.RED)) {
			return RED_BLACK_TREE_VIOLATION.CASE_1;
		}

		if (node.getParentNode().getColor().equals(RED_BLACK_TREE_COLOR.RED)
				&& node.getUncleNode().getColor().equals(RED_BLACK_TREE_COLOR.RED)) {
			return RED_BLACK_TREE_VIOLATION.CASE_2;
		}

		if (node.getParentNode().getColor().equals(RED_BLACK_TREE_COLOR.RED)
				&& node.getUncleNode().getColor().equals(RED_BLACK_TREE_COLOR.BLACK)
				&& node.getColor().equals(RED_BLACK_TREE_COLOR.RED)) {
			if (node.getDirection().equals(RED_BLACK_TREE_NODE_DIRECTION.RIGHT)
					&& node.getParentNode().getDirection().equals(RED_BLACK_TREE_NODE_DIRECTION.LEFT)) {
				return RED_BLACK_TREE_VIOLATION.CASE_3;
			} else if (node.getDirection().equals(RED_BLACK_TREE_NODE_DIRECTION.LEFT)
					&& node.getParentNode().getDirection().equals(RED_BLACK_TREE_NODE_DIRECTION.LEFT)) {
				return RED_BLACK_TREE_VIOLATION.CASE_4;
			}
		}

		return RED_BLACK_TREE_VIOLATION.NULL;

	}

	private void rotate(RedBlackTreeNode<T> node) {
             RedBlackTreeNode<T> parentNode = node.getParentNode();
	}

}
