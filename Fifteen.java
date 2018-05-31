public class Fifteen{
	
	public static void main(String[] args){
		
		RandomField rf = new RandomField();
		Solver solver = new Solver(new Node(rf.generate(), null, 0));
		solver.solve();
		
		
		
	}
	
}