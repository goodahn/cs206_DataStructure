/* PA5 - AVL tree 
 * Due : 12/5/2014 23:59
 */

package AVLTree;

import java.util.Comparator;

import BinarySearchTree.BTNode;
import BinarySearchTree.BTPosition;
import BinarySearchTree.BinarySearchTree;
import BinarySearchTree.Dictionary;
import BinarySearchTree.Entry;
import BinarySearchTree.Position;
import Exception.InvalidEntryException;
import Exception.InvalidKeyException;

public class AVLTree<K, V> extends BinarySearchTree<K, V> implements Dictionary<K, V>{

	public AVLTree(Comparator<K> c)	{ super(c); }
	public AVLTree() { super(); }

	/* Nested class for the nodes of an AVL tree. */
	protected static class AVLNode<K, V> extends BTNode<Entry<K, V>>{
		protected int height; 
		AVLNode(){}
		AVLNode(Entry<K, V> element, BTPosition<Entry<K, V>> parent, 
				BTPosition<Entry<K, V>> left, BTPosition<Entry<K, V>> right){
			super(element, parent, left, right);
			height = 0;
			if(left != null)
				height = Math.max(height, 1 + ((AVLNode<K, V>) left).getHeight());
			if(right != null)
				height = Math.max(height, 1 + ((AVLNode<K, V>) right).getHeight());
		}

		public void setHeight(int h) { height = h; }
		public int getHeight() { return height; }
	}
	

	/* Create a new binary search tree node */ 
	protected BTPosition<Entry<K, V>> createNode(Entry<K, V> element,
			BTPosition<Entry<K, V>> parent, BTPosition<Entry<K, V>> left,
			BTPosition<Entry<K, V>> right) {
		return new AVLNode<K, V>(element, parent, left, right);
	}
	
	/* Returns the height of a node */
	protected int height(Position<Entry<K, V>> p){
		return ((AVLNode<K, V>) p).getHeight();
	}
	
	protected void setHeight(Position<Entry<K, V>> p){
		((AVLNode<K, V>) p).setHeight(1+Math.max(height(left(p)), height(right(p))));
	}
	
	/* Returns whether tree is balanced */
	protected boolean isBalanced(Position<Entry<K, V>> p){
		int bf = height(left(p)) - height(right(p));
		return Math.abs(bf) <= 1;
	}
	
	/* Insert(k, v)
	 *  insert new entry
	 * @see BinarySearchTree.BinarySearchTree#insert
	 * , and then call 'rebalance' method for updating height and restructuring
	 */
	public Entry<K, V> insert(K k, V v) throws InvalidKeyException{
		Entry<K, V> newEntry = super.insert(k, v);
		//actionPos becomes inserted node
		rebalance(actionPos);
		return newEntry;
	}
	
	/* remove(ent) 
	 * remove entry that corresponds to 'ent'
	 * @see BinarySearchTree.BinarySearchTree#remove
	 * , and then call 'rebalance' method for updating height and restructuring
	 */
	public Entry<K, V> remove(Entry<K, V> ent) throws InvalidEntryException {
		Entry<K, V> rmEntry = super.remove(ent);
		//actionPos becomes the removed node's parent
		if(rmEntry != null)
			rebalance(actionPos);
		return rmEntry;
	}
	
	/* getTallerChild(p) 
	 * Returns a child of p with height no smaller than that of other child */ 
	protected Position<Entry<K, V>> getTallerChild(Position<Entry<K, V>> p){
		if(height(left(p)) > height(right(p)))
			return left(p);
		else if(height(left(p)) < height(right(p)))
			return right(p);
		//equal height child - break tie using parent's type
		if(isRoot(p)) return left(p);
		if(p == left(parent(p))) return left(p);
		else return right(p);
		
	}
	
