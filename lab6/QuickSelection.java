package lab6;

public class QuickSelection {    
    static int storeIndex;    // a variable to share the index of the pivot after partitioning
    
    // return the k-th smallest element of the list[left, right] with recursions
    // note k starts from 1 not 0

    public int select(int[] list, int left, int right, int k) {
        int pivotIndex = 0;
        int pivotNewIndex = 0;
        int pivotDist = 0;
        
        if(left == right)        // if the list contains only one element, return the element
            return list[left];
        
        pivotIndex = (left + right)/2;    // select a pivotIndex as a middle point between left and right

        list = partition(list, left, right, pivotIndex);    // make partitions {less than, equal to, greater than}
        pivotNewIndex = storeIndex;    // the position of the pivot after partitioning
        
        pivotDist = pivotNewIndex - left + 1;    // the distance between left and pivotNewIndex

        
        /*******************************************************************************
        * SKELETON
        * Fill up the following recursive conditions and parameters
        * HINT: conditions are based on the pivotDist and the parameter k
        ******************************************************************************/        
        if(pivotNewIndex==k-1)
            return list[pivotNewIndex];
        else if(pivotNewIndex<k-1)
            return select(list,pivotNewIndex+1,right,k);
        else
            return select(list,left,pivotNewIndex-1,k);
     }
    
    /*******************************************************************************
    * SKELETON
    * fill the body of the following method to make partitions {less than, equal to, greater than}
    * HINT: you should use the "storeIndex" variable to update the position of the pivot after partitioning
    * HINT: use the "swap" method to swap the values in the list
    ******************************************************************************/
    private int[] partition(int[] list, int left, int right, int pivotIndex) {
        storeIndex = left;
        int pivotValue = list[pivotIndex];
        // CODE BEGIN: around 8 lines of code expected
        
        int j=left;
        for(int i=left;i<right+1;i++)
        {
            if(list[i]<pivotValue)
            {
                storeIndex+=1;
                j+=1;
            }    
        }
        swap(list,pivotIndex,storeIndex);
        j+=1;
        for(int i=left;i<storeIndex+1;i++)
        {
            if(list[i]>pivotValue)
            {
                
                while(list[j]>pivotValue)
                {
                    j+=1;
                }
                swap(list,i,j);
            }
        }
        
        
        // CODE END
        return list;
    }
    
    // a method to swap the values in the list
    private int[] swap(int[] list, int idx1, int idx2) {
        int temp = 0;
        
        temp = list[idx1];
        list[idx1] = list[idx2];
        list[idx2] = temp;
        
        return list;
    }
}
