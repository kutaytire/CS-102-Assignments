

public abstract class SortAnalyzer {


    // Properties

    private int numberOfComparisons;
    protected int k;

    // Methods

    public int getNumberOfComparisons() {

        return numberOfComparisons;
    }

    protected int compare( Comparable o1, Comparable o2) {

        numberOfComparisons++;

        return o1.compareTo(o2);
    }

    public Comparable[] convert(int[] arr) {


        Comparable[] newArr = new Comparable[arr.length];

        for(int a = 0; a < arr.length; a++) {

            newArr[a] = (Comparable) arr[a];
        }

        return newArr;
    }

    public boolean isSorted(Comparable[] arr) {

        boolean sorted = true;

        for (int k = 0; k < arr.length; k++) {

            for (int i = k; i < arr.length; i++ ) {

                if (arr[k].compareTo(arr[i]) > 0) {

                    sorted = false;
                }

            }
        }

        return sorted;
    }

    public abstract Comparable[] sort(Comparable[] arr);
   

    
    
}
