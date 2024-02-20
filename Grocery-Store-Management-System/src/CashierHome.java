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
import javafx.stage.Stage;

public class CashierHome {

	public static void loginCashier(Stage primaryStage,TextField usernametxfl,TextField passwordtxfl)
	{
		//The beginning of the Cashier's home page
				//Creating the layout
		
BorderPane cashierHomeBP=new BorderPane();
		
		//Button creation and styling
		Button cashierHomeButton=new Button("Home");
		cashierHomeButton.setPrefWidth(110);
		cashierHomeButton.setPrefHeight(100);
		cashierHomeButton.setStyle("-fx-background-color:transparent");

		    cashierHomeButton.setOnMouseEntered(e -> cashierHomeButton.setStyle("-fx-background-color: #A2CDC1; "));
		    cashierHomeButton.setOnMouseExited(e -> cashierHomeButton.setStyle("-fx-background-color: transparent "));
		    cashierHomeButton.setOnMousePressed(e -> {
		        cashierHomeButton.setStyle("-fx-background-color: #92B3A1; -fx-text-fill: black; -fx-font-size:15;");
		    });
		    cashierHomeButton.setOnMouseReleased(e -> {
		        cashierHomeButton.setStyle("-fx-background-color: transparent; ");
		    });
		
	    
		Button cashierInventoryButton=new Button("Inventory");
		cashierInventoryButton.setPrefWidth(110);
		cashierInventoryButton.setPrefHeight(100);
		cashierInventoryButton.setStyle("-fx-background-color:transparent");
		
		cashierInventoryButton.setOnMouseEntered(e ->cashierInventoryButton.setStyle("-fx-background-color: #A2CDC1; "));
		cashierInventoryButton.setOnMouseExited(e -> cashierInventoryButton.setStyle("-fx-background-color: transparent "));
		cashierInventoryButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			cashierInventoryButton.setStyle("-fx-background-color: #92B3A1; -fx-text-fill: black; -fx-font-size:15;");
        });
		cashierInventoryButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			cashierInventoryButton.setStyle("-fx-background-color:transparent; -fx-text-fill:black;");
        });
		
		
		Button managementButton=new Button("Management");
		managementButton.setPrefWidth(110);
		managementButton.setPrefHeight(100);
		managementButton.setStyle("-fx-background-color:transparent");
		
		managementButton.setOnMouseEntered(e -> managementButton.setStyle("-fx-background-color: #A2CDC1; "));
		managementButton.setOnMouseExited(e -> managementButton.setStyle("-fx-background-color: transparent "));
		managementButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			managementButton.setStyle("-fx-background-color: #92B3A1; -fx-text-fill: black; -fx-font-size:15;");
        });
		managementButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			managementButton.setStyle("-fx-background-color:transparent; -fx-text-fill:black;");
        });
		
		
		Button cashierSalesButton=new Button("Sales Report");
		cashierSalesButton.setPrefWidth(110);
		cashierSalesButton.setPrefHeight(100);
		cashierSalesButton.setStyle("-fx-background-color:transparent");
		
		cashierSalesButton.setOnMouseEntered(e -> cashierSalesButton.setStyle("-fx-background-color: #A2CDC1; "));
		cashierSalesButton.setOnMouseExited(e -> cashierSalesButton.setStyle("-fx-background-color: transparent "));
		cashierSalesButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			cashierSalesButton.setStyle("-fx-background-color:#92B3A1; -fx-text-fill: black; -fx-font-size:15;");
        });
		cashierSalesButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			cashierSalesButton.setStyle("-fx-background-color:transparent; -fx-text-fill:black;");
        });
		
		
		Button cashierPOSButton=new Button("Point of Sale");
		cashierPOSButton.setPrefWidth(110);
		cashierPOSButton.setPrefHeight(100);
		cashierPOSButton.setStyle("-fx-background-color:transparent");
		
		cashierPOSButton.setOnMouseEntered(e -> cashierPOSButton.setStyle("-fx-background-color: #A2CDC1; "));
		cashierPOSButton.setOnMouseExited(e -> cashierPOSButton.setStyle("-fx-background-color: transparent "));
		cashierPOSButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			cashierPOSButton.setStyle("-fx-background-color: #92B3A1; -fx-text-fill: black; -fx-font-size:15;");
        });
		cashierPOSButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			cashierPOSButton.setStyle("-fx-background-color:transparent; -fx-text-fill:black;");
        });
		
		
		//Creating a VBox to put the buttons in
		VBox cashierSideMenu=new VBox();
		cashierSideMenu.setStyle("-fx-background-color: #B0E0B0");
		
		cashierSideMenu.getChildren().addAll(
				cashierHomeButton,
				cashierInventoryButton,
				managementButton,
				cashierSalesButton,
				cashierPOSButton);
		
		//Creating the top of the page
		