	/* Skeleton - rebalance(zPos)
	 * Traverse the path from zPos to the root. 
	 * For each node encountered, recompute its height
	 * Perform a trinode reconstructing if it's unbalanced
	 *  --> Call restructure method
	 * 
	 * Refer to methods in 'BinarySearchTree' package to access nodes in binary search tree.
	 */
	protected void rebalance(Position<Entry<K, V>> zPos){
		
		/* BEGIN CODE */
		Position<Entry<K, V>> tmp=null;
		if(zPos.element()!=null)
		{
			if(isRoot(zPos) )
	        {
				setHeight(zPos);
	            if(!isBalanced(zPos))
	            {
	                tmp=restructure(getTallerChild(getTallerChild(zPos)));
	                if(!isRoot(tmp))
	                	rebalance(parent(tmp));
	            }
	            if(!isRoot(zPos))
	            	rebalance(zPos);
	            	
	        }
	        else if(isRoot(parent(zPos)))
	        {
	        	setHeight(zPos);
	            setHeight(parent(zPos));
	            if(!isBalanced(zPos))
	            {
	                tmp=restructure(getTallerChild(getTallerChild(zPos)));
	                if(!isRoot(tmp))
	                	rebalance(parent(tmp));
	            }
	            else if(!isBalanced(parent(zPos)))
	            {
	            	
	                tmp=restructure(getTallerChild(getTallerChild(parent(zPos))));
	                if(!isRoot(tmp))
	                	rebalance(parent(tmp));
	            }
	        }
	        else
	        {
	        	
	        	setHeight(zPos);
	            setHeight(parent(zPos));
	            setHeight(parent(parent(zPos)));
	            if(!isBalanced(zPos))
	            {
	            	tmp=restructure(getTallerChild(getTallerChild(zPos)));
	            	if(!isRoot(tmp))
	            		rebalance(parent(tmp));
	            }
	            if(!isBalanced(parent(zPos)))
	            {
	            	tmp=restructure(getTallerChild(getTallerChild(parent(zPos))));
	            	if(!isRoot(tmp))
	            		rebalance(parent(tmp));
	            }
	            else if(!isBalanced(parent(parent(zPos))))
	            {
	                tmp=restructure(zPos);
	                if(!isRoot(tmp))
	                	rebalance(parent(tmp));
	                
	            }
	            else
	            {
	            	rebalance(parent(parent(zPos)));
	            }
	        }	
		}
		else
		{
			if(root.element().getKey()==null)
				return;
			else
			{
				setHeight(parent(zPos));			
				if(!isBalanced(parent(zPos)))
				{
					tmp=restructure(getTallerChild(getTallerChild(parent(zPos))));
					if(!isRoot(tmp))
						rebalance(parent(tmp));
				}
				else if(!isRoot(parent(zPos)))
					rebalance((parent(parent(zPos))));
			}
		}
		/* END CODE */
	}
	

	/* Skeleton - restructure(x)
	 * Input : A node x of a binary search tree that has both a parent y and grandparent z 
	 * conducts a trinode restructuring involving nodes x, y, and z
	 */
	protected Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
		Position<Entry<K, V>> y = parent(x);
		Position<Entry<K, V>> z = parent(y);
		
		/*For more information, refer to lecture node p. 16~20 */
		BTPosition<Entry<K, V>> a, b, c; //Variable for renaming x, y, z as a, b, c in an inorder traversal
		BTPosition<Entry<K, V>> t0, t1, t2, t3; //Variable for roots of subtrees 
		
		/*Type casting for invoking methods accessing its child nodes or parent node*/
		BTPosition<Entry<K, V>> xx = (BTPosition<Entry<K, V>>) x, 
				yy = (BTPosition<Entry<K, V>>) y, zz = (BTPosition<Entry<K, V>>) z;
				
		/* BEGIN CODE */
		
