package BinaryTree.BinaryTreeArray;

import BinaryTree.Exceptions.*;
import BinaryTree.BinaryTree.*;

public class BinaryTreeArray<T> implements BinaryTreeADT<T> 
{

   protected int count;
   protected int max_index;
   protected T[] tree; 
   private final int capacity = 50;

   public BinaryTreeArray() 
   {
	  max_index=-1;
      count = 0;
      tree = (T[]) new Object[capacity];
   }

   public BinaryTreeArray (T element) 
   {  
	   	  //Implement : create a binary tree with element as root 
		  //
		  //      Implementation!!!!
		  //
	  
	  max_index=0;
	  count=1;
	  tree= (T[]) new Object[capacity];
	  tree[0]=element;
	  
   }
   
   private void BinaryTreeArray() {
	// TODO Auto-generated method stub
	
}

public void addElement (T element) 
   {

      if (tree.length < max_index*2+3)
         expandCapacity();

      Comparable<T> comparableE = (Comparable<T>)element;

      if (isEmpty()) 
      {
         tree[0] = element;
         max_index = 0;
      }
      else 
      {
         boolean added = false;
         int currentIndex = 0;

         while (!added) 
         {
            if (comparableE.compareTo((tree[currentIndex]) ) < 0) 
            {
               
               if (tree[currentIndex*2+1] == null) 
               {
                  tree[currentIndex*2+1] = element;
                  added = true;
                  if (currentIndex*2+1 > max_index)
                     max_index = currentIndex*2+1;
               }
               else
                  currentIndex = currentIndex*2+1;
            }
            else 
            {
               
               if (tree[currentIndex*2+2] == null) 
               {
                  tree[currentIndex*2+2] = element;
                  added = true;
                  if (currentIndex*2+2 > max_index)
                     max_index = currentIndex*2+2;
               }
               else
                  currentIndex = currentIndex*2+2;
            }
            
         }
      }
      count++;

   }  

   protected void expandCapacity()
   {
      T[] temp = (T[]) new Object[max_index*2+3];
      for (int ct=0; ct < max_index+1; ct++)
         temp[ct] = tree[ct];
      tree = temp;
   }
   
   public boolean isExternal(T Element)
   {
	   	  //Implement : whether External node or not
		  //
		  //      Implementation!!!!
		  //
	   	  //Return true or false
	   Comparable<T> comparableE = (Comparable<T>)Element;
	   int index=0;
	   while(index<=max_index)
	   {
		   if(tree[index]==null)
			   return false;
		   if(comparableE.compareTo(tree[index])>0)
			   index=2*index+2;
		   else if(comparableE.compareTo(tree[index])<0)
			   index=index*2+1;
		   else if(comparableE.compareTo(tree[index])==0)
		   {
			   if(tree[index*2+1]==null && tree[index*2+2]==null)
				   return true;
			   else
				   return false;
		   }
	   }
	   return false;
	   
   }
   


   public void deleteLeftSubtree() 
   {	
	   	  //Implement : remove left subtree of this binary tree
		  //
		  //      Implementation!!!!
		  //
	   	  // 
	   
	   Comparable<T> comparableE = (Comparable<T>)tree[0];
	   int i,tmp;
	   if(isEmpty())
		   return;
	  
	   for(i=1;i<=max_index;i++)
	   {
		   if(tree[i]!=null)
		   {
			   if (comparableE.compareTo(tree[i])>0)
			   {
				   tree[i]=null;
				   count+=-1;
			   }
		   }
	   }
	   tmp=0;
	   for(i=0;i<max_index;i++)
	   {
		   if(tree[i]!=null && i>tmp)
			   tmp=i;
	   }
	   max_index=tmp;
	   
   }   
	   
   
   
   public void deleteRightSubtree() 
   {
	   	  //Implement : remove right subtree of this binary tree
		  //
		  //      Implementation!!!!
		  //
	   	  //
	
	   Comparable<T> comparableE = (Comparable<T>)tree[0];
	   int i,tmp;
	   if(isEmpty())
		   return;
	  
	   for(i=1;i<=max_index;i++)
	   {
		   if(tree[i]!=null)
		   {
			   if (comparableE.compareTo(tree[i])<0)
			   {
				   tree[i]=null;
				   count+=-1;
			   }
		   }
	   }
	   tmp=0;
	   for(i=0;i<max_index;i++)
	   {
		   if(tree[i]!=null && i>tmp)
			   tmp=i;
	   }
	   max_index=tmp;
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
	   tree[0]=null;
	   count=0;
	   max_index=-1;
   }  
   
   public boolean isEmpty() 
   {
	   	  //Implement : whether binary tree is empty or not
		  //
		  //      Implementation!!!!
		  //
	   	  //Return true or false
	   if(this.tree[0]==null)
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
	   int num=0;
	   for(int i=0;i<=max_index;i++){
		   if(tree[i]!=null)
			   num+=1;
	   }
	   return num;
   }  
   
   public boolean contains (T targetElement) 
   {
	   	  //Implement : whether contain element or not
		  //
		  //      Implementation!!!!
		  //
	   	  //Return true or false
	   Comparable<T> comparableE = (Comparable<T>)targetElement;
	   int index=0;
	   while(index<=max_index)
	   {
		   if(tree[index]==null)
			   return false;
		   if(comparableE.compareTo(tree[index])>0)
			   index=2*index+2;
		   else if(comparableE.compareTo(tree[index])<0)
			   index=index*2+1;
		   else if(comparableE.compareTo(tree[index])==0)
			   return true;
	   }
	   return false;
   } 


   public T find (T targetElement) throws ENotFoundException 
   {
	   	  //Implement : find element in binary tree
		  //
		  //      Implementation!!!!
		  //
	   	  //Return element
	   Comparable<T> comparableE = (Comparable<T>)targetElement;
	   int index=0;
	   try{
	   while(index<=max_index)
	   {
		   
		   if(comparableE.compareTo(tree[index])>0)
			   index=2*index+2;
		   else if(comparableE.compareTo(tree[index])<0)
			   index=index*2+1;
		   else if(comparableE.compareTo(tree[index])==0)
			   return targetElement;
	   }
	   
		   return tree[index+100];
	   }
	   catch(ENotFoundException e)
	   {
		   System.out.println("can't find target.");
		   return tree[max_index+1];
	   }
   
   }


}  

