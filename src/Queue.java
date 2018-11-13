import java.util.Arrays;
class Queue<Item> {
    
	public static final int defaultSize=10;
	
	Collection<Item> list;
	

    Queue() {
    	list=new Collection<Item>();
    }
    
    Item[] getList()
    {
    	return list.toArray();
    }

    
    

    boolean isEmpty() {
    	return list.isEmpty();
    }

    // insert new item in the queue
    void put(Item item) {
        list.insert(item);
    }

    // extract least recent item from the queue
    Item get(){
    	System.out.println("I am trying to pull the element from the Array");
        Item tempReturnItem= list.get();
        System.out.println(" succedded to pull the element from the Array");
        return tempReturnItem;
    }
    

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
    		
    		
    		if(elementClass.cast(valueOfTheSelectedItem).equals(itemClass.cast(valueOfTheFirstItem)))
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
