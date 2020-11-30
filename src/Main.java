import classes.Matrix;
import classes.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    private static final int NUM_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private static final int MAX_THREADS = 5;


    public static void main(String[] args) {
        int search = new Random().nextInt(20)+1;
        Matrix matrix = new Matrix(5,5);
        Integer [][] searcher = matrix.getMatrix();
        ThreadPoolExecutor fixed =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(NUM_PROCESSORS);


        System.out.printf("Search %d in this matrix...", search);
        System.out.println(Arrays.deepToString(searcher));
        System.out.println("Searching number....");
        List<Search> searchers = new ArrayList<>();
        for (int i = 0; i < MAX_THREADS; i++) {
            searchers.add(new Search(i, search, searcher[i]));
        }

        try {
            Integer[][] result =
                    fixed.invokeAny(searchers);
            System.out.printf("Number found in row %d and the column %d\n",
                    result[0][0], result[1][0]);
        } catch (InterruptedException ignored) {
        } catch (ExecutionException e) {
            System.out.print("Number not found\n");
        } finally {
            fixed.shutdown();
        }

    }
}
