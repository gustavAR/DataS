package datastructures;

public class SplayTree<E extends Comparable<? super E>> extends BinarySearchTree<E> {
	
	
	@Override
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
		if(x.parent == null) return;
		
		Entry z = x.parent.parent;
		
		if(z == null) {
			if(x.parent.left == x) {
				zag(x);
			} else {
				zig(x);
			}
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
