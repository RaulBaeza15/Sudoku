public class Run {
    public static void main(String[] args) {
        int[][] cuadricula1={
                {0,0,0,0,0,9,0,0,6},
                {0,1,0,0,0,0,0,0,0},
                {5,4,0,8,0,0,0,9,0},
                {8,9,0,4,0,0,0,6,0},
                {0,0,0,0,2,0,3,0,0},
                {0,0,7,0,0,0,0,0,0},
                {0,0,6,7,0,0,0,0,0},
                {0,0,1,0,0,0,0,5,0},
                {7,5,0,0,4,0,0,0,2}
        };
        Sudoku sudoku1= new Sudoku(cuadricula1);
        System.out.print(sudoku1);
        sudoku1.resolverBactraking();
        System.out.print(sudoku1);
    }
}
