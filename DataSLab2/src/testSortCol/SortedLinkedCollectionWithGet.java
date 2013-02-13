package testSortCol;

import datastructures.SortedLinkedCollection;

/**
 * This is a sorted singly linked list implementation with get.
 * @author Lukas Kurtyan (910429-5614) & Gustav Alm Rosenblad (910624-3570) Group 14
 * @param <E>
 */
public class SortedLinkedCollectionWithGet<E extends Comparable<? super E>> extends SortedLinkedCollection<E> implements CollectionWithGet<E> {

	/**
	 * Gets an element from the collection which has 
	 * the same natural order as the parameter.
	 * Returns null if no such element was found.
	 * @param The element used for comparison
	 * @return The first element in the collection which has the same natural order as e.
	 * @throws NullPointerException if element is null
	 */
	@Override
	public E get(E e) {
		if(e == null)  {
			throw new NullPointerException();
		} 
		
		if(head == null)  {
			return null;
		} else if(head.element.compareTo(e) == 0) {
			return head.element;			
		}
		
		Entry entry = head;
		while(entry.next != null) {
			entry = entry.next;
			if(entry.element.compareTo(e) == 0) {
				return entry.element;
			}
		}
		return null;
	} 
}