		b=null;
		int root_check=0;
		if(yy==zz.getLeft() && xx==yy.getLeft())
        {
            zz.setLeft(yy.getRight());
            yy.getRight().setParent(zz);
            yy.setRight(zz);
            if(!isRoot(zz))
            {
            	yy.setParent(zz.getParent());
            	if(zz.getParent().getLeft()==zz)
            		zz.getParent().setLeft(yy);
            	else
            		zz.getParent().setRight(yy);
            }
            else
            {
            	yy.setParent(null);
            	root_check+=1;
            }
            zz.setParent(yy);
            b=yy;
            if(root_check==1)
            	root=b;
            
            setHeight(x);
    		if(xx.getLeft().element()!=null)
    			setHeight(left(x));
    		if(xx.getRight().element()!=null)
    			setHeight(right(x));
    		if(!isRoot(x))
    		{
    			if(xx.getParent().element()!=null)
    				setHeight(parent(x));
    		}
    		setHeight(y);
    		if(yy.getLeft().element()!=null)
    			setHeight(left(y));
    		if(yy.getRight().element()!=null)
    			setHeight(right(y));
    		if(!isRoot(y))
    			setHeight(parent(y));
    		setHeight(z);
    		if(zz.getLeft().element()!=null)
    			setHeight(left(z));
    		if(zz.getRight().element()!=null)
    			setHeight(right(z));
    		if(!isRoot(z))
    			setHeight(parent(z));
    		return y;
        }
        else if(yy==zz.getRight() && xx==yy.getRight())
        {
            zz.setRight(yy.getLeft());
            yy.getLeft().setParent(zz);
            yy.setLeft(zz);
            if(!isRoot(zz))
            {
            	yy.setParent(zz.getParent());
            	if(zz.getParent().getLeft()==zz)
            		zz.getParent().setLeft(yy);
            	else
            		zz.getParent().setRight(yy);
            
            }
            else
            {
            	yy.setParent(null);
            	root_check=1;
            }
            zz.setParent(yy);
            b=yy;
            if(root_check==1)
            	root=b;
            
            setHeight(x);
    		if(xx.getLeft().element()!=null)
    			setHeight(left(x));
    		if(xx.getRight().element()!=null)
    			setHeight(right(x));
    		if(!isRoot(x))
    		{
    			if(xx.getParent().element()!=null)
    				setHeight(parent(x));
    		}
    		setHeight(y);
    		if(yy.getLeft().element()!=null)
    			setHeight(left(y));
    		if(yy.getRight().element()!=null)
    			setHeight(right(y));
    		if(!isRoot(y))
    			setHeight(parent(y));
    		setHeight(z);
    		if(zz.getLeft().element()!=null)
    			setHeight(left(z));
    		if(zz.getRight().element()!=null)
    			setHeight(right(z));
    		if(!isRoot(z))
    			setHeight(parent(z));
    		return y;
        }
        else if(yy==zz.getLeft() && xx==yy.getRight())
        {
        	yy.setRight(xx.getLeft());
        	xx.getLeft().setParent(yy);
        	yy.setParent(xx);
        	xx.setLeft(yy);
        	zz.setLeft(xx.getRight());
        	xx.getRight().setParent(zz);
        	if(!isRoot(zz))
        	{
        		xx.setParent(zz.getParent());
        		if(zz.getParent().getLeft()==zz)
            		zz.getParent().setLeft(xx);
            	else
            		zz.getParent().setRight(xx);
            
        	}
        	else
        	{
        		xx.setParent(null);
        		root_check+=1;
        	}
        	zz.setParent(xx);
        	xx.setRight(zz);
        	b=xx;
        	if(root_check==1)
        		root=b;
        	
        	setHeight(x);
    		if(xx.getLeft().element()!=null)
    			setHeight(left(x));
    		if(xx.getRight().element()!=null)
    			setHeight(right(x));
    		if(!isRoot(x))
    		{
    			if(xx.getParent().element()!=null)
    				setHeight(parent(x));
    		}
    		setHeight(y);
    		if(yy.getLeft().element()!=null)
    			setHeight(left(y));
    		if(yy.getRight().element()!=null)
    			setHeight(right(y));
    		if(!isRoot(y))
    			setHeight(parent(y));
    		setHeight(z);
    		if(zz.getLeft().element()!=null)
    			setHeight(left(z));
    		if(zz.getRight().element()!=null)
    			setHeight(right(z));
    		if(!isRoot(z))
    			setHeight(parent(z));
    		return x;
        }
        else if(yy==zz.getRight()&& xx==yy.getLeft())
        {
            yy.setLeft(xx.getRight());
            xx.getRight().setParent(yy);
            yy.setParent(xx);
            xx.setRight(yy);
            zz.setRight(xx.getLeft());
            xx.getLeft().setParent(zz);
            if(!isRoot(zz))
            {
            	xx.setParent(zz.getParent());
            	if(zz.getParent().getLeft()==zz)
            		zz.getParent().setLeft(xx);
            	else
            		zz.getParent().setRight(xx);
            }
            else
            {
            	xx.setParent(null);
            	root_check+=1;
            }
            zz.setParent(xx);
            xx.setLeft(zz);
            b=xx;
            if(root_check==1)
            	root=b;
            
            setHeight(x);
    		if(xx.getLeft().element()!=null)
    			setHeight(left(x));
    		if(xx.getRight().element()!=null)
    			setHeight(right(x));
    		if(!isRoot(x))
    		{
    			if(xx.getParent().element()!=null)
    				setHeight(parent(x));
    		}
    		setHeight(y);
    		if(yy.getLeft().element()!=null)
    			setHeight(left(y));
    		if(yy.getRight().element()!=null)
    			setHeight(right(y));
    		if(!isRoot(y))
    			setHeight(parent(y));
    		setHeight(z);
    		if(zz.getLeft().element()!=null)
    			setHeight(left(z));
    		if(zz.getRight().element()!=null)
    			setHeight(right(z));
    		if(!isRoot(z))
    			setHeight(parent(z));
    		
            return x;
    		
        }
		
		/* END CODE */
		
		return b;
	}
}
