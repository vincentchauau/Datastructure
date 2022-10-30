public class MultiSort {
    void printArray(int a[])
    {
        int n = a.length;
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
        System.out.println();
    }
    void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    // Find sorted a[i]
    void selectionSort(int a[])
    {
        int n = a.length;
        // Find a[i]
        for (int i = 0; i < n-1; i++)
        {
            // Find a[j] which is smaller than a[i]
            int min = i;
            for (int j = i+1; j < n; j++)
                if (a[j] < a[min])
                    min = j;
            swap(a, i, min);
        }
    }
    
    // Insert a[i]
    void insertionSort(int a[])
    {
        int n = a.length;
        // Insert a[i+1] to a[0]..a[i]
        for (int i = 0; i < n-1; i++)
        {
            int min = a[i + 1];
            int j = 0;
            for (j = i; j >= 0; j--)
            {
                if (min < a[j]){
                    a[j + 1] = a[j];
                }
                else {
                    break;
                }
            }
            a[j + 1] = min;
        }
    }
    void bubbleSort(int a[])
    {
        int n = a.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
    }
    // Find sorted a[i]s < a[high] < a[i]s
    int partition(int[] a, int low, int high)
    {
        int pivot = a[high];
        int j = (low - 1);
        // Move a[i] which is less than a[high] to the left
        for (int i = low; i <= high - 1; i++) {
            if (a[i] < pivot) {
                j++;
                swap(a, i, j);
            }
        }
        // Move a[high] to the middle
        swap(a, j + 1, high);
        return (j + 1);
    }
  
    void quickSort(int[] a, int low, int high)
    {
        if (low < high) {
            int mid = partition(a, low, high);
            quickSort(a, low, mid - 1);
            quickSort(a, mid + 1, high);
        }
    }

    void merge(int a[], int l, int m, int r)
    {
        // Copy a array to L and R arrays
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];
        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }
 
    void mergeSort(int a[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }
    // Driver method to test above
    public static void main(String args[])
    {
        MultiSort ob = new MultiSort();
        int a[] = { 4, 3, 1, 2 };
        System.out.println("Input:");
        ob.printArray(a);
        // System.out.println("Bubble sort");
        // ob.bubbleSort(a);
        // ob.printArray(a);
        // System.out.println("Selection sort");
        // ob.selectionSort(a);
        // ob.printArray(a);
        // System.out.println("Insertion sort");
        // ob.insertionSort(a);
        // ob.printArray(a);
        // System.out.println("Quick sort");
        // ob.quickSort(a, 0, a.length - 1);
        // ob.printArray(a);
        
        System.out.println("Merge sort");
        ob.mergeSort(a, 0, a.length - 1);
        ob.printArray(a);
    }
}