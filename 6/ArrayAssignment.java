public class ArrayAssignment {

    public static void main(String[] args) {
        int[][] temp = {
                { 1, 2, 3, 4 },
                { 2, 3, 4, 5 },
                { 3, 4, 5, 6 },
                { 4, 5, 6, 7 }
        };

        diagonalPrint(temp);

        int[] A = { 1, 2, 3, 1, 1, 2, 1, 0, 1, 1, 1, 1, 0, 1, 1, 2, 2, 3, 1 };
        System.out.println(allNumsWithin(A, 4));
    }

    // Exercise 2 without recursion
    public static int allNumsWithin(int[] A, int k) {

        // int seqLength = ;
        int sumMustBe = (k * (k - 1)) / 2;
        int minStep = 100000;
        for (int i = 0; i < A.length; i++) {
            boolean checker[] = new boolean[k];
            int sum = 0;
            int step = 0;
            for (int j = i; j < A.length; j++) {
                step++;
                if (checker[A[j]] == false) {
                    checker[A[j]] = true;
                    sum += A[j];
                }
                if (sum == sumMustBe && checker[0])
                    if (minStep > step)
                        minStep = step;
            }

        }

        if (minStep == 100000)
            return 0;
        return minStep;
    }

    // Exercise 2 with recursion
    public static int allNumsWithinRecursion(int[] A, int k) {

        return 0;
    }

    // Exercise 1
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