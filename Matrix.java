public class Matrix {
    private final int[][] matrix;
    private int XDimension, YDimension;

    public Matrix(int[][] rows) throws IllegalArgumentException {
        if (!isValidMatrix(rows))
            throw new IllegalArgumentException();

        this.matrix = rows;
        this.XDimension = rows.length;
        this.YDimension = rows[0].length;
    }

    /**
     * Given 'matrix', this checks if matrix dimensionality is valid,
     * i.e. num columns = num rows
     * */
    private boolean isValidMatrix(int[][] matrix) {
        boolean consistentRowSizes = true;

        if (!isRowLengthConsistent(matrix)) {
            return false;
        }
        if(calcXDimensionality(matrix) != calcYDimensionality(matrix)) {
            return false;
        }
        return true;
    }

    public int getXDimensionality(int[][] matrix) {
        return this.XDimension;
    }
    public int getYDimensionality(int[][] matrix) {
        return this.YDimension;
    }
    private int calcXDimensionality(int[][] matrix) {
        return matrix[0].length;
    }
    private int calcYDimensionality(int[][] matrix) {
        return matrix.length;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    /**
     * Row length is consistent if row.length for all arrays in the matrix are equal
     * */
    private boolean isRowLengthConsistent(int[][] matrix) {
        boolean rowLenIsConsistent = true;
        int prevRowLen = -1;

        for (int[] row : matrix) {
            // for first encountered row there is no comparison
            if (prevRowLen == -1) {
                prevRowLen = row.length;
            } else {
                if (prevRowLen != row.length) {
                    rowLenIsConsistent = false;
                }
                prevRowLen = row.length;
            }
        }
        return rowLenIsConsistent;
    }

    public int[][] getTranspose() {
        // make the x the columns
        int x = this.getXDimensionality(matrix);
        int y = this.getYDimensionality(matrix);

        int[][] transpose = new int[x][y];

        // Populate the transpose matrix
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;

    }
}
