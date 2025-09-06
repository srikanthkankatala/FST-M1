package activities;
import java.util.*;

public class Activity10 {

	public static void main(String[] args) {
		Set<Integer> numSet = new HashSet<>();
		numSet.add(100);
		numSet.add(77232);
		numSet.add(909099);
		numSet.add(2025);
		numSet.add(1995);
		numSet.add(20081010);
		
		for(int num:numSet) {
			System.out.println("num");
		}
		System.out.println("Size of set"+ numSet.size());
		numSet.remove(100);
		System.out.println("Size of set"+ numSet.size());
		System.out.println(numSet);
		System.out.println("Search for 100: "+numSet.contains(100));
	}
}
