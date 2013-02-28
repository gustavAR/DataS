
import java.util.*;

public class DirectedGraph<E extends Edge> {
    
	private final Set<E>[] nodes;
	private int numEdges;
	
	/**
	 * Constructs a directed graph
	 * @param noOfNodes Number of nodes in the graph
	 */
	public DirectedGraph(int noOfNodes) {
		this.nodes = CreateSetNodes(noOfNodes);
		this.numEdges = 0;
	}

	/**
	 * Creates an array of empty (not null) sets
	 * @param noOfNodes Number of sets in the returned array
	 * @return An initialized array of sets
	 */
	private Set<E>[] CreateSetNodes(int noOfNodes) {
		@SuppressWarnings("unchecked")
		Set<E>[] list = new Set[noOfNodes];		
		for (int i = 0; i < noOfNodes; i++) {
			list[i] = new HashSet<E>();	
		}
		return list;
	}
	
	/**
	 * Tries to add an edge to the appropriate node
	 * @param e edge to add
	 */
	public void addEdge(E e) {
		if(e.from < nodes.length &&
		   e.to   < nodes.length   &&
		   e.from >= 0 &&
		   e.to   >= 0) {
			if(this.nodes[e.from].add(e)) {
				this.numEdges++;
			}
		} else {
			throw new IndexOutOfBoundsException("The node e.from is outside the bounds of the graph.");			
		}
	}

	/**
	 * Returns an iterator over the shortest path 
	 * between the two parameter nodes
	 * @param from Startnode
	 * @param to Endnode
	 * @return An iterator over the sh
	 */
	public Iterator<E> shortestPath(int from, int to) {
		Queue<ComparableDijkstraPath> queue = new PriorityQueue<ComparableDijkstraPath>();
		queue.add(new ComparableDijkstraPath(from));
		
		Set<Integer> visited = new HashSet<Integer>();		
		while(!queue.isEmpty()) {
		    ComparableDijkstraPath elem = queue.poll();		
			if(!visited.contains(elem.node)) {
				if(elem.node == to) {
				     return elem.path.iterator();				
				} else {
					visited.add(elem.node);
					
					for (E edge : this.nodes[elem.node]) {
						if(!visited.contains(edge.to)) {
						   queue.add(new ComparableDijkstraPath(elem.cost, elem.path, edge));				
						}
					}				
				}
			}
		}
		
		
		throw new IllegalArgumentException("No path exists between " + from + " and " + to + ".");
	}
			

	public Iterator<E> minimumSpanningTree() {
		Set<E>[] cc = CreateSetNodes(this.nodes.length);
		Queue<E> queue = new PriorityQueue<E>(this.numEdges, new CompKruskalEdge());
		fillQueue(queue);
		
		while(!queue.isEmpty()) {
		     E edge = queue.poll();
		     Set<E> from = cc[edge.from];
		     Set<E> to = cc[edge.to];
		     
		     if(from != to) {    	 
		    	 if(from.size() > to.size()) {
		    		 mergeAndCorrectCC(cc, to, from);
		    		 cc[edge.to] = from;
		    	 } else {
		    		 mergeAndCorrectCC(cc,  from, to);
		    		 cc[edge.from] = to;
		    	 }
			
		    	 cc[edge.from].add(edge);	 
		     }		     
		}
		
		return cc[0].iterator();
	}
	
	private void mergeAndCorrectCC(Set<E>[] cc, Set<E> from, Set<E> to) {
		for (E e : from) {
		    to.add(e);	
		    
		    //Correcting CC pointers.
		    cc[e.from] = to;
		    cc[e.to] = to;
		}		
	}

	private void fillQueue(Queue<E> queue) {
		for (Set<E> node : this.nodes) {
			for (E edge : node) {
				queue.add(edge);				
			}			
		}
	}
	
	private class ComparableDijkstraPath implements Comparable<ComparableDijkstraPath> {
		
		private final int node;
		private final double cost;
		private final Stack<E> path;
			
		public ComparableDijkstraPath(int node) {
			this.node = node;
			this.cost = 0;
			this.path = new Stack<E>();
		}
			
		public ComparableDijkstraPath(double cost, Stack<E> path, E extra) {
			this.node = extra.to;
			this.cost = cost + extra.getWeight();
			
			this.path = new Stack<E>();
			this.path.addAll(path);
			this.path.add(extra);
		}

		public int compareTo(ComparableDijkstraPath other) {
			return Double.compare(cost, other.cost);
		}
	}
	
	
	private class CompKruskalEdge implements Comparator<E> {
		@Override
		public int compare(E o1, E o2) {
			return Double.compare(o1.getWeight(), o2.getWeight());
		}
	}
	
}
  
