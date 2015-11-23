package BinaryTree.BinaryTreeArray;

import java.util.Iterator;

import BinaryTree.BinaryTree.ArrayUnorderedList;

public class ArrayTraversal<T> extends BinaryTreeArray<T>{

	   public Iterator<T> iteratorInOrderTraversal() 
	   {
	      ArrayUnorderedList<T> list = new ArrayUnorderedList<T>();
	      inorder (0, list);
	      return list.iterator();
	   }  
		
	   protected void inorder (int node, ArrayUnorderedList<T> list) 
	   {
	      //Implement a recursive inorder traversal
		  //
		  //      Implementation!!!!
		  //
		  
		  if(tree[node*2+1]!=null)
			  inorder(node*2+1,list);
		  list.addToRear(tree[node]);
		  if(tree[node*2+2]!=null)
			  inorder(node*2+2,list);
		   
	   } 
	   
	   public Iterator<T> iteratorPreOrderTraversal() 
	   {
	      ArrayUnorderedList<T> list = new ArrayUnorderedList<T>();
	      preorder (0, list);
	      return list.iterator();
	   }  
	   
	   protected void preorder (int node, ArrayUnorderedList<T> list) 
	   {
		   //Implement a recursive preorder traversal
		   //
		   //      Implementation!!!!
		   //
		   list.addToRear(tree[node]);
		   if(tree[node*2+1]!=null)
			   preorder(node*2+1,list);
		   if(tree[node*2+2]!=null)
			   preorder(node*2+2,list);
		   
	      
	   }  
	   
	   public Iterator<T> iteratorPostOrderTraversal() 
	   {
	      ArrayUnorderedList<T> list = new ArrayUnorderedList<T>();
	      postorder (0, list);
	      return list.iterator();
	   }  
	   
	   protected void postorder (int node, ArrayUnorderedList<T> list) 
	   {
		   //Implement a recursive postorder traversal
		   //
		   //      Implementation!!!!
		   //
		   if(tree[node*2+1]!=null)
			   postorder(node*2+1,list);
		   if(tree[node*2+2]!=null)
			   postorder(node*2+2,list);
		   list.addToRear(tree[node]);
		   
	   }  
	   
}
