import java.util.Random;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		BasicTraining sort = new BasicTraining();
		Long[] testArray = new Long[10];
		
		for(int i = 0; i < testArray.length; i++) {
			testArray[i] = random.nextLong(30);
		}
		
		System.out.print("Before sort: [ ");
		for(int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + " ");
		}
		System.out.println("]");
		
		sort.quickSort(testArray, 0, testArray.length - 1);
		
		System.out.print("After sort: [ ");
		for(int i = 0; i < testArray.length; i++) {
			System.out.print(testArray[i] + " ");
		}
		System.out.println("]");
		
	}

}
