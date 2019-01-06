//Eric Audit COP 2552.0m1
//Final Project (Zoo program)
//12-9-2018


package Zoo;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class Animal extends Zoo_Tool
{
	static java.io.File file = new java.io.File("animals.json");
	
	private String name;
	private String food;
	private String terrain;
	private ArrayList<Animal> theZoo = new ArrayList<Animal>();
	private ArrayList<String> nameList = new ArrayList<>();
	private ArrayList<String> foodList = new ArrayList<>();
	private Image picture;
	private String pictureName;
	
	Animal()
	{
		name = "unknown";
		food = "unknown";
		terrain = "unknown";
	}
	Animal(String name, String food, String terrain, Image picture, String pictureName)
	{
		this.name = name;
		this.food = food;
		this.terrain = terrain;
		this.picture = picture;
		this.pictureName = pictureName;
	}
	public void Save() throws FileNotFoundException //save changes in program
	{
		java.io.PrintWriter outputx = new java.io.PrintWriter(file);
		outputx.print("");
		outputx.close(); //erase whatever data might be on the file.
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		for(Animal animal: theZoo) //iterate through the the animal objects.
		{
			output.print(animal.getName() +"\n");
			output.print(animal.getFood() + "\n");
			output.print(animal.getTerrain()+ "\n");
			output.print(animal.getPictureName() + "\n");
		}
		output.close(); //save changes.
		
	}
	public void setName(String aName)
	{
		this.name = aName;
	}
	public void setFood(String aFood)
	{
		this.food = aFood;
	}
	public void setTerrain(String terrainList)
	{
		this.terrain = terrainList;
	}
	public String getName()
	{
		return name;
	}
	public String getFood()
	{
		return food;
	}
	public String getTerrain()
	{
		return terrain;
	}
	public ArrayList<Animal> getTheZoo() {
		return theZoo;
	}
	public void setTheZoo(ArrayList<Animal> theZoo) {
		this.theZoo = theZoo;
	}
	public ArrayList<String> getNameList() {
		return nameList;
	}
	public void setNameList(ArrayList<String> nameList) {
		this.nameList = nameList;
	}
	public ArrayList<String> getFoodList() {
		return foodList;
	}
	public void setFoodList(ArrayList<String> foodList) {
		this.foodList = foodList;
	}
	public Image getPicture() {
		return picture;
	}
	public void setPicture(Image picture) {
		this.picture = picture;
	}
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	
}
