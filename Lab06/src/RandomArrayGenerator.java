import java.util.Random;

public class RandomArrayGenerator implements ArrayGenerator {

    public int [] generate(int n) {

        int [] array = new int [n];
        for ( int k = 1; k <= n; k++) {

            array[k - 1] = k;
        }

        Random rn = new Random();

        for (int a = 0; a < n/2; a++) {

            int index1 = rn.nextInt(n);
            int index2 = rn.nextInt(n);
        
            int tmp = array[index1];
            array[index1] = array[index2];
            array[index2] = tmp;
        }

        return array;
        
    }



}

