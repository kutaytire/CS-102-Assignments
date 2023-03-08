
public class DecreasingArrayGenerator implements ArrayGenerator{

    // Constructor

    public DecreasingArrayGenerator() {

    }
    // Methods

    public int [] generate(int n) {

        int [] array = new int [n];
        for ( int k = n; k > 0; k--) {

            array[n - k] = k;
        }

        return array;

    }
}