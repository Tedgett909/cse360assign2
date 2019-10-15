import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class compatibilityList<T> implements OrderedListADT<T>, Serializable 
{

	private final static int DEFAULT_CAPACITY = 2;
    private final static int NOT_FOUND = -1;
	
    protected int rear;
    protected T[] list; 
	protected int modCount;
	int object = 0;
	
	 public compatibilityList()
	    {
	        this(DEFAULT_CAPACITY);
	    }
	 
	 public compatibilityList(int initialCapacity)
	    {
	        rear = 0;
	        list = (T[])(new Object[initialCapacity]);
			modCount = 0;
	    }
	 
	 protected void expandCapacity() //increase size of list in case old list is too small by doubling
	    {
	    	 T[] larger = (T[])(new Object[list.length*2]);

	         for (int scan=0; scan < list.length; scan++)
	            larger[scan] = list[scan];

	         list = larger;    
	    }
	 
	    public T removeLast() throws EmptyCollectionException //last element will be removed and returned
	    {
	    	 T result;

	         if (isEmpty())
	            throw new EmptyCollectionException ("list");

	         rear--;
	         result = list[rear];
	         list[rear] = null;
	         return result;
	    }
	    
	    
	    public T removeFirst() throws EmptyCollectionException //last element will be removed and returned
	    {
	    	 if (isEmpty())
	             throw new EmptyCollectionException ("list");

	          T result = list[0];
	          rear--;
	          // shift the elements
	          for (int scan=0; scan < rear; scan++)
	             list[scan] = list[scan+1];

	     
	          list[rear] = null;
	     
	          return result;
	    }

	    public T remove(T element) //element defined is removed and returned
	    {
	        T result;
	        int index = find(element);

	        if (index == NOT_FOUND)
	            throw new ElementNotFoundException("compatibilityList");

	        result = list[index];
	        rear--;
			
	        // shift the appropriate elements 
	        for (int scan=index; scan < rear; scan++)
	        {
	            list[scan] = list[scan+1];
	        }
	        list[rear] = null;
			modCount++;
			object--;

	        return result;
	    }
	   
	    public T first() throws EmptyCollectionException // returns first element
	    {
	    	 if (isEmpty())
	             throw new EmptyCollectionException ("list"); 

	          return list[0];
	    }

	    public T last() throws EmptyCollectionException // returns last element
	    {
	        if (isEmpty())
	            throw new EmptyCollectionException ("list"); 

	         return list[rear-1];
	    }

	    public boolean contains(T target) //boolean true if list has element defind
	    {
	        return (find(target) != NOT_FOUND);
	    }

	    private int find(T target) //returns array index of the defined element or NOT_FOUND if simply not found
	    {
	        int scan = 0; 
			int result = NOT_FOUND;
	 
	        if (!isEmpty())
	            while (result == NOT_FOUND && scan < rear)
	                if (target.equals(list[scan]))
	                    result = scan;
	                else
	                    scan++;

	        return result;
	    }

	    public boolean isEmpty() //boolean true if list is empty
	    {
	    	return (rear == 0);
	    }
	 
	    public int size() //returns size of list or elements in list
	    {
	    	return rear;
	    }
	    
	 
	    
	 public String toString()
	 {
		 String result = "";
		 	for(int scan =0; scan <rear; scan++)
		 	{
		 		result = result +list[scan].toString() + "\n";
		 	}
		 return result;
	 }
	 
	 public String Top5toString(int fromIndex, int toIndex)
	 {
		 if (fromIndex < 0 || toIndex > rear || fromIndex > toIndex)
		 {
			 throw new IndexOutOfBoundsException("Could not get top 5.");
		 }
		 String result = "";
		 int scan;
		 	for(scan =fromIndex-1; scan <toIndex-1; scan++)
		 	{
		 		result = result +list[scan].toString() + "\n";
		 	}
		 	
		 return result;
	 }
	 
	 public Iterator<T> iterator() //returns an iterator for the list
    {
        return new compatibilityListIterator();
    }

	private class compatibilityListIterator implements Iterator<T> // implements Iterator for memberList Iterator
	{
		int iteratorModCount;
		int current;
		
		public compatibilityListIterator()
		{
			iteratorModCount = modCount;
			current = 0;
		}
		
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			
			return (current < rear);
		}
		
		public T next() throws ConcurrentModificationException
		{
			if (!hasNext())
				throw new NoSuchElementException();
			
			current++;
			
			return list[current - 1];
		}
		
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public void add(T element) 
	{
		int scan = 0;
		if (!(element instanceof Comparable))
		{
			throw new NonComparableElementException("OrderedList");
		}
		Comparable<T> comparableElement = (Comparable<T>)element;
		
		if (size() == list.length)
		{
            expandCapacity(); 
		
		// find the insertion location
        while (scan < rear && comparableElement.compareTo(list[scan]) > 0)
            scan++;

		// shift existing elements up one
        for (int shift=rear; shift > scan; shift--)
        	{
            list[shift] = list[shift-1];
        	}
		// insert element
        list[scan] = element;
        rear++;
		modCount++;
		object++;
		}
		else
		{ 
			
			// find the insertion location
	        while (scan < rear && comparableElement.compareTo(list[scan]) > 0)
	            scan++;

			// shift existing elements up one
	        for (int shift=rear; shift > scan; shift--)
	        	{
	            list[shift] = list[shift-1];
	        	}
			// insert element
	        list[scan] = element;
	        rear++;
			modCount++;
			object++;
		}
	}
	
	
}