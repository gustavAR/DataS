package datastructures;

/**
 * A balanced binary search tree tree that re-balances itself on searches.
 * @author Lukas Kurtyan (910429-5614) & Gustav Alm Rosenblad (910624-3570) Group 31
 */
public class SplayTree<E extends Comparable<? super E>> extends BinarySearchTree<E> {
	


	@Override
	/**
	 * Finds the entry containing the element.
	 * If the element was not found, returns null.
	 * The entry containing the element, or the entry 
	 * on which the search was terminated, will become
	 * the new root.
	 * 
	 * @param elem The element we search for
	 * @returns The entry in which elem was found. Null if elem wasn't found.
	 */
	protected Entry find(E elem,
			Entry t) {		
		if ( t == null )
				return null;

		int jfr = elem.compareTo( t.element );
		if ( jfr  < 0 ){
			if(t.left == null) {
				splay(t);
				return null;
			} 
			return find(elem, t.left);
		}
		else if ( jfr > 0 )
		{
			if(t.right == null) {
				splay(t);
				return null;
			}
			return find( elem, t.right );
		}
		
		splay(t);
		return t;
	}

	
	
	private void splay(Entry x) {
		if(x.parent == null){
			this.root = x;
			return;
		}
		
		Entry z = x.parent.parent;
		
		if(z == null) {
			if(x.parent.left == x) {
				zag(x);
			} else {
				zig(x);
			}
			this.root = x;
			return;
		}
		
		if(z.left == x.parent) {
			if(z.left.left == x) {
				zagZag(x);				
			} else {
				zagZig(x);
			}
		} else {
			if(z.right.left == x) {
				zigZag(x);				
			} else {
				zigZig(x);
			}
		}
		
		splay(x);
	}


	private void zagZig(Entry x) {
		Entry z = x.parent.parent;
		Entry y = x.parent;
		
		z.left = x.right;
		if(z.left != null)
			z.left.parent = z;
		
		y.right = x.left;
		if(y.right != null)
			y.right.parent = y;
		
		x.parent = z.parent;
		if(x.parent != null) 
			if(x.parent.right == z)
				x.parent.right = x;
			else
				x.parent.left = x;
		
		z.parent = x;
		x.right = z;
		
		y.parent = x;
		x.left = y;	
	}

	private void zagZag(Entry x) {		
		Entry z = x.parent.parent;
		Entry y = x.parent;
		
		z.left = y.right;
		if(z.left != null)
			z.left.parent = z;
		
		y.left = x.right;
		
		if(y.left != null)
			y.left.parent = y;
		
		x.parent = z.parent;
		
		if(x.parent != null) 
			if(x.parent.right == z)
				x.parent.right = x;
			else
				x.parent.left = x;
			
		y.parent = x;
		x.right = y;
			
		z.parent = y;
		y.right = z;
	}
	
	private void zigZag(Entry x) {
		Entry z = x.parent.parent;
		Entry y = x.parent;
		
		z.right = x.left;
		if(z.right != null)
			z.right.parent = z;
		
		y.left = x.right;
		if(y.left != null)
			y.left.parent = y;
		
		x.parent = z.parent;
		if(x.parent != null) 
			if(x.parent.left == z)
				x.parent.left = x;
			else
				x.parent.right = x;
		
		z.parent = x;
		x.left = z;
		
		y.parent = x;
		x.right = y;		
	}

	private void zag(Entry x) {
		Entry y = x.parent;
		
		y.left = x.right;
		if(y.left != null)
			y.left.parent = y;
		
		y.parent = x;		
		x.right = y;
		
		x.parent = null;
	}

	private void zig(Entry x) {
		Entry y = x.parent;
		
		y.right = x.left;
		if(y.right != null)
			y.right.parent = y;
		
		y.parent = x;		
		x.left = y;
		
		x.parent = null;
	}



	private void zigZig(Entry x) {
		Entry z = x.parent.parent;
		Entry y = x.parent;
		
		z.right = y.left;
		if(z.right != null) 
			z.right.parent = z;
		
		y.right = x.left;
		
		if(y.right != null)
			y.right.parent = y;
		
		x.parent = z.parent;
		
		if(x.parent != null) 
			if(x.parent.left == z)
				x.parent.left = x;
			else
				x.parent.right = x;
			
		y.parent = x;
		x.left = y;
			
		z.parent = y;
		y.left = z;
	}
}
