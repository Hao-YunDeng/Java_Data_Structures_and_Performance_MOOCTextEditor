package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("You cannot store a null object");
		}
		LLNode<E> n = new LLNode<E>(element);
		n.next = tail;
		n.prev = n.next.prev;
		n.next.prev = n;
		n.prev.next = n;
		size ++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("This index is out of bounds");
		}
		LLNode<E> currNode = head;
		for(int i = 0; i <= index; i++) {
			currNode = currNode.next;
		}
		return currNode.data;		
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("You cannot store a null object");
		}	
		if(index < 0 || index > this.size) {
			throw new IndexOutOfBoundsException("This index is out of bounds");
		}
		
		LLNode<E> n = new LLNode<E>(element);
		LLNode<E> currNode = head;
		for(int i = 0; i <= index; i++) {
			currNode = currNode.next;
		}
		n.next = currNode;
		n.prev = n.next.prev;
		n.next.prev = n;
		n.prev.next = n;
		size ++;		
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("This index is out of bounds");
		}
		LLNode<E> currNode = head;
		for(int i = 0; i <= index; i++) {
			currNode = currNode.next;
		}
		LLNode<E> nodeToRemove = currNode;
		currNode.next.prev = currNode.prev;
		currNode.prev.next = currNode.next;
		size --;		
		return nodeToRemove.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("You cannot store a null object");
		}		
		if(index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException("This index is out of bounds");
		}
		LLNode<E> currNode = head;
		for(int i = 0; i <= index; i++) {
			currNode = currNode.next;
		}
		E data = currNode.data;
		currNode.data = element;
		return data;
	}   
	
	public String toString() 
	{
		String result = "";
		LLNode<E> currNode = head;
		for(int i = 0; i <= size; i++) {
			currNode = currNode.next;
			if(currNode.data != null) {
				result += currNode.data;
				if(currNode.next.data != null) {
					result += ", ";
				}
			}			
		}
		return result;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
