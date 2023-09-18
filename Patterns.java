import java.util.*;

public class Patterns{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows : ");
        int row = sc.nextInt();
        System.out.println("Enter cols : ");
        int col = sc.nextInt();

        // solidRectangle(row,col);
        // hollowReactangle(row,col);
        // halfpyramid(row);
        // invertedhalfpyramid(row);
        // invertedhalfpyramidRotated180(row);
        // halfpyramidWithNumbers(row);
        // invertedHalfPyramidWithNumbers(row);
        // floydsTriangle(row);
        // triangle01(row);

        // ADVANCED PATTERNS

        // butterfly(row);
        // solidRhombus(row);
        // numberPyramid(row);
        // numberPallindrome(row);
        diamondPattern(row);

    }

    public static void solidRectangle(int row,int col){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
    
    public static void hollowReactangle(int row, int col){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if (i == 1 || i == row || j == 1 || j == col){
                    System.out.print("* ");
                } else {
                    System.out.print("");
                }
            }
            System.out.println("");
        }
    }
    
    public static void halfpyramid(int row){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
    
    public static void invertedhalfpyramid(int row){
        for(int i=row;i>=1;i--){
            for(int j=i;j>=1;j--){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
    
    public static void invertedhalfpyramidRotated180(int row){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=row-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
        
    public static void halfpyramidWithNumbers(int row){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println("");
        }
    }
    
    public static void invertedHalfPyramidWithNumbers(int row){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=row-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println("");
        }
    }
    
    public static void floydsTriangle(int row){
        int k = 1;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                System.out.print(k+" ");
                k++;
            }
            System.out.println("");
        }
    }
    
    public static void triangle01(int row){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2 ==0) {
                    System.out.print("1"+" ");
                } else {
                    System.out.print("0"+" ");

                }
            }
            System.out.println("");
        }
    }

    public static void butterfly(int row){
        row *= 2;
        int col = row;

        // upper half

        for(int i=1; i<=row/2; i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            for(int j=1;j<=(row-2*i);j++){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println("");
        }

        // lower half

        for(int i=row/2; i>=1; i--){
            for(int j=i;j>=1;j--){
                System.out.print("* ");
            }
            for(int j=(row-2*i);j>=1;j--){
                System.out.print("  ");
            }
            for(int j=i;j>=1;j--){
                System.out.print("* ");
            }
            System.out.println("");
        }

    }

    public static void solidRhombus(int row){
        for(int i=1; i<=row; i++){
            for(int j=1;j<=row-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=row;j++){
                System.out.print("* ");
            }
            for(int j=1;j<=i-1;j++){
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void numberPyramid(int row){
        int k = 1;
        for(int i=1; i<=row; i++){
            for(int j=row-i;j>=1;j--){
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(k+"  ");
            }
            System.out.println("");
            k++;
        }
    }

    public static void numberPallindrome(int row){
        for(int i=1; i<=row; i++){
            for(int j=1;j<=row-i;j++){
                System.out.print("  ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j+" ");
            }
            for(int j=2;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println("");
        }
    }

    // TIP : IF U WANT TO ROTATE 180 downwards -> REVERSE THE OUTER LOOP as done in diamondPattern

    public static void diamondPattern(int row){
        int col = row;
        for(int i=1; i<=row; i++){
            for(int j=1;j<=row-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=(2*i-1);j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
        for(int i=row; i>=1; i--){
            System.out.print(" ");
            for(int j=1;j<=row-i;j++){
                System.out.print("  ");
            }
            for(int j=1;j<=(2*i-1);j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

}