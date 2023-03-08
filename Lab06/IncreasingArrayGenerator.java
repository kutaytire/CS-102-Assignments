public class IncreasingArrayGenerator implements ArrayGenerator {


    public int [] generate(int n) {


        int [] array = new int [n];
        for ( int k = 1; k <= n; k++) {

            array[k - 1] = k;
        }

        return array;
        
    }
    
}
