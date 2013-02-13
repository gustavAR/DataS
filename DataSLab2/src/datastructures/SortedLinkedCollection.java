package datastructures;

/**
 * This is a sorted singly linked list implementation.
 * @author Lukas Kurtyan (910429-5614) & Gustav Alm Rosenblad (910624-3570) Group 14
 * @param <E>
 */
public class SortedLinkedCollection<E extends Comparable<? super E>> extends LinkedCollection<E>{

	
	/**
	 * Adds an element to the collection. 
	 * The element is placed according to its natural order.
	 * @param The element to be inserted
	 * @return true if the element was successfully placed in the collection
	 * @throws NullPointerException if element is null
	 */
	@Override
	public boolean add(E element){
		if ( element == null ){
			throw new NullPointerException();
		}
		
		if(head == null) {
			this.head = new Entry(element, null);
			return true;
		} else if(head.element.compareTo(element) <= 0) {
			this.head = new Entry(element, head);
			return true;
		}
		
		Entry next = head;		
		while(next.next != null) {
			next = next.next;
			if(next.element.compareTo(element) <= 0) {
				next.next = new Entry(element, next.next);
				return true;
			}
		}
		
		next.next = new Entry(element, null);
		return true;
	}
}
