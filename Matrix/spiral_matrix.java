import java.util.*;

public class spiral_matrix {
    public static List<Integer> spiral (int[][] matrix){
        int rowStart=0,colStart=0,rowEnd=matrix.length-1,colEnd=matrix[0].length-1;
        List<Integer> ans = new ArrayList<>();
        while(rowStart<=rowEnd && colStart<=colEnd) {
            // in rect. matrix (for eg. (2,5)), if only 1 condition is used then, spiral will be repeated
            for(int i = colStart; i <= colEnd; i++) {
                ans.add(matrix[rowStart][i]);
            }
            for(int i = rowStart+1; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }
            for(int i = colEnd-1; i >= colStart; i--) {
                if(rowStart < rowEnd){
                    // this if condition is used so that if when rowStart & rowEnd are equal, it won't be repeated
                    ans.add(matrix[rowEnd][i]);
                }
            }
            for(int i = rowEnd-1; i >= colStart+1; i--) {
                if(colStart < colEnd){
                    // this if condition is used so that if when colStart & colEnd are equal, it won't be repeated
                    ans.add(matrix[i][colStart]);
                }
            }
            colStart++;
            rowStart++;
            colEnd--;
            rowEnd--;
        }
        return ans;
    }
    public static void main(String args[]) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            // {13,14,15,16}
        };
        List<Integer> ans = spiral(matrix);
        System.out.println(ans);
    }
}