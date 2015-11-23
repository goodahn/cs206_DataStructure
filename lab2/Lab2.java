package Lab2;

/* Maze
 * There is maze to find path. 
 * You have to find path from start to goal using data structure, stack.
 * 
 * this is an example of maze
 * 
 * 11111111111
 * 11111111111
 * 00000000011
 * 11110111111
 * 11110111111
 * 11110000000
 * 11110111111
 * 
 * 1: wall, 0: road
 * start: row=2, column=0, direction=east
 * goal: row=5, column=10
 * 
 */



public class Lab2 {
	
    //////////////////////////////////////////////////////Do not modify this region
	// Constant for direction.
	private final int north = 1;
	private final int east = 2;
	private final int south = 3;
	private final int west = 4;
	
	element stack_top = null;
	
	public Lab2()  // constructor
	{
		
	}
    //////////////////////////////////////////////////////
	
	
	
	public element path(int[][] maze, element start, element goal)
	{
		stack_top = null;
				
		////////////////////////////////////////////////////// Do not modify this region
		int num_rows = maze.length;
		int num_cols = maze[0].length;	
		int[][] mark = new int [num_rows][num_cols];
		
						
		push(start);
		/////////////////////////////////////////////////////
		while (stack_top != null) 
	    // Hint: use top variable(index of stack top) and mark variable
			
		{
			
			
            
			// if stack top equal goal 
			if (stack_top.get_row() == goal.get_row() && stack_top.get_col() == goal.get_col())
			{
				System.out.println("path exists");
				return stack_top; // change return value 
			}
						
			
			
			////////////////////////////////////////////// Fill your code to find path in this region 
			

					/*   FILL in HERE!!!! */
					/*   FILL in HERE!!!! */
					/*   FILL in HERE!!!! */
			
			int a=0;
			int direction=0;
			
			int x=0;
			int y=0;
			element next_stack=new element();
			
			int i=0;
			int j=0;
			
			int c=0;
			int non_path_check=0;
			
			//if we came here first we make mark 1.
			
			
			//////////////// we check open direction and don't go before.
			if(stack_top.get_row()<(num_rows-1))
			{
				if( (maze[stack_top.get_row()+1][stack_top.get_col()]==0) && (mark[stack_top.get_row()+1][stack_top.get_col()]==0) )
				{
					a+=1;
					direction=south;
				}
			}
			
			if(stack_top.get_row()>0)
			{
				if( (maze[stack_top.get_row()-1][stack_top.get_col()]==0) && (mark[stack_top.get_row()-1][stack_top.get_col()]==0) )
				{
					a+=1;
					direction=north;
				}
			}
			
			if(stack_top.get_col()<(num_cols-1))
			{
				if( (maze[stack_top.get_row()][stack_top.get_col()+1]==0) && (mark[stack_top.get_row()][stack_top.get_col()+1]==0) )
				{
					a+=1;
					direction=east;
				}
			}
			
			if(stack_top.get_col()>0)
			{
				if( (maze[stack_top.get_row()][stack_top.get_col()-1]==0) && (mark[stack_top.get_row()][stack_top.get_col()-1]==0) )
				{
					a+=1;
					direction=west;
					
				}
			}
			
			///////////if we walk everywhere but not end then it has no path.
		
			////////////////
			///////////////// if we get mak-hin-gil we pop until turning point.
			if(a==0)
			{
				mark[stack_top.get_row()][stack_top.get_col()]=1;
				
				
				while(mark[stack_top.get_row()][stack_top.get_col()]!=2)
				{
				
					pop();
					if(stack_top.below==null)
					{
						return null;
					}
					
						
				}
				
				
				
			}
			//////////////////////////////////if there is only one point just push.
			if(a==1)
			{
				mark[stack_top.get_row()][stack_top.get_col()]=1;
				if(direction==south)
				{
					next_stack.set(stack_top.get_row()+1,stack_top.get_col() , south);
					push(next_stack);
					mark[stack_top.get_row()][stack_top.get_col()]=1;
				}
				
				if(direction==west)
				{
					next_stack.set(stack_top.get_row(),stack_top.get_col()-1 , west);
					push(next_stack);
					mark[stack_top.get_row()][stack_top.get_col()]=1;
				}
				
				if(direction==north)
				{
					next_stack.set(stack_top.get_row()-1,stack_top.get_col() , north);
					push(next_stack);
					mark[stack_top.get_row()][stack_top.get_col()]=1;
				}
				
				if(direction==east)
				{
					next_stack.set(stack_top.get_row(),stack_top.get_col()+1 , east);
					push(next_stack);
					mark[stack_top.get_row()][stack_top.get_col()]=1;
				}
			
			}
			
			if(a>1) // if it has many roads we make mark 2 and this will be turning point. And we choose a road that clean zone
			{
				mark[stack_top.get_row()][stack_top.get_col()]=2;
				
				if(direction==south)
				{
					next_stack.set(stack_top.get_row()+1,stack_top.get_col() , south);
					push(next_stack);
					mark[stack_top.get_row()][stack_top.get_col()]=1;
				}
				
				if(direction==west)
				{
					next_stack.set(stack_top.get_row(),stack_top.get_col()-1 , west);
					push(next_stack);
					mark[stack_top.get_row()][stack_top.get_col()]=1;
				}
				
				if(direction==north)
				{
					next_stack.set(stack_top.get_row()-1,stack_top.get_col() , north);
					push(next_stack);
					mark[stack_top.get_row()][stack_top.get_col()]=1;
				}
				
				if(direction==east)
				{
					next_stack.set(stack_top.get_row(),stack_top.get_col()+1 , east);
					push(next_stack);
					mark[stack_top.get_row()][stack_top.get_col()]=1;
				}
			}
			
			//////////////////////////////////////////////
			
			
			
			
		}
		
		
	
		return null;  // Do not modify		
	}
	
	
	public void push(element item)
	{
		
		////////////////////////////////////////////// Fill your code to find path in this region 
		

		/*   FILL in HERE!!!! */
		/*   FILL in HERE!!!! */
		/*   FILL in HERE!!!! */

		/*element item2;
		
		item2=stack_top;
		stack_top=item;
		stack_top.below=item2;
		 */
		
		item.below = stack_top;
		stack_top=item;
		///////////////////////////////////////////////
		
	}

