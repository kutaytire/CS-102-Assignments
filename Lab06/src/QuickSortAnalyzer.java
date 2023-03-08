public class QuickSortAnalyzer extends SortAnalyzer {



    public Comparable[] sort(Comparable[] arr) {

       quickSort(arr, 0, arr.length -1);
       return arr;
    }

    public void swap(Comparable[] arr, int i, int j)
    {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 

    public int partition(Comparable[] arr, int low, int high)
    {
        
        // pivot
        Comparable pivot = arr[high];
        int i = (low - 1);
    
        for(int j = low; j <= high - 1; j++)
        {
        
            if (compare(pivot, arr[j]) > 0)
            {
                
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    

    public void quickSort(Comparable[] arr, int low, int high)
    {
        if (low < high)
        {
            
          
            int pi = partition(arr, low, high);
    
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
 

    
}
