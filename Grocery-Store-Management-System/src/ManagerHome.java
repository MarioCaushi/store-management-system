import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ManagerHome {

	public static void loginManager(Stage primaryStage,TextField usernametxfl,TextField passwordtxfl)
	{
		//The beginning of the Manager's home page
		//Creating the layout
		
		BorderPane managerHomeBP=new BorderPane();
		
		//Button creation and styling
		Button managerHomeButton=new Button("Home");
		managerHomeButton.setPrefWidth(110);
		managerHomeButton.setPrefHeight(100);
		managerHomeButton.setStyle("-fx-background-color:transparent");

		    managerHomeButton.setOnMouseEntered(e -> managerHomeButton.setStyle("-fx-background-color: #7FB3D5; "));
		    managerHomeButton.setOnMouseExited(e -> managerHomeButton.setStyle("-fx-background-color: transparent "));
		    managerHomeButton.setOnMousePressed(e -> {
		        managerHomeButton.setStyle("-fx-background-color: #6699CC; -fx-text-fill: black; -fx-font-size:15;");
		    });
		    managerHomeButton.setOnMouseReleased(e -> {
		        managerHomeButton.setStyle("-fx-background-color: transparent; ");
		    });
		
	    
		Button managerInventoryButton=new Button("Inventory");
		managerInventoryButton.setPrefWidth(110);
		managerInventoryButton.setPrefHeight(100);
		managerInventoryButton.setStyle("-fx-background-color:transparent");
		
		managerInventoryButton.setOnMouseEntered(e ->managerInventoryButton.setStyle("-fx-background-color: #7FB3D5; "));
		managerInventoryButton.setOnMouseExited(e -> managerInventoryButton.setStyle("-fx-background-color: transparent "));
		managerInventoryButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			managerInventoryButton.setStyle("-fx-background-color: #6699CC; -fx-text-fill: black; -fx-font-size:15;");
        });
		managerInventoryButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			managerInventoryButton.setStyle("-fx-background-color:transparent; -fx-text-fill:black;");
        });
		
		
		Button managementButton=new Button("Management");
		managementButton.setPrefWidth(110);
		managementButton.setPrefHeight(100);
		managementButton.setStyle("-fx-background-color:transparent");
		
		managementButton.setOnMouseEntered(e -> managementButton.setStyle("-fx-background-color: #7FB3D5; "));
		managementButton.setOnMouseExited(e -> managementButton.setStyle("-fx-background-color: transparent "));
		managementButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			managementButton.setStyle("-fx-background-color: #6699CC; -fx-text-fill: black; -fx-font-size:15;");
        });
		managementButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			managementButton.setStyle("-fx-background-color:transparent; -fx-text-fill:black;");
        });
		
		
		Button managerSalesButton=new Button("Sales Report");
		managerSalesButton.setPrefWidth(110);
		managerSalesButton.setPrefHeight(100);
		managerSalesButton.setStyle("-fx-background-color:transparent");
		
		managerSalesButton.setOnMouseEntered(e -> managerSalesButton.setStyle("-fx-background-color: #7FB3D5; "));
		managerSalesButton.setOnMouseExited(e -> managerSalesButton.setStyle("-fx-background-color: transparent "));
		managerSalesButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			managerSalesButton.setStyle("-fx-background-color: #6699CC; -fx-text-fill: black; -fx-font-size:15;");
        });
		managerSalesButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			managerSalesButton.setStyle("-fx-background-color:transparent; -fx-text-fill:black;");
        });
		
		
		Button managerLoyaltyButton=new Button("Loyalty Program");
		managerLoyaltyButton.setPrefWidth(110);
		managerLoyaltyButton.setPrefHeight(100);
		managerLoyaltyButton.setStyle("-fx-background-color:transparent");
		
		managerLoyaltyButton.setOnMouseEntered(e -> managerLoyaltyButton.setStyle("-fx-background-color: #7FB3D5; "));
		managerLoyaltyButton.setOnMouseExited(e -> managerLoyaltyButton.setStyle("-fx-background-color: transparent "));
		managerLoyaltyButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			managerLoyaltyButton.setStyle("-fx-background-color: #6699CC; -fx-text-fill: black; -fx-font-size:15;");
        });
		managerLoyaltyButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			managerLoyaltyButton.setStyle("-fx-background-color:transparent; -fx-text-fill:black;");
        });
		
		
		//Creating a VBox to put the buttons in
		VBox managerSideMenu=new VBox();
		managerSideMenu.setStyle("-fx-background-color: #ADD8E6");
		
		managerSideMenu.getChildren().addAll(
				managerHomeButton,
				managerInventoryButton,
				managementButton,
				managerSalesButton,
				managerLoyaltyButton);
		
		//Creating the top of the page
		