	public void pop()
	{
		////////////////////////////////////////////// Fill your code to find path in this region 

	
		/*   FILL in HERE!!!! */
		/*   FILL in HERE!!!! */
		/*   FILL in HERE!!!! */
		
		element item2;
		
		if(stack_top.below==null)
		{
			stack_top=null;
		}
		else
		{
			item2=stack_top.below;
			stack_top=item2;
		}
		//////////////////////////////////////////////
	}
	
	public boolean isequal_element(element element1, element element2)
	{
		if ((element1.get_col()==element2.get_col()) && (element1.get_row()==element2.get_row()) && (element1.get_dir()==element2.get_dir()) && element1.get_below()==element2.get_below())
		{
			return true;
		}
		return false;
	}
}


//////////////////////////////////////////////////// Do not modify this region
class element{
	
	private int row;
	private int col;
	private int dir;
	element below;
	
	public element()
	{
		this.row = -1;
		this.col = -1;
		this.dir = -1;
		this.below = null;
	}
	
	public element(int row, int col, int dir, element below)
	{
		this.row = row;
		this.col = col;
		this.dir = dir;
		this.below = below;
	}
	
	public void set_row(int row)
	{
		this.row = row;
	}
	
	public void set_col(int col)
	{
		this.col = col;
	}
	
	public void set_dir(int dir)
	{
		this.dir = dir;
	}
	
	public void set(int row, int col, int dir)
	{
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
	
	public void set_below(element below)
	{
		this.below = below;
	}
	
	public int get_row()
	{
		return this.row;
	}
	
	public int get_col()
	{
		return this.col;
	}
	
	public int get_dir()
	{
		return this.dir;
	}	
	
	public element get_below()
	{
		return this.below;
	}
}
//////////////////////////////////////////////////////////