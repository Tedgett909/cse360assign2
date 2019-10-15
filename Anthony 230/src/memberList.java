import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class memberList<T> implements Iterable<T>, Serializable, ListADT<T> {

    private final static int DEFAULT_CAPACITY = 2;
    private final static int NOT_FOUND = -1;
	
    protected int rear;
    protected T[] list; 
	protected int modCount;
	int object = 0;

    public memberList()
    {
        this(DEFAULT_CAPACITY);
    }
    
    public memberList(int initialCapacity)
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
    
    public void add(T element)
    {
    	if(object==list.length)  		
    		{
    			expandCapacity();
    			list[rear] = element;
    	    	rear++;
    	    	modCount++;
    		}
    	else 
    	{
    	list[rear] = element;
    	rear++;
    	modCount++;
    	}
    	object++;
    }
    
    public T remove(T element) //element defined is removed and returned
    {
        T result;
        int index = find(element);

        if (index == NOT_FOUND)
            throw new ElementNotFoundException("memberList");

        result = list[index];
        rear--;
		
        // shift the appropriate elements 
        for (int scan=index; scan < rear; scan++) {
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

    public boolean contains(T target) //boolean true if list has element defined
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

    public String toString() //converts to string
    {
    	 String result = "";

         for (int scan=0; scan < rear; scan++) 
            result = result + list[scan].toString() + "\n";

         return result;
    }
	
    public Iterator<T> iterator() //returns an iterator for the list
    {
        return new memberListIterator();
    }

	private class memberListIterator implements Iterator<T> // implements Iterator for memberList Iterator
	{
		int iteratorModCount;
		int current;
		
		public memberListIterator()
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
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	public void save(String fileName) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(fileName); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		oos.writeObject(this); 
		oos.flush(); 
		oos.close(); 
	}
	
	public memberList<member> load(String fileName) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		memberList<member> pos = (memberList<member>) ois.readObject();
		ois.close();
		
		return pos;
	}
}
