package activities;
import java.util.Arrays;
public class Activity4 {
	
	public static void main(String[] args) {
		int[] arr = {5,3,6,2,9};
		
		System.out.println("Before sorting: "+ Arrays.toString(arr));
		ascendingSort(arr);
		
		
		
	}

	
	static void ascendingSort(int array[]) {
		int size = array.length;
		int i;
		
		for(i=1;i<size;i++) {
			int key=array[i];
			int j=i-1;
			
			while(j>=0 && key < array[j]) {
				array[j+1]= array[j];
				--j;
			}
			array[j+1] = key;
		}
		
		System.out.println("After sorting: "+ Arrays.toString(array));
	}
	
}
