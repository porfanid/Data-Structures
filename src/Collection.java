/**
 *Pavlos Orfanidis 4134
 *Pantelis Rempakos 4279
 *Giorgos Kamaridis 4264
 */






import java.util.Iterator;

// linked list implementation of a collection of items

/**
 * 
 * @author porfanid
 *
 * @param <Item>
 * 
 * creating a class Collection to store the data
 */
public class Collection<Item> implements Iterable<Item> {

	
	
	
	
	
	
	
	/**
	 * 
	 * @author porfanid
	 * creating a class to make the collection iterable.
	 */
	private class CollectionIterator implements Iterator<Item>
    {
        private Node current = head;

        public boolean hasNext()
        {
            return current!=null;
        }

        public void remove() {}
        
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
	
	
	
	
	
	
	
	/**
	 * 
	 * @author porfanid
	 *creating a node class to store the items
	 */
	private class Node {
        Item item;
        Node next;
        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
	
	
	
	
	
	
	private Node head; // first node in the list
	
	
	int length; // setting the length of the list
    
    
    
    
    
    
    
	/**
	 * setting the first element of the list to null and the length of the list to 0.
	 */
    Collection() {
        head = null;
        length=0;
    }
    
    
    
    
    /**
     * returning the list as a string seperating all the values with comma.
     */
    public String toString()
    {
    	String returnVal="";
    	Item[] getAllNodes=toArray();
    	
    	for(Item item:getAllNodes)
    	{
    		returnVal+=item.toString()+", ";
    	}
    	
    	returnVal=returnVal.substring(0, returnVal.length()-2);
    	
    	return returnVal;
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * if the head of the list is null, then the list is empty.
     * @return boolean if the list is empty or not.
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    
    
    
    
    /**
     * inserting an element to the list.
     * @param item
     * If the list is empty, it maskes the head equal to a Node containing the element.
     * Otherwise, it checkls all the items in the list, until it finds one that is empty.
     * Then, it takes the previous node and adds a new one as its next.
     */
    public void insert(Item item) {
    	length++;
    	if(isEmpty())
    	{
    		head = new Node(item, null);
    		return;
    	}
    	
    	
    	
    	Node previousNode=head;
    	Node currentNode=head;
    	
    	while(currentNode!=null)
    	{
    		previousNode=currentNode;
    		currentNode=currentNode.next;
    	}
    	
    	
    	previousNode.next=new Node(item,null);
    }
    
    
    
    
    
    
    
    /**
     * returning an iterator because it is required by the super class.
     */
    public Iterator<Item> iterator()
    {
        return new CollectionIterator();
    }
    
    
    
    
    
    
    /**
     * constructing an array from all the data of the Nodes.
     * If the list is empty, it returns null.
     * 
     * it is counting all the nodes  in the list.
     * 
     * it is creating a list with a length same of all the it4ems in the array.
     * 
     * for every node it findes, it is adding it to the array.
     * 
     * @return the constructed array
     */
    Item[] toArray()
    {
    	
    	
    	if(isEmpty())
    	{
    		return null;
    	}
    	
    	
    	
    	
    	int numberOfArrayElements=0;
    	Node currentNode=head;
    	while(currentNode!=null)
    	{
    		numberOfArrayElements++;
    		currentNode=currentNode.next;
    	}
    	
    	
    	
    	
    	
    	Object[] tempArrayToInitializeTheItemArray=new Object[numberOfArrayElements];
    	@SuppressWarnings("unchecked")
		Item[] returnList=(Item[]) tempArrayToInitializeTheItemArray;
    	
    	
    	
    	
    	
    	
    	currentNode=head;
    	int i=0;
    	while(i<numberOfArrayElements)
    	{
    		returnList[i]=currentNode.item;
    		currentNode=currentNode.next;
    		i++;
    	}
    	
    	
    	
    	
    	return returnList;
    }
    
    
    
    

    public static void main(String[] args)
    {
        Collection<Integer> C = new Collection<Integer>();

        C.insert(1); C.insert(4); C.insert(2);

        for (Integer k : C) {
            System.out.println(""+k);
        }
    }
    
    
}
