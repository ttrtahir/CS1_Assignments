public class ArrayAssignment {

    public static void main(String[] args) {
        int[][] temp = {
                { 1, 2, 3, 4 },
                { 2, 3, 4, 5 },
                { 3, 4, 5, 6 },
                { 4, 5, 6, 7 }
        };

        diagonalPrint(temp);

        int[] A = { 0, 2, 0, 2, 2, 1, 1, 0 };
        allNumsWithin(A, 3);
    }

    public static int allNumsWithin(int[] A, int k) {

        // int seqLength = ;
        for (int i = 0; i < A.length - k; i++) {
            int checker[] = new int[k];

            for (int j = i; j < A.length; j++) {
                if (checker[A[j]] == 0) {
                    checker[A[j]] = 1;
                }
            }
        }
        return 0;
    }

    public static void diagonalPrint(int[][] M) {

        int rowCount = M.length;
        int columnCount = M[0].length;
        for (int i = 0; i <= rowCount + columnCount - 2; i++) {
            int tempMax = ((rowCount - 1) < i ? rowCount - 1 : i);
            for (int j = tempMax; j >= i - tempMax; j--) {
                System.out.print(M[j][i - j]);
                System.out.print(" ");
            }
        }
    }
}