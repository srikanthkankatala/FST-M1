package activities;

import java.util.*;


public class Activity9 {
	public static void main(String[] args) {
		
		//Create a String list
		List<String> strList= new ArrayList<>();
		//Add 5 names
		strList.add("Apples");
		strList.add("Cherry");
		strList.add("Papaya");
		strList.add("Watermelon");
		strList.add("Mango");
		
		//print all the names
		for(String name:strList) {
			System.out.println(name);
		}
		//using iterator
		Iterator<String> listItr = strList.iterator();
		while(listItr.hasNext()) {
			System.out.println(listItr.next());
		}
		
		//retrive third name is
		System.out.println("3rd name in the list is "+strList.get(2));
		System.out.println("Does mango exist?: "+strList.contains("Mango"));
		System.out.println("No of elements in list are: "+strList.size());
		//remove item from list
		strList.remove("Papaya");
		System.out.println("No of elements in list are: "+strList.size());
		
	}
}
