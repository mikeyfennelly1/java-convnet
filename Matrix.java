public class Matrix {
    private final Double[][] matrix;
    private int XDimension, YDimension;

    public Matrix(Double[][] rows) throws IllegalArgumentException {
        if (!isValidMatrix(rows))
            throw new IllegalArgumentException();

        this.matrix = rows;
        this.XDimension = rows.length;
        this.YDimension = rows[0].length;
    }

    public Matrix(int XDimension, int YDimension) throws IllegalArgumentException {
        this.XDimension = XDimension;
        this.YDimension = YDimension;
        matrix = (Double[][]) new Object[XDimension][YDimension];
    }

    /**
     * Given 'matrix', this checks if matrix dimensionality is valid,
     * i.e. num columns = num rows
     * */
    private boolean isValidMatrix(Double[][] matrix) {
        boolean consistentRowSizes = true;

        if (!isRowLengthConsistent(matrix)) {
            return false;
        }
        if(calcXDimensionality(matrix) != calcYDimensionality(matrix)) {
            return false;
        }
        return true;
    }

    public int getXDimensionality(Double[][] matrix) {
        return this.XDimension;
    }
    public int getYDimensionality(Double[][] matrix) {
        return this.YDimension;
    }
    private int calcXDimensionality(Double[][] matrix) {
        return matrix[0].length;
    }
    private int calcYDimensionality(Double[][] matrix) {
        return matrix.length;
    }

    public Double[][] getMatrix() {
        return this.matrix;
    }

    /**
     * Row length is consistent if row.length for all arrays in the matrix are equal
     * */
    private boolean isRowLengthConsistent(Double[][] matrix) {
        boolean rowLenIsConsistent = true;
        int prevRowLen = -1;

        for (Double[] row : matrix) {
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

    public java.lang.Double[][] getTranspose() {
        // make the x the columns
        int x = this.getXDimensionality(matrix);
        int y = this.getYDimensionality(matrix);

        java.lang.Double[][] transpose = new java.lang.Double[x][y];

        // Populate the transpose matrix
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;

    }
}
