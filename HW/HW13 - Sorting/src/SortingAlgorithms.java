//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework name: HW13 - Sorting
//Resources used: None

import java.io.UncheckedIOException;
import java.util.Arrays;

public class SortingAlgorithms {

	@SuppressWarnings("unchecked")

	/*
	 * Swaps the elements and indices i and j in list
	 * */
	private static <T> void swap(T[] list, int i, int j) {
		if (i < 0 || i >= list.length)
			return;
		if (j < 0 || j >= list.length)
			return;
		T temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	// ####################
	// ## INSERTION SORT ## ----------------------------------------------------------------------
	// ####################
	// ## IMPORTANT: the code we've given you below has a small bug!
	// ##   You will need to look at this code and/or test, and fix the bug.
	// ####################
	// Shifts each element into the sorted portion of the list until it reaches a smaller element
	/**
	 * Usually a slow sorting algorithm. Insertion sort. 
	 * @param list - An array of items
	 */

	public static <T extends Comparable<T>> void insertionSort(T[] list) {
		for (int i = 1; i < list.length; i++) {
			T val = list[i];
			int j = i - 1;
			while (j >= 0 && val.compareTo(list[j]) < 0) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = val;
		}
	}


	//A version of insertion sort that only sorts within the inputted bounds of an array
	public static <T extends Comparable<T>> void insertionSort(T[] list, int beg, int end) {
		for (int i = beg + 1; i < end+1; i++) {
			T val = list[i];
			int j = i - 1;
			while (j >= beg && val.compareTo(list[j]) < 0) {
				list[j+1] = list[j];
				j--;
			}
			list[j+1] = val;
		}
	}

	//=================================================================================


	// ################
	// ## MERGE SORT ## ----------------------------------------------------------------------
	// ################	
	/**
	 * Fully recursive Merge sort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * 
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void mergeSort(T[] list) {
		mergeSort(list, 0, list.length - 1);
	}

	//Splits the array into two halves and calls the method recursively within those halves
	//Stops once a split portion of the array is only a single element
	public static<T extends Comparable<T>> void mergeSort(T[] list, int i, int j) {
		if(i < j) {
            int mid = (i+j)/2;
            mergeSort(list, i, mid);
			mergeSort(list, mid+1, j);
			merge(list, i, mid, j);
		}
	}
	
	/**
	 * Merge method for Merge Sort algorithm.
	 * Your mergeSort algorithm will call this method as appropriate to do the merging.
	 * @param list - An array of items
	 * @param i - lower bound index
	 * @param mid - middle index
	 * @param j - upper bound index 
	 */
	public static<T extends Comparable<T>> void merge(T[] list, int i, int mid, int j) {
		//TODO: write the body of this method

		@SuppressWarnings("unchecked")
		T[] merged = (T[]) new Comparable[j-i+1]; // space for new merged list to hold (sorted) sublist
		int len = merged.length;
		//Sorts the two halves into the merged array
		//Checks both halves to find the next lowest element to add to the array
		if(i != j){
			int a = i; int b = mid+1; int index = 0;
			while(a <= mid && b <= j){
				if(list[a].compareTo(list[b]) < 0){
					merged[index] = list[a];
					index++;
					a++;
				} else{
					merged[index] = list[b];
					index++;
					b++;
				}
			}
			//If one half is done, inputs remaining elements from other half
			if(a > mid){
				while(index < len){
					merged[index] = list[b];
					b++;
					index++;
				}
			} else{
				while(index < len){
					merged[index] = list[a];
					a++;
					index++;
				}
			}

			//Transfers merged array into main list array
			index = 0;
			for(int y = i; i <= j; i++){
				list[i] = merged[index];
				index++;
			}
		}
	}

	//=================================================================================

	// #######################
	// ## HYBRID MERGE SORT ## ----------------------------------------------------------------------
	// #######################
	/**
	 * Hybrid recursive Merge sort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * For this implementation, when the size of the portion of the array
	 * to be sorted is less than 100 items, call insertionSort method to
	 * sort that chunk of the array.
	 *
	 *
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void mergeSortHybrid(T[] list) {
		mergeSortHybrid(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void mergeSortHybrid(T[] list, int i, int j) {
		if(i < j) {
            int mid = (i+j)/2;
            mergeSortHybrid(list, i, mid);
			mergeSortHybrid(list, mid+1, j);
			if(j - i + 1 < 100) //If size < 100, insertion sort is called
				insertionSort(list, i, j);
			else //if not, merge sort is called
				merge(list, i, mid, j);
		}
	}

	//=================================================================================
	
	// ###############
	// ## QUICKSORT ## ----------------------------------------------------------------------
	// ###############	
	/**
	 * Fully recursive Quicksort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * >>> Use any partition scheme that you like. 
	 * 
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void quickSort(T[] list) {
		quickSort(list, 0, list.length - 1);
	}

	//Finds a pivot and partitions the array around that pivot, then calls the method
	//recursively on the two partitions
	public static<T extends Comparable<T>> void quickSort(T[] list, int i, int j) {
		//TODO: write the body of this method
		if(i < j) {
            int pivot = partition(list, i, j);
			quickSort(list, i, pivot-1);
			quickSort(list, pivot+1, j);
		}
	}
	
	/**
	 * Partition method for Quicksort - Use any valid partition algorithm that you like.
	 * Your quickSort algorithm will call this method as appropriate to do the partitioning.
	 * @param list - An array of items
	 * @param i - lower bound
	 * @param j - upper bound
	 */

	public static<T extends Comparable<T>> int partition(T[] list, int i, int j) {
		//TODO: write the body of this method
		int pivot = i;
		int left = i-1;
		int right = j+1;
		//Swaps elements so elements greater than pivot are to the right and elements less
		//than pivot are to the left
		while (left < right) {
			left++;
			right--;
			while (list[left].compareTo(list[pivot]) < 0 && left <= j) {
				left++;
			}
			while (list[right].compareTo(list[pivot]) > 0 && right >= i) {
				right--;
			}
			if (left < right) {
				if (left == pivot) {
					swap(list, left, right);
					pivot = right;
				} else {
					swap(list, left, right);
				}
			}
		}
		//Ensures pivot is swapped back to be between the two sets of elements
		swap(list, left, pivot);
		pivot = left;


		return pivot; //Returns index of pivot
	}
	
	//=================================================================================

    // ######################
	// ## HYBRID QUICKSORT ## ----------------------------------------------------------------------
	// ######################
	/**
	 * Hybrid Quicksort and associated helper method.
	 * The second method below provides the portion of the array
	 * (i.e., index i to j inclusive) that we want to sort.
	 * >>> Use any partition scheme that you like.
	 * For this implementation, when the size of the portion of the array
	 * to be sorted is less than 100 items, call insertionSort method to
	 * sort that chunk of the array.
	 *
	 * @param list - An array of items
	 */
	public static<T extends Comparable<T>> void quickSortHybrid(T[] list) {
		quickSortHybrid(list, 0, list.length - 1);
	}
	public static<T extends Comparable<T>> void quickSortHybrid(T[] list, int i, int j) {
		if(i < j) {
			int pivot = partitionHybrid(list, i, j);
			if(j - i + 1 < 100){ //If size < 100, insertion sort is called
				insertionSort(list, i, pivot - 1);
				insertionSort(list, pivot + 1, j);
			} else { //If not, quick sort is called
				quickSortHybrid(list, i, pivot - 1);
				quickSortHybrid(list, pivot + 1, j);
			}
		}
	}

	/**
	 * Partition method for Quicksort - Use any valid partition algorithm that you like.
	 * Your quickSort algorithm will call this method as appropriate to do the partitioning.
	 * @param list - An array of items
	 * @param i - lower bound
	 * @param j - upper bound
	 */
	public static<T extends Comparable<T>> int partitionHybrid(T[] list, int i, int j) {
		//This is the same exact implementation as the partition method
		int pivot = i;
		int left = i-1;
		int right = j+1;
		while (left < right) {
			left++;
			right--;
			while (list[left].compareTo(list[pivot]) < 0 && left <= j) {
				left++;
			}
			while (list[right].compareTo(list[pivot]) > 0 && right >= i) {
				right--;
			}
			if (left < right) {
				if (left == pivot) {
					swap(list, left, right);
					pivot = right;
				} else {
					swap(list, left, right);
				}
			}
		}
		swap(list, left, pivot);
		pivot = left;

		return pivot;
	}

}