//		Text cashierRecognition=new Text("Hello, "+ usernametxfl.getText());
		
		 Label cashierRecognition = new Label("Hello, "+usernametxfl.getText()); // Replace with your text
	        cashierRecognition.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 0px; -fx-padding: 5px;");
	        cashierRecognition.setMaxWidth(Double.MAX_VALUE); // Allow the label to expand horizontally
	        cashierRecognition.setWrapText(true);
	        cashierRecognition.setTextFill(Color.BLACK);
        
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
		
		HBox cashierTopMenu=new HBox();
		cashierTopMenu.getChildren().addAll(cashierRecognition,logoutButton);
		cashierTopMenu.setPadding(new Insets(10));
		cashierTopMenu.setSpacing(10);
		cashierTopMenu.setAlignment(Pos.TOP_RIGHT);
		cashierTopMenu.setStyle("-fx-background-color: #B0E0B0");
		
		//Setting the VBox in the right place
		cashierHomeBP.setLeft(cashierSideMenu);
		cashierHomeBP.setTop(cashierTopMenu);
		
		//Creating a stage and a scene to put all these stuff on
		Stage cashierPage=new Stage();
		Scene cashierHome=new Scene(cashierHomeBP,900,600);
		cashierPage.setScene(cashierHome);
		cashierPage.setTitle("Cashier Window");
		cashierPage.setResizable(false);
		primaryStage.close();
		cashierPage.show();
		
		Login.displaySuccessAlert("Attention!!","Cashier information can only be edited at HomePage\nTo edit Name and Surname contact a Manager");
	
		Button[] buttons= {cashierHomeButton,cashierInventoryButton,managementButton,cashierSalesButton,cashierPOSButton};	
		
	logoutButton.setOnAction(e ->ManagerHome.logoutCaution(primaryStage,cashierPage));
	
Person person=GroceryStore.getCertainPerson(usernametxfl);
	
	int personIndex=GroceryStore.personList.indexOf(person);
	
	cashierHomeButtonAction(personIndex,cashierHomeBP, buttons);
	
	cashierHomeButton.setOnAction(e -> {
		cashierHomeButtonAction(personIndex,cashierHomeBP, buttons);
	});
	
	cashierInventoryButton.setOnAction(e -> {
		ManagerInventory.managerInventoryButtonAction( buttons, cashierHomeBP,person);
	});
	
	managementButton.setOnAction(e -> {
		ManagerManagement.managementDeafultButtonAction( buttons,cashierHomeBP, person);
	});
	
	cashierPOSButton.setOnAction(e -> {
		Login.displayInfo("POS Information", "Select a costumer from Management to access POS");
	});
	
	cashierSalesButton.setOnAction(e -> {
		SalesReport.salesButtonAction( cashierHomeBP, buttons);
	});
	
	
	}
	public static void cashierHomeButtonAction(int personIndex,BorderPane cashierHomeBP,Button[] buttons)
	{
		buttons[0].setDisable(true);
		buttons[1].setDisable(false);
		buttons[2].setDisable(false);
		buttons[3].setDisable(false);
		buttons[4].setDisable(false);
		
		

		Person person=GroceryStore.personList.get(personIndex);
		
		VBox cashierHomeVB=new VBox();
		
		Label nameLabel =new Label("Name: "+person.getName());
		nameLabel.setAlignment(Pos.CENTER);
		
		Label surnameLabel=new Label("Surname: "+person.getSurname());
		surnameLabel.setAlignment(Pos.CENTER);
		
		HBox firstRow =new HBox();
		firstRow.getChildren().addAll(nameLabel,surnameLabel);
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
		editbutton.setStyle("-fx-background-color: #3366CC; -fx-text-fill: white;");
		 
		editbutton.setOnMousePressed(e -> {
	            // Apply different style or effect when pressed
			editbutton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
		editbutton.setOnMouseReleased(e -> {
	            // Reset style when mouse is released
			editbutton.setStyle("-fx-background-color: #3366CC; -fx-text-fill: white;");
	        });
		
		ComboBox <String> chooseEditCB=new ComboBox<>();
		chooseEditCB.setPromptText("Choose to Edit");
		chooseEditCB.getItems().addAll("Username","Birthday","Password","None");
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
		
		
		cashierHomeVB.getChildren().addAll(userinputVB,loginButtonsPane);
		cashierHomeVB.setPadding(new Insets(140));
		cashierHomeVB.setSpacing(20);
		
		cashierHomeBP.setCenter(cashierHomeVB);
		
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
		
		
	
		usernametxfl.setDisable(true);
		yearComboBox.setDisable(true);
		monthComboBox.setDisable(true);
		dayComboBox.setDisable(true);
		passwordtxfl.setDisable(true);
		editbutton.setDisable(true);
		
		chooseEditCB.setOnAction(e ->{
			if(chooseEditCB.getValue().equalsIgnoreCase("None"))
			{

				usernametxfl.setDisable(true);
				yearComboBox.setDisable(true);
				monthComboBox.setDisable(true);
				dayComboBox.setDisable(true);
				passwordtxfl.setDisable(true);
				editbutton.setDisable(true);
			}

			else if (chooseEditCB.getValue().equalsIgnoreCase("Username")) {
			
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
