import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashSet;

public class Solver{
	
	private LinkedList<Node> nodeQueue;
	private CompareNodes comparator;
	private HashSet<String> searched;
	
	public Solver(Node startNode){
		searched = new HashSet<String>();
		nodeQueue = new LinkedList<Node>();
		nodeQueue.add(startNode);
		comparator = new CompareNodes();
	}
	
	public int solve(){
		
		while(!nodeQueue.isEmpty()){
			
			Node thisNode = nodeQueue.pop();
			
			if(thisNode.toString().equals("00010203040506070809101112131415")) return solved(thisNode);
			
			LinkedList<Node> neighbours = thisNode.getNeighbours();
			for(Node i: neighbours){
				if(!searched.contains(i.toString())){
					nodeQueue.add(i);
					searched.add(i.toString());
				}
			}
			Collections.sort(nodeQueue, comparator);
		}
		
		return -1;
	}
	
	public int solved(Node winningNode){
		
		int moves = 0;
		
		while(winningNode.getParent() != null){
			
			Converter.printState(winningNode);
			System.out.println();
			winningNode = winningNode.getParent();
			moves++;
			
		}
		
		System.out.println(moves + " moves");
		return moves;
	}
	
}

class CompareNodes implements Comparator<Node>{
	
	@Override
	public int compare(Node a, Node b){
		
		int x = a.getF();
		int y = b.getF();
		
		if(x > y){
			return 1;
		}else if(y > x){
			return -1;
		}
		
		return 0;
	}
}