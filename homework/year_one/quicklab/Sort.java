import java.util.Random;
import java.util.Arrays;

public class Sort {

    public static void quicksort(int[] arr, int start, int end){
	if(end - start <= 64){
	    insertionSort(arr, start, end);
	    return;
	}else{
	    if(start < end){
		System.out.println("quicksorted");
		int p = partition(arr, start, end);
		quicksort(arr, start, p - 1);
		quicksort(arr, p + 1, end);
	    }
	}
    }

    public static int partition(int[] arr, int start, int end){
	int pivot = arr[end];
	int i = start - 1;
	for(int j = start; j <= end - 1; j++){
	    if(arr[j] <= pivot){
		i++;
		swap(arr, i, j);
	    }
	}
	swap(arr, i + 1, end);
	return i + 1;
    }

    public static void swap(int[] arr, int i, int j){
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }

    public static void insertionSort(int[] arr, int start, int end){
	System.out.println("insertion Sorted");
	for(int i = start; i <= end; i++){
	    int j = i;
	    while(j > start && (arr[j-1] > arr[j])){
		int temp = arr[j];
		arr[j] = arr[j-1];
		arr[j-1] = temp;
		j = j-1;
	    }
	}
    }

    public static int[] randomArray(int length, int range){
	Random rn = new Random();
	int[] nums = new int[length];

	for(int i = 0; i < nums.length; i++){
	    int randomNumber = rn.nextInt() % range;
	    if(randomNumber < 0){
		nums[i] = -randomNumber;
	    }else{
		nums[i] = randomNumber;
	    }
	}
	return nums;

    }
    
    public static void main(String[] args){
	int[] arr = randomArray(100, 1000);
	System.out.println(Arrays.toString(arr));
	quicksort(arr, 0, arr.length-1);
	System.out.println();
	System.out.println(Arrays.toString(arr));
    }
}
	
