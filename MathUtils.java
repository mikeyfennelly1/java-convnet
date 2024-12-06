import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class MathUtils {
    public static void main(String[] args) {
        Double[] a = {2.0,1.0};
        Double[] b = {4.0,5.0};
        Double oneDimDP = get1DimensionalDotProduct(a,b);

        Double[][] M1Rows = {
                {2.0,1.0},
                {3.0,7.0}
        };
        Double[][] M2Rows = {
                {4.0,9.0},
                {5.0,8.0}
        };
        Matrix M1 = new Matrix(M1Rows);
        Matrix M2 = new Matrix(M2Rows);
        List<Double[]> M1M2DP = getMatrixDotProduct(M1, M2);
        System.out.println("!");
    }


    private static Double get1DimensionalDotProduct(Double[] matrixA, Double[] matrixB) throws InputMismatchException {
        if (matrixA.length != matrixB.length) {
            throw new InputMismatchException("Two matrices have different dimensions");
        }

        Double total = (double) 0;
        for (int i = 0; i < matrixA.length; i++) {
            total += matrixA[i] * matrixB[i];
        }
        return total;
    }

    public static List<Double[]> getMatrixDotProduct(Matrix m1, Matrix m2) {
        List<Double[]> DP = new ArrayList<>();
        Double[][] ma = m1.getMatrix();
        Double[][] mb = m2.getTranspose();
        for (Double[] vectorA: ma) { // y values
            Double[] thisDPRow = new Double[vectorA.length];
            int vbNum = 0;
            for (Double[] vectorB: mb) {
                Double thisDP = MathUtils.get1DimensionalDotProduct(vectorA, vectorB);
                thisDPRow[vbNum] = thisDP;
                vbNum++;
            }
            DP.add(thisDPRow);
        }

        return DP;
    }
}