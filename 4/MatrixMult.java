public class MatrixMult {
    public static void main(String[] args) {
        /*
         * 
         * Input examples are from https://www.baeldung.com/java-matrix-multiplication
         * 
         * double[][] firstMatrix = {
         * new double[] { 1d, 5d },
         * new double[] { 2d, 3d },
         * new double[] { 1d, 7d }
         * };
         * 
         * double[][] secondMatrix = {
         * new double[] { 1d, 2d, 3d, 7d },
         * new double[] { 5d, 2d, 8d, 1d }
         * };
         * 
         * multiplyMatrices(firstMatrix, secondMatrix);
         */
    }

    public static double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {

        // Matrix lengts [x][y]
        int firstLengthX = firstMatrix.length;
        int firstLengthY = firstMatrix[0].length;
        int secondLengthX = secondMatrix.length;
        int secondLengthY = secondMatrix[0].length;
        int commonBoundary = firstLengthY; // or secondLengthX

        if (firstLengthY != secondLengthX) {
            System.out.println("The matrices' sizes don't match!");
            return null;
        }

        double[][] endMatrice = new double[firstLengthX][secondLengthY];

        for (int row = 0; row < firstLengthX; row++) {
            for (int column = 0; column < secondLengthY; column++) {
                for (int temp = 0; temp < commonBoundary; temp++) {
                    endMatrice[row][column] += firstMatrix[row][temp] * secondMatrix[temp][column];
                }
            }
        }
        return endMatrice;
    }
}