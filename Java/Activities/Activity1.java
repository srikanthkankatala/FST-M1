package activities;

public class Activity1 {
public static void  main(String [] args) {
	
	Car Maruthi = new Car();
	Maruthi.make = 2014;
	Maruthi.color = "Black";
	Maruthi.transmission = "Manual";

	Maruthi.displayCharacteristics();
	Maruthi.accelerate();
	Maruthi.brake();
	
}	
}
