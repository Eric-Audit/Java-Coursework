//Eric Audit COP 2552.0m1
//Final Project (Zoo program)
//12-9-2018

//Thanks for a great semester.

package Zoo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Zoo_Tool extends Application {
	
	public static int LIMIT = 20; //to control how large of a string I let users input.

	static public class Zoo
	{	
		static java.io.File file = new java.io.File("animals.json");
		static java.io.File file2 = new java.io.File("forests.json");
		static java.io.File file3 = new java.io.File("mountains.json");
		static java.io.File file4 = new java.io.File("smountains.json");
		//my object instances. this will give me access to all their functions.
		Animal creator = new Animal();
		Forest fcreator = new Forest();
		Mountain mcreator = new Mountain();
		SnowyMountain smcreator = new SnowyMountain();
		ArrayList<Animal> theZoo = new ArrayList<>();
		ArrayList<Forest> aforest = new ArrayList<>();
		ArrayList<Mountain> aMountain = new ArrayList<>();
		ArrayList<SnowyMountain> aSnowyMountain = new ArrayList<>();
	
		Zoo() throws FileNotFoundException // A basic constructor.
			{
				
			}
		
		public void FileAninmals() //new and improved file program loads 4 files (added a file for each terrain type.) Error messages work.
		{
			//variables to unpack the files
			String name;
			String food;
			String terrain;
			String fName;
			String mName;
			String smName;
			String tName;
			String tClimate;
			String tDensity;
			String tRain;
			String tMonths;
			String bMonths;
			String pictureName;
			Image image;
			int temp;
			int tempm;
			int tempbm;
			Scanner input1 = null; //load the file.
			Scanner input2 = null;
			Scanner input3 = null;
			Scanner input4 = null;
			//the forest animals
			try {
				input1 = new Scanner(file2);
				} 
			catch (FileNotFoundException e) // Handle incident where the save file is missing.
				{
				// TODO Auto-generated catch block
				try {
					fcreator.Save();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Forest file doesn't exist, creating a new one.");
				try {
					input1 = new Scanner(file2);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}// Gracious error message.
				}
			while(input1.hasNext())
			{
				fName = input1.nextLine();
				tName = input1.nextLine();
				tClimate = input1.nextLine();
				tDensity = input1.nextLine();
				tRain = input1.nextLine();
				temp = Integer.parseInt(tRain);
				aforest.add (new Forest(fName, tName, tClimate, tDensity, temp)); //pull a file into an array of forest objects.
			}
			//the mountain animals
			try {
				input2 = new Scanner(file3);
				} 
			catch (FileNotFoundException e) // Handle incident where the save file is missing.
				{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Mountain file doesn't exist, creating a new one."); // Gracious error message.
				try {
					mcreator.Save();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					input2 = new Scanner(file3);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			while(input2.hasNext())
			{
				mName = input2.nextLine();
				tName = input2.nextLine();
				tClimate = input2.nextLine();
				tDensity = input2.nextLine();
				tMonths = input2.nextLine();
				tempm = Integer.parseInt(tMonths);
				aMountain.add (new Mountain(mName, tName, tClimate, tDensity, tempm)); //pull a file into an array of mountain objects.
			}
			//the snowy mountain animals
			try {
				input3 = new Scanner(file4);
				} 
			catch (FileNotFoundException e) // Handle incident where the save file is missing.
				{
				try {
					smcreator.Save();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Snowy Mountain file doesn't exist, creating a new one."); // Gracious error message.
				try {
					input3 = new Scanner(file4);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			while(input3.hasNext())
			{
				smName = input3.nextLine();
				tName = input3.nextLine();
				tClimate = input3.nextLine();
				tDensity = input3.nextLine();
				tMonths = input3.nextLine();
				bMonths = input3.nextLine();
				tempm = Integer.parseInt(tMonths);
				tempbm = Integer.parseInt(bMonths);
				aSnowyMountain.add (new SnowyMountain( smName, tName, tClimate, tDensity, tempm, tempbm)); //pull a file into an array of snowymountain objects.
			}
			//the animal array
			try {
				input4 = new Scanner(file);
				} 
			catch (FileNotFoundException e) // Handle incident where the save file is missing.
				{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Animal file doesn't exist, sorry.\n"); // Gracious error message.
				e.printStackTrace();
				}
			while(input4.hasNext())
			{
				name = input4.nextLine();
				food = input4.nextLine();
				terrain = input4.nextLine();
				pictureName = input4.nextLine(); //this while save the file name.
				pictureName = pictureName.replace("file:", "");
				image = new Image("file:images/"+pictureName); //this will search the image folder for it.
				theZoo.add(new Animal(name, food, terrain, image, pictureName)); //my array animal objects. finally figured out how to code this.it works really well.
			}
			creator.setTheZoo(theZoo);
			fcreator.setTheForest(aforest);
			mcreator.setTheMountain(aMountain);
			smcreator.setTheSnowyMountain(aSnowyMountain);
		}
		// This method lets the user set their zoo animals.
		public void SetAnimals(Stage setAnimal) 
			{
				GridPane pane = new GridPane();
				//using a grid to keep things organized.
				pane.setAlignment(Pos.CENTER);
				pane.setPadding(new Insets(11, 12, 13, 14));
				pane.setHgap(15);
				pane.setVgap(15);
				//scene
				Scene scene = new Scene(pane, 1280, 800);
				setAnimal.setTitle("Set Animals"); // Set the stage title
				setAnimal.setScene(scene); // Place the scene in the stage
				setAnimal.show(); // Display the stage
				Label Instructions = new Label("Please enter an animal name:"); //user gives a name
				pane.add(Instructions,0,0);
				TextField nameInput = new TextField();
				pane.add(nameInput,1,0);
				nameInput.lengthProperty().addListener(new ChangeListener<Number>() {
		            public void changed(ObservableValue<? extends Number> observable,
		                    Number oldValue, Number newValue) {
		                if (newValue.intValue() > oldValue.intValue()) {
		                    // Check if the new character is greater than LIMIT
		                    if (nameInput.getText().length() >= LIMIT) {

		                        // if it's 20th character then just setText to previous
		                        // one
		                        nameInput.setText(nameInput.getText().substring(0, LIMIT));
		                    }
		                }
		            }
		        });
				Label Instructions2 = new Label("Please enter what foods they eat: \n"); //the food
				pane.add(Instructions2,0,1);
				TextField foodInput = new TextField();
				pane.add(foodInput,1,1);
				foodInput.lengthProperty().addListener(new ChangeListener<Number>() {
		            public void changed(ObservableValue<? extends Number> observable,
		                    Number oldValue, Number newValue) {
		                if (newValue.intValue() > oldValue.intValue()) {
		                    // Check if the new character is greater than LIMIT
		                    if (foodInput.getText().length() >= (LIMIT+40)) {

		                        // if it's 60th character then just setText to previous
		                        foodInput.setText(foodInput.getText().substring(0, (LIMIT+40)));
		                    }
		                }
		            }
		        });
				//use some radios to set a basic terrain.
				Label Instructions3 = new Label("Which terrain does the animal belong to? (1) forest, (2) mountain, (3) snowy mountain:"); //basic terrain option
				pane.add(Instructions3,0,2);
				Label Instructions4 = new Label("");
				pane.add(Instructions4,0,3);
				VBox paneForRadioButtons = new VBox(20);
				paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5));
				RadioButton rb1 = new RadioButton("Forest");
				RadioButton rb2 = new RadioButton("Mountain");
				RadioButton rb3 = new RadioButton("Snowy Mountain");
				paneForRadioButtons.getChildren().addAll(rb1, rb2, rb3);
				pane.add(paneForRadioButtons, 0, 4);
				ToggleGroup group = new ToggleGroup();
				rb1.setToggleGroup(group);
				rb2.setToggleGroup(group);
				rb3.setToggleGroup(group);
				rb1.setOnAction(e -> {
					if (rb1.isSelected()) {
						Instructions4.setText("forest");
					}
				});
				rb2.setOnAction(e -> {
					if (rb2.isSelected()) {
						Instructions4.setText("mountain");
					}
				});
				rb3.setOnAction(e -> {
					if (rb3.isSelected()) {
						Instructions4.setText("snowy mountain");
					}
				});
				Label Instructions5 = new Label("Do you want to add an image to this animal?:");
				//this is a new trick i learned, i can use it to play with variables inside an action event. I'm going to use this a lot in the program as a peusdo-boolean
				final int[] dangerous = {0};
				pane.add(Instructions5,1,2);
				Label Instructions6 = new Label("");
				pane.add(Instructions6, 1, 3);
				VBox paneForDangerous = new VBox(20);
				paneForDangerous.setPadding(new Insets(5, 5, 5, 5));
				RadioButton rby = new RadioButton("Yes");
				RadioButton rbn = new RadioButton("No");
				paneForDangerous.getChildren().addAll(rby, rbn);
				pane.add(paneForDangerous, 1, 4);
				ToggleGroup dangerousGroup = new ToggleGroup();
				rby.setToggleGroup(dangerousGroup);
				rbn.setToggleGroup(dangerousGroup);
				rby.setOnAction(e -> {
					if (rby.isSelected()) {
						dangerous[0] = 1;
						Instructions6.setText("Yes");
					}
				});
				rbn.setOnAction(e -> {
					if (rbn.isSelected()) {
						dangerous[0] = 0;
						Instructions6.setText("No");
					}
				});
				Button Button1 = new Button("Set Animal");
				pane.add(Button1, 5,0);
				Button1.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent e)
					{
						int counter = theZoo.size();
						for(int i=0; i < counter; i++) // If i initialize the loop like this, then it doesn't run on the first entry (which is ideal).
						{
							if(theZoo.get(i).getName().trim().toLowerCase().equals(nameInput.getText().trim().toLowerCase())) // If the user's current input equals a previous entry.
							{
								JOptionPane.showMessageDialog(null, "You've already picked that animal");
								nameInput.setText("");
							}
						}
						//my next statement will make sure the user has made every selection.
						if(!nameInput.getText().equals("") && (!foodInput.getText().equals("")) && (!Instructions4.getText().equals("")) && (!Instructions6.getText().equals("")))
						{
							nameInput.setText(nameInput.getText().trim().toLowerCase());
							foodInput.setText(foodInput.getText().trim().toLowerCase());
							Image picture = null;
							String pName = null;
							if(dangerous[0] == 0)
							{
								picture = new Image("file:images/none.png");
								pName = "file:none.png";
								//if the user chooses not to set an image, a generic "no image available" is used. 
								//This lets the user know they haven't set one and i can still save it in my animal object.
							}
							else
							{
								FileChooser fileChooser = new FileChooser();
								fileChooser.setTitle("Open Resource File");
								fileChooser.getExtensionFilters().addAll(
								new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
								File selectedFile = fileChooser.showOpenDialog(setAnimal);
									if (selectedFile != null) {
										 BufferedImage bufferedImage;
										try {
											pName = selectedFile.getName();
											bufferedImage = ImageIO.read(selectedFile);
											picture = SwingFXUtils.toFXImage(bufferedImage, null);
											File current = new java.io.File("images/"+selectedFile.getName());
											try{
												Files.copy(selectedFile.toPath(), current.toPath());
											}
											catch(FileAlreadyExistsException f1)
											{
												//don't need to do anything, just keep it from throwing an uncatched error.
											}
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									 };
							}
							if(picture == null)
							{
								picture = new Image("file:images/none.png");
								pName = "file:none.png";
								//this will catch when the user closes the file explorer before picking an image, like if they change their mind.
								//they can always use the edit function to add a photo later.
							}
							theZoo.add( new Animal(nameInput.getText(),foodInput.getText(),Instructions4.getText(), picture, pName));
							creator.setTheZoo(theZoo);
							try 
							{
								creator.Save(); //save the program.
							} 
							catch (FileNotFoundException e1) // Handle incident where the save file is missing.
							{ 
								// TODO Auto-generated catch block
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry."); // Gracious error message.
							}
							try {
								Menu(setAnimal);
							} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Make sure you fill in all the fields.");
						}
						}
				});
				//home button included in every function so user can traverse the program easily.
				Button Button4 = new Button("Return Home");
				pane.add(Button4, 5,1);
				Button4.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent e)
					{
						try {
							Menu(setAnimal);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				}
		public void GetAnimals(Stage getAnimal) // This function will show the user the animals they've entered.
		{
			getAnimal.setTitle("Get Animals");
	        TextArea textArea = new TextArea(); //create a text area to dump the animal names.
	        GridPane pane = new GridPane();
	        Scene scene = new Scene(pane, 1280, 800);
	        pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11, 12, 13, 14));
			pane.setHgap(15);
			pane.setVgap(15);
			pane.add(textArea, 1, 1);
	        getAnimal.setScene(scene);
	        getAnimal.show();
		    int size = theZoo.size();
			for(int i = 0; i < size; i++)
			{
				textArea.appendText(theZoo.get(i).getName()+ "\n");
			}
			Button Button1 = new Button("Return Home");
			pane.add(Button1, 1,0);
			Button1.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					try {
						Menu(getAnimal);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		public void SpecificAnimal(Stage SpecificAnimal) //this will allow the user to view an animal.
		{
			SpecificAnimal.setTitle("Specific Animals");
	        GridPane pane = new GridPane();
	        Scene scene = new Scene(pane, 1280, 800);
	        pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11, 12, 13, 14));
			pane.setHgap(15);
			pane.setVgap(15);
	        SpecificAnimal.setScene(scene);
	        SpecificAnimal.show();
	        Label Instructions = new Label("Please enter the animal you would like to view:");
			pane.add(Instructions,0,0);
			TextField nameInput = new TextField();
			pane.add(nameInput,1,0);
			nameInput.lengthProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (nameInput.getText().length() >= LIMIT) {

	                        // if it's 20th character then just setText to previous
	                        // one
	                        nameInput.setText(nameInput.getText().substring(0, LIMIT));
	                    }
	                }
	            }
	        });
			Button Button1 = new Button("Set Animal");
			pane.add(Button1, 1,1);
			int size = theZoo.size();
			//more of my pseudo booleans
			final int[] pass = {0};
			final int[] poss = {0};
			final int[] invalid = {0};
			final int[] invalid2 = {0};
			Button1.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					for(int i = 0; i < size; i++)
					{
						if(theZoo.get(i).getName().matches(nameInput.getText().trim().toLowerCase()))
							{
							pass[0] = 1;
							poss[0] = i;
							}
					}
					if(invalid[0] == 1 && invalid2[0] ==1)
					{
						JOptionPane.showMessageDialog(null, "You can only search one animal at a time.");
						
					}
					//the conditions for this statement will prevent the program from redrawing the labels if the button is continuously clicked.
					if(pass[0] == 1 && (!(invalid2[0] == 1)))
					{
						invalid2[0] =1;
						int k = poss[0];
						Label nameLabel = new Label("Name: ");
						pane.add(nameLabel,0,2);
						Label nameInfo = new Label(nameInput.getText().trim().toLowerCase());
						pane.add(nameInfo, 1, 2);
						Label foodLabel = new Label("Food: ");
						pane.add(foodLabel,0,3);
						Label foodInfo = new Label(theZoo.get(k).getFood().trim().toLowerCase());
						pane.add(foodInfo, 1, 3);
						Label terrainLabel = new Label("Basic Terrain: ");
						pane.add(terrainLabel,0,4);
						Label terrainInfo = new Label(theZoo.get(k).getTerrain().trim().toLowerCase());
						pane.add(terrainInfo, 1, 4);
						ImageView pictureView = new ImageView(theZoo.get(k).getPicture());
						pictureView.setFitHeight(500);
						pictureView.setFitWidth(500);
						pictureView.setPreserveRatio(true);
						Label imgLbl = new Label(nameInput.getText().trim().toLowerCase(), pictureView);
						pane.add(imgLbl, 0, 5);
					}
					
					//set a flag at the end to mark that the button has been clicked at least once.
					invalid[0] = 1;
					if(!(pass[0] == 1))
					{
						JOptionPane.showMessageDialog(null, "This animal doesn't exist, sorry.");
					}
				}
			});
			Button Button4 = new Button("Return Home");
			pane.add(Button4, 1,6);
			Button4.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					try {
						Menu(SpecificAnimal);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		public void EditName(Stage EditName) //this will allow the user to change the animal name and the image.
		{
			GridPane pane = new GridPane();
			//using a grid to keep things organized.
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11, 12, 13, 14));
			pane.setHgap(15);
			pane.setVgap(15);
			//scene
			Scene scene = new Scene(pane, 1280, 800);
			EditName.setTitle("Edit Animal"); // Set the stage title
			EditName.setScene(scene); // Place the scene in the stage
			EditName.show(); // Display the stage
			Label Instructions5 = new Label("Do you want to associate an image with this animal?:");
			final int[] hasImage = {0}; //this is the psuedo-boolean for the image.
			pane.add(Instructions5,0,3);
			Label Instructions6 = new Label("");
			pane.add(Instructions6, 1, 3);
			VBox paneForImage = new VBox(20);
			paneForImage.setPadding(new Insets(5, 5, 5, 5));
			RadioButton rby = new RadioButton("Yes");
			RadioButton rbn = new RadioButton("No");
			paneForImage.getChildren().addAll(rby, rbn);
			pane.add(paneForImage, 1, 4);
			ToggleGroup dangerousGroup = new ToggleGroup();
			rby.setToggleGroup(dangerousGroup);
			rbn.setToggleGroup(dangerousGroup);
			rby.setOnAction(e -> {
				if (rby.isSelected()) {
					hasImage[0] = 1;
					Instructions6.setText("Yes");
				}
			});
			rbn.setOnAction(e -> {
				if (rbn.isSelected()) {
					hasImage[0] = 0;
					Instructions6.setText("No");
				}
			});
			Label Instructions = new Label("Please enter the animal name you would like to change:");
			pane.add(Instructions,0,0);
			TextField nameInput = new TextField();
			pane.add(nameInput,1,0);
			nameInput.lengthProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (nameInput.getText().length() >= LIMIT) {

	                        // if it's 20th character then just setText to previous
	                        // one
	                        nameInput.setText(nameInput.getText().substring(0, LIMIT));
	                    }
	                }
	            }
	        });
			Button Button1 = new Button("Set Animal");
			pane.add(Button1, 1,1);
			int size = theZoo.size();
			final int[] pass = {0};
			final int[] poss = {0};
			final int[] invalid = {0};
			final int[] invalid2 = {0};
			Button1.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					if(invalid[0] ==1 && invalid2[0] ==1) //prevent button from being clicked more than once.
					{
						JOptionPane.showMessageDialog(null, "You may only edit one animal at a time.");
					}
					for(int i = 0; i < size; i++)
					{
						if(theZoo.get(i).getName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase()) && (!(invalid2[0] == 1)))
							{
								pass[0] = 1;
								poss[0] = i;
								invalid2[0] =1;
								Label Instructions2 = new Label("What would you like to rename the " + nameInput.getText().trim().toLowerCase());
								pane.add(Instructions2,0,2);
								TextField newNameInput = new TextField();
								pane.add(newNameInput,1,2);
								newNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
						            public void changed(ObservableValue<? extends Number> observable,
						                    Number oldValue, Number newValue) {
						                if (newValue.intValue() > oldValue.intValue()) {
						                    // Check if the new character is greater than LIMIT
						                    if (newNameInput.getText().length() >= LIMIT) {
	
						                        // if it's 20th character then just setText to previous
						                        // one
						                        newNameInput.setText(newNameInput.getText().substring(0, LIMIT));
						                    }
						                }
						            }
						        });
								Button Button2 = new Button("Save");
								pane.add(Button2, 1,5);
								Button2.setOnAction(new EventHandler<ActionEvent>(){
									public void handle(ActionEvent e)
									{
										if((pass[0] == 1) && (!Instructions6.getText().equals("")) && (!(newNameInput.getText().trim().toLowerCase().equals("")))) //this will let the user pick an image, and move it to the "images" folder.
										{
											final int k = poss[0];
											Image picture = null;
											String pName = null;
												if(hasImage[0] == 0)
												{
													picture = new Image("file:images/none.png");
													pName = "file:none.png";
												}
												else
												{
													FileChooser fileChooser = new FileChooser();
													fileChooser.setTitle("Open Resource File");
													fileChooser.getExtensionFilters().addAll(
														    new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
													File selectedFile = fileChooser.showOpenDialog(EditName);
														if (selectedFile != null) {
															 BufferedImage bufferedImage;
															try {
																pName = selectedFile.getName();
																bufferedImage = ImageIO.read(selectedFile);
																picture = SwingFXUtils.toFXImage(bufferedImage, null);
																File current = new java.io.File("images/"+selectedFile.getName());
																try{
																	Files.copy(selectedFile.toPath(), current.toPath());
																}
																catch(FileAlreadyExistsException f2)
																{
																	//doesn't need to do anything, just catch the error.
																}
															} catch (IOException e1) {
																// TODO Auto-generated catch block
																e1.printStackTrace();
															}
														 };
												}
											newNameInput.setText(newNameInput.getText().trim().toLowerCase());
											theZoo.get(k).setName(newNameInput.getText().trim().toLowerCase());
											theZoo.get(k).setPictureName(pName);
											if(picture == null)
											{
												picture = new Image("file:images/none.png");
												pName = "file:none.png";
												//this will catch when the user closes the file explorer before picking an image, like if they change their mind.
												//they can always use the edit function to add a photo later.
											}
											theZoo.get(k).setPicture(picture);
											creator.setTheZoo(theZoo);
											try {
												Menu(EditName);
											} catch (FileNotFoundException e2) {
													// TODO Auto-generated catch block
													e2.printStackTrace();
											}
											try 
											{
												creator.Save(); 
											} 
											catch (FileNotFoundException e1) // Handle incident where the save file is missing.
											{ 
												// TODO Auto-generated catch block
												e1.printStackTrace();
												JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry."); // Gracious error message.
											}
										}
										else
										{
											JOptionPane.showMessageDialog(null, "Make sure to fill in all the fields with valid information.");
										}
									}
									});
							}
					}
					invalid[0] =1;
					if(!(pass[0] == 1))
					{
						JOptionPane.showMessageDialog(null, "This animal doesn't exist, sorry.");
					}
				}
				
			});	
			Button Button4 = new Button("Return Home");
			pane.add(Button4, 1,6);
			Button4.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					try {
						Menu(EditName);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		public void SetFoods(Stage SetFoods) // This method will allow the user to set the diet.
			{
			GridPane pane = new GridPane();
			//using a grid to keep things organized.
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11, 12, 13, 14));
			pane.setHgap(15);
			pane.setVgap(15);
			//scene
			Scene scene = new Scene(pane, 1280, 800);
			SetFoods.setTitle("Set Foods"); // Set the stage title
			SetFoods.setScene(scene); // Place the scene in the stage
			SetFoods.show(); // Display the stage
			Label Instructions = new Label("Please enter an animal name:");
			pane.add(Instructions,0,0);
			TextField nameInput = new TextField();
			pane.add(nameInput,1,0);
			nameInput.lengthProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (nameInput.getText().length() >= LIMIT) {

	                        // if it's 20th character then just setText to previous
	                        // one
	                        nameInput.setText(nameInput.getText().substring(0, LIMIT));
	                    }
	                }
	            }
	        });
			Button Button1 = new Button("Set Animal");
			pane.add(Button1, 1,1);
			int size = theZoo.size();
			final int pass[] = {0};
			final int[] invalid = {0};
			final int[] invalid2 = {0};
			Button1.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					if(invalid[0] ==1 && invalid2[0] ==1) //make sure the user doesn't click the button multiple times.
					{
					JOptionPane.showMessageDialog(null, "You may only edit one animal at a time.");
					}
					for(int i = 0; i < size; i++)
					{
						if(theZoo.get(i).getName().matches(nameInput.getText().trim().toLowerCase()) &&(!(invalid2[0] ==1)))
							{
							invalid2[0] =1;
							pass[0] = 1;
							Label Instructions2 = new Label("List all the foods your " + nameInput.getText().trim().toLowerCase() + " eats");
							pane.add(Instructions2,0,2);
							TextField foodInput = new TextField();
							pane.add(foodInput,1,2);
							final int temp = i;
							foodInput.lengthProperty().addListener(new ChangeListener<Number>() {
					            public void changed(ObservableValue<? extends Number> observable,
					                    Number oldValue, Number newValue) {
					                if (newValue.intValue() > oldValue.intValue()) {
					                    // Check if the new character is greater than LIMIT
					                    if (foodInput.getText().length() >= (LIMIT+40)) {

					                        // if it's 20th character then just setText to previous
					                        // one
					                        foodInput.setText(foodInput.getText().substring(0, (LIMIT+40)));
					                    }
					                }
					            }
					        });
							Button Button2 = new Button("Save");
							pane.add(Button2, 1,3);
							Button2.setOnAction(new EventHandler<ActionEvent>(){
								public void handle(ActionEvent e)
								{
									foodInput.setText(foodInput.getText().trim().toLowerCase());
									theZoo.get(temp).setFood(foodInput.getText());
									creator.setTheZoo(theZoo);
									try {
										Menu(SetFoods);
									} catch (FileNotFoundException e2) {
										// TODO Auto-generated catch block
										e2.printStackTrace();
									}
									try 
									{
										creator.Save(); 
									} 
									catch (FileNotFoundException e1) // Handle incident where the save file is missing.
									{ 
										// TODO Auto-generated catch block
										e1.printStackTrace();
										JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry."); // Gracious error message.
									}
								}
								});
							}
						
					}
					invalid[0] =1;
					if(!(pass[0] == 1))
					{
						JOptionPane.showMessageDialog(null, "This animal doesn't exist, sorry.");
					}
				}
			});	
			Button Button4 = new Button("Return Home");
			pane.add(Button4, 1,4);
			Button4.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					try {
						Menu(SetFoods);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			}
		public void FindFoods(Stage findFood) // Method to search for the requested animals diet.
		{
			findFood.setTitle("Get Foods");
	        GridPane pane = new GridPane();
	        Scene scene = new Scene(pane, 1280, 800);
	        pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11, 12, 13, 14));
			pane.setHgap(15);
			pane.setVgap(15);
	        findFood.setScene(scene);
	        findFood.show();
		    int size = theZoo.size();
		    Label Instructions = new Label("Please enter an animal name:");
			pane.add(Instructions,0,0);
			TextField nameInput = new TextField();
			pane.add(nameInput,1,0);
			nameInput.lengthProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (nameInput.getText().length() >= LIMIT) {

	                        // if it's 20th character then just setText to previous
	                        // one
	                        nameInput.setText(nameInput.getText().substring(0, LIMIT));
	                    }
	                }
	            }
	        });
			Button Button2 = new Button("Show Food");
			pane.add(Button2, 1,1);
			Label Instructions2 = new Label("");
			pane.add(Instructions2,1,2);
			final int pass[] = {0};
			Button2.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					for(int i = 0; i < size; i++)
					{
						if(theZoo.get(i).getName().matches(nameInput.getText().trim().toLowerCase()))
						{
							pass[0] = 1;
							Instructions2.setText("");
							Instructions2.setText("The " + nameInput.getText().trim().toLowerCase() + " eats " + theZoo.get(i).getFood() + ".");
						}
					}
					if(!(pass[0] == 1))
					{
						JOptionPane.showMessageDialog(null, "This animal doesn't exist, sorry.");
					}
				}
			});
			Button Button1 = new Button("Return Home");
			pane.add(Button1, 1,3);
			Button1.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					try {
						Menu(findFood);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		public void FindTerrain(Stage FindTerrain) // Method to search the for the requested animals terrain. User must set terrain first.
		{
			FindTerrain.setTitle("View Terrain");
			GridPane pane = new GridPane();
			//using a grid to keep things organized.
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11, 12, 13, 14));
			pane.setHgap(15);
			pane.setVgap(15);
			//scene
			Scene scene = new Scene(pane, 1400, 800);
			FindTerrain.setTitle("View Terrain"); // Set the stage title
			FindTerrain.setScene(scene); // Place the scene in the stage
			FindTerrain.show(); // Display the stage
			Label Instructions = new Label("Which animal's biome do you want to see?");
			pane.add(Instructions,0,0);
			TextField nameInput = new TextField();
			pane.add(nameInput,1,0);
			nameInput.lengthProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (nameInput.getText().length() >= LIMIT) {

	                        // if it's 20th character then just setText to previous
	                        // one
	                        nameInput.setText(nameInput.getText().substring(0, LIMIT));
	                    }
	                }
	            }
	        });
			int fsize = aforest.size();
			int msize = aMountain.size();
			int smsize = aSnowyMountain.size();
			final int[] invalid = {0};
			final int[] invalid2 = {0};
			final int pass[] = {0};
			//get the size of my terrain arrays for the loops.
			Button Button2 = new Button("Show Me");
			pane.add(Button2, 1,1);
			Label Instructions2 = new Label("");
			pane.add(Instructions2,1,2);
			Button2.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					for(int i = 0; i < fsize; i++)
					{
						if(aforest.get(i).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase()))
						{
							invalid2[0] =1;
							pass[0] = 1;
							Instructions2.setText("");
							Instructions2.setText("The " + nameInput.getText().trim().toLowerCase() + " lives in " + aforest.get(i).aString());
						}
					}
					for(int j = 0; j < msize; j++)
					{
						if(aMountain.get(j).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase()))
						{
							invalid2[0] =1;
							pass[0] = 1;
							Instructions2.setText("");
							Instructions2.setText("The " + nameInput.getText().trim().toLowerCase() + " lives in " + aMountain.get(j).aString());
						}
					}
					for(int k = 0; k < smsize; k ++)
					{
						if(aSnowyMountain.get(k).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase()))
						{
							invalid2[0] =1;
							pass[0] = 1;
							Instructions2.setText("");
							Instructions2.setText("The " + nameInput.getText().trim().toLowerCase() + " lives in " + aSnowyMountain.get(k).aString());
						}
					}
				if(!(pass[0] == 1))
				{
					JOptionPane.showMessageDialog(null, "This animal's specific terrain hasn't been set yet.");
				}
			}
			});
			Button Button3 = new Button("Return Home");
			pane.add(Button3, 1,3);
			Button3.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
					try {
						Menu(FindTerrain);
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try 
					{
						creator.Save(); 
					} 
					catch (FileNotFoundException e1) // Handle incident where the save file is missing.
					{ 
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry.\n"); // Gracious error message.
					}
				}
				});
		}
		public void SpecificTerrain(Stage SpecificTerrain) //Set terrain, It's basically a massive html form.
		{
			SpecificTerrain.setTitle("View Terrain");
			GridPane pane = new GridPane();
			//using a grid to keep things organized.
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11, 12, 13, 14));
			pane.setHgap(15);
			pane.setVgap(15);
			//scene
			Scene scene = new Scene(pane, 1280, 800);
			SpecificTerrain.setTitle("Specify Terrain"); // Set the stage title
			SpecificTerrain.setScene(scene); // Place the scene in the stage
			SpecificTerrain.show(); // Display the stage
			Label Instructions = new Label("Which animal do you want to specify the terrain for?");
			pane.add(Instructions,0,0);
			TextField nameInput = new TextField();
			pane.add(nameInput,1,0);
			nameInput.lengthProperty().addListener(new ChangeListener<Number>() {
	            public void changed(ObservableValue<? extends Number> observable,
	                    Number oldValue, Number newValue) {
	                if (newValue.intValue() > oldValue.intValue()) {
	                    // Check if the new character is greater than LIMIT
	                    if (nameInput.getText().length() >= LIMIT) {

	                        // if it's 20th character then just setText to previous
	                        // one
	                        nameInput.setText(nameInput.getText().substring(0, LIMIT));
	                    }
	                }
	            }
	        });
			int zsize = theZoo.size();
			int fsize = aforest.size();
			int msize = aMountain.size();
			int smsize = aSnowyMountain.size();
			//set the size for the terrain array loops.
			final int[] intPass = {0}; //make sure the user gives an int for those fields.
			final int[] pass = {0}; // Set a flag to determine if the user finds an animal post loop.
			final int[] blank = {0};
					Label choose = new Label("Fill out one of the Terrain forms bellow:");
					GridPane.setHalignment(choose, HPos.RIGHT);
					pane.add(choose,1,1);
					Label Instructions2 = new Label("Forest Name: ");
					pane.add(Instructions2,0,2);
					TextField fNameInput = new TextField();
					pane.add(fNameInput,1,2);
					fNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
				            public void changed(ObservableValue<? extends Number> observable,
				                    Number oldValue, Number newValue) {
				                if (newValue.intValue() > oldValue.intValue()) {
				                    // Check if the new character is greater than LIMIT
				                    if (fNameInput.getText().length() >= LIMIT) {

				                        // if it's 20th character then just setText to previous
				                        // one
				                        fNameInput.setText(fNameInput.getText().substring(0, LIMIT));
				                    }
				                }
				            }
				        });
					Label Instructions3 = new Label("Climate (hot, cold, ect): ");
					pane.add(Instructions3,0,3);
					TextField cliNameInput = new TextField();
					pane.add(cliNameInput,1,3);
					cliNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
				            public void changed(ObservableValue<? extends Number> observable,
				                    Number oldValue, Number newValue) {
				                if (newValue.intValue() > oldValue.intValue()) {
				                    // Check if the new character is greater than LIMIT
				                    if (cliNameInput.getText().length() >= LIMIT) {

				                        // if it's 20th character then just setText to previous
				                        // one
				                        cliNameInput.setText(cliNameInput.getText().substring(0, LIMIT));
				                    }
				                }
				            }
				        });
					Label Instructions4 = new Label("Density (sparse, populated, ect): ");
					pane.add(Instructions4,0,4);
					TextField dNameInput = new TextField();
					pane.add(dNameInput,1,4);
					dNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
				            public void changed(ObservableValue<? extends Number> observable,
				                    Number oldValue, Number newValue) {
				                if (newValue.intValue() > oldValue.intValue()) {
				                    // Check if the new character is greater than LIMIT
				                    if (dNameInput.getText().length() >= LIMIT) {

				                        // if it's 20th character then just setText to previous
				                        // one
				                        dNameInput.setText(dNameInput.getText().substring(0, LIMIT));
				                    }
				                }
				            }
				        });
					Label Instructions5 = new Label("Average rain in inches: ");
					pane.add(Instructions5,0,5);
					TextField rNameInput = new TextField();
					pane.add(rNameInput,1,5);
					rNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
				            public void changed(ObservableValue<? extends Number> observable,
				                    Number oldValue, Number newValue) {
				                if (newValue.intValue() > oldValue.intValue()) {
				                    // Check if the new character is greater than LIMIT
				                    if (rNameInput.getText().length() >= LIMIT) {

				                        // if it's 20th character then just setText to previous
				                        // one
				                        rNameInput.setText(rNameInput.getText().substring(0, LIMIT));
				                    }
				                }
				            }
				        });
					Button Button1 = new Button("Save");
					pane.add(Button1, 1,6);
					final int[] fpass = {0};
					final int[] fposition = {0};
					Button1.setOnAction(new EventHandler<ActionEvent>(){
						public void handle(ActionEvent e)
						{
							while((intPass[0] == 0) && (!(rNameInput.getText().equals("")))) //keep the user in a loop until i get a number.
							{
								try {
									Integer.parseInt(rNameInput.getText());
									if(Integer.parseInt(rNameInput.getText()) >= 0)
										{
											intPass[0] = 1;
										}
									else
									{
										rNameInput.setText("");
										JOptionPane.showMessageDialog(null, "You need to enter a postive number.");
									}
										
								}
								catch(NumberFormatException exception)
								{
									rNameInput.setText("");
									intPass[0] = 0;
									JOptionPane.showMessageDialog(null, "You need to enter a number.");
								}
							}
							if(intPass[0] == 1 && (!(fNameInput.getText().trim().toLowerCase().equals("")))
									&& (!(cliNameInput.getText().trim().toLowerCase().equals(""))) && (!(dNameInput.getText().trim().toLowerCase().equals(""))) &&
									(!(rNameInput.getText().trim().toLowerCase().equals(""))))
							{
								blank[0] = 1;
								for(int i = 0; i < zsize; i++)
								{
									if(theZoo.get(i).getName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase()))
									{
										pass[0] = 1;
										fposition[0] = i;
										for(int ik =0; ik <fsize; ik++)
										{
											if(aforest.get(ik).getAnimalName().matches(nameInput.getText().trim().toLowerCase()))
											{
												fpass[0] = 1;
												//let the program know it's in the forest terrain, so it doesn't check the others.
												fNameInput.setText(fNameInput.getText().trim().toLowerCase());
												cliNameInput.setText(cliNameInput.getText().trim().toLowerCase());
												dNameInput.setText(dNameInput.getText().trim().toLowerCase());
												rNameInput.setText(rNameInput.getText().trim().toLowerCase());
												aforest.get(ik).setName(fNameInput.getText());
												aforest.get(ik).setClimate(cliNameInput.getText());
												aforest.get(ik).setDensity(dNameInput.getText());
												aforest.get(ik).setAverageRainfall(Integer.parseInt(rNameInput.getText().trim().toLowerCase()));
												fcreator.setTheForest(aforest);
												theZoo.get(i).setTerrain("forest");
												creator.setTheZoo(theZoo);
												try {
													Menu(SpecificTerrain);
												} catch (FileNotFoundException e2) {
													// TODO Auto-generated catch block
													e2.printStackTrace();
												}
												try 
												{
													fcreator.Save();
													mcreator.Save();
													smcreator.Save();
													creator.Save();
												} 
												catch (FileNotFoundException e1) // Handle incident where the save file is missing.
												{ 
													// TODO Auto-generated catch block
													e1.printStackTrace();
													JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry."); // Gracious error message.
												}
											}
										}
										
									}
								}
							}
							else if(((fNameInput.getText().trim().toLowerCase().equals(""))) || ((cliNameInput.getText().trim().toLowerCase().equals(""))) 
									|| ((dNameInput.getText().trim().toLowerCase().equals(""))) || ((rNameInput.getText().trim().toLowerCase().equals(""))))
							{
								JOptionPane.showMessageDialog(null, "You need to fill in all the data fields.");
							}
							if((!(fpass[0] == 1)) && (pass[0] == 1) && intPass[0] == 1)
							{
								for(int xx = 0; xx <msize; xx++)
								{
									if((aMountain.get(xx).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase())))
									{
										aMountain.remove(xx);
										//remove it from mountain if it's there.
									}
									
								}
								for(int yy = 0; yy < smsize; yy++)
								{
									if((aSnowyMountain.get(yy).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase())))
									{
										aSnowyMountain.remove(yy);
										//remove it from snowy mountain if its there.
									}
								}
								nameInput.setText(nameInput.getText().trim().toLowerCase());
								fNameInput.setText(fNameInput.getText().trim().toLowerCase());
								cliNameInput.setText(cliNameInput.getText().trim().toLowerCase());
								dNameInput.setText(dNameInput.getText().trim().toLowerCase());
								rNameInput.setText(rNameInput.getText().trim().toLowerCase());
								final int temp = (Integer.parseInt(rNameInput.getText()));
								aforest.add(new Forest(nameInput.getText(), fNameInput.getText(), cliNameInput.getText(), dNameInput.getText(), temp));
								final int temp2 = fposition[0];
								theZoo.get(temp2).setTerrain("forest");
								creator.setTheZoo(theZoo);
								fcreator.setTheForest(aforest);
								try {
									Menu(SpecificTerrain);
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								try 
								{
									fcreator.Save();
									mcreator.Save();
									smcreator.Save();
									creator.Save();
								} 
								catch (FileNotFoundException e1) // Handle incident where the save file is missing.
								{ 
									// TODO Auto-generated catch block
									e1.printStackTrace();
									JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry."); // Gracious error message.
								}
							}
							
							if(!(pass[0] == 1) && (intPass[0] == 1) && (blank[0] == 1))
							{
								JOptionPane.showMessageDialog(null, "This animal doesn't exist, sorry.");
								blank[0] = 0;
							}
						}
						});															
																					//Mountains Start HERE
				Label Instructions6 = new Label("Mountain Name: ");
				pane.add(Instructions6,2,2);
				TextField mNameInput = new TextField();
				pane.add(mNameInput,3,2);
				mNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> observable,
			                    Number oldValue, Number newValue) {
			                if (newValue.intValue() > oldValue.intValue()) {
			                    // Check if the new character is greater than LIMIT
			                    if (mNameInput.getText().length() >= LIMIT) {

			                        // if it's 20th character then just setText to previous
			                        // one
			                        mNameInput.setText(mNameInput.getText().substring(0, LIMIT));
			                    }
			                }
			            }
			        });
				Label Instructions7 = new Label("Climate (hot, cold, ect): ");
				pane.add(Instructions7,2,3);
				TextField mCliNameInput = new TextField();
				pane.add(mCliNameInput,3,3);
				mCliNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> observable,
			                    Number oldValue, Number newValue) {
			                if (newValue.intValue() > oldValue.intValue()) {
			                    // Check if the new character is greater than LIMIT
			                    if (mCliNameInput.getText().length() >= LIMIT) {

			                        // if it's 20th character then just setText to previous
			                        // one
			                        mCliNameInput.setText(mCliNameInput.getText().substring(0, LIMIT));
			                    }
			                }
			            }
			        });
				Label Instructions8 = new Label("Density (sparse, populated, ect): ");
				pane.add(Instructions8,2,4);
				TextField mDNameInput = new TextField();
				pane.add(mDNameInput,3,4);
				mDNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> observable,
			                    Number oldValue, Number newValue) {
			                if (newValue.intValue() > oldValue.intValue()) {
			                    // Check if the new character is greater than LIMIT
			                    if (mDNameInput.getText().length() >= LIMIT) {

			                        // if it's 20th character then just setText to previous
			                        // one
			                        mDNameInput.setText(mDNameInput.getText().substring(0, LIMIT));
			                    }
			                }
			            }
			        });
				Label Instructions9 = new Label("Months climable: ");
				pane.add(Instructions9,2,5);
				TextField cNameInput = new TextField();
				pane.add(cNameInput,3,5);
				cNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> observable,
			                    Number oldValue, Number newValue) {
			                if (newValue.intValue() > oldValue.intValue()) {
			                    // Check if the new character is greater than LIMIT
			                    if (cNameInput.getText().length() >= LIMIT) {

			                        // if it's 20th character then just setText to previous
			                        // one
			                        cNameInput.setText(cNameInput.getText().substring(0, LIMIT));
			                    }
			                }
			            }
			        });
				Button Button2 = new Button("Save");
				final int[] mpass = {0};
				final int[] mposition = {0};
				final int[] monthPass = {0};
				pane.add(Button2, 3,6);
				Button2.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent e)
					{
						while((intPass[0] == 0) && (!(cNameInput.getText().equals("")))) //keep the user in a loop until i get a valid number.
						{
							try {
								Integer.parseInt(cNameInput.getText());
								if((Integer.parseInt(cNameInput.getText()) <= 12) && (Integer.parseInt(cNameInput.getText()) >= 0))
									{
									intPass[0] = 1;
									}
								else
									cNameInput.setText("");
							}
							catch(NumberFormatException exception)
							{
								cNameInput.setText("");
								intPass[0] = 0;
								JOptionPane.showMessageDialog(null, "You need to enter a number between 0 and 12.");
							}
						}
						if(intPass[0] == 1)
						{
							monthPass[0] = 1;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Set the months between 0 and 12.");
						}
						if(monthPass[0] == 1 && (!(mNameInput.getText().trim().toLowerCase().equals("")))
								&& (!(mCliNameInput.getText().trim().toLowerCase().equals(""))) && (!(mDNameInput.getText().trim().toLowerCase().equals(""))) &&
								(!(cNameInput.getText().trim().toLowerCase().equals(""))))
						{
							blank[0] = 1;
							for(int j = 0; j < zsize; j++)
							{
								if(theZoo.get(j).getName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase()))
								{
									pass[0]=1;
									mposition[0] = j;
									for(int jk = 0; jk <msize; jk++)
									{
										if((aMountain.get(jk).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase())) && (monthPass[0] == 1))
										{
											mpass[0] = 1;
											nameInput.setText(nameInput.getText().trim().toLowerCase());
											mNameInput.setText(mNameInput.getText().trim().toLowerCase());
											mCliNameInput.setText(mCliNameInput.getText().trim().toLowerCase());
											mDNameInput.setText(mDNameInput.getText().trim().toLowerCase());
											cNameInput.setText(cNameInput.getText().trim().toLowerCase());
											aMountain.get(jk).setName(mNameInput.getText());
											aMountain.get(jk).setClimate(mCliNameInput.getText());
											aMountain.get(jk).setDensity(mDNameInput.getText());
											aMountain.get(jk).setMonthsClimable(Integer.parseInt(cNameInput.getText()));
											mcreator.setTheMountain(aMountain);
											theZoo.get(j).setTerrain("mountain");
											creator.setTheZoo(theZoo);
											try {
												Menu(SpecificTerrain);
											} catch (FileNotFoundException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
											try 
											{
												fcreator.Save();
												mcreator.Save();
												smcreator.Save();
												creator.Save();
											} 
											catch (FileNotFoundException e1) // Handle incident where the save file is missing.
											{ 
												// TODO Auto-generated catch block
												e1.printStackTrace();
												JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry."); // Gracious error message.
											}
											try {
												creator.Save();
											} catch (FileNotFoundException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
												JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry.");
											}
										}
									}
								}
							}
						}
						else if(((mNameInput.getText().trim().toLowerCase().equals(""))) || ((mCliNameInput.getText().trim().toLowerCase().equals(""))) 
								|| ((mDNameInput.getText().trim().toLowerCase().equals(""))) || ((cNameInput.getText().trim().toLowerCase().equals(""))))
						{
							JOptionPane.showMessageDialog(null, "You need to fill in all the data fields.");
						}
						if(!(mpass[0] ==1) && (pass[0] ==1) && (monthPass[0] ==1))
						{
							for(int xx = 0; xx <fsize; xx++)
							{
								if((aforest.get(xx).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase())))
								{
									aforest.remove(xx);
									//remove from forest.
								}
							}
							for(int yy = 0; yy < smsize; yy++)
							{
								if((aSnowyMountain.get(yy).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase())))
								{
									aSnowyMountain.remove(yy);
									//remove from snowymountain.
								}
							}
							if((pass[0] == 1) && (monthPass[0] == 1))
							{
								nameInput.setText(nameInput.getText().trim().toLowerCase());
								mNameInput.setText(mNameInput.getText().trim().toLowerCase());
								mCliNameInput.setText(mCliNameInput.getText().trim().toLowerCase());
								mDNameInput.setText(mDNameInput.getText().trim().toLowerCase());
								cNameInput.setText(cNameInput.getText().trim().toLowerCase());
								final int temp = (Integer.parseInt(cNameInput.getText()));
								aMountain.add(new Mountain(nameInput.getText(), mNameInput.getText(), mCliNameInput.getText(), mDNameInput.getText(), temp));
								final int temp2 = mposition[0];
								theZoo.get(temp2).setTerrain("mountain");
								creator.setTheZoo(theZoo);
								mcreator.setTheMountain(aMountain);
								try {
									Menu(SpecificTerrain);
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								try 
								{
									fcreator.Save();
									mcreator.Save();
									smcreator.Save();
									creator.Save();
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
									JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry.");
								}
							}
						}
						if(!(pass[0] == 1) && (monthPass[0] == 1) && (blank[0] == 1))
						{
							JOptionPane.showMessageDialog(null, "This animal doesn't exist, sorry.");
							blank[0] = 0;
						}
					}
					});
															//Snowy Mountains start here
				Label Instructions10 = new Label("Snowy Mountain Name: ");
				pane.add(Instructions10,4,2);
				TextField smNameInput = new TextField();
				pane.add(smNameInput,5,2);
				smNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> observable,
			                    Number oldValue, Number newValue) {
			                if (newValue.intValue() > oldValue.intValue()) {
			                    // Check if the new character is greater than LIMIT
			                    if (smNameInput.getText().length() >= LIMIT) {

			                        // if it's 20th character then just setText to previous
			                        // one
			                        smNameInput.setText(smNameInput.getText().substring(0, LIMIT));
			                    }
			                }
			            }
			        });
				Label Instructions11 = new Label("Climate (hot, cold, ect): ");
				pane.add(Instructions11,4,3);
				TextField smCliNameInput = new TextField();
				pane.add(smCliNameInput,5,3);
				smCliNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> observable,
			                    Number oldValue, Number newValue) {
			                if (newValue.intValue() > oldValue.intValue()) {
			                    // Check if the new character is greater than LIMIT
			                    if (smCliNameInput.getText().length() >= LIMIT) {

			                        // if it's 20th character then just setText to previous
			                        // one
			                        smCliNameInput.setText(mCliNameInput.getText().substring(0, LIMIT));
			                    }
			                }
			            }
			        });
				Label Instructions12 = new Label("Density (sparse, populated, ect): ");
				pane.add(Instructions12,4,4);
				TextField smDNameInput = new TextField();
				pane.add(smDNameInput,5,4);
				smDNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> observable,
			                    Number oldValue, Number newValue) {
			                if (newValue.intValue() > oldValue.intValue()) {
			                    // Check if the new character is greater than LIMIT
			                    if (smDNameInput.getText().length() >= LIMIT) {

			                        // if it's 20th character then just setText to previous
			                        // one
			                        smDNameInput.setText(smDNameInput.getText().substring(0, LIMIT));
			                    }
			                }
			            }
			        });
				Label Instructions13 = new Label("Months climable: ");
				pane.add(Instructions13,4,5);
				TextField scNameInput = new TextField();
				pane.add(scNameInput,5,5);
				scNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> observable,
			                    Number oldValue, Number newValue) {
			                if (newValue.intValue() > oldValue.intValue()) {
			                    // Check if the new character is greater than LIMIT
			                    if (scNameInput.getText().length() >= LIMIT) {

			                        // if it's 20th character then just setText to previous
			                        // one
			                        scNameInput.setText(scNameInput.getText().substring(0, LIMIT));
			                    }
			                }
			            }
			        });
				Label Instructions14 = new Label("Blizzard Warning Months: ");
				pane.add(Instructions14,4,6);
				TextField sBCNameInput = new TextField();
				pane.add(sBCNameInput,5,6);
				sBCNameInput.lengthProperty().addListener(new ChangeListener<Number>() {
			            public void changed(ObservableValue<? extends Number> observable,
			                    Number oldValue, Number newValue) {
			                if (newValue.intValue() > oldValue.intValue()) {
			                    // Check if the new character is greater than LIMIT
			                    if (sBCNameInput.getText().length() >= LIMIT) {

			                        // if it's 20th character then just setText to previous
			                        // one
			                        sBCNameInput.setText(sBCNameInput.getText().substring(0, LIMIT));
			                    }
			                }
			            }
			        });
				Button Button3 = new Button("Save");
				pane.add(Button3, 5,7);
				final int[] smpass = {0};
				final int[] smposition = {0};
				final int[] sMonthPass = {0};
				Button3.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent e)
					{
						while((intPass[0] == 0) && (!(scNameInput.getText().equals("")))) //keep the user in a loop until i get a valid number.
						{
							try {
								Integer.parseInt(scNameInput.getText());
								Integer.parseInt(sBCNameInput.getText());
								if((Integer.parseInt(scNameInput.getText()) <= 12) && (Integer.parseInt(scNameInput.getText()) >= 0) 
										&& (Integer.parseInt(sBCNameInput.getText()) <= 12) && (Integer.parseInt(sBCNameInput.getText()) >= 0))
									{
									intPass[0] = 1;
									}
								else
									{
										scNameInput.setText("");
										sBCNameInput.setText("");
									}
							}
							catch(NumberFormatException exception)
							{
								scNameInput.setText("");
								sBCNameInput.setText("");
								intPass[0] = 0;
								JOptionPane.showMessageDialog(null, "You need to enter a number between 0 and 12.");
							}
						}
						if(intPass[0] == 1)
						{
							sMonthPass[0] = 1;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Set the months between 0 and 12.");
						}
						if(sMonthPass[0] == 1 && (!(smNameInput.getText().trim().toLowerCase().equals("")))
								&& (!(smCliNameInput.getText().trim().toLowerCase().equals(""))) && (!(smDNameInput.getText().trim().toLowerCase().equals(""))) &&
								(!(scNameInput.getText().trim().toLowerCase().equals(""))) && (!(sBCNameInput.getText().trim().toLowerCase().equals(""))))
						{
							blank[0] = 1;
							for(int k = 0; k < zsize; k++)
							{
								if(theZoo.get(k).getName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase()))
								{
									pass[0]=1;
									smposition[0] = k;
									for(int kk = 0; kk <smsize; kk++)
										//make sure its an animal
									{
										if((aSnowyMountain.get(kk).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase())) && (sMonthPass[0] == 1))
										{
											smpass[0] = 1;
											nameInput.setText(nameInput.getText().trim().toLowerCase());
											smNameInput.setText(smNameInput.getText().trim().toLowerCase());
											smCliNameInput.setText(smCliNameInput.getText().trim().toLowerCase());
											smDNameInput.setText(smDNameInput.getText().trim().toLowerCase());
											scNameInput.setText(scNameInput.getText().trim().toLowerCase());
											sBCNameInput.setText(sBCNameInput.getText().trim().toLowerCase());
											aSnowyMountain.get(kk).setName(smNameInput.getText());
											aSnowyMountain.get(kk).setClimate(smCliNameInput.getText());
											aSnowyMountain.get(kk).setDensity(smDNameInput.getText());
											aSnowyMountain.get(kk).setMonthsClimable(Integer.parseInt(scNameInput.getText()));
											aSnowyMountain.get(kk).setMonthsClimable(Integer.parseInt(sBCNameInput.getText()));
											smcreator.setTheSnowyMountain(aSnowyMountain);
											theZoo.get(k).setTerrain("snowy mountain");
											creator.setTheZoo(theZoo);
											try {
												Menu(SpecificTerrain);
											} catch (FileNotFoundException e2) {
												// TODO Auto-generated catch block
												e2.printStackTrace();
											}
											try 
											{
												fcreator.Save();
												mcreator.Save();
												smcreator.Save();
												creator.Save();
											} 
											catch (FileNotFoundException e1) // Handle incident where the save file is missing.
											{ 
												// TODO Auto-generated catch block
												e1.printStackTrace();
												JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry."); // Gracious error message.
											}
										}
									}
								}
							}
						}
						else if(((smNameInput.getText().trim().toLowerCase().equals(""))) || ((smCliNameInput.getText().trim().toLowerCase().equals(""))) 
								|| ((smDNameInput.getText().trim().toLowerCase().equals(""))) || ((scNameInput.getText().trim().toLowerCase().equals(""))) 
								|| ((sBCNameInput.getText().trim().toLowerCase().equals(""))))
						{
							JOptionPane.showMessageDialog(null, "You need to fill in all the data fields.");
						}
						if(!(smpass[0]==1) && (pass[0]==1) && (sMonthPass[0] == 1)) //check if its in the forest or mountain
						{
							for(int xx = 0; xx <fsize; xx++)
							{
								if((aforest.get(xx).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase())))
								{
									aforest.remove(xx);
									//remove from forest
								}
							}
							for(int yy = 0; yy < msize; yy++)
							{
								if((aMountain.get(yy).getAnimalName().trim().toLowerCase().matches(nameInput.getText().trim().toLowerCase())))
								{
									aMountain.remove(yy);
									//remove from mountain.
								}
							}
							if((sMonthPass[0] == 1) && (pass[0] == 1))
							{
								nameInput.setText(nameInput.getText().trim().toLowerCase());
								smNameInput.setText(smNameInput.getText().trim().toLowerCase());
								smCliNameInput.setText(smCliNameInput.getText().trim().toLowerCase());
								smDNameInput.setText(smDNameInput.getText().trim().toLowerCase());
								scNameInput.setText(scNameInput.getText().trim().toLowerCase());
								sBCNameInput.setText(sBCNameInput.getText().trim().toLowerCase());
								final int temp = (Integer.parseInt(scNameInput.getText()));
								final int temp2 = (Integer.parseInt(sBCNameInput.getText()));
								final int temp3 = smposition[0];
								aSnowyMountain.add(new SnowyMountain(nameInput.getText(), smNameInput.getText(), smCliNameInput.getText(), smDNameInput.getText(), temp, temp2));
								theZoo.get(temp3).setTerrain("snowy mountain");
								creator.setTheZoo(theZoo);
								smcreator.setTheSnowyMountain(aSnowyMountain);
								try {
									Menu(SpecificTerrain);
								} catch (FileNotFoundException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								try 
								{
									fcreator.Save();
									mcreator.Save();
									smcreator.Save();
									creator.Save();
								} 
								catch (FileNotFoundException e1) // Handle incident where the save file is missing.
								{ 
									// TODO Auto-generated catch block
									e1.printStackTrace();
									JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry."); // Gracious error message.
								}
							}
						}
						if(!(pass[0] == 1) && (intPass[0] ==1) && (blank[0] == 1))
						{
							JOptionPane.showMessageDialog(null, "This animal doesn't exist, sorry.");
							blank[0] = 0;
						}
					}
					});
				Button Button4 = new Button("Return Home");
				pane.add(Button4, 5,8);
				Button4.setOnAction(new EventHandler<ActionEvent>(){
					public void handle(ActionEvent e)
					{
						try {
							Menu(SpecificTerrain);
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try 
						{
							creator.Save(); 
						} 
						catch (FileNotFoundException e1) // Handle incident where the save file is missing.
						{ 
							// TODO Auto-generated catch block
							e1.printStackTrace();
							JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry.\n"); // Gracious error message.
						}
					}
					});

		}
		public void Menu(Stage menu) throws FileNotFoundException // main menu.
			{
			GridPane pane = new GridPane();
			BorderPane border = new BorderPane();
			border.setPadding(new Insets(11, 12, 13, 14));
			HBox banner = new HBox();
			border.setTop(banner);
			border.setCenter(pane);
			//using a grid to keep things organized.
			//using boarderPane for the image.
			pane.setAlignment(Pos.CENTER);
			pane.setPadding(new Insets(11, 12, 13, 14));
			pane.setHgap(15);
			pane.setVgap(15);
			//scene
			Scene scene = new Scene(border, 1280, 800);
			menu.setTitle("Simple JavaFX Program"); // Set the stage title
			menu.setScene(scene); // Place the scene in the stage
			menu.show(); // Display the stage
			//label
			ImageView pictureView = new ImageView("file:images/thezoo.jpg");
			pictureView.setFitHeight(200);
			pictureView.setFitWidth(500);
			pictureView.setPreserveRatio(true);
			banner.getChildren().add(pictureView);
			Label Instructions1 = new Label("If you want to retrieve your animal list: ");
			pane.add(Instructions1,0,1);
			Label Instructions2 = new Label("If you want to add an animal: ");
			pane.add(Instructions2,0,2);
			Label Instructions3 = new Label("View the details of a specific animal: ");
			pane.add(Instructions3,0,3);
			Label Instructions4 = new Label("If you want to edit an animal's name and/or image: ");
			pane.add(Instructions4,0,4);
			Label Instructions5 = new Label("If you want to see what type of food an animal eats: ");
			pane.add(Instructions5,0,5);
			Label Instructions6 = new Label("If you want to edit the food(s) for an animal: ");
			pane.add(Instructions6,0,6);
			Label Instructions7 = new Label("If you want to see an animal's terrain: ");
			pane.add(Instructions7,0,7);
			Label Instructions8 = new Label("If you want to set specific details of an animal's terrain: ");
			pane.add(Instructions8,0,8);
			GridPane.setHalignment(Instructions1, HPos.RIGHT);
			GridPane.setHalignment(Instructions2, HPos.RIGHT);
			GridPane.setHalignment(Instructions3, HPos.RIGHT);
			GridPane.setHalignment(Instructions4, HPos.RIGHT);
			GridPane.setHalignment(Instructions5, HPos.RIGHT); 
			GridPane.setHalignment(Instructions6, HPos.RIGHT); 
			GridPane.setHalignment(Instructions7, HPos.RIGHT); 
			GridPane.setHalignment(Instructions8, HPos.RIGHT);
			Button Button1 = new Button("Animal List");
			pane.add(Button1, 1,1);
			Button1.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
				GetAnimals(menu);
				//view the animals.
				}
			});
			Button Button2 = new Button("Add Animal");
			pane.add(Button2, 1,2);
			Button2.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
				SetAnimals(menu);
				//set the animals.
				}
			});
			Button Button3 = new Button("View An Animal");
			pane.add(Button3, 1,3);
			Button3.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
				SpecificAnimal(menu);
				//view an Animal's details
				}
			});
			Button Button4 = new Button("Edit Animal");
			pane.add(Button4, 1,4);
			Button4.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
				EditName(menu);
				//edit Animals name and the picture flag
				}
			});
			Button Button5 = new Button("View Food");
			pane.add(Button5, 1,5);
			Button5.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
				FindFoods(menu);
				// find a diet
				}
			});
			Button Button6 = new Button("Edit Food");
			pane.add(Button6, 1,6);
			Button6.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
				SetFoods(menu);
				// Set a diet
				}
			});
			Button Button7 = new Button("View Terrain");
			pane.add(Button7, 1,7);
			Button7.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
				FindTerrain(menu); // view a terrain
				}
			});
			Button Button8 = new Button("Set Terrain");
			pane.add(Button8, 1,8);
			Button8.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e)
				{
				SpecificTerrain(menu); // associate an animal with a terrain object.
				}
			});
			try 
			{
				creator.Save(); 
			} 
			catch (FileNotFoundException e) // Handle incident where the save file is missing.
			{ 
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "This file doesn't exist, sorry."); // Gracious error message.
			}
		}
	}
	public void start(Stage MainStage) throws Exception 
	{
		GridPane pane = new GridPane();
		//using a grid to keep things organized.
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11, 12, 13, 14));
		pane.setHgap(15);
		pane.setVgap(15);
		//scene
		Scene scene = new Scene(pane, 1280, 800);
		MainStage.setTitle("Simple JavaFX Program"); // Set the stage title
		MainStage.setScene(scene); // Place the scene in the stage
		MainStage.show(); // Display the stage
		java.io.File file = new java.io.File("animals.json"); //grab file.
		Zoo MyZoo = new Zoo(); //make my zoo.
		if(file.length() == 0)
		{
			JOptionPane.showMessageDialog(null, "Welcome to the zoo program.\nCurrently we can support unlimited animals.\n"
					+"The animals must belong to a biome type of forest, mountain, or snowy mountain.\n" + "Make sure your animal images are in the images folder in the zoo program.");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Welcome back. Make sure your animal images are in the images folder of the zoo program.");
			MyZoo.FileAninmals(); //load an old set
		}
		MyZoo.Menu(MainStage); 
	}
}
