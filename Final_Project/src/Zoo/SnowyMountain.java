//Eric Audit COP 2552.0m1
//Exercise 5 (terrain)
//10-13-2018 

package Zoo;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SnowyMountain extends Mountain{
	static java.io.File file4 = new java.io.File("smountains.json");
	private int blizzardMonths;
	private ArrayList<SnowyMountain> theSnowyMountain = new ArrayList<SnowyMountain>();
	// Constructor with unique instance variable.
	public SnowyMountain() {};
	
	public SnowyMountain(String animalName, String name, String climate, String density, int monthsClimable, int blizzardMonths) {
		super(animalName, name, climate, density, monthsClimable);
		this.blizzardMonths = blizzardMonths;
	}
	// Unique setters and getters.
	public void setBlizzardMonths(int blizzardMonths) {
		this.blizzardMonths = blizzardMonths;
	}
	public int getBlizzardMonths() {
		return blizzardMonths;
	}
	public void Save() throws FileNotFoundException //save changes in program
	{
		java.io.PrintWriter outputx = new java.io.PrintWriter(file4);
		outputx.print("");
		outputx.close(); //erase whatever data might be on the file.
		java.io.PrintWriter outputf = new java.io.PrintWriter(file4);
		for(SnowyMountain snowyMountain: theSnowyMountain ) //iterate through the the terrain objects.
		{
			outputf.print(snowyMountain.getAnimalName() +"\n");
			outputf.print(snowyMountain.getName() + "\n");
			outputf.print(snowyMountain.getClimate()+ "\n");
			outputf.print(snowyMountain.getDensity()+ "\n");
			outputf.print(String.valueOf(snowyMountain.getMonthsClimable()) + "\n");
			outputf.print(String.valueOf(snowyMountain.getBlizzardMonths()) + "\n");
		}
		outputf.close(); //save changes.
	}
	// My Overrides
	@Override
	public String aString() {
		String s = super.aString() + " Be aware there is a blizzard warning in effect " + blizzardMonths + " months of the year.";
		return s;
	}
	
	@Override
	public int compareTo(Terrain o) {
		if(this.blizzardMonths > ((SnowyMountain)o).blizzardMonths)
			return 1;
		else if(this.blizzardMonths < ((SnowyMountain)o).blizzardMonths)
			return -1;
		else
			return 0;
	}
	public ArrayList<SnowyMountain> getTheSnowyMountain() {
		return theSnowyMountain;
	}

	public void setTheSnowyMountain(ArrayList<SnowyMountain> theSnowyMountain) {
		this.theSnowyMountain = theSnowyMountain;
	}
}
