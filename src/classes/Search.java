package classes;

import java.util.concurrent.Callable;

public class Search implements Callable<Integer[][]> {

    private final int intent;
    private final int search;
    private final Integer[] searcher;
    private final Integer[][] result = new Integer[2][1];

    public Search(int intent, int search, Integer[] searcher){
        this.intent = intent;
        this.search = search;
        this.searcher = searcher;
    }
    @Override
    public Integer[][] call() throws Exception {
        for (int i = 0; i < searcher.length; i++) {
            if(search == searcher[i]){
                result[0][0] = intent;
                result[1][0] = i;
                return result;
            }
        }
        throw new RuntimeException("Not found number in the matrix in the file" + intent);

    }

    public int getRow(){
        return result[0][0];
    }

    public int getColumn(){
        return result[1][0];
    }
}
