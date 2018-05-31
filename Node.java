import java.util.LinkedList;

public class Node{
	
	private String nodeState;
	private Node parent;
	private int distanceLeft;
	private int movementCost;
	
	public Node(String nodeState, Node parent, int movementCost){
		this.nodeState = nodeState;
		this.parent = parent;
		this.movementCost = movementCost;
		distanceLeft = 0;
		calculateDistanceLeft();
	}
	
	public int getF(){
		return distanceLeft + (int) 0.75 * movementCost;
	}
	
	public void calculateDistanceLeft(){
		
		int[][] array = Converter.stringToArray(nodeState);
		
		for(int i = 0; i < 4; i++){
			
			for(int j = 0; j < 4; j++){
				
				if(i == 0 && j == 0) continue; //because I do not want to move 0 to 0,0 per se, rather move the rest to their positions
				
				int index = i*4 + j;
				int indexSearched = Converter.getIndex(array, index);
				distanceLeft += Math.abs(Converter.getCol(indexSearched) - j) + Math.abs(Converter.getRow(indexSearched) - i);
				
			}	
		}
	}
	
	public LinkedList<Node> getNeighbours(){
		
		LinkedList<Node> neighbours = new LinkedList<Node>();
		
		for(int i = 0; i < 4; i++){
			String newNodeState = Converter.move(nodeState,i);
			if(newNodeState != null) neighbours.add(new Node(newNodeState, this, movementCost + 1));
		}
		
		return neighbours;
	}
	
	public Node getParent(){
		
		return parent;
		
	}
	
	public String toString(){
		return nodeState;
	}
	
	@Override
	public boolean equals(Object node2){
		node2 = (Node) node2;
		return toString().equals(node2.toString());
	}
}

