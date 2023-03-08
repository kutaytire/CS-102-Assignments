

public class MergeSortAnalyzer extends SortAnalyzer{


    // Methods

    public  Comparable[] sort(Comparable[] arr) {

        mergeSort(arr, 0, arr.length - 1);

        return arr;

    }

  

    public void mergeSort( Comparable [] arr, int start, int end) {

        if (end > start) {

            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public void merge( Comparable [] arr, int start, int mid, int end) {

        int size1 = mid - start + 1;
        int size2 = end - mid;

        Comparable [] tmp1 = new Comparable[size1];
        Comparable [] tmp2 = new Comparable[size2];
        
        for (int i = 0; i < size1; i++)
            tmp1[i] = arr[start + i];

        for (int j = 0; j < size2; j++)
            tmp2[j] = arr[mid + 1 + j];

        int index1 = 0;
        int index2 = 0;

        int index = start;

        while (index1 < size1 && index2 < size2) {

            if (compare(tmp1[index1], tmp2[index2] ) < 0) {

                arr[index] = tmp1[index1];
                index1++;

            }

            else {

                arr[index] = tmp2[index2];
                index2++;

            }

            index++;
        }

        while(index1 < size1) {

            arr[index] = tmp1[index1];
            index++;
            index1++;
        }

        while(index2 < size2) {

            arr[index] = tmp2[index2];
            index++;
            index2++;
        }



    }

    
}