//		Text managerRecognition=new Text("Hello, "+ usernametxfl.getText());
		
		 Label managerRecognition = new Label("Hello, "+usernametxfl.getText()); // Replace with your text
	        managerRecognition.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 0px; -fx-padding: 5px;");
	        managerRecognition.setMaxWidth(Double.MAX_VALUE); // Allow the label to expand horizontally
	        managerRecognition.setWrapText(true);
	        managerRecognition.setTextFill(Color.BLACK);
        
		Button logoutButton=new Button("Log Out");
		logoutButton.setStyle("-fx-background-color:#FFA07A; -fx-text-fill:white;");
		logoutButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			logoutButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		logoutButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			logoutButton.setStyle("-fx-background-color:#FFA07A; -fx-text-fill:white;");
        });
		
		HBox managerTopMenu=new HBox();
		managerTopMenu.getChildren().addAll(managerRecognition,logoutButton);
		managerTopMenu.setPadding(new Insets(10));
		managerTopMenu.setSpacing(10);
		managerTopMenu.setAlignment(Pos.TOP_RIGHT);
		managerTopMenu.setStyle("-fx-background-color: #ADD8E6");
		
		//Setting the VBox in the right place
		managerHomeBP.setLeft(managerSideMenu);
		managerHomeBP.setTop(managerTopMenu);
		
		//Creating a stage and a scene to put all these stuff on
		Stage managerPage=new Stage();
		Scene managerHome=new Scene(managerHomeBP,900,600);
		managerPage.setScene(managerHome);
		managerPage.setTitle("Manager Window");
		managerPage.setResizable(false);
		primaryStage.close();
		managerPage.show();
		Login.displaySuccessAlert("Attention!!","Manager information can only be edited at HomePage");
	
		Button[] buttons= {managerHomeButton,managerInventoryButton,managementButton,managerSalesButton,managerLoyaltyButton};	
		
	logoutButton.setOnAction(e ->logoutCaution(primaryStage,managerPage));
	
	Person person=GroceryStore.getCertainPerson(usernametxfl);
	
	int personIndex=GroceryStore.personList.indexOf(person);
	
	managerHomeButtonAction(personIndex,managerHomeBP, buttons);
	
	managerHomeButton.setOnAction(e -> {
		managerHomeButtonAction(personIndex,managerHomeBP, buttons);
	});
	
	managementButton.setOnAction(e -> {
		ManagerManagement.managementDeafultButtonAction(buttons,managerHomeBP, person);
	});
	
	managerInventoryButton.setOnAction(e -> {
		ManagerInventory.managerInventoryButtonAction( buttons, managerHomeBP,person);
	});
	
	managerLoyaltyButton.setOnAction(e -> {
		ManagerLoyaltyProgram.managerLoyaltyPointsButton( buttons,managerHomeBP,person);
	});
	
	managerSalesButton.setOnAction(e -> {
		SalesReport.salesButtonAction( managerHomeBP,buttons);
	});
	
	}
		
	
	
	//METHODS
	public static void logoutCaution(Stage primaryStage, Stage managerPage)
	{
	Stage stage=new Stage();
	stage.setTitle("Logout Message");
	Text text=new Text("Are You Sure?");
	Button button=new Button("Yes");
	button.setAlignment(Pos.CENTER);
	Button button1=new Button("No");
	button1.setAlignment(Pos.CENTER);
	HBox logoutPanel=new HBox();
	logoutPanel.getChildren().addAll(button,button1);
	logoutPanel.setSpacing(10);
	logoutPanel.setAlignment(Pos.CENTER);
	VBox pane=new VBox();
	pane.setAlignment(Pos.CENTER);
	pane.getChildren().addAll(text,logoutPanel);
	pane.setSpacing(10);
	Scene scene=new Scene(pane,300,100);
	stage.setScene(scene);
	stage.setAlwaysOnTop(true);
	stage.show();
	
	
	button.setOnAction(e -> {
		stage.close();
		managerPage.close();
		primaryStage.show();
	});
	
	button1.setOnAction(e -> {
		stage.close();
	});
	
	}
	
	//A method to view and edit the HomePage 
	public static void managerHomeButtonAction(int personIndex,BorderPane managerHomeBP,Button[] buttons)
	{
		buttons[0].setDisable(true);
		buttons[1].setDisable(false);
		buttons[2].setDisable(false);
		buttons[3].setDisable(false);
		buttons[4].setDisable(false);
		
		

		Person person=GroceryStore.personList.get(personIndex);
		
		VBox managerHomeVB=new VBox();
		
		TextField nametxfl=new TextField();
		nametxfl.setPrefColumnCount(1);
		nametxfl.setAlignment(Pos.BASELINE_LEFT);
		nametxfl.setPromptText(GroceryStore.personList.get(personIndex).getName());
		nametxfl.setPrefWidth(190);
		
		TextField surnametxfl=new TextField();
		surnametxfl.setPrefColumnCount(1);
		surnametxfl.setAlignment(Pos.BASELINE_LEFT);
		surnametxfl.setPromptText(GroceryStore.personList.get(personIndex).getSurname());
		surnametxfl.setPrefWidth(190);
		
		HBox firstRow =new HBox();
		firstRow.getChildren().addAll(nametxfl,surnametxfl);
		firstRow.setSpacing(20);
		
		
		TextField usernametxfl=new TextField();
		usernametxfl.setPrefColumnCount(1);
		usernametxfl.setAlignment(Pos.BASELINE_LEFT);
		usernametxfl.setPromptText(GroceryStore.personList.get(personIndex).getUsername());
		usernametxfl.setPrefWidth(400);
		
		HBox secondRow =new HBox();
		secondRow.getChildren().addAll(usernametxfl);
		
		
		 ComboBox<Integer> yearComboBox = Register.createComboBox(1900, 2030);
		 int year = GroceryStore.personList.get(personIndex).getYear();
		 yearComboBox.setPromptText("Year: "+String.valueOf(year));
		 
	     ComboBox<String> monthComboBox = new ComboBox<>();
	     int month=GroceryStore.personList.get(personIndex).getMonth();
	     monthComboBox.setPromptText("Month: "+String.valueOf(month));
	     monthComboBox.getItems().addAll
	     ("January", "February", "March", "April", "May", "June",
	      "July", "August", "September", "October", "November", "December");
	     
	     ComboBox<Integer> dayComboBox = Register.createComboBox(1, 31);
	     int day=GroceryStore.personList.get(personIndex).getDay();
	     dayComboBox.setPromptText("Day: "+String.valueOf(day));  	 
	     
	     HBox thirdRow =new HBox();
		thirdRow.getChildren().addAll(yearComboBox,monthComboBox,dayComboBox);
		thirdRow.setAlignment(Pos.BASELINE_LEFT);
		thirdRow.setSpacing(10);
		
	    TextField passwordtxfl=new TextField();
		passwordtxfl.setPrefColumnCount(1);
		passwordtxfl.setAlignment(Pos.BASELINE_LEFT);
		passwordtxfl.setPromptText(GroceryStore.personList.get(personIndex).getPassword());
		passwordtxfl.setPrefWidth(230);
		
		 HBox fourthRow =new HBox();
		fourthRow.getChildren().addAll(passwordtxfl);
		fourthRow.setSpacing(20);
		
		Label dateRegisteredLabel=new Label("Date Registered: "+GroceryStore.personList.get(personIndex).getDateRegistered());
		dateRegisteredLabel.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 0px; -fx-padding: 5px;");
		dateRegisteredLabel.setMaxWidth(Double.MAX_VALUE); // Allow the label to expand horizontally
		dateRegisteredLabel.setWrapText(true);
		dateRegisteredLabel.setTextFill(Color.BLACK);
		
		VBox userinputVB=new VBox();
		userinputVB.getChildren().addAll(firstRow,secondRow,thirdRow,fourthRow,dateRegisteredLabel);
		userinputVB.setSpacing(10);
		
		//THe buttons 
		
		Button editbutton=new Button("Edit");
		editbutton.setAlignment(Pos.CENTER);
		editbutton.setPrefWidth(150);
		editbutton.setStyle("-fx-background-color: #6699CC; -fx-text-fill: white;");
		
		editbutton.setOnMousePressed(e -> {
	            // Apply different style or effect when pressed
			editbutton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
		editbutton.setOnMouseReleased(e -> {
	            // Reset style when mouse is released
			editbutton.setStyle("-fx-background-color: #6699CC; -fx-text-fill: white;");
	        });
		
		ComboBox <String> chooseEditCB=new ComboBox<>();
		chooseEditCB.setPromptText("Choose to Edit");
		chooseEditCB.getItems().addAll("Name","Surname","Username","Birthday","Password","None");
		chooseEditCB.setPrefWidth(150);
		chooseEditCB.setStyle(  "-fx-background-color: #F5F5F5; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
		chooseEditCB.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			chooseEditCB.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		chooseEditCB.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			chooseEditCB.setStyle(  "-fx-background-color: #F5F5F5; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
        });
		
		 
		//Create VBOX to put the buttons in
		VBox loginButtonsPane=new VBox();
		loginButtonsPane.getChildren().addAll(editbutton,chooseEditCB);
		loginButtonsPane.setAlignment(Pos.CENTER);
		loginButtonsPane.setSpacing(10);
		
		
		managerHomeVB.getChildren().addAll(userinputVB,loginButtonsPane);
		managerHomeVB.setPadding(new Insets(140));
		managerHomeVB.setSpacing(20);
		
		managerHomeBP.setCenter(managerHomeVB);
		
		//Fixing the birthday buttons so the user enters the right date right from the beginning
		monthComboBox.setDisable(true);
		dayComboBox.setDisable(true);
		
		yearComboBox.setOnAction(e ->
		{
			if(yearComboBox.getValue()!=null)
			{
	     		monthComboBox.setDisable(false);
			}
		});
		
		monthComboBox.setOnAction(e ->
		{
			if(monthComboBox.getValue()!=null)
			{
				dayComboBox.setDisable(false);
			}
		});
				
		//Event handler to show the right amount of days corresponding to year and month
		dayComboBox.setOnMouseReleased(e -> {
		    int selectedYear = yearComboBox.getValue();
		    String selectedMonth = monthComboBox.getValue();

		    int maxDays = 31; // Default to 31 days

		    if (selectedMonth != null && selectedMonth.equals("February")) {
		        // Check for leap year
		        if ((selectedYear % 4 == 0) && ((selectedYear % 100 != 0) || (selectedYear % 400 == 0))) {
		            maxDays = 29; // Leap year, set max days in February to 29
		        } else {
		            maxDays = 28; // Non-leap year, set max days in February to 28
		        }
		    } else if (selectedMonth != null && (selectedMonth.equals("April") || selectedMonth.equals("June") ||
		                                        selectedMonth.equals("September") || selectedMonth.equals("November"))) {
		        maxDays = 30; // Months with 30 days
		    }

		    // Update dayComboBox with new values based on maxDays
		    dayComboBox.getItems().clear(); // Clear previous items
		    for (int i = 1; i <= maxDays; i++) {
		        dayComboBox.getItems().add(i); // Add days based on maxDays
		    }
		});
		
		
		nametxfl.setDisable(true);
		surnametxfl.setDisable(true);
		usernametxfl.setDisable(true);
		yearComboBox.setDisable(true);
		monthComboBox.setDisable(true);
		dayComboBox.setDisable(true);
		passwordtxfl.setDisable(true);
		editbutton.setDisable(true);
		
		chooseEditCB.setOnAction(e ->{
			if(chooseEditCB.getValue().equalsIgnoreCase("None"))
			{
				nametxfl.setDisable(true);
				surnametxfl.setDisable(true);
				usernametxfl.setDisable(true);
				yearComboBox.setDisable(true);
				monthComboBox.setDisable(true);
				dayComboBox.setDisable(true);
				passwordtxfl.setDisable(true);
				editbutton.setDisable(true);
			}
			else if (chooseEditCB.getValue().equalsIgnoreCase("Name")) {
			    nametxfl.setDisable(false);
			    surnametxfl.setDisable(true);
			    usernametxfl.setDisable(true);
			    yearComboBox.setDisable(true);
			    monthComboBox.setDisable(true);
			    dayComboBox.setDisable(true);
			    passwordtxfl.setDisable(true);
			    editbutton.setDisable(true);

			    nametxfl.setOnKeyTyped(e1 -> {
			        // Enable editbutton if the name field is not empty
			        editbutton.setDisable(nametxfl.getText().isEmpty());
			    });

			    editbutton.setOnAction(e1 -> {
			        String name = nametxfl.getText();
			        person.setName(name);
			        Login.displaySuccessAlert("Edit Message", "Name changed successfully");
			        GroceryStore.personList.set(personIndex, person);
			        GroceryStore.storeInPersonDatabase();
			        try {
						GroceryStore.openPersonDatabaseWithoutMessage();
					} catch (ClassNotFoundException | IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

			        // Reset the action of editbutton if needed
			        editbutton.setOnAction(null);
			    });
			}

			else if (chooseEditCB.getValue().equalsIgnoreCase("Surname")) {
			    nametxfl.setDisable(true);
			    surnametxfl.setDisable(false);
			    usernametxfl.setDisable(true);
			    yearComboBox.setDisable(true);
			    monthComboBox.setDisable(true);
			    dayComboBox.setDisable(true);
			    passwordtxfl.setDisable(true);
			    editbutton.setDisable(true);

			    surnametxfl.setOnKeyTyped(e1 -> {
			        // Enable editbutton if the surname field is not empty
			        editbutton.setDisable(surnametxfl.getText().isEmpty());
			    });

			    editbutton.setOnAction(e1 -> {
			        String surname = surnametxfl.getText();
			        person.setSurname(surname);
			        Login.displaySuccessAlert("Edit Message", "Surname changed successfully");
			        GroceryStore.personList.set(personIndex, person);
			        GroceryStore.storeInPersonDatabase();
			        try {
			        	GroceryStore.openPersonDatabaseWithoutMessage();
					} catch (ClassNotFoundException | IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

			        // Reset the action of editbutton if needed
			        editbutton.setOnAction(null);
			    });
			}

			else if (chooseEditCB.getValue().equalsIgnoreCase("Username")) {
			    nametxfl.setDisable(true);
			    surnametxfl.setDisable(true);
			    usernametxfl.setDisable(false);
			    yearComboBox.setDisable(true);
			    monthComboBox.setDisable(true);
			    dayComboBox.setDisable(true);
			    passwordtxfl.setDisable(true);
			    editbutton.setDisable(true);

			    usernametxfl.setOnKeyTyped(e1 -> {
			        // Enable editbutton if the username field is not empty
			        editbutton.setDisable(usernametxfl.getText().isEmpty());
			    });

			    editbutton.setOnAction(e1 -> {
			        String username1 = usernametxfl.getText();
			        boolean isValidUsername = Register.checkUsername(usernametxfl.getText());

			        if (!isValidUsername) {
			            person.setUsername(username1);
			            Login.displaySuccessAlert("Edit Message", "Username changed successfully");
			            GroceryStore.personList.set(personIndex, person);
			            GroceryStore.storeInPersonDatabase();
			            try {
			            	GroceryStore.openPersonDatabaseWithoutMessage();
						} catch (ClassNotFoundException | IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
			        } else {
			            Login.displayErrorAlert("Edit Message", "Username Invalid: Try Again!");
			        }

			        // Reset the action of editbutton if needed
			        editbutton.setOnAction(null);
			    });
			}

			else if (chooseEditCB.getValue().equalsIgnoreCase("Birthday")) {
			    // Enable/disable fields accordingly
			    nametxfl.setDisable(true);
			    surnametxfl.setDisable(true);
			    usernametxfl.setDisable(true);
			    yearComboBox.setDisable(false);
			    monthComboBox.setDisable(false);
			    dayComboBox.setDisable(false);
			    passwordtxfl.setDisable(true);
			    editbutton.setDisable(true);

			    // Action for year selection
			    yearComboBox.setOnAction(e1 -> {
			        if (yearComboBox.getValue() != null) {
			            int x = yearComboBox.getValue();

			            // Action for month selection
			            monthComboBox.setOnAction(e2 -> {
			                if (monthComboBox.getValue() != null) {
			                    int y = GroceryStore.convertMonthFromStringToInt(monthComboBox.getValue());

			                    // Action for day selection
			                    dayComboBox.setOnAction(e3 -> {
			                        if (dayComboBox.getValue() != null) {
			                            int z = dayComboBox.getValue();
			                            editbutton.setDisable(false);

			                            // Action for edit button
			                            editbutton.setOnAction(e4 -> {
			                                // On edit button click, update the person's birthday
			                                person.setDay(z);
			                                person.setMonth(y);
			                                person.setYear(x);
			                                Login.displaySuccessAlert("Edit Message", "Birthday changed successfully");
			                                GroceryStore.personList.set(personIndex, person);
			                                GroceryStore.storeInPersonDatabase();
			                                try {
			                                	GroceryStore.openPersonDatabaseWithoutMessage();
			            					} catch (ClassNotFoundException | IOException e5) {
			            						// TODO Auto-generated catch block
			            						e5.printStackTrace();
			            					}
			                                editbutton.setOnAction(null);
			                            });
			                        }
			                    });
			                }
			            });
			        }
			    });
			}
			else {
			    nametxfl.setDisable(true);
			    surnametxfl.setDisable(true);
			    usernametxfl.setDisable(true);
			    yearComboBox.setDisable(true);
			    monthComboBox.setDisable(true);
			    dayComboBox.setDisable(true);
			    passwordtxfl.setDisable(false);
			    editbutton.setDisable(true);

			      
			      
			        editbutton.setDisable(false);
			        editbutton.setOnAction(e4 -> {
			         String newpassword = passwordtxfl.getText();
			            // On edit button click, update the person's birthday
			            person.setPassword(newpassword);
			            Login.displaySuccessAlert("Edit Message", "New Password: " + person.getPassword());
			            GroceryStore.personList.set(personIndex, person);
			            GroceryStore.storeInPersonDatabase();
			            try {
			            	GroceryStore.openPersonDatabaseWithoutMessage();
						} catch (ClassNotFoundException | IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
			        });
			    }
		});
	}
	
}
