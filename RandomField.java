import java.util.Random;

public class RandomField{
	
	private Random random;
	
	public RandomField(){
		
		random = new Random();
		
	}
	
	public String generate(){
		
		String nodeState = "00010203040506070809101112131415";
		
		for(int i = 0; i < 1000; i++){
			
			int direction = random.nextInt(4);
			String newState = Converter.move(nodeState,direction);
			if(newState == null){
				i--;
				continue;
			}else{
				nodeState = newState;
			}
			
		}
		
		return nodeState;
	}
	
}