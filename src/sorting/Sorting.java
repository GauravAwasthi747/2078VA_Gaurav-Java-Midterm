package sorting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Sorting {


    /** INSTRUCTIONS
     * You must implement all of the sorting algorithms below. Feel free to add any helper methods that you may need,
     * but make sure they are private, as to not be accessed outside of this class.
     *
     * You must also store the sorted arrays into their own individual database tables (Selection Sort should be stored
     *  in table `selection_sort`, Insertion Sort should be stored in table `insertion_sort`)
     */

    long executionTime = 0;

    public static void printSortedArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /*
     Quadratic sorting algorithms are some of the more popular sorting algorithms that are easy to understand and implement. These don’t offer a unique or optimized approach for sorting the array -
     rather they should offer building blocks for the concept of sorting itself for someone new to it. In selection sort, two loops are used. The inner loop one picks the minimum element from the
     array and shifts it to its correct index indicated by the outer loop. In every run of the outer loop, one element is shifted to its correct location in the array. It is a very popular sorting
     algorithm in python as well.
     */
    public int[] selectionSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min])
                    min = j;
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }


    /*
      Insertion sort isn’t a much-optimized algorithm for sorting an array, it is one of the more easily understood ones. Implementation is pretty easy too. In insertion sort, one picks up an element
      and considers it to be the key. If the key is smaller than its predecessor, it is shifted to its correct location in the array.
     */
    public int[] insertionSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int array_length = array.length;

        if (array_length <= 1) {
            return array;
        }

        for (int i = 1; i < array_length; i++) {
            int key = array[i];
            int j = i-1;

            //Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while ((j >= 0) && (array[j] > key)) {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = key;
        }

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }


    /*
      Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
     */
    public int[] bubbleSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int array_length = array.length;

        if (array_length <= 1) {
            return array;
        }
        //iteration through unsorted elements
        for (int i = 0; i < (array_length-1); i++) {
           for (int j = 0; j < (array_length-i-1); j++)
            if ((array[j]) > (array[j+1])) {
                //swap array[j+1] and array[j]
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }


    /*
     Merge sort is one of the most flexible sorting algorithms in java known to mankind (yes, no kidding). It uses the divide and conquers strategy for sorting elements in an array. It is also a
     stable sort, meaning that it will not change the order of the original elements in an array concerning each other. The underlying strategy breaks up the array into multiple smaller segments till
     segments of only two elements (or one element) are obtained. Now, elements in these segments are sorted and the segments are merged to form larger segments. This process continues till the entire
     array is sorted.
     */
    public int[] mergeSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        mergesort(array, 0, array.length - 1);

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }

    void mergesort(int[] array, int start, int end) {
        // break problem into smaller structurally identical problems
        int mid = (start + end) / 2;
        if (start < end) {
            mergesort(array, start, mid);
            mergesort(array, mid + 1, end);
        }

        // merge solved pieces to get solution to original problem
        int i = 0, first = start, last = mid + 1;
        int[] tmp = new int[end - start + 1];

        while (first <= mid && last <= end) {
            tmp[i++] = array[first] < array[last] ? array[first++] : array[last++];
        }
        while (first <= mid) {
            tmp[i++] = array[first++];
        }
        while (last <= end) {
            tmp[i++] = array[last++];
        }
        i = 0;
        while (start <= end) {
            array[start++] = tmp[i++];
        }
    }


    /*
     Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many versions of quickSort that pick
     pivot in different ways.
            Always pick first element as pivot.
            Always pick last element as pivot (implemented below)
            Pick a random element as pivot.
            Pick median as pivot.
     The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements
     (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear time.
     */
    public int[] quickSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int low = 0;
        int high = array.length-1;

        // pi is partitioning index, arr[p] is now at right place
        int pi = partition(array, low, high);

        // Separately sort elements before partition
        high = pi-1;
        pi = partition(array, low, high);

        // Separately sort elements after partition
        low = pi+1;
        pi = partition(array, low, high);

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }

    static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];

        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /*
     Heap sort is one of the most important sorting methods in java that one needs to learn to get into sorting. It combines the concepts of a tree as well as sorting, properly reinforcing the use of
     concepts from both. A heap is a complete binary search tree where items are stored in a special order depending on the requirement. A min-heap contains the minimum element at the root, and every
     child of the root must be greater than the root itself. The children at the level after that must be greater than these children, and so on. Similarly, a max-heap contains the maximum element at
     the root. For the sorting process, the heap is stored as an array where for every parent node at the index i, the left child is at index 2 * i + 1, and the right child is at index 2 * i + 2.
     A max heap is built with the elements of the unsorted array, and then the maximum element is extracted from the root of the array and then exchanged with the last element of the array. Once done,
     the max heap is rebuilt for getting the next maximum element. This process continues till there is only one node present in the heap.
     */
    public int[] heapSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int n = array.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }

    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    /*
    Bucket sort is mainly useful when input is uniformly distributed over a range
     */
    public int[] bucketSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int bktSize = 10;

        //creating a list of buckets for storing lists
        List<Integer>[] buckets = new List[bktSize];

        // Linked list with each bucket array index as there may be hash collision
        for(int i = 0; i < bktSize; i++) {
            buckets[i] = new LinkedList<>();
        }

        //calculate the hash and assigns elements to the proper bucket
        for(int num : array) {
            buckets[hash(num, bktSize)].add(num);
        }

        //iterate over the buckets and sorts the elements
        for(List<Integer> bucket : buckets) {
            //sorts the bucket
            Collections.sort(bucket);
        }

        int index = 0;
        //gethered the buckets after sorting
        for(List<Integer> bucket : buckets) {
            for(int num : bucket) {
                array[index++] = num;
            }
        }

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }

    //distributing elements
    private static int hash(int num, int bucketSize) {
        return num/bucketSize;
    }


    /*
     ShellSort is mainly a variation of Insertion Sort. In insertion sort, we move elements only one position ahead. When an element has to be moved far ahead, many movements are involved. The idea of
     shellSort is to allow exchange of far items. In shellSort, we make the array h-sorted for a large value of h. We keep reducing the value of h until it becomes 1. An array is said to be h-sorted
     if all sublist of every h’th element is sorted.
     */
    public int[] shellSort(int[] array) {
        final long startTime = System.currentTimeMillis();

        int n = array.length;

        for (int interval = n/2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i+= 1) {
               int temp = array[i];  //store array[i] to the variable temp and make the ith position empty
               int j;

               for (j = i; j >= interval && array[j - interval] > temp; j -= interval)
                   array[j] = array[j - interval];
                   array[j] = temp;  //put temp (the original a[i]) in its correct position
            }
        }

        final long endTime = System.currentTimeMillis();
        this.executionTime = endTime - startTime;

        return array;
    }
}
