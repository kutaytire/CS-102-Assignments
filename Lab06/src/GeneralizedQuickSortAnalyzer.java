
public class GeneralizedQuickSortAnalyzer extends SortAnalyzer{



    public GeneralizedQuickSortAnalyzer(int way) {

        k = way;
    }

    public Comparable[] sort(Comparable[] arr) {

        //generalQuickSort(arr, 0, arr.length - 1, k);
        generalQuickSort(arr, k, 0, arr.length - 1);
        return arr;
    }

    
    
    public void generalQuickSort(Comparable[] arr, int k, int start, int end) {


        
        if (end - start >= 2) {

            if (k > end - start) {

                k = end - start;
            }

            int [] pivots = new int [k + 1];
            Comparable [] pivotVal = new Comparable [k + 1];
            
            for (int i = 0; i <= k; i++) {

                pivots[i] = start + (end - start) * i / k; 
                pivotVal[i] = arr[pivots[i]];
            }

            sortPivots(pivotVal);
        
            /*

            System.out.print("pivots: ");
            for (int a = 0; a < pivotVal.length; a++) {

                System.out.print(pivotVal[a] + " ");
            }

            System.out.println();

            System.out.print("pivot indexes: ");
            for (int a = 0; a < pivots.length; a++) {

                System.out.print(pivots[a] + " ");
            }

            System.out.println();

            */
            for (int t = 0; t < pivotVal.length; t++) {

                arr[pivots[t]] = pivotVal[t];

            }


            partition(arr, start, pivotVal, end);

            for (int f = 0; f < pivots.length; f++) {


                pivots[f] = findIndex(pivotVal[f], arr);
            }

            

            for (int i = 0; i < k; i++) {

               // System.out.println("Sorting between " + pivots[i] + " , " + pivots[i + 1]);

                /*

                if (pivots[i] == start)
                    generalQuickSort(arr, k, pivots[i], pivots[i + 1]); 

                else if (pivots[i + 1] == end)
                    generalQuickSort(arr,k, pivots[i] + 1, pivots[i + 1]);

                else 
                    generalQuickSort(arr,k, pivots[i] + 1, pivots[i + 1] - 1);

                    */

                    generalQuickSort(arr, k, pivots[i], pivots[i + 1]);
            }

            generalQuickSort(arr, k, pivots[pivots.length - 1], end);

          
        }  
    }

    public void sortPivots(Comparable [] arr) {

        int n = arr.length;
  
        
        for (int i = 0; i < n - 1; i++)
        {
           
            int min_index = i;
            for (int j = i+1; j < n; j++) {

                if (arr[j].compareTo(arr[min_index]) < 0) {

                    min_index = j;
                }
            }
           
            Comparable temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }

    }

    

    public void partition(Comparable[] arr, int start, Comparable[] pivots, int end) {

        
        for (int idx = start; idx  <=  end; idx++) {

            int pvtidx = 0;

            while (pvtidx < pivots.length - 1 && compare(arr[idx], pivots[pvtidx]) >= 0 && compare(arr[idx], pivots[pvtidx + 1]) >= 0) {

                pvtidx++;

            }

            Comparable piv = pivots[pvtidx];
            int wanted = findIndex(piv, arr);
            Comparable upPiv;

            if (pvtidx < pivots.length - 1) {
               upPiv = pivots[pvtidx + 1];
            }

            else {

                upPiv = pivots[pvtidx];
            }
            
            int wanted2 = findIndex(upPiv, arr);

            if ( idx < wanted || idx > wanted2 ) {

                if (wanted > idx) {

                    Comparable tmp = arr[idx];

                    int sw;
                    for (sw = idx; sw < wanted; sw++) {

                        
                        arr[sw ] = arr[sw + 1];
                        
                    }

                    arr[sw] = tmp;
                    idx--;


                }

                else if ( idx > wanted) {

                    Comparable tmp = arr[idx];
                    int sw;

                    for (sw = idx; wanted + 1 < sw; sw--) {

                        arr[sw ] = arr[sw - 1];
                        
                    }

                    arr[sw] = tmp;
                   

                }

                        
               
            }

            /*
            System.out.print("After partition: ");
            for (int s = 0; s < arr.length; s++) {

                System.out.print(arr[s] + " ");
            }
            System.out.println();

            */
        }

        /*
        System.out.print("After partition: ");
        for (int s = 0; s < arr.length; s++) {

            System.out.print(arr[s] + " ");
        }
        System.out.println();

        */
        
    }

    public int findIndex(Comparable pivot, Comparable [] arr) {

        for (int a = 0; a < arr.length; a++) {

            if (arr[a].compareTo(pivot) == 0) {

                return a;
            }
        }

        return -1;



    }
    
    
}
