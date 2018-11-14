/**
 *Pavlos Orfanidis 4134
 *Pantelis Rempakos 4279
 *Giorgos Kamaridis 4264
 */

/**
 * A class that creates a list based on the FIFO(First in  first out) sequence
 * 
 * fields:
 * 		A collection item containing all the items of the list
 * 		An int containing the length of the queue.
 * 
 * @author porfanid
 *
 * @param <Item>
 */
class Queue<Item> {
	
	
	
	private Collection<Item> list;
	
	
	
	
	
	
	
	public int length;

	
	
	
	
	
	
	
	/**
	 * Constructor
	 * 
	 * initializing the collection item
	 * 
	 * setting the list size to 0.
	 */
    public Queue() {
    	list=new Collection<Item>();
    	length=0;
    }
    

    
    
    
    
    
    
    
    /**
     * returning the list as a String seperated with commas
     */
    public String toString()
    {
    	return list.toString();
    }
    
    
    
    
    
    
    
    
    /**
     * checks if the collection item is empty.
     * 
     * If it is, then the Queue is also empty.
     */
    public boolean isEmpty() {
    	return list.isEmpty();
    }
    
    
    
    
    
    
    
    

    /**
     * Inserting a new item to the collection
     * @param item
     */
    public void put(Item item) {
        list.insert(item);
        length++;
    }
    
    
    
    
    
    
    
    
    
    
    
    /**
     * returning the Queue as an array.
     * 
     */
    Item[] toArray()
    {
    	return list.toArray();
    }
    
    
    
    
    
    
    

    /**
     * returning the last element of the queue.
     * @return Item
     */
    Item get() {
        return list.toArray()[list.length-1];
    }
    
    
    
    
    
    
    
    
    
    
    /**'
     * Checking if an element exists within an array
     * 
     * Getting the class types and checks if they are equal.
     * 		Maybe that is not necessary, as the parameter is an Item object and so are all the items ion the list.
     * 
     * Then it is trying to compare the values of the items.
     * 
     * It is casting them back to the classes they originated and executes the equals function to see if the values are the same.
     * 
     * 
     * 
     * 
     * if I do not check the classes, then I cannot be sure that the elements are the same.
     * 
     * if I execute the "==" character, then Java will try to compare if the memory cells are the same, which is not what I want.
     * 
     * if I exequte the equals directly, instead of down casting the items, then the function will be executed as an objefct, instead of the type they originated from.
     * and this is not what it is supposed to do, because it will compare not the values, but the memory cells.
     * 
     * 
     * @param element
     * 
     * @return boolean if they have the same value or not.
     */
    boolean contains(Item element)
    {
    	for(Item item:list)
    	{
    		
    		Class<?> elementClass=element.getClass();
    		Class<?> itemClass=item.getClass();
    		
    		
    		
    		
    		boolean areOfTheSameType = elementClass.equals(itemClass);
    		
    		if(!areOfTheSameType)
    		{
    			return false;
    		}
    		
    		
    		
    		
    		
    		
    		Object valueOfTheFirstItem=(Object) item;
    		Object valueOfTheSelectedItem=(Object) element;
    		
    		System.out.println("First: "+element+"\n"+"Second: "+item);
    		if(elementClass.cast(valueOfTheSelectedItem).equals(itemClass.cast(valueOfTheFirstItem)))
    		{
    			
    			return true;
    		}
    		
    		
    		
    	}
    	
    	
    	return false;
    }
}
