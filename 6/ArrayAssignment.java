public class ArrayAssignment {

    public static void main(String[] args) {
        int[][] temp = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
        };

        diagonalPrint(temp);

        int[] A = { 9, 1, 2, 3, 4, 5, 6, 5, 0, 1, 2, 3, 5, 7, 1, 1, 2, 2, 3, 1, 8 };
        System.out.println(allNumsWithin(A, 6));
    }

    // Exercise 2 without recursion
    public static int allNumsWithin(int[] A, int k) {

        int sumMustBe = (k * (k - 1)) / 2;
        int minStep = 100000;
        for (int startingPoint = 0; startingPoint < A.length; startingPoint++) {
            boolean checker[] = new boolean[10];
            int sum = 0;
            int step = 0;
            for (int followingNumberIndex = startingPoint; followingNumberIndex < A.length; followingNumberIndex++) {
                step++;
                int followingNumberValue = A[followingNumberIndex];
                // If I haven't used it before, label as it is used and add it to the sum
                if (checker[followingNumberValue] == false && followingNumberValue < k) {
                    checker[followingNumberValue] = true;
                    sum += followingNumberValue;
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

        int rowMax = M.length;
        int columnMax = M[0].length;

        for (int sumOfUnitsPlaces = 0; sumOfUnitsPlaces <= rowMax + columnMax - 2; sumOfUnitsPlaces++) {
            int minimumValue = ((rowMax - 1) < sumOfUnitsPlaces ? rowMax - 1 : sumOfUnitsPlaces);
            for (int row = minimumValue; row >= 0; row--) {
                int column = sumOfUnitsPlaces - row;
                if (column >= columnMax)
                    break;
                System.out.print(M[row][column] + " ");
            }
            // System.out.println("");
        }

        return;
    }
}