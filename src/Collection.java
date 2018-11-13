import java.util.Iterator;

// linked list implementation of a collection of items
public class Collection<Item> implements Iterable<Item> {

    private Node head; // first node in the list

    private class Node {
        Item item;
        Node next;
        Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    
    Item get(int index)
    {
    	return toArray()[index];
    }
    
    Item get()
    {
    	return get(toArray().length);
    }

    Collection() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(Item item) {
        head = new Node(item, head);
    }

    public Iterator<Item> iterator()
    {
        return new CollectionIterator();
    }
    
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
    
    Item[] toArray()
    {
    	int numberOfArrayElements=0;
    	Node currentNode=head;
    	while(currentNode!=null)
    	{
    		numberOfArrayElements++;
    		currentNode=currentNode.next;
    	}
    	
    	if(isEmpty())
    	{
    		return null;
    	}
    	
    	Object[] tempArrayToInitializeTheItemArray=new Object[numberOfArrayElements];
    	
    	
    	@SuppressWarnings("unchecked")
		Item[] returnList=(Item[]) tempArrayToInitializeTheItemArray;
    	
    	currentNode=head;
    	int i=0;
    	while(i<numberOfArrayElements+1)
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
