import java.util.*;

public class search_in_sorted_matrix {
    public static boolean searchInSortedMatrix (int[][] matrix,int key){
        int startRow = 0, startCol = matrix[0].length-1, endRow = matrix.length, endCol = 0;
        while(startRow <= endRow && startCol >= endCol) {
            System.out.println(startRow+","+startCol);
            if (key == matrix[startRow][startCol]) {
                return true;
            } else if(key < matrix[startRow][startCol]) {
                startCol--;
            } else {
                startRow++;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int key = 13;
        boolean ans = searchInSortedMatrix(matrix,key);
        System.out.println(ans);
    }
}