import java.util.*;

// Class LinkedList<E> can be used to store a list of values of type E.
// from Buildingjavaprograms.com
// modified by W.P. Iverson, Bellevue College, January 2017 
// added backwards() to check list in backwards order

// HOMEWORK METHODS IDENTIFIED BELOW COMPLETED BY MATT KOENIG
// CS211
// FEBRUARY 20, 2019
// ASSIGNMENT 16

//QUIZ METHODS IDENTIFIED BELOW COMPLETED BY MATT KOENIG
//CS211
//FEBRUARY 25, 2019
//QUIZ 16



public class LinkedList<E extends Comparable<E>> implements Iterable<E>{  
	// removed implements List due to version differences of List
    private ListNode<E> front;  // first value in the list
    private ListNode<E> back;   // last value in the list
    private int size;           // current number of elements

    // post: constructs an empty list
    public LinkedList() {
        front = new ListNode<E>(null);
        back = new ListNode<E>(null);
        clear();
    }
    
    
// QUIZ EXERCISES BELOW 
    // basic boolean method to determine if a linkedlist is stuttered or not
    public boolean isPerfectStutter() {
        ListNode<E> current = front.next;
        boolean answer = false;
        int count = 0;

        // length of 0 or 1
        if(current == null || current.next == null) {
        	return answer;
        }
        
        // uneven list, must be false
    	LinkedIterator itr = new LinkedIterator();
    	while(itr.hasNext()) {
    		count++;
    		itr.next();
    	}
    	if(count % 2 != 0) {
    		return false;
    	}
        
        // while there is a current and a next, see if they're same
        while (current != null && current.next != null) {
            E temp = current.data;
            E temp2 = current.next.data;
            if(temp.compareTo(temp2) == 0) {
            	answer = true;
            } else {
            	answer = false;
            	break;
            }
            current = current.next.next;
        }
        
        return answer;
    }
    
    
    // basic stutter undo method
    public void undoStutter() {
    	if(this.isPerfectStutter() == true) {
            ListNode<E> current = front.next;
            while (current != null && current.next != null) {
            	current.next = current.next.next;
            	current = current.next;
            }
    	}
    }
    


// HOMEWORK EXERCISES BELOW
    
    // works both forwards and backwards. leverages iterator in this class
    public E deleteBack() {
    	E answer = null;
    	LinkedIterator itr = new LinkedIterator();
    	if(!itr.hasNext()) {
    		return null;
    	}
    	while(itr.hasNext()) {
    		answer = itr.next();
    	}
    	itr.remove();
    	return answer;
    }
//    public E deleteBack() {
//        ListNode<E> current = front.next;
//        if(current == null) {
//            throw new NoSuchElementException();
//        }
//        if(current.next == null) {
//            E answer = current.data;
//            current = null;
//            return answer;
//        }
//        while(current.next.next != null) {
//            current = current.next;
//        }
//        E answer = current.next.data;
//        current.next = null;
//        return answer;
//    }
    
    // works both forwards and backwards
    public void switchPairs() {
        ListNode<E> current = front.next;
        
        while (current != null && current.next != null) {
            E temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }
    }
    
    // works both forwards and backwards 
    public void stutter() {
        ListNode<E> current = front.next;
        while(current.next != null) {
            E temp = current.data;
            ListNode<E> tempNode = new ListNode(temp);
            tempNode.next = current.next;
            current.next.prev = tempNode;
            tempNode.prev = current;
            current.next = tempNode;
            current = current.next.next;
        }
        back = current;
        }
    
    // works both forwards and backwards
    public void removeAll(E n) {
        ListNode<E> previous = null;
        ListNode<E> current = front.next;
        
        while(current != null) {
            if(current.data == n) {
                if(previous != front) {
                previous.next = current.next;
                current.next.prev = previous;

                } else {
                    front = current.next;
                    current.next.prev = front;
                }
                current = current.next;
            } else {
                previous = current;
                current = current.next;
            }
        }
    }
    
    
    






    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index);
        return current.data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + front.next.data;
            ListNode<E> current = front.next.next;
            while (current != back) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
    
    // post: creates a comma-separated, bracketed version of the list
    // Iverson creation
    public String backwards() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + back.prev.data;
            ListNode<E> current = back.prev.prev;
            while (current != front) {
                result += ", " + current.data;
                current = current.prev;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        int index = 0;
        ListNode<E> current = front.next;
        while (current !=  back) {
            if (current.data.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    // post: appends the given value to the end of the list
    public void add(E value) {
        add(size, value);
    }

    // pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent
    //       values right
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ListNode<E> current = nodeAt(index - 1);
        ListNode<E> newNode = new ListNode<E>(value, current.next, current);
        current.next = newNode;
        newNode.next.prev = newNode;
        size++;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(List<E> other) {
        for (E value: other) {
            add(value);
        }
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        ListNode<E> current = nodeAt(index - 1);
        current.next = current.next.next;
        current.next.prev = current;
        size--;
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    //public void set(int index, E value) {
    //    checkIndex(index);
    //    ListNode<E> current = nodeAt(index);
    //    current.data = value;
    //}

    // post: list is empty
    public void clear() {
        front.next = back;
        back.prev = front;
        size = 0;
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }

    // pre : 0 <= index < size()
    // post: returns the node at a specific index.  Uses the fact that the list
    //       is doubly-linked to start from the front or the back, whichever
    //       is closer.
    private ListNode<E> nodeAt(int index) {
        ListNode<E> current;
        if (index < size / 2) {
            current = front;
            for (int i = 0; i < index + 1; i++) {
                current = current.next;
            }
        } else {
            current = back;
            for (int i = size; i >= index + 1; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    private static class ListNode<E> {
        public E data;         // data stored in this node
        public ListNode<E> next;  // link to next node in the list
        public ListNode<E> prev;  // link to previous node in the list

        // post: constructs a node with given data and null links
        public ListNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with given data and given links
        public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    private class LinkedIterator implements Iterator<E> {
        private ListNode<E> current;  // location of next value to return
        private boolean removeOK;  // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return current != back;
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = current.data;
            current = current.next;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (i.e., at most
        //       one call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK) {
                throw new IllegalStateException();
            }
            ListNode<E> prev2 = current.prev.prev;
            prev2.next = current;
            current.prev = prev2;
            size--;
            removeOK = false;
        }
    }
}