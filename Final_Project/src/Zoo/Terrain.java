package Zoo;
//Eric Audit COP 2552.0m1
//Exercise 5 (terrain)
//10-13-2018 

import java.util.ArrayList;

public abstract class Terrain extends Animal implements Comparable <Terrain>{
	static java.io.File file2 = new java.io.File("forests.txt");
	static java.io.File file3 = new java.io.File("mountains.txt");
	static java.io.File file4 = new java.io.File("smountains.txt");
	private ArrayList<Terrain> theTerrain = new ArrayList<Terrain>();
	// My base attributes that apply to all my Terrains.
	private String animalName ="unknown";
	private String name = "abstract terrain class";
	private String climate = "unknown";
	private String density = "unknown";
	
	
	
	// An empty constructor to show default values.
	protected Terrain(){}
	
	// Constructor used to create other Terrains.
	protected Terrain(String animalName, String name, String climate, String density)
	{
		this.animalName = animalName;
		this.name = name;
		this.climate = climate;
		this.density = density;
	}
	
	// Base toString.
	public String aString() {
		String s = "the " + name + " habitat. There is a " + climate + " climate with " + density + " wildlife density";
		return s;
	}
	
	//base setters and getters.
	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setClimate(String climate) {
		this.climate = climate;
	}
	
	public String getClimate() {
		return climate;
	}
	
	public void setDensity(String density) {
		this.density = density;
	}
	
	public String getDensity() {
		return density;
	}

	public ArrayList<Terrain> getTheTerrain() {
		return theTerrain;
	}

	public void setTheTerrain(ArrayList<Terrain> theTerrain) {
		this.theTerrain = theTerrain;
	}
	
}
