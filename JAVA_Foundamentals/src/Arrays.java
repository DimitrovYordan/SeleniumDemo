import java.util.ArrayList;

public class Arrays {

	public static void main(String[] args) {
		int[] array = new int[5];
		array[0] = 2;
		array[1] = 4;
		array[2] = 4;
		array[3] = 4;
		array[4] = 4;
		
		int[] array2 = {1, 2, 5, 4, 6, 7, 100};
		System.out.println(array2[4]);
		
		for(int i = 0; i < array2.length; i++) {
			System.out.println(array2[i]);
		}
		
		int count = 0;
		
		for (int n: array) {
			count += n;
		}
		System.out.println(count + " sum of array");
		
		for(int i = 0; i < array2.length; i++) {
			if (array2[i] % 2 == 0) {
				System.out.println(array2[i] + " even");
			}
			else {
				System.out.println(array2[i] + " odd");
			}
		}
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("test");
		list.add("something");
		list.add("text");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
