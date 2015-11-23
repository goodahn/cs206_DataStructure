package BinaryTree.BinaryTreeLinked;

import java.util.Iterator;

import BinaryTree.BinaryTree.*;

public class LinkedTraversal<T> extends BinaryTreeLinked<T>{

	   public Iterator<T> iteratorInOrderTraversal() 
	   {
	      ArrayUnorderedList<T>list = new ArrayUnorderedList<T>();
	      inorder (root, list);
	      return list.iterator();
	   }
	   
	   protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> list) 
	   {

		   //Implement a recursive inorder traversal
		   //
		   //      Implementation!!!!
		   //
		   if(node.left!=null)
			   inorder(node.left,list);
		   list.addToRear((T) node);
		   if(node.right!=null)
			   inorder(node.right,list);

	   }
	   
	   public Iterator<T> iteratorPreOrderTraversal() 
	   {
	      ArrayUnorderedList<T> list = new ArrayUnorderedList<T>();
	      preorder (root, list);
	      return list.iterator();
	   }
	   protected void preorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> list) 
	   {

		   //Implement a recursive preorder traversal
		   //
		   //      Implementation!!!!
		   //
		   list.addToRear((T) node);
		   if(node.left!=null)
			   preorder(node.left,list);
		   if(node.right!=null)
			   preorder(node.right,list);

	   }
	   
	   public Iterator<T> iteratorPostOrderTraversal() 
	   {
	      ArrayUnorderedList<T> list = new ArrayUnorderedList<T>();
	      postorder (root, list);
	      return list.iterator();
	   }
	   
	   protected void postorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> list) 
	   {

		   //Implement a recursive postorder traversal
		   //
		   //      Implementation!!!!
		   //
		   if(node.left!=null)
			   postorder(node.left,list);
		   if(node.right!=null)
			   postorder(node.right,list);
		   list.addToRear((T) node);
		   
	   }
	   
	   
}
