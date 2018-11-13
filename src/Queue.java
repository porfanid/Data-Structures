import java.util.Arrays;
class Queue<Item> {
    
	public static final int defaultSize=10;

	Item[] List;

    Queue() {
        List=createList(defaultSize);
    }
    
    Item[] getList()
    {
    	return List;
    }

    void grow(int newLength)
    {
    	if(newLength>List.length)
    	{
    		List=Arrays.copyOf(List,newLength);
    	}
    }
    
    void grow()
    {
    	grow(List.length*2);
    }

    void trimToSize()
    {
    	//int ListSize=List.length;
    	int elements=0;
    	for (int i=0;i<List.length;i++)
    	{
    		if(List[i]!=null)
    		{
    			elements++;
    		}
    	}
    	List=Arrays.copyOf(List,elements);
    }

    boolean isEmpty() {
    	System.out.println(List.length);
        return List.length==0; // change appropriately
    }

    // insert new item in the queue
    void put(Item item) {
        /* enter your code! */
        int elements=0;
    	for (int i=0;i<List.length;i++)
    	{
    		if(List[i]!=null)
    		{
    			elements++;
    		}
    	}
    	try{
    		List[elements+1] = item;
    	}catch(Exception e)
    	{
    		grow();
    		List[elements+1] = item;
    	}
    }

    // extract least recent item from the queue
    Item get() throws Exception {
        /* 
        *get the index of the first "not" null element from the list
        */
        int FirstNotNullElement=0;
        for(int i=0;i<List.length;i++)
        {
        	if(List[i]!=null)
        	{
        		FirstNotNullElement=i;
        		break;
        	}
        }

        /* 
        *If the position of the first "not" null element is greater than the 1/4 of the length of the list  
        *trim the list
        */

        if(FirstNotNullElement>List.length/4)
        {
        	List=Arrays.copyOfRange(List,FirstNotNullElement,List.length);
            trimToSize();
    	}


                
        /*
        *Exception for the case in which the list is empty
        */

        try{
        	return List[FirstNotNullElement];
        }catch(Exception e)
        {
        	throw new Exception("List is empty");
        }
    }
    
    private boolean equals(Object thisOne,Object otherOne){
        if (otherOne instanceof Queue<?>){
            if ( ((Queue<?>)otherOne).equals(thisOne) ){
                return true;
            }
        }
        return false;
    }

    boolean contains(Item element)
    {
    	for(Item item:List)
    	{
    		if(equals(item,element))
    		{
    			return true;
    		}
    	}
    	return false;
    }
        /*
        *Create an object array and downcast it into an item.
        */
    @SuppressWarnings("unchecked")
    Item[] createList(int length)
    {
    	Object[] temp= new Object[length];
    	return (Item[]) temp;
    }
}
