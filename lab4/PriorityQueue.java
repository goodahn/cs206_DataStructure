import java.util.LinkedList;
import java.util.Random;

public class PriorityQueue{
	
	BT root;
	public PriorityQueue(){
		root = null;
	}
	
	public int size(){
		// Use 'getTreeSize()' to count nodes in the 'root'.
		return PriorityQueue.getTreeSize(this.root);
	}
	
	// Custom static method for counting nodes under the BT instance including itself. 
	private static int getTreeSize(BT root) {
		// Recursively call itself.
		
		if(root==null)
			return 0;
		else
		{
			if(root.getLeftChild()!=null && root.getLeftChild()!=null)
				return 1+getTreeSize(root.getLeftChild())+getTreeSize(root.getRightChild());
			else if(root.getLeftChild()!=null && root.getLeftChild()==null)
				return 1+getTreeSize(root.getLeftChild());
			else if(root.getLeftChild()==null && root.getLeftChild()!=null)
				return 1+getTreeSize(root.getRightChild());
			else
				return 1;
		}
		
	}
	
	
	
	public void add(int priority, String name){
		BT newNode = new BT(priority, name);
		BT tmp=new BT();
		BT tmp2=new BT();
		int tmp_p;
		int tmp_p2;
		int child;
		String tmp_s;
		String tmp_s2;
		
		int odd=0;
		int i;
		int size;
		
		if(root==null)
			root=newNode;
		else
		{
			
			size=size();
			BT[] list=new BT[size+1];
			list[0]=root;
			int index=1;
			int l_index=0;
			while(l_index*2+1<=size)
			{
				for(i=0;i<index;i++)
				{
					if(list[l_index+i]!=null)
					{
						if(list[l_index+i].getLeftChild()!=null)
							list[(l_index+i)*2+1]=list[l_index+i].getLeftChild();
						if(list[l_index+i].getRightChild()!=null)
							list[(l_index+i)*2+2]=list[l_index+i].getRightChild();
					}
				}
				index=index*2;
				l_index=l_index*2+1;
			}
			list[size]=newNode;
			
			if(size%2==0)
			{
				child=size;
				index=(size-2)/2;
				list[index].setRightChild(list[index*2+2]);
				if(index==0)
				{
					if(list[0].getPriority()<newNode.getPriority())
					{
						tmp.setPriority(list[0].getPriority());
						tmp.setValue(list[0].getValue());
						newNode.setLeftChild(list[1]);
						newNode.setRightChild(tmp);
						root=newNode;
						return;
					}
					else
					{
						list[0].setRightChild(list[2]);
						root=list[0];
					}
					
				}
			
			}
			else
			{
				odd=1;
				child=size;
				index=(size-1)/2;
				list[index].setLeftChild(list[index*2+1]);
				if(index==0)
				{
					if(list[0].getPriority()<newNode.getPriority())
					{
						tmp.setPriority(list[0].getPriority());
						tmp.setValue(list[0].getValue());
						root=newNode;
						newNode.setLeftChild(tmp);
						root=newNode;
						return;
					}
					else
					{
						list[0].setLeftChild(list[1]);
						root=list[0];
					}
				}
			}
			if(list[index].getPriority()<list[child].getPriority())
			{
				while(list[index].getPriority()<list[child].getPriority())
				{
					
					if(odd==1)
					{
			/**			tmp2.setPriority(list[index*2+1].getPriority());
						tmp2.setLeftChild(list[index*2+1].getLeftChild());
						tmp2.setRightChild(list[index*2+1].getRightChild());
						
						list[index*2+1].setRightChild(tmp.getRightChild());
						tmp.setLeftChild(tmp2.getLeftChild());
						tmp.setRightChild(tmp2.getRightChild());
						list[index*2+1].setLeftChild(tmp);
						
						list[index].setPriority(list[index*2+1].getPriority());
						list[index].setLeftChild(list[index*2+1].getLeftChild());
						list[index].setRightChild(list[index*2+1].getRightChild());
				**/		tmp_p=list[index].getPriority();
						tmp_s=list[index].getValue();
						tmp_p2=list[index*2+1].getPriority();
						tmp_s2=list[index*2+1].getValue();
						list[index].setPriority(tmp_p2);
						list[index].setValue(tmp_s2);
						list[index*2+1].setPriority(tmp_p);
						list[index*2+1].setValue(tmp_s);
					}
					else
					{
				/**		tmp2.setPriority(list[index*2+2].getPriority());
						tmp2.setLeftChild(list[index*2+2].getLeftChild());
						tmp2.setRightChild(list[index*2+2].getRightChild());
						
						list[index*2+2].setLeftChild(tmp.getLeftChild());
						tmp.setLeftChild(tmp2.getLeftChild());
						tmp.setRightChild(tmp2.getRightChild());
						list[index*2+2].setRightChild(tmp);
						
						list[index].setPriority(list[index*2+2].getPriority());
						list[index].setLeftChild(list[index*2+2].getLeftChild());
						list[index].setRightChild(list[index*2+2].getRightChild());
					**/	
						tmp_p=list[index].getPriority();
						tmp_s=list[index].getValue();
						tmp_p2=list[index*2+2].getPriority();
						tmp_s2=list[index*2+2].getValue();
						list[index].setPriority(tmp_p2);
						list[index].setValue(tmp_s2);
						list[index*2+2].setPriority(tmp_p);
						list[index*2+2].setValue(tmp_s);
						
					}
					
					if(index!=0)
					{
						if(index%2==0)
						{
							child=index;
							index=(index-2)/2;
							odd=0;
							//	list[index].setRightChild(list[index*2+2]);
						}
						else
						{
							child=index;
							index=(index-1)/2;
							odd=1;
							//	list[index].setLeftChild(list[index*2+1]);
						}
					}
					else
						root=list[0];					
					
				}
			}
			else
			{
				if(odd==1)
					list[index].setLeftChild(newNode);
				else
					list[index].setRightChild(newNode);
			}

			root=list[0];
			return;
			
				
			
		}
		
			
		
	}
	
	
	public String remove(){
		// remove the root and return its value
		
		// If the root was the only node, simply remove.
		// If not, locate the last node and get it to root position.
		if(root.getLeftChild()==null && root.getRightChild()==null && root!=null)
		{
			String result=root.getValue();
			root=null;
			return result;
		}
		else
		{
			String result=root.getValue();
			root=merge(root.getRightChild(),root.getLeftChild());
			return result;
		}
			
			
	}
	public String getHighestPriorityValue(){
		return root.getValue();
	}
	
