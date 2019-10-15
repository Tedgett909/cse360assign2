import java.util.Stack;

public class LinkedStack<T> implements StackADT<T> {
	private List<T> x;
	public LinkedStack() {
		x = new List<T>();		
	}
	@Override
	public void push(T element) {
		x.addFirst(element);

	}

	@Override
	public T pop() {
		T u = x.get(0);
		x.delete(0);
		return u;
	}

	@Override
	public T peek() {
		T u = x.get(0);
		return u;
	}

	@Override
	public boolean isEmpty() {
		if(x.length() == 0)
			return true;
		else 
			return false;
	}

	@Override
	public int size() {
		
		return x.length();
	}

	
}
