package activities;

public class Activity2 {

	public static void main(String[]args) {
		
		int[] arr = {10,77,10,54,-11,10};
		int arrLength = arr.length;
		int i;
		int sum=0;
		
		for (i=0;i<arrLength;i++) {
			if (arr[i] == 10) {
				sum=sum+arr[i];
			}
		}
		
		if(sum==30) {
			
			System.out.println("Yes! The sum is 30");
		}else {System.out.println("No! The sum is not 30");}
	}
	
}
