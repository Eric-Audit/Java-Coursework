//Eric Audit COP 2552.0m1
//Exercise 5 (terrain)
//10-13-2018

//This is really only in the package for reference.
package Zoo;

public class TestTerrain{
	
	public static void main (String[] args) 
	{
		// Initialize my subclasses
		Terrain forest = new Forest("bear","Boreal","mild","abundant", 10 );
		Terrain forest2 = new Forest("bear","Temperate","cold","abundant", 12 );
		Terrain forest3 = new Forest(); //created a constructor with no variables so it would show the Terrain defaults.
		Terrain mountain = new Mountain("bear","Andes","cold","sparse", 2 );
		Terrain mountain2 = new Mountain("bear","rockies","cold","sparse", 4 );
		Terrain snowyMountain = new SnowyMountain("bear","Alps", "subzero", "sparse", 3, 5);
		Terrain snowyMountain2 = new SnowyMountain("bear","Himalayas", "subzero", "sparse", 3, 6);
		
		// Display all my subclass data.
		System.out.println(forest3.toString());
		System.out.println(forest.toString());
		System.out.println(forest2.toString());
		System.out.println(mountain.toString());
		System.out.println(mountain2.toString());
		System.out.println(snowyMountain.toString());
		System.out.println(snowyMountain2.toString());
		
		// Simple comparisons using int values in the Terrains.
		if(forest.compareTo(forest2) == -1)
			System.out.println("The " + forest.getName() + " forest has less rain.");
		else
			System.out.println("The " + forest2.getName() + " forest has less rain.");
		if(mountain.compareTo(mountain2) == -1)
			System.out.println("The " + mountain.getName() + " Mountain has a shorter climbing season.");
		else
			System.out.println("The " + mountain2.getName() + " Mountain has a shorter climbing season.");
		if(snowyMountain.compareTo(snowyMountain2) == -1)
			System.out.println("The " + snowyMountain.getName() + " Mountain has a shorter blizzard season.");
		else
			System.out.println("The " + snowyMountain2.getName() + " Mountain has a shorter blizzard season.");
	}
}