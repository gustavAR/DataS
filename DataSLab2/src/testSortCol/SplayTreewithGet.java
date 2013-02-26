package testSortCol;
import datastructures.SplayTree;

/**
 * 
 * A balanced binary search tree tree that re-balances itself on searches.
 * Also has get for testing purposes.
 * @author Lukas Kurtyan (910429-5614) & Gustav Alm Rosenblad (910624-3570) Group 31
 */
public class SplayTreewithGet<E extends Comparable<? super E>> extends SplayTree<E> implements CollectionWithGet<E> {

	@Override

	/**
	 * Gets an element from the collection which has 
	 * the same natural order as the parameter.
	 * Returns null if no such element was found.
	 * @param The element used for comparison
	 * @return The first element in the collection which has the same natural order as e.
	 * @throws NullPointerException if element is null
	 */
	public E get(E e) {
		if(e == null)  {
			throw new NullPointerException();
		} 
		
		Entry entry = this.find(e, this.root);
		if(entry != null)
			return entry.element;		
		
		return null;
	}
}
