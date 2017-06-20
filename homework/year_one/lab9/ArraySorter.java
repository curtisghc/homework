import java.util.Arrays;
/**
Class for sorting an array of base type int from smallest to largest.
 */
public class ArraySorter
{
	/**
    Precondition: Every element in anArray has a value.
    Action: Sorts the array into ascending order.
	 */
	public static void selectionSort(int[] anArray)
	{
		for (int index = 0; index < anArray.length - 1; index++)
		{   // Place the correct value in anArray[index]
			int indexOfNextSmallest = getIndexOfSmallest(index, anArray);
			interchange(index, indexOfNextSmallest, anArray);
			//Assertion:anArray[0] <= anArray[1] <=...<= anArray[index]
			//and these are the smallest of the original array elements.
			//The remaining positions contain the rest of the original
			//array elements.
		}
	}
	/**
    Returns the index of the smallest value in the portion of the
    array that begins at the element whose index is startIndex and
    ends at the last element.
	 */
	private static int getIndexOfSmallest(int startIndex, int[] a)
	{
		int min = a[startIndex];   
		int indexOfMin = startIndex;
		for (int index = startIndex + 1; index < a.length; index++)
		{
			if (a[index] < min)
			{
				min = a[index];
				indexOfMin = index;
				//min is smallest of a[startIndex] through a[index]
			}
		}
		return indexOfMin;
	}
	/**
    Precondition: i and j are valid indices for the array a.
    Postcondition: Values of a[i] and a[j] have been interchanged.
	 */
	private static void interchange(int i, int j, int[] a)
	{
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp; //original value of a[i]
	}
	
	public static void insertionSort(int[] arr) {
		int[] newArr = new int[arr.length];
		for(int value : arr){
			int c = 0;
			for(int i = 0; i < arr.length; i++) {
				if(value > arr[i]){
					c++;
				}
			}
			newArr[c] = value;
		}
		arr = newArr;
	}

	public static void bubbleSort(int[] arr) {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 0; i < arr.length - 1; i++) {
				if(arr[i] > arr[i + 1]) {
					//interchange(arr[i], arr[i + 1], arr);

					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

					sorted = false;
				}
			}		
		}
	}
	
	public static void quicksort(int[] arr, int lo, int hi) {
		if(lo < hi) {
			int p = partition(arr, lo, hi);
			quicksort(arr, lo, p - 1);
			quicksort(arr, p + 1, hi);
		}
	}

	private static int partition(int[] arr, int hi, int lo) {
		int pivot = arr[hi];
		int i = lo;
		for(int j = lo; j < hi; j++) {
			if(arr[j] <= pivot) {
			interchange(arr[i], arr[j], arr);
			/*
			arr[i] = arr[i] + arr[j];
			arr[j] = arr[i] - arr[j];
			arr[i] = arr[i] - all[j];
			*/
			i++;
			}
		}
		interchange(arr[i], arr[hi], arr);
		return i;
	}
	
	public static void main(String[] args) {
		int[] myArr = {7, 2, 5, 3, 4, 1, 8, 6, 9, 10};

		quicksort(myArr, myArr[0], myArr[myArr.length - 1]);
		System.out.println(Arrays.toString(myArr));
	}
}
