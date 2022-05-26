import java.util.Random;

public class BasicTraining {
	
	/**
	 * 
	 * {@summary
	 * Sorts the specified range of the specified array of objects in ascending order.
	 * }
	 * 
	 * @param <T> Type of array being passed in
	 * @param array Array to be sorted
	 * @param lowIndex the index of first element to be sorted
	 * @param highIndex the index of last element to be sorted
	 */
	public <T extends Comparable<? super T>> void quickSort(T[] array, int lowIndex, int highIndex) {
		
		Random random = new Random();
		
		if(lowIndex >= highIndex)
			return;
		
		int pivot = highIndex;;
		int lp = lowIndex;
		int rp = highIndex;
		
		while(lp < rp) {
			
			while((array[lp].compareTo(array[pivot]) == -1 || array[lp].compareTo(array[pivot]) == 0) && lp < rp) {
				lp++;
			}
			while((array[rp].compareTo(array[pivot]) == 1 || array[rp].compareTo(array[pivot]) == 0) && lp < rp) {
				rp--;
			}
			
			swap(array, lp, rp);
			
		}
		
		swap(array, lp, pivot);
		
		quickSort(array, lowIndex, lp - 1);
		quickSort(array, lp + 1, highIndex);
		
	}
	
	/**
	 * 
	 * {@summary
	 * Swaps two values at specified indexes for specified array.
	 * }
	 * 
	 * @param <T> Type of array being passed in
	 * @param array Array to have 2 elements swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	private static <T> void swap(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
}
