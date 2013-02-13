package testSortCol;
import datastructures.SplayTree;

public class SplayTreewithGet<E extends Comparable<? super E>> extends SplayTree<E> implements CollectionWithGet<E> {

	@Override
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
