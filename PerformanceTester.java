public class PerformanceTester{
	
	private RandomField rf;
	private int tests;
	private int total;
	
	public PerformanceTester(int tests){
		rf = new RandomField();
		this.tests = tests;
		total = 0;
	}
	
	public void printAverage(){
		for(int i = 0; i < tests; i++){
			Solver solver = new Solver(new Node(rf.generate(), null, 0));
			total += solver.solve();
		}
		
		System.out.println(total / tests);
	}
}