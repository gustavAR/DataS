package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

import datastructures.LinkedCollection.Entry;
import testSortCol.CollectionWithGet;

public class SortedLinkedCollection<E extends Comparable<? super E>> extends LinkedCollection<E> implements CollectionWithGet<E>, Iterable<E> {


	@Override
	public boolean add(E element){
		if ( element == null ){
			throw new NullPointerException();
		}

		SortedLinkedCollectionIterator it = new SortedLinkedCollectionIterator();
		while(it.hasNext()){
			Entry next = it.next;
			if(element.compareTo(next.element)<=0){
				it.next = new Entry( element, it.next);
				return true;
			}
			it.next();
		}
		return false;
	}

	@Override
	public E get(E e) {
		Iterator<E> it = new SortedLinkedCollectionIterator();
		while(it.hasNext()){
			E next = it.next();
			if(e.compareTo(next)==0){
				return next;
			}
		}
		return null;
	}
	
	@Override
	public Iterator<E> iterator(){
		return new SortedLinkedCollectionIterator();
	}
	
	private class SortedLinkedCollectionIterator
	implements Iterator<E>         {

		Entry   next, previous;
		boolean removeAllowed;

		SortedLinkedCollectionIterator() {
			next          = head;
			previous      = null;
			removeAllowed = false;
		} //  constructor LinkedCollectionIterator

		public boolean hasNext() {
			return next != null;
		}  //  hasNext

		public E next() {
			try {
				previous      = next;
				next          = next.next;
				removeAllowed = true;
				return previous.element;
			}
			catch(NullPointerException npe) {
				throw new NoSuchElementException();
			} //  next

		} // next 

		public void remove() {
			if ( removeAllowed ) {
				if ( previous == head )
					head = head.next;
				else {
					Entry p = head;
					while ( p.next != previous )
						p = p.next;
					p.next = p.next.next;
				}
				removeAllowed = false;
			}
			else
				throw new IllegalStateException();
		}  //  remove 

	}  // class LinkedCollectionIterator
}
