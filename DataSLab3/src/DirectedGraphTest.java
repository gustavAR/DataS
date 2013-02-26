import java.util.Iterator;


public class DirectedGraphTest {

	private static class TestEdge extends Edge
	{
		private final double weigth;
		
		public TestEdge(int from, int to, double weigth) {
			super(from, to);
			this.weigth = weigth;			
		}
		
		public double getWeight() {
			return weigth;
		}
	}
	
	public static void main(String[] args) {
		DirectedGraph<TestEdge> graph = new DirectedGraph<TestEdge>(6);		
		buildGraph(graph);	
		
		
		Iterator<TestEdge> edges = graph.minimumSpanningTree();
		System.out.println("Testing minimum spanning!");		
		while(edges.hasNext()) {
			TestEdge edge = edges.next();
			System.out.println("From " + edge.from + " to " + edge.to);
		}
		
		
		Iterator<TestEdge> path = graph.shortestPath(0, 5);
		System.out.println("\nTesting shortes path from 0 to 5");
		while(path.hasNext()) {
			TestEdge edge = path.next();
			System.out.print(edge.from + " --> " + edge.to + " ");
		}
		
	}

	private static void buildGraph(DirectedGraph<TestEdge> graph) {
		//Start Node.
		graph.addEdge(new TestEdge(0, 1, 6));
		graph.addEdge(new TestEdge(0, 2, 1));
		graph.addEdge(new TestEdge(0, 3, 5));
		
		//Node 1
		graph.addEdge(new TestEdge(1, 0, 6));
		graph.addEdge(new TestEdge(1, 2, 5));
		graph.addEdge(new TestEdge(1, 4, 3));
			
		//Node 2
		graph.addEdge(new TestEdge(2, 1, 5));	
		graph.addEdge(new TestEdge(2, 3, 5));	
		graph.addEdge(new TestEdge(2, 4, 6));	
		graph.addEdge(new TestEdge(2, 5, 4));	
		
		//Node 3
		graph.addEdge(new TestEdge(3, 0, 5));	
		graph.addEdge(new TestEdge(3, 2, 5));	
		graph.addEdge(new TestEdge(3, 5, 2));	
		
		//Node 4
		graph.addEdge(new TestEdge(4, 1, 3));	
		graph.addEdge(new TestEdge(4, 2, 6));	
		graph.addEdge(new TestEdge(4, 5, 6));	
						
		
		//Node 5
		graph.addEdge(new TestEdge(5, 2, 4));	
		graph.addEdge(new TestEdge(5, 3, 2));	
		graph.addEdge(new TestEdge(5, 4, 6));
	}
}