    public static boolean isEmpty(BT root)
	{
    	if(root==null)
    		return true;
    	else
    		return false;
    
	}
	public static BT merge(BT root1,BT root2){
		//return the root of new merged queue		

		int size;
		int n1=getTreeSize(root1);
		int n2=getTreeSize(root2);
		size=n1+n2;
		if(root1==null)
			return root2;
		else if(root2==null)
			return root1;
		else
		{
			BT[] list1=new BT[n1];
			BT[] list2=new BT[n2];
			BT[] list=new BT[size];
			int[] list_n=new int[size];
			String[] list_s=new String[size];
			list1[0]=root1;
			list2[0]=root2;
			int index=1;
			int i;
			int l_index=0;
			while(l_index*2+1<=n1)
			{
				for(i=0;i<index;i++)
				{
					if(list1[l_index+i]!=null)
					{
						if(list1[l_index+i].getLeftChild()!=null)
							list1[(l_index+i)*2+1]=list1[l_index+i].getLeftChild();
						if(list1[l_index+i].getRightChild()!=null)
							list1[(l_index+i)*2+2]=list1[l_index+i].getRightChild();
					}
				}
				index=index*2;
				l_index=l_index*2+1;
			}
			l_index=0;
			index=1;
			while(l_index*2+1<=n2)
			{
				for(i=0;i<index;i++)
				{
					if(list2[l_index+i]!=null)
					{
						if(list2[l_index+i].getLeftChild()!=null)
							list2[(l_index+i)*2+1]=list2[l_index+i].getLeftChild();
						if(list2[l_index+i].getRightChild()!=null)
							list2[(l_index+i)*2+2]=list2[l_index+i].getRightChild();
					}
				}
				index=index*2;
				l_index=l_index*2+1;
			}
			for(i=0;i<n1;i++)
			{
				list1[i].setLeftChild(null);
				list1[i].setRightChild(null);
				list[i]=list1[i];
				list_n[i]=list[i].getPriority();
				list_s[i]=list[i].getValue();
			}
			for(i=0;i<n2;i++)
			{
				list2[i].setLeftChild(null);
				list2[i].setRightChild(null);
				list[i+n1]=list2[i];
				list_n[i+n1]=list2[i].getPriority();
				list_s[i+n1]=list2[i].getValue();
			}
			
			int position;
			int[] list_position=new int[size];
			for(i=0;i<size;i++)
			{
				position=0;
				for(int j=0;j<size;j++)
				{
					if(list[i].getPriority()<list[j].getPriority())
						position+=1;
					
				}
				list_position[i]=position;
			}
			
			for(i=0;i<size;i++)
			{
				list[list_position[i]].setPriority(list_n[i]);
				list[list_position[i]].setValue(list_s[i]);
			}
			
			l_index=0;
			index=1;
			while(l_index*2+1<=size)
			{
				for(i=0;i<index;i++)
				{
					
					if(list[l_index+i]!=null)
					{
						if((l_index+i)*2+1<size)
						{
							list[l_index+i].setLeftChild(list[l_index*2+i*2+1]);
						}
						if((l_index+i)*2+2<size)
						{
							list[l_index+i].setRightChild(list[l_index*2+i*2+2]);
						}
					}
				}
				index=index*2;
				l_index=l_index*2+1;
			}
			return list[0];
			
			
			
		}
	}
	
	
}