import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MathUtils {
    public static void main(String[] args) {
        int[] a = {2,1};
        int[] b = {4,5};
        int oneDimDP = get1DimensionalDotProduct(a,b);

        int[][] M1Rows = {
                {2,1},
                {3,7}
        };
        int[][] M2Rows = {
                {4,9},
                {5,8}
        };
        Matrix M1 = new Matrix(M1Rows);
        Matrix M2 = new Matrix(M2Rows);
        List<int[]> M1M2DP = getMatrixDotProduct(M1, M2);
        System.out.println("!");
    }


    private static int get1DimensionalDotProduct(int[] matrixA, int[] matrixB) throws InputMismatchException {
        if (matrixA.length != matrixB.length) {
            throw new InputMismatchException("Two matrices have different dimensions");
        }

        int total = 0;
        for (int i = 0; i < matrixA.length; i++) {
            total += matrixA[i] * matrixB[i];
        }
        return total;
    }

    public static List<int[]> getMatrixDotProduct(Matrix m1, Matrix m2) {
        List<int[]> DP = new ArrayList<>();
        int[][] ma = m1.getMatrix();
        int[][] mb = m2.getTranspose();
        for (int[] vectorA: ma) { // y values
            int[] thisDPRow = new int[vectorA.length];
            int vbNum = 0;
            for (int[] vectorB: mb) {
                int thisDP = MathUtils.get1DimensionalDotProduct(vectorA, vectorB);
                thisDPRow[vbNum] = thisDP;
                vbNum++;
            }
            DP.add(thisDPRow);
        }

        return DP;
    }
}