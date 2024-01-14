package arrays;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeros {
	public static void main(String[] args) {
		int[][] case1 = {{1,1,1},
				         {1,0,1},
				         {1,1,1}};
		int[][] case2 = {{0,1,2,0},
				         {3,4,5,2},
				         {1,3,1,5}};
		int[][] case3 = {{0,1}};
		
		int[][] matrix = case2;
		
		setZeroes1(matrix);
		printMatrix(matrix);
	}
	private static void printMatrix(int[][] matrix) {
		for(int[] arr : matrix) {
			for(int n : arr) {
				System.out.print(n+"\t");
			}System.out.println();
		}
	}
	/*===================	Approach- 1==============================*/
    public static void setZeroes1(int[][] matrix) {
    	int m = matrix.length, n = matrix[0].length;
    	boolean[][] flag = new boolean[m][n];
    	
    	for(int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {
    			if(matrix[i][j] == 0) {
    				int k;
    				for(k=0; k<m; k++ ) {
    					flag[k][j]=true;
    				}
    				for(k=0; k<n; k++) {
    					flag[i][k]=true;
    				}
    			}
    		}
    	}
    	for(int i=0; i<m; i++) {
    		for(int j=0; j<n; j++) {	
    			if(flag[i][j])matrix[i][j]=0;
    		}
    	}
    }
	
    /*===================	Approach- 2==============================*/
    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length, n=matrix[0].length;
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }makeZeros(matrix,list);
    }
    private static void makeZeros(int[][] matrix,List<int[]> list){
        for(int[] arr : list){
            for(int i=0; i<matrix.length; i++){
                matrix[i][arr[1]] = 0;
            }
            for(int j=0; j<matrix[0].length; j++){
                matrix[arr[0]][j] = 0;
            }
        }
    }
}
