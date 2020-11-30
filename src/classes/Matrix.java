package classes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Matrix {

    private final Integer[][] matrix;
    private final Random random = new Random();

    public Matrix(Integer maxRows, Integer maxColumns){
        matrix = new Integer[maxRows][maxColumns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(10) +1;
            }
        }
    }

    public Integer[][] getMatrix() {
        return matrix;
    }
}
