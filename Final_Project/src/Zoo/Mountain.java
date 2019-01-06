//Eric Audit COP 2552.0m1
//Exercise 5 (terrain)
//10-13-2018 

package Zoo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Mountain extends Terrain {
	static java.io.File file3 = new java.io.File("mountains.json");
	private ArrayList<Mountain> theMountain = new ArrayList<Mountain>();
	private int monthsClimable;
	// Constructor with unique instance variable.
	public Mountain() {};
	
	public Mountain(String animalName, String name, String climate, String density, int monthsClimable) {
		super(animalName, name, climate, density);
		this.monthsClimable = monthsClimable;
	}
	// My unique instance methods (setter and getter).
	public void setMonthsClimable(int monthsClimable) {
		this.monthsClimable = monthsClimable;
	}
	public int getMonthsClimable() {
		return monthsClimable;
	}
	public void Save() throws FileNotFoundException //save changes in program
	{
		java.io.PrintWriter outputx = new java.io.PrintWriter(file3);
		outputx.print("");
		outputx.close(); //erase whatever data might be on the file.
		java.io.PrintWriter outputf = new java.io.PrintWriter(file3);
		for(Mountain Mountain: theMountain ) //iterate through the the terrain objects.
		{
			outputf.print(Mountain.getAnimalName() +"\n");
			outputf.print(Mountain.getName() + "\n");
			outputf.print(Mountain.getClimate()+ "\n");
			outputf.print(Mountain.getDensity()+ "\n");
			outputf.print(String.valueOf(Mountain.getMonthsClimable()) + "\n");
		}
		outputf.close(); //save changes.
	}
	// My overrides.
	@Override
	public String aString() {
		String s = super.aString() + ". Additionally there are " + monthsClimable + " months you can climb per year.";
		return s;
	}
	
	@Override
	public int compareTo(Terrain o) {
		if(this.monthsClimable > ((Mountain)o).monthsClimable)
			return 1;
		else if(this.monthsClimable < ((Mountain)o).monthsClimable)
			return -1;
		else
			return 0;
	}
	public ArrayList<Mountain> getTheMountain() {
		return theMountain;
	}

	public void setTheMountain(ArrayList<Mountain> theMountain) {
		this.theMountain = theMountain;
	}

}
