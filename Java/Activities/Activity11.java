package activities;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Activity11 {
	public static void main(String[] args) {
		Map<Integer,String> colours = new HashMap<>();
		colours.put(100, "Red");
		colours.put(101, "Blue");
		colours.put(102, "Green");
		colours.put(103, "White");
		colours.put(104, "Black");
		System.out.println(colours);
		
		for(Entry<Integer, String> item: colours.entrySet()) {
			System.out.println(item.getKey()+item.getValue());
		}
		
		for(int key:colours.keySet()) {
				System.out.println(key+": "+colours.get(key));
			
		}
		colours.remove(104);
		
		System.out.println(colours);
		System.out.println(colours.containsValue("Yellow"));
		System.out.println("Sizeof the map is : " + colours.size());
	}
}
