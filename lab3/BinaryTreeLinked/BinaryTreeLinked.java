package BinaryTree.BinaryTreeLinked;

import BinaryTree.BinaryTree.*;
import BinaryTree.Exceptions.*;


public class BinaryTreeLinked<T> implements BinaryTreeADT<T> 
{

   protected int count;
   protected BinaryTreeNode<T> root; 

   public BinaryTreeLinked() 
   {
      count = 0;
      root = null;
   }  
   
   public BinaryTreeLinked (T element) 
   {
	   	  //Implement : create a binary tree with element as root 
		  //
		  //      Implementation!!!!
		  //
	   this.addElement(element);
	   
	   
	   count=1;
   }  
  
   
   public void addElement (T element) 
   {

      BinaryTreeNode<T> temp = new BinaryTreeNode<T> (element);
      Comparable<T> comparableE = (Comparable<T>)element;

      if (isEmpty())
         root = temp;
      else 
      {
         BinaryTreeNode<T> current = root;
         boolean added = false;

         while (!added) 
         {
            if (comparableE.compareTo(current.element) < 0)

               if (current.left == null) 
               {
                  current.left = temp;
                  added = true;
               } 
               else
                  current = current.left;
            else
               if (current.right == null) 
               {
                  current.right = temp;
                  added = true;
               } 
               else
                  current = current.right;
         }
      }

      count++;

   }  
   public boolean isExternal(T Element, BinaryTreeNode<T> next)
   {
	   	  //Implement : whether External node or not
		  //
		  //      Implementation!!!!
		  //
	   	  //Return true or false
	   if(findrepeat(Element,root).left==null && findrepeat(Element,root).right==null)
		   return true;
	   else
		   return false;

	   
   }
   
  
   public void deleteLeftSubtree() 
   {
	   	  //Implement : remove left subtree of this binary tree
		  //
		  //      Implementation!!!!
		  //
	   	  //
	  
	   if(isEmpty())
		   return;
	   if(root.left==null)
		   return;
	   else
	   {
		   
		   count=count-1-root.left.numChildren();
		   
		   root.left=null;
		   
		   
	   }
	   
   } 

   public void deleteRightSubtree() 
   {
	   	  //Implement : remove right subtree of this binary tree
		  //
		  //      Implementation!!!!
		  //
	   	  // 
	   if(isEmpty())
		   return;
	   if(root.right==null)
		   return;
	   else
	   {
		   count=count-1-root.right.numChildren();
		   root.right=null;
	   }
   }  
   
   public void deleteAllElements() 
   {
	   	  //Implement : remove all elements in this binary tree
		  //
		  //      Implementation!!!!
		  //
	   	  //
	   deleteLeftSubtree();
	   deleteRightSubtree();
	   root=null;
	   count=0;
	   
	   
   }  

   public boolean isEmpty() 
   {
	   	  //Implement : whether binary tree is empty or not
		  //
		  //      Implementation!!!!
		  //
	   	  //Return true or false
	   if(root==null)
		   return true;
	   else
		   
		   return false;
   }  

   public int size() 
   {
	   	  //Implement : size of binary tree
		  //
		  //      Implementation!!!!
		  //
	   	  //Return # of elements
	   return count;
   } 
   
   public boolean contains (T targetElement) 
   {

      T temp;
      boolean found = false;

      try 
	 {
         temp = find (targetElement);
         found = true;
      }//try
  
      catch (Exception ENotFoundException) 
	 {
         found = false;
      }

      return found;

   }  
   
   public T find(T targetElement) throws ENotFoundException 
   {
     BinaryTreeNode<T> current = findrepeat( targetElement, root );
     if( current == null )
       throw new ENotFoundException("binarytree");
     return (current.element);
   }

   private BinaryTreeNode<T> findrepeat(T targetElement, BinaryTreeNode<T> next)
   {
	   	  //Implement : find element by using recursive method
		  //
		  //      Implementation!!!!
		  //
	   	  //Return elment
	   Comparable<T> comparableE = (Comparable<T>)targetElement;

	   if(comparableE.compareTo(next.element)>0)
		   return findrepeat(targetElement,next.right);
	   else if(comparableE.compareTo(next.element)<0)
		   return findrepeat(targetElement,next.left);
	   else
		   return (BinaryTreeNode<T>) next;
	   
	   
	   
   } 
 
} 

