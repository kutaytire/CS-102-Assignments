

public class GeneralizedMergeSortAnalyzer extends SortAnalyzer {

  

    public GeneralizedMergeSortAnalyzer(int way) {

        k = way;

    }

    public  Comparable[] sort(Comparable[] arr) {

        generalMergeSort(arr, k, 0, arr.length);
        return arr;

    }


    public  void generalMergeSort(Comparable[] a, int k, int start, int end) {
     
        if (end - start >= 2) {

            if (k > end - start) {

                k = end - start;
            }
            int[] bounds = new int[k + 1]; 
            for (int i = 0; i <= k; i++) {
                bounds[i] = start + (end - start) * i / k; 
            }
            for (int i = 0; i < k; i++) {
                generalMergeSort(a, k, bounds[i], bounds[i + 1]); 
            }
            while (k > 1) {

                int i;
                int n = 1;
                for (i = 0; i < k - 1; i = i + 2) {
                    
                    
                    merge(a, bounds[i], bounds[i + 1], bounds[i + 2]);
                    bounds[n] = bounds[i + 2];
                    n++;
                }
                if (i < k) {

                    bounds[n] = bounds[i + 1];
                    n++;
                }

                k = n - 1;
            }
        }
      
    }

    public void merge( Comparable [] arr, int start, int mid, int end) {

        int n1 = mid - start;  
        
        Comparable[] tmp = new Comparable[n1];

        for (int i = 0; i < n1; i++) {
            tmp[i] = arr[start + i];
        }

        int index = 0;  
        int j = mid;  
        int k = start;  

        while (index < n1 && j < end) { 

            if (compare(arr[j],tmp[index]) >= 0 ) {

                arr[k] = tmp[index];
                index++;
                k++;
            } 
            else {
                
                arr[k] = arr[j];
            
                k++;
                j++;
            }
        }
        while (index < n1) { 

            arr[k] = tmp[index];
            index++;
            k++;
        }
       
        



    }

    



    
    

}