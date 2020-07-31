import java.util.EmptyStackException; // for EmptyStackException
import java.util.NoSuchElementException; // for EmptyStackException


/**
 * An ArrayIntStack class. ArrayIntStack can be used to store integers and can be modified using 
 * methods defined in this class. Important things to remember are:
 *
 * <ul>
 *      <li> Stacks are FIFO: "First-in-first-out"
 *      <li> Methods feature pre and post conditions
 * </ul>
 *
 *
 * @author  Matt Koenig
 * @see StackIterator
 * @since 1.2
 */
public class ArrayIntStack {
	// PRIVATE FIELDS
	private static int[] stackData;
	private int size;
	
	// PUBLIC FIELDS
	public static final int default_capacity = 19;

	
	// CONSTRUCTORS
	//PRE - null
	//POST - constructed ArrayIntStack with default capacity (19 at default)
	public ArrayIntStack() {
		this(default_capacity);
	}
	
	//PRE - capacity 
	//POST - constructed ArrayIntStack with given capacity 
	public ArrayIntStack(int capacity) {
		stackData = new int[capacity];
		size = 0;
	}

	
	// METHODS
    /**
     * Returns {@code true} if the ArrayIntStack is empty.
     */
	
	//PRE - valid stack
	//POST - boolean telling if empty or not 
	public boolean empty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}
	
    /**
     * Returns the next element without modifying the stack.
     */
	//PRE - next element
	//POST - returns next element (doesn't modify stack)
	public int peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		int tempPeek = stackData[size];
		return tempPeek;
	}

    /**
     * Removes and returns the next element in the stack.
     */
	//PRE - next element 
	//POST - removes and returns next element 
	public int pop() {
		if (!emptySize()) {
			throw new EmptyStackException();
		} else {
		int tempPeek = stackData[size];
		size--;
		return tempPeek;
		}
	}

    /**
     * Adds a new item to the end of the stack and returns that item.
     */
	//PRE - valid stack
	//POST - adds element to stack and returns element 
	public int push(int item) {
		if (size >= 19) {
			throw new StackOverflowError();
		}
		stackData[size + 1] = item;
		size++;

		return item;
	}
	
	// HELPER METHODS
	// private helper method to ensure legal size
	private boolean emptySize() {
		if (size == 0) {
			return false;
		} else {
			return true;
			
		}
	}
	// private helper method to assist the iterator 
	private static int number(int i) {
		return stackData[i];
	}

	// LOCAL ITERATOR INSTANCE
    /**
     * Local iterator instance.
     */
	public IntStackIterator iterator() {
		return new IntStackIterator(this);
	}

	
	
	
	
	// NESTED ITERATOR CLASS
    /**
     * Nested iterator class to be used by the parent class.
     */
	public static class IntStackIterator {
		private ArrayIntStack stack; // stack to iterate through
		private int position; // current position in stack
		private boolean removeAllowed; // remove allowed or not

		public IntStackIterator(ArrayIntStack stack) {
			this.stack = stack;
			position = stack.size;
			removeAllowed = false;
		}

	    /**
	     * Returns {@code true} if there is a next element in the stack.
	     */
		public boolean hasNext() {
			return position > 0;
		}

	    /**
	     * Returns the next element in the stack.
	     */
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				int result = number(position);
				position--;
				removeAllowed = true;
				return result;
			}
		}

	    /**
	     * Removes the next element in the stack.
	     */
		public void remove() {
			if (!removeAllowed) {
				throw new IllegalStateException();
			} else {
				stack.pop();
				position--;
				removeAllowed = false;
			}
		}

	}

}
