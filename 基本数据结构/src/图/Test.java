package Õº;

public class Test {

	public static void main(String[] args) {
		
		//testMatrixGraph(); //≤‚ ‘Õº-¡⁄Ω”æÿ’Û
		
		//testALGraph();  //≤‚ ‘Õº-¡⁄Ω”±Ì
		
		

	}

	private static void testALGraph() {
		MyALGraph myALGraph = new MyALGraph();
		myALGraph.DFSTraverse();
		System.out.println("\n");
		myALGraph.DFSTraverse2(0);
		System.out.println("\n");
		myALGraph.BFS(0);
	}

	private static void testMatrixGraph() {
		MyMatrixGraph myMatrixNDGraph = new MyMatrixGraph(9);
		for(int i = 0;i < 9;i++){
			myMatrixNDGraph.insertVertex(i);
		}
		myMatrixNDGraph.insertEdge(0, 1, 1);
		myMatrixNDGraph.insertEdge(0, 5, 1);
		
		myMatrixNDGraph.insertEdge(1, 2, 1);
		myMatrixNDGraph.insertEdge(1, 8, 1);
		myMatrixNDGraph.insertEdge(1, 6, 1);
		
		myMatrixNDGraph.insertEdge(2, 8, 1);
		myMatrixNDGraph.insertEdge(2, 3, 1);
		
		myMatrixNDGraph.insertEdge(3, 8, 1);
		myMatrixNDGraph.insertEdge(3, 6, 1);
		myMatrixNDGraph.insertEdge(3, 7, 1);
		myMatrixNDGraph.insertEdge(3, 4, 1);
		
		myMatrixNDGraph.insertEdge(4, 7, 1);
		myMatrixNDGraph.insertEdge(4, 5, 1);
		
		myMatrixNDGraph.insertEdge(5, 6, 1);
		myMatrixNDGraph.insertEdge(6, 7, 1);
		
		System.out.println(myMatrixNDGraph.getNumOfVertexes());
		System.out.println(myMatrixNDGraph.getNumOfEdges());
		System.out.println(myMatrixNDGraph.getFirstNeighbour(0));
		System.out.println(myMatrixNDGraph.getNextNeighbor(0, 2));
		System.out.println("\n");
		
		myMatrixNDGraph.DFSTraverse();
		System.out.println("\n");
		

		myMatrixNDGraph.BFSTraverse();
	}

}
