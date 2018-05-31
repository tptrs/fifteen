public class Converter{
	
	public static String move(String nodeState, int direction){
		int[][] array = stringToArray(nodeState);
		int indexOfEmpty = getIndex(array, 0);
		int col = getCol(indexOfEmpty);
		int row = getRow(indexOfEmpty);
		
		switch (direction) {
			
			case 0:	if(row == 0) return null;
					array[row][col] = array[row-1][col];
					array[row-1][col] = 0;
					break;
			case 1:	if(col == 3) return null;
					array[row][col] = array[row][col+1];
					array[row][col+1] = 0;
					break;
			case 2:	if(row == 3) return null;
					array[row][col] = array[row+1][col];
					array[row+1][col] = 0;
					break;
			case 3:	if(col == 0) return null;
					array[row][col] = array[row][col-1];
					array[row][col-1] = 0;
					break;
		}
		
		return arrayToString(array);
	}
	
	public static String arrayToString(int[][] array){
		
		String nodeState = "";
		
		for(int i = 0; i < array.length; i++){
			
			for(int j = 0; j < array[0].length; j++){
				
				nodeState += digitToString(array[i][j]);
				
			}
		}
		return nodeState;
	}
	
	private static String digitToString(int value){
		String digitString = "" + value;
		if(digitString.length() == 1) digitString = "0" + digitString;
		return digitString;
	}
	
	public static int[][] stringToArray(String nodeState){
		
		int[][] array = new int[4][4];
		
		for(int i = 0; i < array.length; i++){
			
			for(int j = 0; j < array.length; j++){
				
				int indexOfString = 2*(i*4 + j);
				String substring = nodeState.substring(indexOfString, indexOfString+2);
				array[i][j] = Integer.parseInt(substring);
				
			}
		}
		return array;
	}
	
	public static int getIndex(int[][] array, int value){
		
		for(int i = 0; i < array.length; i ++){
			
			for(int j = 0; j < array.length; j++){
				
				if(array[i][j] == value) return i*4 + j;
			}
		}
		return -1;
	}
	
	public static int getCol(int value){
		return value % 4;
	}
	
	public static int getRow(int value){
		return value / 4;
	}
	
	public static void printState(Node node){
		int[][] array = Converter.stringToArray(node.toString());
		
		for(int i = 0; i < 4; i++){
			
			for(int j = 0; j < 4; j++){
				
				if(array[i][j] / 10 == 0) System.out.print(" ");
				
				System.out.print(array[i][j] + " ");
				
				if(j == 3) System.out.println("");
				
			}
			
		}
	}
	
}