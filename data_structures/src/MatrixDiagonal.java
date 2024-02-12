
public class MatrixDiagonal {

	public static void main(String[] args) {
		/**
		 * To print the diagonal elements of the matrix
		 * if the matrix is square then it will have a diagonal
		 * row index==column index will be same for diagonal elements
		 * 
		 */
		
		//declare  2d matrix
		int[][] numArray = new int[2][2];
		
		//initalize
		int count =1; // just giving continious numbers
		for(int i=0;i<numArray.length;i++) {
			for(int j=0;j<numArray[i].length;j++) {
				numArray[i][j]=count;
				count++;
			}
		}
		
		//print the diagonal elements by checking for conditins
		if(numArray.length==numArray[0].length) {
			for(int i=0;i<numArray.length;i++) {
				for(int j=0;j<numArray[i].length;j++) {
					if(i==j)
						System.out.print(numArray[i][j]);
				}
				System.out.println();
			}
		}
		

	}

}
