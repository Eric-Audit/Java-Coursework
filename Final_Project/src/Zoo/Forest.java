//Eric Audit COP 2552.0m1
//Exercise 5 (terrain)
//10-13-2018 

package Zoo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Forest extends Terrain{
	static java.io.File file2 = new java.io.File("forests.json");
	private ArrayList<Forest> theForest = new ArrayList<Forest>();
	private int averageRainfall;
	// Empty constructor so i can display Terrain info.
	public Forest() {};
	// Constructor with unique instance variable.
	public Forest(String animalName, String name, String climate, String density, int averageRainfall) {
		super(animalName, name, climate, density);
		this.averageRainfall = averageRainfall;
	}
	// My unique instance methods (setters and getters).
	public void setAverageRainfall(int averageRainfall) {
		this.averageRainfall = averageRainfall;
	}
	public int getAverageRainfall() {
		return averageRainfall;
	}
	public void Save() throws FileNotFoundException //save changes in program
	{
		java.io.PrintWriter outputx = new java.io.PrintWriter(file2);
		outputx.print("");
		outputx.close(); //erase whatever data might be on the file.
		java.io.PrintWriter outputf = new java.io.PrintWriter(file2);
		for(Forest Forest: theForest) //iterate through the the terrain objects.
		{
			outputf.print(Forest.getAnimalName() +"\n");
			outputf.print(Forest.getName() + "\n");
			outputf.print(Forest.getClimate() + "\n");
			outputf.print(Forest.getDensity() + "\n");
			outputf.print(String.valueOf(Forest.getAverageRainfall()) + "\n");
		}
		outputf.close(); //save changes.
	}
	// My overrides.
	@Override
	public String aString() {
		String s = super.aString() + ". Additionally there is " +averageRainfall+ " inches of rainfall per year.";
		return s;
	}
	@Override
	public int compareTo(Terrain o) {
		if(this.averageRainfall > ((Forest) o).averageRainfall)
			return 1;
		else if(this.averageRainfall < ((Forest) o).averageRainfall)
			return -1;
		else
			return 0;
	}
	public ArrayList<Forest> getTheForest() {
		return theForest;
	}

	public void setTheForest(ArrayList<Forest> theForest) {
		this.theForest = theForest;
	}
}
