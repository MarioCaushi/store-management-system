import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Register {

	//A method to create action when pressing the register:  button
		//It directs the user the the register for s stage
	public static void registerBtnAction(Stage primaryStage)
	{
		BorderPane registerBP=new BorderPane();
		
		VBox registerVB=new VBox();
		
		Label registerlb1=new Label("Welcome");
		registerlb1.setAlignment(Pos.BASELINE_CENTER);
		registerlb1.setFont(Font.font("Arial", 30)); // Set font size to 20
		registerlb1.setStyle("-fx-font-weight: bold;"); // Set font weight to bold
		
		Label registerlb2=new Label("Enter your details below to create an account");
		registerlb2.setAlignment(Pos.BASELINE_CENTER);
		registerlb2.setFont(Font.font("Arial", 12)); // Set font size to 20
		
		//Create VBOX to put labels in
		VBox registerlbPane=new VBox();
		registerlbPane.getChildren().addAll(registerlb1,registerlb2);
		registerlbPane.setAlignment(Pos.CENTER);
		registerlbPane.setSpacing(5);
		
		
		//The TextFields part for user input
		TextField nametxfl=new TextField();
		nametxfl.setPrefColumnCount(1);
		nametxfl.setAlignment(Pos.BASELINE_LEFT);
		nametxfl.setPromptText("Name");
		nametxfl.setPrefWidth(190);
		
		TextField surnametxfl=new TextField();
		surnametxfl.setPrefColumnCount(1);
		surnametxfl.setAlignment(Pos.BASELINE_LEFT);
		surnametxfl.setPromptText("Surname");
		surnametxfl.setPrefWidth(190);
		
		HBox firstRow =new HBox();
		firstRow.getChildren().addAll(nametxfl,surnametxfl);
		firstRow.setSpacing(20);
		
		
		TextField usernametxfl=new TextField();
		usernametxfl.setPrefColumnCount(1);
		usernametxfl.setAlignment(Pos.BASELINE_LEFT);
		usernametxfl.setPromptText("Username");
		usernametxfl.setPrefWidth(400);
		
		HBox secondRow =new HBox();
		secondRow.getChildren().addAll(usernametxfl);
		
		
		 ComboBox<Integer> yearComboBox = createComboBox(1900, 2030);
		 yearComboBox.setPromptText("Year");
		 
	     ComboBox<String> monthComboBox = new ComboBox<>();
	     monthComboBox.setPromptText("Month");
	     monthComboBox.getItems().addAll
	     ("January", "February", "March", "April", "May", "June",
	      "July", "August", "September", "October", "November", "December");
	     
	     ComboBox<Integer> dayComboBox = createComboBox(1, 31);
	     dayComboBox.setPromptText("Day");  	 
	     
	     HBox thirdRow =new HBox();
		thirdRow.getChildren().addAll(yearComboBox,monthComboBox,dayComboBox);
		thirdRow.setAlignment(Pos.CENTER);
		thirdRow.setSpacing(10);
		
	    PasswordField passwordtxfl=new PasswordField();
		passwordtxfl.setPrefColumnCount(1);
		passwordtxfl.setAlignment(Pos.BASELINE_LEFT);
		passwordtxfl.setPromptText("Password");
		passwordtxfl.setPrefWidth(230);

		CheckBox autogenerateCB = new CheckBox("Auto-Generate");
		autogenerateCB.setPrefWidth(160);
		autogenerateCB.setAlignment(Pos.CENTER);
		
		 HBox fourthRow =new HBox();
		fourthRow.getChildren().addAll(passwordtxfl,autogenerateCB);
		fourthRow.setSpacing(20);
		
		VBox userinputVB=new VBox();
		userinputVB.getChildren().addAll(firstRow,secondRow,thirdRow,fourthRow);
		userinputVB.setSpacing(10);
		
		//THe buttons 
		
		Button loginbtn=new Button("Login");
		loginbtn.setAlignment(Pos.CENTER);
		loginbtn.setPrefWidth(150);
		loginbtn.setStyle("-fx-background-color: #00B300; -fx-text-fill: white;");
		
		loginbtn.setOnMousePressed(e -> {
	            // Apply different style or effect when pressed
			loginbtn.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
		loginbtn.setOnMouseReleased(e -> {
	            // Reset style when mouse is released
			loginbtn.setStyle("-fx-background-color: #00B300; -fx-text-fill: white;");
	        });
		
		
		Label orLabel=new Label("or");
		orLabel.setAlignment(Pos.CENTER);
		orLabel.setStyle("-fx-font-weight: bold;");
		
		
		Button registerBtn=new Button("Register");
		registerBtn.setAlignment(Pos.CENTER);
		registerBtn.setPrefWidth(150);
		registerBtn.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
		
		registerBtn.setOnMousePressed(e -> {
	            // Apply different style or effect when pressed
			registerBtn.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
		registerBtn.setOnMouseReleased(e -> {
	            // Reset style when mouse is released
			registerBtn.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
	        });
		 
		//Create VBOX to put the buttons in
		VBox loginButtonsPane=new VBox();
		loginButtonsPane.getChildren().addAll(registerBtn,orLabel,loginbtn);
		loginButtonsPane.setAlignment(Pos.CENTER);
		loginButtonsPane.setSpacing(5);
		
		
		registerVB.getChildren().addAll(registerlbPane,userinputVB,loginButtonsPane);
		registerVB.setPadding(new Insets(150));
		registerVB.setSpacing(20);
		
		registerBP.setCenter(registerVB);
		
		Scene registerScene= new Scene(registerBP,600,600);
		
		Stage registerStage=new Stage();
		registerStage.setScene(registerScene);
		registerStage.setTitle("Register: ");
		registerStage.setResizable(false);
		registerStage.show();
		
		primaryStage.close();
		
		//Event handler to go back to the login window
		loginbtn.setOnAction(e ->{
			registerStage.close();
			primaryStage.show();
		});
		
		
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
		
		//Handler for the auto-generate CheckBox
		autogenerateCB.setOnAction(e -> {
			if(autogenerateCB.isSelected())
			{
				passwordtxfl.setDisable(true);
			}
			else
			{
				passwordtxfl.setDisable(false);
			}
		});
		
		//Setting conditions on the register button
		registerBtn.setOnAction(e -> {
			
			String nametxt=nametxfl.getText();
			String surnametxt=surnametxfl.getText();
			String usernametxt=usernametxfl.getText();
			
			if(autogenerateCB.isSelected())
			{				
				if (nametxt.isEmpty() || surnametxt.isEmpty() || usernametxt.isEmpty() || yearComboBox.getValue() == null || monthComboBox.getValue() == null || dayComboBox.getValue() == null)
				{
				    showRegisterCautionMessage();
				}
				else
				{
					if(checkUsername(usernametxfl))
					{
						checkUsernameMessage();
					}
					else
					{
					chooseCategoryRegister( registerStage, nametxfl, surnametxfl, usernametxfl
							,yearComboBox,monthComboBox,dayComboBox,autogenerateCB,passwordtxfl,primaryStage);
					}
				}
			}
			else
			{
				String passwordtxt=passwordtxfl.getText();
				if (nametxt.isEmpty() || surnametxt.isEmpty() || usernametxt.isEmpty() || passwordtxt.isEmpty() || yearComboBox.getValue() == null || monthComboBox.getValue() == null || dayComboBox.getValue() == null)
				{
				    showRegisterCautionMessage();
				}
				else
				{
					if(checkUsername(usernametxfl))
					{
						checkUsernameMessage();
					}
					else
					{
					chooseCategoryRegister( registerStage, nametxfl, surnametxfl, usernametxfl
					,yearComboBox,monthComboBox,dayComboBox,autogenerateCB,passwordtxfl,primaryStage);
					}
				}
			}
		});
		
	}
	
	
	public static ComboBox<Integer> createComboBox(int start, int end)
	  {
		        ComboBox<Integer> comboBox = new ComboBox<>();
		        for (int i = start; i <= end; i++) {
		            comboBox.getItems().add(i);
		        }
		        return comboBox;
	  }
	
	//A method to show that without completing the fields the user cannot proceed
	private static void showRegisterCautionMessage()
	{
		Stage stage=new Stage();
		stage.setTitle("Register Message");
		Text text=new Text("You cannot proceed without completing all the fields!!");
		Button button=new Button("Close");
		button.setAlignment(Pos.CENTER);
		VBox pane=new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(text,button);
		pane.setSpacing(10);
		Scene scene=new Scene(pane,300,100);
		stage.setScene(scene);
		stage.show();
		
		button.setOnAction(e -> {
			stage.close();
		});
	}
	
	//A method to choose if you are a manager or a cashier after clicking register
	private static void chooseCategoryRegister(Stage registerStage,TextField nametxfl,TextField surnametxfl,TextField usernametxfl
			,ComboBox<Integer>yearComboBox,ComboBox<String>monthComboBox,ComboBox<Integer>dayComboBox,CheckBox autogenerateCB,TextField passwordtxfl,Stage primaryStage)
	{
		Stage choosestage=new Stage();
		choosestage.setTitle("Register: Choose Category");
		
		Text text=new Text("Choose: ");
		text.setStyle("-fx-font-weight:bold;");
		
		HBox chooseHB=new HBox();
		
		Button cashierbutton=new Button("Cashier");
		cashierbutton.setStyle(
                "-fx-background-color: #ADD8E6; " + // Lighter blue background
                "-fx-border-color: black; " +    // Dark blue border
                "-fx-text-fill: black;");        // Text color
		cashierbutton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			cashierbutton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		cashierbutton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			cashierbutton.setStyle(
	                "-fx-background-color: #ADD8E6; " + // Lighter blue background
	                "-fx-border-color: black; " +    // Dark blue border
	                "-fx-text-fill: black;");        // Text color
        });
		
		Button managerbutton=new Button("Manager");
		managerbutton.setStyle(
                "-fx-background-color: #ADD8E6; " + // Lighter blue background
                "-fx-border-color: black; " +    // Dark blue border
                "-fx-text-fill: black;");        // Text color
		managerbutton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			managerbutton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		managerbutton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			managerbutton.setStyle(
	                "-fx-background-color: #ADD8E6; " + // Lighter blue background
	                "-fx-border-color: black; " +    // Dark blue border
	                "-fx-text-fill: black;");        // Text color
        });
		
		chooseHB.getChildren().addAll(cashierbutton,managerbutton);
		chooseHB.setSpacing(10);
		chooseHB.setAlignment(Pos.CENTER);
		
		Button closebutton=new Button("Close");
		closebutton.setAlignment(Pos.CENTER);
		
		VBox pane=new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(text,chooseHB,closebutton);
		pane.setSpacing(20);
		
		Scene scene=new Scene(pane,300,150);
		choosestage.setScene(scene);
		choosestage.show();
		
		closebutton.setOnAction(e -> {
			choosestage.close();
		});
		
		cashierbutton.setOnAction(e -> {
			String name=nametxfl.getText();
			String surname=surnametxfl.getText();
			String username=usernametxfl.getText();
			int day=dayComboBox.getValue();
		    int month=GroceryStore.convertMonthFromStringToInt(monthComboBox.getValue());
			int year=yearComboBox.getValue();
			
			if(autogenerateCB.isSelected())
			{
				Cashier cashier=new Cashier(name,surname,day,month,year,username);
				GroceryStore.personList.add(cashier);
				GroceryStore.storeInPersonDatabase(); 
				showAutoGeneratedPassword(autogenerateCB,registerStage,cashier, primaryStage, choosestage);
			}
			else
			{
				String password=passwordtxfl.getText();
				Cashier cashier=new Cashier(name,surname,day,month,year,password,username);
				GroceryStore.personList.add(cashier);
				GroceryStore.storeInPersonDatabase();
				successfulRegister(primaryStage,choosestage,registerStage);
			}
		});
		managerbutton.setOnAction(e -> {
			String name=nametxfl.getText();
			String surname=surnametxfl.getText();
			String username=usernametxfl.getText();
			int day=dayComboBox.getValue();
		    int month=GroceryStore.convertMonthFromStringToInt(monthComboBox.getValue());
			int year=yearComboBox.getValue();
			
			if(autogenerateCB.isSelected())
			{
				Manager manager=new Manager(name,surname,day,month,year,username);
				GroceryStore.personList.add(manager);
				GroceryStore.storeInPersonDatabase();
				showAutoGeneratedPassword(autogenerateCB,registerStage,manager, primaryStage, choosestage);
			}
			else
			{
				String password=passwordtxfl.getText();
				Manager manager=new Manager(name,surname,day,month,year,password,username);
				GroceryStore.personList.add(manager);
				GroceryStore.storeInPersonDatabase();
				successfulRegister(primaryStage,choosestage,registerStage);
			}
		});

	}
	
	//a method to show the auto generated password after registration
	private static void showAutoGeneratedPassword(CheckBox autogenerateCB,Stage registerStage,Person person,Stage primaryStage,Stage chooseStage)
	{
		Stage stage=new Stage();
		stage.setTitle("Auto-Generated Password");
		
		String passwordtxt=person.getPassword();
		
		Text text=new Text("Your Password is: "+passwordtxt);
		text.setStyle("-fx-font-weight:bold;");
		Button button=new Button("Login");
		button.setAlignment(Pos.CENTER);
        button.setStyle("-fx-background-color: #00B300; -fx-text-fill: white;");
		
		button.setOnMousePressed(e -> {
	            // Apply different style or effect when pressed
			button.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
		button.setOnMouseReleased(e -> {
	            // Reset style when mouse is released
			button.setStyle("-fx-background-color: #00B300; -fx-text-fill: white;");
	        });
		
		VBox pane=new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(text,button);
		pane.setSpacing(10);
		Scene scene=new Scene(pane,300,100);
		stage.setScene(scene);
		chooseStage.close();
		registerStage.close();
		stage.show();
		
		button.setOnAction(e -> {
			stage.close();
			primaryStage.show();
		});
	}
	
	//A method to show that registration has been completed successfully
	private static void successfulRegister(Stage primaryStage,Stage choosestage,Stage registerStage)
	{
		Stage stage=new Stage();
		stage.setTitle("Register: Successfull");
		
		Text text=new Text("Registered Successfully!");
		text.setStyle("-fx-font-weight:bold;");
		Button button=new Button("Login");
		button.setAlignment(Pos.CENTER);
        button.setStyle("-fx-background-color: #00B300; -fx-text-fill: white;");
		
		button.setOnMousePressed(e -> {
	            // Apply different style or effect when pressed
			button.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
		button.setOnMouseReleased(e -> {
	            // Reset style when mouse is released
			button.setStyle("-fx-background-color: #00B300; -fx-text-fill: white;");
	        });
		
		VBox pane=new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(text,button);
		pane.setSpacing(10);
		Scene scene=new Scene(pane,300,100);
		stage.setScene(scene);
		choosestage.close();
		registerStage.close();
		stage.show();
		
		button.setOnAction(e -> {
			stage.close();
			primaryStage.show();
		});
	}
	
	//A method to check if the username entered is valid
	public static boolean checkUsername(TextField usernametxfl)
	{
		boolean x=false;
		for(int i=0;i<GroceryStore.personList.size();i++)
		{
			if(usernametxfl.getText().equals(GroceryStore.personList.get(i).getUsername()))
			{
				x=true;
				return x;
			}
		} 
		return x;
	}
	
	public static boolean checkUsername(String usernametxfl)
	{
		boolean x=false;
		for(int i=0;i<GroceryStore.personList.size();i++)
		{
			if(usernametxfl.equals(GroceryStore.personList.get(i).getUsername()))
			{
				x=true;
				return x;
			}
		} 
		return x;
	}
	private static void checkUsernameMessage()
	{
		Stage stage=new Stage();
		stage.setTitle("Register Message");
		Text text=new Text("Username Invalid. Try Again!");
		Button button=new Button("Close");
		button.setAlignment(Pos.CENTER);
		VBox pane=new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(text,button);
		pane.setSpacing(10);
		Scene scene=new Scene(pane,300,100);
		stage.setScene(scene);
		stage.show();
		
		button.setOnAction(e -> { 
			stage.close();
		});
	} 
	
}