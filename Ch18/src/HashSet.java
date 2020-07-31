import java.util.LinkedList;

// HOMEWORK COMPLETED BY MATT KOENIG
// CS 211
// MARCH 4, 2019


// QUIZ COMPLETED BY MATT KOENIG 
// CS 211
// MARCH 11, 2019


// Implements a set of objects using a hash table.
// The hash table uses separate chaining to resolve collisions.
public class HashSet<E> {
    private static final double MAX_LOAD_FACTOR = 0.75;
    private HashEntry<E>[] elementData;
    private int size;
    
    // Constructs an empty set.
    @SuppressWarnings("unchecked")
	public HashSet() {
        elementData = new HashEntry[10];
        size = 0;
    }
    
	// ADD METHODS HERE for quiz solutions:
    // Accepts another HashSet as a parameter and returns true if the other HashSet contains exactly the same elements as this HashSet
	public boolean contentsEqual(HashSet<E> o) {
		boolean answer = false;
		if (o instanceof HashSet) { //leverages instanceof, idea for this comes from GitHub/StackOverflow
			HashSet temp = (HashSet) o;

			if (size != temp.size()) {
				return answer;
			}

			for (int d = 0; d < elementData.length; d++) {
				HashSet<E>.HashEntry<E> node = elementData[d];
				while (node != null) {
					if (!temp.contains(node.data))
						return answer;
					node = node.next;
				}
			}

			answer = true;
			return answer;
		}

		return answer;
	}

	// An int method that returns the number of nodes in the longest linked list of this HashSet (also leveraged below in toString2)
	public int longestLinkedList() {
		int indexLength = elementData.length;
		int largestBucketLength = 0;

		for (int j = 0; j < indexLength; j++) {
			int tempCounter = 0;

			HashEntry<E> temp = elementData[j];
			while (temp != null) {
				tempCounter++;
				temp = temp.next;
				if (tempCounter > largestBucketLength) {
					largestBucketLength = tempCounter;

				}
			}
		}
		return largestBucketLength;

	}
    // ADD METHODS HERE for exercise solutions:
    // HOMEWORK METHOD COMPLETE --
    public String toString2() {

    	int largestBucketLength = 0;
        int indexLength = elementData.length;
        String result = "";

        // first pass through prints index bucket numbers and determines the length of the largest bucket (in number of elements)
    	// prints buckets
        for(int j = 0; j < indexLength; j++) {
    		int tempCounter = 0;

        	result += result.format("%-10s", ("[" + j + "]" + ""));
        	
        	// determines length of the largest bucket
    		HashEntry<E> temp = elementData[j];
        	while(temp != null) {
        		tempCounter++;
        		temp = temp.next;
        		if(tempCounter > largestBucketLength) {
        			largestBucketLength = tempCounter;
        		
        		}
        	}
        	
    	}
        result += "\n";
        
        
        
        // original loop runs through entire index the number of times of the largest bucket

        for(int i = 0; i < largestBucketLength; i++) {
        	
        	// second loop runs through entire index
        	for(int j = 0; j < indexLength; j++) {
                HashEntry<E> nextData = elementData[j];

        		
        		// new linkedlist to store the elements at each bucket 
        		LinkedList<E> temp1 = new LinkedList<E>();
        		
        		// loops through and adds elements at each bucket to LinkedList
        		for(int m = 0; m < largestBucketLength; m++) {
        			
        			
                    if(nextData != null && nextData.next != null) {
                    	
                    temp1.add(nextData.data);
                	nextData = nextData.next;

                    } else if(nextData != null && nextData.next == null) {
                        temp1.add(nextData.data);
                        temp1.add(null);
                    }


                    }
                    

        		
        		
        		if(!temp1.isEmpty() && temp1.get(i) != null) {
        			result += temp1.get(i).toString().format("%-10s", temp1.get(i));
        			
        		} else {
        			result += result.format("%-10s", (""));
        		}
        	}
        	result += "\n";
        }
        
        
        
    	return result;
    }

    
    
    
    
    
    // Adds the given element to this set, if it was not already
    // contained in the set.
    public void add(E value) {
        if (!contains(value)) {
            if (loadFactor() >= MAX_LOAD_FACTOR) {
                rehash();
            }
            
            // insert new value at front of list
            int bucket = hashFunction(value);
            elementData[bucket] = new HashEntry<E>(value, elementData[bucket]);
            size++;
        }
    }
    
    // Removes all elements from the set.
    public void clear() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }
    
    // Returns true if the given value is found in this set.
    public boolean contains(E value) {
        int bucket = hashFunction(value);
        HashEntry<E> current = elementData[bucket];
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Removes the given value if it is contained in the set.
    // If the set does not contain the value, has no effect.
    public void remove(E value) {
        int bucket = hashFunction(value);
        if (elementData[bucket] != null) {
            // check front of list
            if (elementData[bucket].data.equals(value)) {
                elementData[bucket] = elementData[bucket].next;
                size--;
            } else {
                // check rest of list
                HashEntry<E> current = elementData[bucket];
                while (current.next != null && !current.next.data.equals(value)) {
                    current = current.next;
                }
                
                // if the element is found, remove it
                if (current.next != null && current.next.data.equals(value)) {
                    current.next = current.next.next;
                    size--;
				}
            }
        }
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return size;
    }
    
    // Returns a string representation of this queue, such as "[10, 20, 30]";
    // The elements are not guaranteed to be listed in sorted order.
    public String toString() {
        String result = "[";
        boolean first = true;
        if (!isEmpty()) {
            for (int i = 0; i < elementData.length; i++) {
                HashEntry<E> current = elementData[i];
                while (current != null) {
                    if (!first) {
                        result += ", ";
                    }
                    result += current.data;
                    first = false;
                    current = current.next;
                }
            }
        }
        return result + "]";
    }
    
    
    // Returns the preferred hash bucket index for the given value.
    private int hashFunction(E value) {
        return Math.abs(value.hashCode()) % elementData.length;
    }
    
    private double loadFactor() {
        return (double) size / elementData.length;
    }
    
    // Resizes the hash table to twice its former size.
    @SuppressWarnings("unchecked")
	private void rehash() {
        // replace element data array with a larger empty version
        HashEntry<E>[] oldElementData = elementData;
        elementData = new HashEntry[2 * oldElementData.length];
        size = 0;

        // re-add all of the old data into the new array
        for (int i = 0; i < oldElementData.length; i++) {
            HashEntry<E> current = oldElementData[i];
            while (current != null) {
                add((E)current.data);
                current = current.next;
            }
        }
    }
    
    // Represents a single value in a chain stored in one hash bucket.
    @SuppressWarnings("hiding")
	private class HashEntry<E> {
        public E data;
        public HashEntry<E> next;

        @SuppressWarnings("unused")
		public HashEntry(E data) {
            this(data, null);
        }

        public HashEntry(E data, HashEntry<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
