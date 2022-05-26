import java.util.Random;

public class BasicTraining {
	
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
	
	private static <T> void swap(T[] array, int index1, int index2) {
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
}
