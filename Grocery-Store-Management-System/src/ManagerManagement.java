import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class ManagerManagement {

	public static void managementDeafultButtonAction(Button[] buttons,BorderPane ManagerHomeBP,Person person)
	{
		buttons[0].setDisable(false);
		buttons[1].setDisable(false);
		buttons[2].setDisable(true);
		buttons[3].setDisable(false);
		buttons[4].setDisable(false);
		
		try {
			GroceryStore.openPersonDatabaseWithoutMessage();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GroceryStore.arrangeDatabase();
		
		//Creating three buttons to choose what table to view
		Button cashierTableButton=new Button("Cashier");
		cashierTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		cashierTableButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			cashierTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		cashierTableButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			cashierTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button costumerTableButton=new Button("Costumer");
		costumerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		costumerTableButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			costumerTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		costumerTableButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			costumerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button ManagerTableButton=new Button("Manager");
		ManagerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		ManagerTableButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			ManagerTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		ManagerTableButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			ManagerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button[] managementButtonsArr= {cashierTableButton,costumerTableButton,ManagerTableButton};
		
		managementButtonsArr[0].setDisable(true);
		managementButtonsArr[1].setDisable(false);
		managementButtonsArr[2].setDisable(false);
		
		
		HBox managementButtons=new HBox();
		managementButtons.setAlignment(Pos.TOP_CENTER);
		managementButtons.setSpacing(10);
		managementButtons.getChildren().addAll(cashierTableButton,costumerTableButton,ManagerTableButton);
		
		//Creating the default table that will be shown when you open the management page
		//The cashierTable
		
		TableView<Cashier> CashierTable=new TableView<>();
		
		TableColumn<Cashier,String> nameColumnCashierTable=new TableColumn<Cashier,String>("Name");
		nameColumnCashierTable.setCellValueFactory(new PropertyValueFactory<Cashier, String>("name"));
		nameColumnCashierTable.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumnCashierTable.setOnEditCommit(new EventHandler<CellEditEvent<Cashier, String>>() {
		    @Override
		    public void handle(CellEditEvent<Cashier, String> event) {
		        Cashier cashier = event.getRowValue();
		        cashier.setName(event.getNewValue());
		        
		        Person person=GroceryStore.findCorrespondingPersoninPersonList(cashier);
		        person.setName(event.getNewValue());
		        
		        GroceryStore.storeInPersonDatabase();
		    }
		});

		
		TableColumn<Cashier,String> surnameColumnCashierTable=new TableColumn<Cashier,String>("Surname");
		surnameColumnCashierTable.setCellValueFactory(new PropertyValueFactory<Cashier,String>("surname"));
		surnameColumnCashierTable.setCellFactory(TextFieldTableCell.forTableColumn());
		surnameColumnCashierTable.setOnEditCommit(new EventHandler<CellEditEvent<Cashier, String>>() {
		    @Override
		    public void handle(CellEditEvent<Cashier, String> event) {
		        Cashier cashier = event.getRowValue();
		        cashier.setSurname(event.getNewValue());
		        
		        Person person=GroceryStore.findCorrespondingPersoninPersonList(cashier);
		        person.setSurname(event.getNewValue());
		        
		        GroceryStore.storeInPersonDatabase();
		    }
		});
		
		TableColumn<Cashier,String> usernameColumnCashierTable=new TableColumn<Cashier,String>("Username");
		usernameColumnCashierTable.setCellValueFactory(new PropertyValueFactory<Cashier,String>("username"));
		
		TableColumn<Cashier,String> passwordColumnCashierTable=new TableColumn<Cashier,String>("Password");
		passwordColumnCashierTable.setCellValueFactory(new PropertyValueFactory<Cashier,String>("password"));
		
		TableColumn<Cashier,String> birthdayColumnCashierTable=new TableColumn<Cashier,String>("Birthday");
		birthdayColumnCashierTable.setCellValueFactory(new PropertyValueFactory<Cashier,String>("birthday"));
		
		TableColumn<Cashier,String> dateregisteredColumnCashierTable=new TableColumn<Cashier,String>("Date Registered");
		dateregisteredColumnCashierTable.setCellValueFactory(new PropertyValueFactory<Cashier,String>("dateRegistered"));
		
		CashierTable.getColumns().addAll(nameColumnCashierTable, surnameColumnCashierTable,
                usernameColumnCashierTable,passwordColumnCashierTable, birthdayColumnCashierTable,
                dateregisteredColumnCashierTable);
		
		for(int i=0;i<GroceryStore.cashierList.size();i++)
		{
			CashierTable.getItems().add(GroceryStore.cashierList.get(i));
		}
		
		CashierTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		CashierTable.setStyle("-fx-background-color:transparent");
		
		CashierTable.setEditable(true);
		
		//CashierTable finishes here but will be set up later
		
		//Creating an VBox to put all the layout in and then align it right in the BorderPane
		if(person instanceof Manager)
		{
			CashierTable.setEditable(true);
			
		Button addCashierToTable=new Button("Add");
		addCashierToTable.setStyle("-fx-background-color:#7FEE7E; -fx-text-fill:white;");
		addCashierToTable.setPrefWidth(100);
		
		addCashierToTable.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			addCashierToTable.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		addCashierToTable.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			addCashierToTable.setStyle("-fx-background-color:#7FEE7E; -fx-text-fill:white;");
        });
		
		addCashierToTable.setOnAction(e -> {
			
			addCashierToTableButtonAction(CashierTable);
		});
		
		
		Button deleteCashierFromTable =new Button("Delete");
		deleteCashierFromTable.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
		deleteCashierFromTable.setPrefWidth(100);
		
		deleteCashierFromTable.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			deleteCashierFromTable.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		deleteCashierFromTable.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			deleteCashierFromTable.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
        });
		
		deleteCashierFromTable.setOnAction(e -> {
			deleteManagementButtonCashier(CashierTable);
		});
		
		
		HBox actionButtonsManagementCashier =new HBox();
		 actionButtonsManagementCashier.setSpacing(10);
		 actionButtonsManagementCashier.getChildren().addAll(addCashierToTable,deleteCashierFromTable);
		 actionButtonsManagementCashier.setAlignment(Pos.CENTER);
		 
	   Text deleteButtonInstr=new Text("To delete an item select it first.");
		 
	   VBox actionButtonsManagementCashierAndText =new VBox();  
	   actionButtonsManagementCashierAndText.setSpacing(10);
	   actionButtonsManagementCashierAndText.getChildren().addAll(actionButtonsManagementCashier, deleteButtonInstr);
	   actionButtonsManagementCashierAndText.setAlignment(Pos.CENTER);
			
		
		
		VBox managementCashierLayout=new VBox();
		managementCashierLayout.setSpacing(20);
		managementCashierLayout.setAlignment(Pos.CENTER);
		managementCashierLayout.setPadding(new Insets(5));
		managementCashierLayout.getChildren().addAll(managementButtons,CashierTable,actionButtonsManagementCashierAndText);
		
		ManagerHomeBP.setCenter(managementCashierLayout);
		
		Login.displaySuccessAlert("Attention!!!", "The manager can only edit Name and Surname of Cashier \nDouble-Click to Edit\nPress Enter to Store");
		}
		else
		{	
			CashierTable.setEditable(false);
			
			
			VBox managementCashierLayout=new VBox();
			managementCashierLayout.setSpacing(20);
			managementCashierLayout.setAlignment(Pos.CENTER);
			managementCashierLayout.setPadding(new Insets(5));
			managementCashierLayout.getChildren().addAll(managementButtons,CashierTable);
			
			ManagerHomeBP.setCenter(managementCashierLayout);
			
			Login.displaySuccessAlert("Attention!!!", "A Cashier cannot edit anything");
		}
		ManagerTableButton.setOnAction(e -> {
			 managementManagerButtonAction( ManagerHomeBP,buttons,person);
		});
		
			
		costumerTableButton.setOnAction(e -> {
				managementCostumerButtonAction( ManagerHomeBP, buttons,person);
			});
		
	}
	
	
	//Methods for different actions such as add and delete buttons and the buttons on top
	public static void addCashierToTableButtonAction(TableView<Cashier> cashierTable)
	{
		BorderPane addCashierBP=new BorderPane();
		
		VBox addCashierVB=new VBox();
		
		Label addCashierlb1 =new Label("Welcome");
		 addCashierlb1.setAlignment(Pos.BASELINE_CENTER);
		 addCashierlb1.setFont(Font.font("Arial", 30)); // Set font size to 20
		 addCashierlb1.setStyle("-fx-font-weight: bold;"); // Set font weight to bold
		
		Label addCashierlb2 =new Label("Enter the details below to add a Cashier");
		addCashierlb2.setAlignment(Pos.BASELINE_CENTER);
		addCashierlb2.setFont(Font.font("Arial", 12)); // Set font size to 20
		
		//Create VBOX to put labels in
		VBox addCashierlbPane =new VBox();
		addCashierlbPane.getChildren().addAll(addCashierlb1,addCashierlb2);
		addCashierlbPane.setAlignment(Pos.CENTER);
		addCashierlbPane.setSpacing(5);
		
		
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
		
		
		 ComboBox<Integer> yearComboBox = Register.createComboBox(1900, 2030);
		 yearComboBox.setPromptText("Year");
		 
	     ComboBox<String> monthComboBox = new ComboBox<>();
	     monthComboBox.setPromptText("Month");
	     monthComboBox.getItems().addAll
	     ("January", "February", "March", "April", "May", "June",
	      "July", "August", "September", "October", "November", "December");
	     
	     ComboBox<Integer> dayComboBox = Register.createComboBox(1, 31);
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
		
		Button addCashierBtn =new Button("Add");
		addCashierBtn.setAlignment(Pos.CENTER);
		addCashierBtn.setPrefWidth(150);
		addCashierBtn.setStyle("-fx-background-color: #00B300; -fx-text-fill: white;");
		
		addCashierBtn.setOnMousePressed(e -> {
	            // Apply different style or effect when pressed
			addCashierBtn.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
		addCashierBtn.setOnMouseReleased(e -> {
	            // Reset style when mouse is released
			addCashierBtn.setStyle("-fx-background-color: #00B300; -fx-text-fill: white;");
	        });
		
		
		Button cancelCashierBtn =new Button("Cancel");
		cancelCashierBtn.setAlignment(Pos.CENTER);
		cancelCashierBtn.setPrefWidth(150);
		cancelCashierBtn.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
		
		cancelCashierBtn.setOnMousePressed(e -> {
	            // Apply different style or effect when pressed
			cancelCashierBtn.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
		cancelCashierBtn.setOnMouseReleased(e -> {
	            // Reset style when mouse is released
			cancelCashierBtn.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
	        });
		 
		//Create VBOX to put the buttons in
		VBox loginButtonsPane=new VBox();
		loginButtonsPane.getChildren().addAll(addCashierBtn,cancelCashierBtn);
		loginButtonsPane.setAlignment(Pos.CENTER);
		loginButtonsPane.setSpacing(5);
		
		
		addCashierVB.getChildren().addAll(addCashierlbPane,userinputVB,loginButtonsPane);
		addCashierVB.setPadding(new Insets(150));
		addCashierVB.setSpacing(20);
		
		addCashierBP.setCenter(addCashierVB);
		
		Scene addCashierScene= new Scene(addCashierBP,600,600);
		
		Stage addCashierStage =new Stage();
		addCashierStage.setScene(addCashierScene);
		addCashierStage.setTitle("Add a cashier: ");
		addCashierStage.setResizable(false);
		addCashierStage.setAlwaysOnTop(true);
		addCashierStage.show();
		
		
		cancelCashierBtn.setOnAction(e -> {
			addCashierStage.close();
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
		addCashierBtn.setOnAction(e -> {
			
			String nametxt=nametxfl.getText();
			String surnametxt=surnametxfl.getText();
			String usernametxt=usernametxfl.getText();
				
			if(autogenerateCB.isSelected())
			{				
				if (nametxt.isEmpty() || surnametxt.isEmpty() || usernametxt.isEmpty() || yearComboBox.getValue() == null || monthComboBox.getValue() == null || dayComboBox.getValue() == null)
				{
				   Login.displayInfo("Add Cashier Message", "Cannot proceed without completing all the fields");
				}
				else
				{
					if(Register.checkUsername(usernametxfl))
					{
						Login.displayInfo("Username Error", "Username Invalid. Try Again!");
					}
					else
					{
						int day=dayComboBox.getValue();
					    int month=GroceryStore.convertMonthFromStringToInt(monthComboBox.getValue());
						int year=yearComboBox.getValue();

					   Cashier cashier=new Cashier(nametxt,surnametxt,day,month,year,usernametxt);
					   GroceryStore.personList.add(cashier);
					   GroceryStore.cashierList.add(cashier);
					  cashierTable.getItems().add(cashier);
					  addCashierStage.close();
					  Login.displaySuccessAlert("Success","Cashier added. \nAuto-Generated Password: "+cashier.getPassword());
					  GroceryStore.storeInPersonDatabase();
					}
				}
			}
			else
			{
				String passwordtxt=passwordtxfl.getText();
				if (nametxt.isEmpty() || surnametxt.isEmpty() || usernametxt.isEmpty() || passwordtxt.isEmpty() || yearComboBox.getValue() == null || monthComboBox.getValue() == null || dayComboBox.getValue() == null)
				{
					Login.displayInfo("Add Cashier Message", "Cannot proceed without completing all the fields");
				}
				else
				{
					if(Register.checkUsername(usernametxfl))
					{
						Login.displayInfo("Username Error", "Username Invalid. Try Again!");
					}
					else
					{
						int day=dayComboBox.getValue();
					    int month=GroceryStore.convertMonthFromStringToInt(monthComboBox.getValue());
						int year=yearComboBox.getValue();

						Cashier cashier=new Cashier(nametxt,surnametxt,day,month,year,passwordtxt,usernametxt);
						   GroceryStore.personList.add(cashier);
						   GroceryStore.cashierList.add(cashier);
						  cashierTable.getItems().add(cashier);
						  
						  addCashierStage.close();
						  GroceryStore.storeInPersonDatabase();
					}
				}
			}
		});
		
	}
	
	public static void managementManagerButtonAction(BorderPane ManagerHomeBP,Button[] buttons,Person person)
	{
		//Creating three buttons to choose what table to view
				Button cashierTableButton=new Button("Cashier");
				cashierTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				cashierTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					cashierTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				cashierTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					cashierTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				
				Button costumerTableButton=new Button("Costumer");
				costumerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				costumerTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					costumerTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				costumerTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					costumerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				
				Button ManagerTableButton=new Button("Manager");
				ManagerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				ManagerTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					ManagerTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				ManagerTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					ManagerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				Button[] managementButtonsArr= {cashierTableButton,costumerTableButton,ManagerTableButton};
				managementButtonsArr[0].setDisable(false);
				managementButtonsArr[1].setDisable(false);
				managementButtonsArr[2].setDisable(true);
				
				
				HBox managementButtons=new HBox();
				managementButtons.setAlignment(Pos.TOP_CENTER);
				managementButtons.setSpacing(10);
				managementButtons.getChildren().addAll(cashierTableButton,costumerTableButton,ManagerTableButton);
				
				TableView<Manager> ManagerTable=new TableView<>();
				
				TableColumn<Manager,String> nameColumnManagerTable=new TableColumn<Manager,String>("Name");
				nameColumnManagerTable.setCellValueFactory(new PropertyValueFactory<Manager, String>("name"));

				
				TableColumn<Manager,String> surnameColumnManagerTable=new TableColumn<Manager,String>("Surname");
				surnameColumnManagerTable.setCellValueFactory(new PropertyValueFactory<Manager,String>("surname"));

				
				TableColumn<Manager,String> usernameColumnManagerTable=new TableColumn<Manager,String>("Username");
				usernameColumnManagerTable.setCellValueFactory(new PropertyValueFactory<Manager,String>("username"));
				
				TableColumn<Manager,String> birthdayColumnManagerTable=new TableColumn<Manager,String>("Birthday");
				birthdayColumnManagerTable.setCellValueFactory(new PropertyValueFactory<Manager,String>("birthday"));
				
				TableColumn<Manager,String> dateregisteredColumnManagerTable=new TableColumn<Manager,String>("Date Registered");
				dateregisteredColumnManagerTable.setCellValueFactory(new PropertyValueFactory<Manager,String>("dateRegistered"));
				
				ManagerTable.getColumns().addAll(nameColumnManagerTable, surnameColumnManagerTable,
		                usernameColumnManagerTable,birthdayColumnManagerTable,
		                dateregisteredColumnManagerTable);
				
				for(int i=0;i<GroceryStore.managerList.size();i++)
				{
					ManagerTable.getItems().add(GroceryStore.managerList.get(i));
				}
				
				ManagerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
				ManagerTable.setStyle("-fx-background-color:transparent");
				ManagerTable.setEditable(false);
				
				if(person instanceof Manager)
				{
				Button deleteManagerFromTable =new Button("Delete");
				deleteManagerFromTable.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
				deleteManagerFromTable.setPrefWidth(100);
				
				deleteManagerFromTable.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					deleteManagerFromTable.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				deleteManagerFromTable.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					deleteManagerFromTable.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
		        });
				
				deleteManagerFromTable.setOnAction(e -> {
					deleteManagementButtonManager(ManagerTable);
				});
				
				
				 
			   Text deleteButtonInstr=new Text("To delete an item select it first.");
				
			   VBox actionButtonsManagementCashierAndText =new VBox();  
			   actionButtonsManagementCashierAndText.setSpacing(10);
			   actionButtonsManagementCashierAndText.getChildren().addAll(deleteManagerFromTable,deleteButtonInstr);
			   actionButtonsManagementCashierAndText.setAlignment(Pos.CENTER);
					
				
				
				VBox managementManagerLayout=new VBox();
				managementManagerLayout.setSpacing(20);
				managementManagerLayout.setAlignment(Pos.CENTER);
				managementManagerLayout.setPadding(new Insets(5));
				managementManagerLayout.getChildren().addAll(managementButtons,ManagerTable,actionButtonsManagementCashierAndText);
				
				ManagerHomeBP.setCenter(managementManagerLayout);
				}
				else
				{	
					VBox managementManagerLayout=new VBox();
					managementManagerLayout.setSpacing(20);
					managementManagerLayout.setAlignment(Pos.CENTER);
					managementManagerLayout.setPadding(new Insets(5));
					managementManagerLayout.getChildren().addAll(managementButtons,ManagerTable);
					
					ManagerHomeBP.setCenter(managementManagerLayout);
				}
				if(person instanceof Manager)
				{
					Login.displaySuccessAlert("Attention!!!", "The manager can only delete other managers");
				}
				else {
					Login.displaySuccessAlert("Attention!!!", "A cashier CANNOT edit anything");
				}
				
			
				cashierTableButton.setOnAction(e -> {
					managementDeafultButtonAction( buttons, ManagerHomeBP,person);
				});
				
				costumerTableButton.setOnAction(e -> {
					managementCostumerButtonAction( ManagerHomeBP, buttons,person);
				});
				
				
	}
	
	public static void managementCostumerButtonAction(BorderPane ManagerHomeBP,Button[] buttons,Person person)
	{
		//Creating three buttons to choose what table to view
				Button cashierTableButton=new Button("Cashier");
				cashierTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				cashierTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					cashierTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				cashierTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					cashierTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				
				Button costumerTableButton=new Button("Costumer");
				costumerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				costumerTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					costumerTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				costumerTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					costumerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				
				Button ManagerTableButton=new Button("Manager");
				ManagerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				ManagerTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					ManagerTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				ManagerTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					ManagerTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				Button[] managementButtonsArr= {cashierTableButton,costumerTableButton,ManagerTableButton};
				managementButtonsArr[0].setDisable(false);
				managementButtonsArr[1].setDisable(true);
				managementButtonsArr[2].setDisable(false);
				
				
				HBox managementButtons=new HBox();
				managementButtons.setAlignment(Pos.TOP_CENTER);
				managementButtons.setSpacing(10);
				managementButtons.getChildren().addAll(cashierTableButton,costumerTableButton,ManagerTableButton);
				
				TableView<Costumer> CostumerTable=new TableView<>();
				
				TableColumn<Costumer,String> nameColumnCostumerTable=new TableColumn<Costumer,String>("Name");
				nameColumnCostumerTable.setCellValueFactory(new PropertyValueFactory<Costumer, String>("name"));
				nameColumnCostumerTable.setCellFactory(TextFieldTableCell.forTableColumn());
				nameColumnCostumerTable.setOnEditCommit(new EventHandler<CellEditEvent<Costumer, String>>() {
				    @Override
				    public void handle(CellEditEvent<Costumer, String> event) {
				        Costumer costumer = event.getRowValue();
				        costumer.setName(event.getNewValue());
				        
				        Person person=GroceryStore.findCorrespondingPersoninPersonList(costumer);
				        person.setName(event.getNewValue());
				        
				        GroceryStore.storeInPersonDatabase();
				    }
				});

				
				TableColumn<Costumer,String> surnameColumnCostumerTable=new TableColumn<Costumer,String>("Surname");
				surnameColumnCostumerTable.setCellValueFactory(new PropertyValueFactory<Costumer,String>("surname"));
				surnameColumnCostumerTable.setCellFactory(TextFieldTableCell.forTableColumn());
				surnameColumnCostumerTable.setOnEditCommit(new EventHandler<CellEditEvent<Costumer, String>>() {
				    @Override
				    public void handle(CellEditEvent<Costumer, String> event) {
				        Costumer costumer = event.getRowValue();
				        costumer.setSurname(event.getNewValue());
				        
				        Person person=GroceryStore.findCorrespondingPersoninPersonList(costumer);
				        person.setSurname(event.getNewValue());
				        
				        GroceryStore.storeInPersonDatabase();
				    }
				});

				
				TableColumn<Costumer,String> emailColumnCostumerTable=new TableColumn<Costumer,String>("Email");
				emailColumnCostumerTable.setCellValueFactory(new PropertyValueFactory<Costumer,String>("email"));
				emailColumnCostumerTable.setCellFactory(TextFieldTableCell.forTableColumn());
				emailColumnCostumerTable.setOnEditCommit(new EventHandler<CellEditEvent<Costumer, String>>() {
				    @Override
				    public void handle(CellEditEvent<Costumer, String> event) {
				      
				        
				        boolean x=false;
						for(int i=0;i<GroceryStore.costumerList.size();i++)
						{
							if(event.getNewValue().equalsIgnoreCase(GroceryStore.costumerList.get(i).getEmail()))
							{
							x=true;
							break;
							}
						}
						if(x)
						{

							Login.displayInfo("Edit Costumer Message", "Email Invalid");
						}
						else 
						{
							
							Costumer costumer = event.getRowValue();
							 costumer.setEmail(event.getNewValue());
						        
						        int index=GroceryStore.personList.indexOf(costumer);
						        
						        GroceryStore.personList.set(index, costumer);
						        
						        GroceryStore.storeInPersonDatabase();
						}
				    }
				});
				
				TableColumn<Costumer,Integer> loyaltypointsColumnCostumertable=new TableColumn<Costumer,Integer>("Loyalty Points");
				loyaltypointsColumnCostumertable.setCellValueFactory(new PropertyValueFactory<Costumer,Integer>("loyaltyPoints"));
				
				TableColumn<Costumer,Double> discountColumnCostumertable=new TableColumn<Costumer,Double>("Discount");
				discountColumnCostumertable.setCellValueFactory(new PropertyValueFactory<Costumer,Double>("discount"));
				
				TableColumn<Costumer,String> dateregisteredColumnCostumerTable=new TableColumn<Costumer,String>("Date Registered");
				dateregisteredColumnCostumerTable.setCellValueFactory(new PropertyValueFactory<Costumer,String>("dateRegistered"));
				
				CostumerTable.getColumns().addAll(nameColumnCostumerTable, surnameColumnCostumerTable,
		                emailColumnCostumerTable,loyaltypointsColumnCostumertable,
		                discountColumnCostumertable, dateregisteredColumnCostumerTable);
				
				for(int i=0;i<GroceryStore.costumerList.size();i++)
				{
					CostumerTable.getItems().add(GroceryStore.costumerList.get(i));
				}
				
				CostumerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
				CostumerTable.setStyle("-fx-background-color:transparent");
				CostumerTable.setEditable(true);
				
				//The add costumer part 
				
				TextField nameCostumertxfl=new TextField();
				nameCostumertxfl.setPromptText("Name");
				nameCostumertxfl.setPrefColumnCount(1);
				nameCostumertxfl.setPrefWidth(150);
				
				TextField surnameCostumertxfl=new TextField();
				surnameCostumertxfl.setPromptText("Surname");
				surnameCostumertxfl.setPrefColumnCount(1);
				surnameCostumertxfl.setPrefWidth(150);
				
				TextField emailCostumertxfl=new TextField();
				emailCostumertxfl.setPromptText("Email-Not Obligatory");
				emailCostumertxfl.setPrefColumnCount(1);
				emailCostumertxfl.setPrefWidth(150);
				
				Button addCostumerToTable=new Button("Add");
				
				if(person instanceof Manager)
				{
					addCostumerToTable.setStyle("-fx-background-color:#7FEE7E; -fx-text-fill:white;");
					addCostumerToTable.setPrefWidth(100);
					
					addCostumerToTable.setOnMousePressed(e -> {
			            // Apply different style or effect when pressed
						addCostumerToTable.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
			        });
					addCostumerToTable.setOnMouseReleased(e -> {
			            // Reset style when mouse is released
						addCostumerToTable.setStyle("-fx-background-color:#7FEE7E; -fx-text-fill:white;");
			        });
				}
				else
				{
					addCostumerToTable.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
					addCostumerToTable.setPrefWidth(100);
					
					addCostumerToTable.setOnMousePressed(e -> {
			            // Apply different style or effect when pressed
						addCostumerToTable.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
			        });
					addCostumerToTable.setOnMouseReleased(e -> {
			            // Reset style when mouse is released
						addCostumerToTable.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
			        });
				}
				
				addCostumerToTable.setOnAction(e -> {
					if(nameCostumertxfl.getText().isBlank() || surnameCostumertxfl.getText().isBlank() || emailCostumertxfl.getText().isBlank())
					{
						Login.displayInfo("Add Costumer Message", "You need to complete all the fields");
					}
					else
					{
						if(GroceryStore.costumerList.isEmpty())
						{
							Costumer costumer=new Costumer(nameCostumertxfl.getText(),surnameCostumertxfl.getText(),emailCostumertxfl.getText());
							GroceryStore.personList.add(costumer);
							GroceryStore.costumerList.add(costumer);
							GroceryStore.storeInPersonDatabase();
							
							CostumerTable.getItems().add(costumer);
							
							 nameCostumertxfl.setText("");
							 surnameCostumertxfl.setText("");
							 emailCostumertxfl.setText("");
						}
						else
						{
							boolean x=false;
							for(int i=0;i<GroceryStore.costumerList.size();i++)
							{
								if(emailCostumertxfl.getText().equalsIgnoreCase(GroceryStore.costumerList.get(i).getEmail()))
								{
								x=true;
								break;
								}
							}
							if(x)
							{
	
								Login.displayInfo("Add Costumer Message", "Email Invalid");
							}
							else
							{
								Costumer costumer=new Costumer(nameCostumertxfl.getText(),surnameCostumertxfl.getText(),emailCostumertxfl.getText());
								GroceryStore.personList.add(costumer);
								GroceryStore.costumerList.add(costumer);
								GroceryStore.storeInPersonDatabase();
								
								CostumerTable.getItems().add(costumer);
								
								 nameCostumertxfl.setText("");
								 surnameCostumertxfl.setText("");
								 emailCostumertxfl.setText("");
							}
						}
					}
				});
				
				HBox addCostumer =new HBox();
				addCostumer.setSpacing(5);
				addCostumer.setAlignment(Pos.CENTER);
				addCostumer.getChildren().addAll(nameCostumertxfl,surnameCostumertxfl,emailCostumertxfl,addCostumerToTable);
				
				
				//The search costumer part
				TextField nameCostumerSearchtxfl=new TextField();
				nameCostumerSearchtxfl.setPromptText("Name");
				nameCostumerSearchtxfl.setPrefColumnCount(1);
				nameCostumerSearchtxfl.setPrefWidth(150);
				
				TextField surnameCostumerSearchtxfl=new TextField();
				surnameCostumerSearchtxfl.setPromptText("Surname");
				surnameCostumerSearchtxfl.setPrefColumnCount(1);
				surnameCostumerSearchtxfl.setPrefWidth(150);
				
				TextField emailCostumerSearchtxfl=new TextField();
				emailCostumerSearchtxfl.setPromptText("Email");
				emailCostumerSearchtxfl.setPrefColumnCount(1);
				emailCostumerSearchtxfl.setPrefWidth(150);
				
				Button searchCostumerFromTable =new Button("Search");
				searchCostumerFromTable.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
				searchCostumerFromTable.setPrefWidth(100);
				
				searchCostumerFromTable.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					searchCostumerFromTable.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				searchCostumerFromTable.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					searchCostumerFromTable.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
		        });
				
			
				searchCostumerFromTable.setOnAction(e -> {
				if(nameCostumerSearchtxfl.getText().isBlank() && surnameCostumerSearchtxfl.getText().isBlank() && emailCostumerSearchtxfl.getText().isBlank())
				{
					viewAll( CostumerTable);
					 nameCostumerSearchtxfl.setText("");
					 surnameCostumerSearchtxfl.setText("");
					 emailCostumerSearchtxfl.setText("");
				}
				else
				{
					if(surnameCostumerSearchtxfl.getText().isBlank() && emailCostumerSearchtxfl.getText().isBlank())
					{
						searchCostumerButtonByName(CostumerTable,nameCostumerSearchtxfl);
					
						 nameCostumerSearchtxfl.setText("");
						 surnameCostumerSearchtxfl.setText("");
						 emailCostumerSearchtxfl.setText("");
					}
					else if(nameCostumerSearchtxfl.getText().isBlank() && emailCostumerSearchtxfl.getText().isBlank())
					{
						searchCostumerButtonBySurname(CostumerTable,surnameCostumerSearchtxfl);
				
						 nameCostumerSearchtxfl.setText("");
						 surnameCostumerSearchtxfl.setText("");
						 emailCostumerSearchtxfl.setText("");
					}
					else if(nameCostumerSearchtxfl.getText().isBlank() && surnameCostumerSearchtxfl.getText().isBlank())
					{
						searchCostumerButtonByEmail(CostumerTable,emailCostumerSearchtxfl);
			
						 nameCostumerSearchtxfl.setText("");
						 surnameCostumerSearchtxfl.setText("");
						 emailCostumerSearchtxfl.setText("");
					}
					else if (emailCostumerSearchtxfl.getText().isBlank())
					{
						searchCostumerButtonByNameAndSurname(CostumerTable,nameCostumerSearchtxfl,surnameCostumerSearchtxfl);
				
						 nameCostumerSearchtxfl.setText("");
						 surnameCostumerSearchtxfl.setText("");
						 emailCostumerSearchtxfl.setText("");
					}
					else if(nameCostumerSearchtxfl.getText().isBlank())
					{
						searchCostumerButtonBySurnameAndEmail(CostumerTable,surnameCostumerSearchtxfl,emailCostumerSearchtxfl);
				
						 nameCostumerSearchtxfl.setText("");
						 surnameCostumerSearchtxfl.setText("");
						 emailCostumerSearchtxfl.setText("");
					}
					else if(surnameCostumerSearchtxfl.getText().isBlank())
					{
						searchCostumerButtonByNameAndEmail(CostumerTable, nameCostumerSearchtxfl, emailCostumerSearchtxfl);
						
						 nameCostumerSearchtxfl.setText("");
						 surnameCostumerSearchtxfl.setText("");
						 emailCostumerSearchtxfl.setText("");
					}
					else
					{
						searchCostumerButton(CostumerTable, nameCostumerSearchtxfl, emailCostumerSearchtxfl, surnameCostumerSearchtxfl);
		
						 nameCostumerSearchtxfl.setText("");
						 surnameCostumerSearchtxfl.setText("");
						 emailCostumerSearchtxfl.setText("");
					}
						
					
				}
	});	
				
				HBox searchCostumer =new HBox();
				searchCostumer.setSpacing(5);
				searchCostumer.setAlignment(Pos.CENTER);
				searchCostumer.getChildren().addAll(nameCostumerSearchtxfl,surnameCostumerSearchtxfl,emailCostumerSearchtxfl,searchCostumerFromTable);
				
				if(person instanceof Manager)
				{
					Button deleteCostumerFromTable =new Button("Delete");
					deleteCostumerFromTable.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
					deleteCostumerFromTable.setPrefWidth(100);
					
					deleteCostumerFromTable.setOnMousePressed(e -> {
			            // Apply different style or effect when pressed
						deleteCostumerFromTable.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
			        });
					deleteCostumerFromTable.setOnMouseReleased(e -> {
			            // Reset style when mouse is released
						deleteCostumerFromTable.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
			        });
					
					deleteCostumerFromTable.setOnAction(e -> {
						deleteManagementButtonCostumer(CostumerTable);
					});
					
					 
				   Text deleteButtonInstr=new Text("To perform an action on an item select it first.");
				   
				   Button boughtCostumer =new Button("Items Bought");
					boughtCostumer.setStyle("-fx-background-color: #808080; -fx-text-fill:white;");
					boughtCostumer.setPrefWidth(100);
					
					boughtCostumer.setOnMousePressed(e -> {
			            // Apply different style or effect when pressed
						boughtCostumer.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
			        });
					boughtCostumer.setOnMouseReleased(e -> {
			            // Reset style when mouse is released
						boughtCostumer.setStyle("-fx-background-color: #808080; -fx-text-fill:white;");
			        });
					
					HBox  smth=new HBox();
					smth.setSpacing(5);
					smth.setAlignment(Pos.CENTER);
					smth.getChildren().addAll(deleteCostumerFromTable,boughtCostumer);
							
					
				   VBox actionButtonsManagementCashierAndText =new VBox();  
				   actionButtonsManagementCashierAndText.setSpacing(10);
				   actionButtonsManagementCashierAndText.getChildren().addAll(addCostumer,searchCostumer,smth,deleteButtonInstr);
				   actionButtonsManagementCashierAndText.setAlignment(Pos.CENTER);
				   
				   VBox managementCostumerLayout =new VBox();
					managementCostumerLayout.setSpacing(20);
					managementCostumerLayout.setAlignment(Pos.CENTER);
					managementCostumerLayout.setPadding(new Insets(5));
					managementCostumerLayout.getChildren().addAll(managementButtons,CostumerTable,actionButtonsManagementCashierAndText);
					
					ManagerHomeBP.setCenter(managementCostumerLayout);
					
					cashierTableButton.setOnAction(e -> {
						managementDeafultButtonAction( buttons, ManagerHomeBP,person);
					});
					
					ManagerTableButton.setOnAction(e -> {
						managementManagerButtonAction( ManagerHomeBP, buttons,person);
					});
					
					
					boughtCostumer.setOnAction(e -> {
						
						ObservableList<Costumer> costumerSelected = CostumerTable.getSelectionModel().getSelectedItems();

						if (costumerSelected.isEmpty()) {
						    Login.displayInfo("Show Bought Items Message", "Select a Costumer first");
						} else {
						    Costumer costumer = costumerSelected.get(0);
						
						Stage boughtStage=new Stage();
						
						TableView<ProductSold> boughtTable=new TableView<>();
						
						TableColumn<ProductSold,String> categoryColumnProductTable=new TableColumn<ProductSold,String>("Category");
						categoryColumnProductTable.setCellValueFactory(new PropertyValueFactory<ProductSold,String>("category"));
						
						TableColumn<ProductSold, String> nameColumnProductTable = new TableColumn<>("Name");
						nameColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("name"));
						
						TableColumn<ProductSold, Integer> quantityColumnProductTable = new TableColumn<>("Quantity");
						quantityColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("quantity"));

						TableColumn<ProductSold, Double> priceColumnProductTable = new TableColumn<>("Price");
						priceColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("price"));

						TableColumn<ProductSold, String> supplierColumnProductTable = new TableColumn<>("Supplier");
						supplierColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("supplier"));
						
						TableColumn<ProductSold,Integer> serialnumberColumnProductTable=new TableColumn<ProductSold,Integer>("SerialNo");
						serialnumberColumnProductTable.setCellValueFactory(new PropertyValueFactory<ProductSold,Integer>("serialNumber"));
						
						
						boughtTable.getColumns().addAll(categoryColumnProductTable,nameColumnProductTable,
								quantityColumnProductTable,priceColumnProductTable,supplierColumnProductTable,serialnumberColumnProductTable);
		
						for(int i=0;i<costumer.getSize();i++)
						{
							boughtTable.getItems().add(costumer.getBoughtItems(i));
						}
						
						boughtTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
						boughtTable.setStyle("-fx-background-color:transparent");
						boughtTable.setEditable(false);
						

						ComboBox<String> categoryProductSearch =new ComboBox<>();
						categoryProductSearch.setPromptText("Category");
						categoryProductSearch.getItems().addAll("Fruit","Vegetable","Beverages","Bakery","Dairy","Meat & Fish","Freezer","Alcoholics",
								"Health & Beauty","Snacks");
						
						TextField nameProductSearch=new TextField();
						nameProductSearch.setPromptText("Name");
						nameProductSearch.setPrefColumnCount(1);
						nameProductSearch.setPrefWidth(150);
						
						TextField supplierProductSearch=new TextField();
						supplierProductSearch.setPromptText("Supplier");
						supplierProductSearch.setPrefColumnCount(1);
						supplierProductSearch.setPrefWidth(150);
						
						TextField serialnoProductSearch=new TextField();
						serialnoProductSearch.setPromptText("Serial Number");
						serialnoProductSearch.setPrefColumnCount(1);
						serialnoProductSearch.setPrefWidth(150);
						
						
						
						Button searchProductButton=new Button("Search");
						searchProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
						searchProductButton.setPrefWidth(100);
						
						searchProductButton.setOnMousePressed(e1 -> {
				            // Apply different style or effect when pressed
							searchProductButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
				        });
						searchProductButton.setOnMouseReleased(e1 -> {
				            // Reset style when mouse is released
							searchProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
				        });
						
						searchProductButton.setOnAction(e1 -> {
						    String name = nameProductSearch.getText().toLowerCase();
						    String supplier = supplierProductSearch.getText().toLowerCase();
						    String category = categoryProductSearch.getValue();
						    int serialNo = 0;

						    try {
						        serialNo = Integer.parseInt(serialnoProductSearch.getText());
						    } catch (NumberFormatException ex) {
						        // Handle the case where the input cannot be parsed as an integer
						        // You can display an error message or handle it according to your application logic
						    }

						    ArrayList<ProductSold> allData = costumer.getAllItems();
						    ArrayList<ProductSold> filteredData = new ArrayList<>();

						    for (ProductSold item : allData) {
						        boolean match = true;

						        if (!name.isBlank() && !item.getName().toLowerCase().contains(name)) {
						            match = false;
						        }

						        if (!supplier.isBlank() && item.getSupplier() != null && !item.getSupplier().toLowerCase().contains(supplier)) {
						            match = false;
						        }

						        if (category != null && !category.isBlank() && !item.getCategory().equalsIgnoreCase(category)) {
						            match = false;
						        }

						        if (serialNo != 0 && item.getSerialNumber() != serialNo) {
						            match = false;
						        }

						        if (match) {
						            filteredData.add(item);
						        }
						    }

						    boughtTable.getItems().clear();
						    boughtTable.getItems().addAll(filteredData);

						    // Clear search fields after filtering
						    nameProductSearch.setText("");
						    supplierProductSearch.setText("");
						    categoryProductSearch.setValue(null);
						});

						HBox searchProduct=new HBox();
						searchProduct.setSpacing(12);
						searchProduct.setAlignment(Pos.CENTER);
						searchProduct.getChildren().addAll(categoryProductSearch,nameProductSearch,supplierProductSearch,serialnoProductSearch,searchProductButton);
						
						Button cancelSelect=new Button("Cancel");
						cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
						cancelSelect.setPrefWidth(100);
						
						cancelSelect.setOnMousePressed(e2 -> {
				            // Apply different style or effect when pressed
							cancelSelect.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
				        });
						cancelSelect.setOnMouseReleased(e2 -> {
				            // Reset style when mouse is released
							cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
				        });
						
						VBox inventoryLayout=new VBox();
						   inventoryLayout.setSpacing(20);
						   inventoryLayout.setAlignment(Pos.CENTER);
						   inventoryLayout.setPadding(new Insets(5));
						   inventoryLayout.getChildren().addAll(boughtTable,searchProduct,cancelSelect);
						   
						   Scene boughtScene=new Scene(inventoryLayout,600,600);
						   boughtStage.setScene(boughtScene);
						   boughtStage.show();
						   
						   
						   cancelSelect.setOnAction(e1 -> {
							   boughtStage.close();
						   });
						}
					});
					
					
				}
				else
				{
					Button deleteCostumerFromTable =new Button("Delete");
					deleteCostumerFromTable.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
					deleteCostumerFromTable.setPrefWidth(100);
					
					deleteCostumerFromTable.setOnMousePressed(e -> {
			            // Apply different style or effect when pressed
						deleteCostumerFromTable.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
			        });
					deleteCostumerFromTable.setOnMouseReleased(e -> {
			            // Reset style when mouse is released
						deleteCostumerFromTable.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
			        });
					
					deleteCostumerFromTable.setOnAction(e -> {
						deleteManagementButtonCostumer(CostumerTable);
					});
					
					Button selectCostumer =new Button("Select for POS");
					selectCostumer.setStyle("-fx-background-color: #808080; -fx-text-fill:white;");
					selectCostumer.setPrefWidth(100);
					
					selectCostumer.setOnMousePressed(e -> {
			            // Apply different style or effect when pressed
						selectCostumer.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
			        });
					selectCostumer.setOnMouseReleased(e -> {
			            // Reset style when mouse is released
						selectCostumer.setStyle("-fx-background-color: #808080; -fx-text-fill:white;");
			        });
					
					selectCostumer.setOnAction(e -> {
						ObservableList<Costumer> costumer = CostumerTable.getSelectionModel().getSelectedItems();
						
						if(costumer.isEmpty())
						{
							Login.displayInfo("POS Selection Message","Select a costumer first");
						}
						else
						{
							CashierPOS.cashierPOSButton( buttons ,ManagerHomeBP,person, CostumerTable);
						}
					});
					
					
					Button boughtCostumer =new Button("Items Bought");
					boughtCostumer.setStyle("-fx-background-color: #808080; -fx-text-fill:white;");
					boughtCostumer.setPrefWidth(100);
					
					boughtCostumer.setOnMousePressed(e -> {
			            // Apply different style or effect when pressed
						boughtCostumer.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
			        });
					boughtCostumer.setOnMouseReleased(e -> {
			            // Reset style when mouse is released
						boughtCostumer.setStyle("-fx-background-color: #808080; -fx-text-fill:white;");
			        });

					
					
					HBox buttonsCashier= new HBox();					
					buttonsCashier.setAlignment(Pos.CENTER);
					buttonsCashier.setSpacing(10);
					buttonsCashier.getChildren().addAll(selectCostumer,deleteCostumerFromTable,boughtCostumer);
					 
				   Text deleteButtonInstr=new Text("To perform an action select an item first.");
					 
				   VBox actionButtonsManagementCashierAndText =new VBox();  
				   actionButtonsManagementCashierAndText.setSpacing(10);
				   actionButtonsManagementCashierAndText.getChildren().addAll(addCostumer,searchCostumer,buttonsCashier,deleteButtonInstr);
				   actionButtonsManagementCashierAndText.setAlignment(Pos.CENTER);
				   
				   VBox managementCostumerLayout =new VBox();
					managementCostumerLayout.setSpacing(20);
					managementCostumerLayout.setAlignment(Pos.CENTER);
					managementCostumerLayout.setPadding(new Insets(5));
					managementCostumerLayout.getChildren().addAll(managementButtons,CostumerTable,actionButtonsManagementCashierAndText);
					
					ManagerHomeBP.setCenter(managementCostumerLayout);
					
					cashierTableButton.setOnAction(e -> {
						managementDeafultButtonAction( buttons, ManagerHomeBP,person);
					});
					
					ManagerTableButton.setOnAction(e -> {
						managementManagerButtonAction( ManagerHomeBP, buttons,person);
					});
					
					
					boughtCostumer.setOnAction(e -> {
						
						ObservableList<Costumer> costumerSelected = CostumerTable.getSelectionModel().getSelectedItems();

						if (costumerSelected.isEmpty()) {
						    Login.displayInfo("Show Bought Items Message", "Select a Costumer first");
						} else {
						    Costumer costumer = costumerSelected.get(0);
						
						Stage boughtStage=new Stage();
						
						TableView<ProductSold> boughtTable=new TableView<>();
						
						TableColumn<ProductSold,String> categoryColumnProductTable=new TableColumn<ProductSold,String>("Category");
						categoryColumnProductTable.setCellValueFactory(new PropertyValueFactory<ProductSold,String>("category"));
						
						TableColumn<ProductSold, String> nameColumnProductTable = new TableColumn<>("Name");
						nameColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("name"));
						
						TableColumn<ProductSold, Integer> quantityColumnProductTable = new TableColumn<>("Quantity");
						quantityColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("quantity"));

						TableColumn<ProductSold, Double> priceColumnProductTable = new TableColumn<>("Price");
						priceColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("price"));

						TableColumn<ProductSold, String> supplierColumnProductTable = new TableColumn<>("Supplier");
						supplierColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("supplier"));
						
						TableColumn<ProductSold,Integer> serialnumberColumnProductTable=new TableColumn<ProductSold,Integer>("SerialNo");
						serialnumberColumnProductTable.setCellValueFactory(new PropertyValueFactory<ProductSold,Integer>("serialNumber"));
						
						
						boughtTable.getColumns().addAll(categoryColumnProductTable,nameColumnProductTable,
								quantityColumnProductTable,priceColumnProductTable,supplierColumnProductTable,serialnumberColumnProductTable);
		
						for(int i=0;i<costumer.getSize();i++)
						{
							boughtTable.getItems().add(costumer.getBoughtItems(i));
						}
						
						boughtTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
						boughtTable.setStyle("-fx-background-color:transparent");
						boughtTable.setEditable(false);
						

						ComboBox<String> categoryProductSearch =new ComboBox<>();
						categoryProductSearch.setPromptText("Category");
						categoryProductSearch.getItems().addAll("Fruit","Vegetable","Beverages","Bakery","Dairy","Meat & Fish","Freezer","Alcoholics",
								"Health & Beauty","Snacks");
						
						TextField nameProductSearch=new TextField();
						nameProductSearch.setPromptText("Name");
						nameProductSearch.setPrefColumnCount(1);
						nameProductSearch.setPrefWidth(150);
						
						TextField supplierProductSearch=new TextField();
						supplierProductSearch.setPromptText("Supplier");
						supplierProductSearch.setPrefColumnCount(1);
						supplierProductSearch.setPrefWidth(150);
						
						TextField serialnoProductSearch=new TextField();
						serialnoProductSearch.setPromptText("Serial Number");
						serialnoProductSearch.setPrefColumnCount(1);
						serialnoProductSearch.setPrefWidth(150);
						
						
						
						Button searchProductButton=new Button("Search");
						searchProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
						searchProductButton.setPrefWidth(100);
						
						searchProductButton.setOnMousePressed(e1 -> {
				            // Apply different style or effect when pressed
							searchProductButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
				        });
						searchProductButton.setOnMouseReleased(e1 -> {
				            // Reset style when mouse is released
							searchProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
				        });
						
						searchProductButton.setOnAction(e1 -> {
						    String name = nameProductSearch.getText().toLowerCase();
						    String supplier = supplierProductSearch.getText().toLowerCase();
						    String category = categoryProductSearch.getValue();
						    int serialNo = 0;

						    try {
						        serialNo = Integer.parseInt(serialnoProductSearch.getText());
						    } catch (NumberFormatException ex) {
						        // Handle the case where the input cannot be parsed as an integer
						        // You can display an error message or handle it according to your application logic
						    }

						    ArrayList<ProductSold> allData = costumer.getAllItems();
						    ArrayList<ProductSold> filteredData = new ArrayList<>();

						    for (ProductSold item : allData) {
						        boolean match = true;

						        if (!name.isBlank() && !item.getName().toLowerCase().contains(name)) {
						            match = false;
						        }

						        if (!supplier.isBlank() && item.getSupplier() != null && !item.getSupplier().toLowerCase().contains(supplier)) {
						            match = false;
						        }

						        if (category != null && !category.isBlank() && !item.getCategory().equalsIgnoreCase(category)) {
						            match = false;
						        }

						        if (serialNo != 0 && item.getSerialNumber() != serialNo) {
						            match = false;
						        }

						        if (match) {
						            filteredData.add(item);
						        }
						    }

						    boughtTable.getItems().clear();
						    boughtTable.getItems().addAll(filteredData);

						    // Clear search fields after filtering
						    nameProductSearch.setText("");
						    supplierProductSearch.setText("");
						    categoryProductSearch.setValue(null);
						});

						HBox searchProduct=new HBox();
						searchProduct.setSpacing(12);
						searchProduct.setAlignment(Pos.CENTER);
						searchProduct.getChildren().addAll(categoryProductSearch,nameProductSearch,supplierProductSearch,serialnoProductSearch,searchProductButton);
						
						Button cancelSelect=new Button("Cancel");
						cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
						cancelSelect.setPrefWidth(100);
						
						cancelSelect.setOnMousePressed(e2 -> {
				            // Apply different style or effect when pressed
							cancelSelect.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
				        });
						cancelSelect.setOnMouseReleased(e2 -> {
				            // Reset style when mouse is released
							cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
				        });
						
						VBox inventoryLayout=new VBox();
						   inventoryLayout.setSpacing(20);
						   inventoryLayout.setAlignment(Pos.CENTER);
						   inventoryLayout.setPadding(new Insets(5));
						   inventoryLayout.getChildren().addAll(boughtTable,searchProduct,cancelSelect);
						   
						   Scene boughtScene=new Scene(inventoryLayout,600,600);
						   boughtStage.setScene(boughtScene);
						   boughtStage.show();
						   
						   
						   cancelSelect.setOnAction(e1 -> {
							   boughtStage.close();
						   });
						}
					});
					
					
	}
				
				if(person instanceof Manager)
				{
					Login.displaySuccessAlert("Attention!!!", "The manager can edit Name, Surname and Email of Costumer\nDouble-Click to Edit\nPress Enter to Store");
				}
				else
				{
					Login.displaySuccessAlert("Attention!!!", "A Cashier can edit Name, Surname and Email of Costumer\nDouble-Click to Edit\nPress Enter to Store");
				}		
				
	}
	
	public static void deleteManagementButtonCashier(TableView<Cashier> cashierTable)
	{
	    ObservableList<Cashier> cashierSelected = cashierTable.getSelectionModel().getSelectedItems();
	    GroceryStore.personList.removeAll(cashierSelected);
	    GroceryStore.cashierList.removeAll(cashierSelected);

	    GroceryStore.storeInPersonDatabase();
	    cashierTable.getItems().removeAll(cashierSelected);
	}
	
	public static void deleteManagementButtonManager(TableView<Manager> ManagerTable)
	{
	    ObservableList<Manager> managerSelected = ManagerTable.getSelectionModel().getSelectedItems();
	    GroceryStore.personList.removeAll(managerSelected);
	    GroceryStore.managerList.removeAll(managerSelected);

	    GroceryStore.storeInPersonDatabase();
	    ManagerTable.getItems().removeAll(managerSelected);
	}
	
	public static void deleteManagementButtonCostumer(TableView<Costumer> CostumerTable)
	{
	    ObservableList<Costumer> costumerSelected = CostumerTable.getSelectionModel().getSelectedItems();
	    GroceryStore.personList.removeAll(costumerSelected);
	    GroceryStore.costumerList.removeAll(costumerSelected);

	    GroceryStore.storeInPersonDatabase();
	    CostumerTable.getItems().removeAll(costumerSelected);
	}
	
	public static void searchCostumerButtonByName(TableView<Costumer> CostumerTable, TextField nameCostumerSearchtxfl)
	{

		String searchNametxt = nameCostumerSearchtxfl.getText().toLowerCase(); // Get the search text
        
		ArrayList<Costumer> allData = GroceryStore.costumerList;
		ArrayList<Costumer> filteredData = new ArrayList<>();

		for (int i = 0; i < allData.size(); i++)
		{
		    Costumer item = allData.get(i);
		    
		    if (item.getName().toLowerCase().contains(searchNametxt))
		    {
		        filteredData.add(item);
		    }
		}

		CostumerTable.getItems().clear();
		CostumerTable.getItems().addAll(filteredData);
	}
	
	public static void searchCostumerButtonBySurname(TableView<Costumer> CostumerTable,TextField surnameCostumerSearchtxfl)
	{
       String searchSurnametxt = surnameCostumerSearchtxfl.getText().toLowerCase(); // Get the search text
        
		ArrayList<Costumer> allData = GroceryStore.costumerList;
		ArrayList<Costumer> filteredData = new ArrayList<>();

		for (int i = 0; i < allData.size(); i++)
		{
		    Costumer item = allData.get(i);
		    
		    if (item.getSurname().toLowerCase().contains(searchSurnametxt))
		    {
		        filteredData.add(item);
		    }
		}

		CostumerTable.getItems().clear();
		CostumerTable.getItems().addAll(filteredData);
	}
	public static void searchCostumerButtonByEmail(TableView<Costumer> CostumerTable,TextField emailCostumerSearchtxfl)
	{
       String searchEmailtxt = emailCostumerSearchtxfl.getText().toLowerCase(); // Get the search text
        
		ArrayList<Costumer> allData = GroceryStore.costumerList;
		ArrayList<Costumer> filteredData = new ArrayList<>();

		for (int i = 0; i < allData.size(); i++)
		{
		    Costumer item = allData.get(i);
		    
		    if (item.getEmail().toLowerCase().contains(searchEmailtxt))
		    {
		        filteredData.add(item);
		    }
		}

		CostumerTable.getItems().clear();
		CostumerTable.getItems().addAll(filteredData);
	}
	public static void searchCostumerButtonByNameAndSurname(TableView<Costumer> CostumerTable,TextField nameCostumerSearchtxfl,TextField surname)
	{
       String searchNametxt = nameCostumerSearchtxfl.getText().toLowerCase(); // Get the search text
        String surnamesearch=surname.getText().toLowerCase();
		ArrayList<Costumer> allData = GroceryStore.costumerList;
		ArrayList<Costumer> filteredData = new ArrayList<>();

		for (int i = 0; i < allData.size(); i++)
		{
		    Costumer item = allData.get(i);
		    
		    if (item.getSurname().toLowerCase().contains(surnamesearch) && item.getName().toLowerCase().contains(searchNametxt))
		    {
		        filteredData.add(item);
		    }
		}

		CostumerTable.getItems().clear();
		CostumerTable.getItems().addAll(filteredData);
	}
	public static void searchCostumerButtonBySurnameAndEmail(TableView<Costumer> CostumerTable,TextField surnameCostumerSearchtxfl,TextField email)
	{
       String searchsurname = surnameCostumerSearchtxfl.getText().toLowerCase(); // Get the search text
        String emailsearch=email.getText().toLowerCase();
		ArrayList<Costumer> allData = GroceryStore.costumerList;
		ArrayList<Costumer> filteredData = new ArrayList<>();

		for (int i = 0; i < allData.size(); i++)
		{
		    Costumer item = allData.get(i);
		    
		    if (item.getSurname().toLowerCase().contains(searchsurname) && item.getEmail().toLowerCase().contains(emailsearch))
		    {
		        filteredData.add(item);
		    }
		}

		CostumerTable.getItems().clear();
		CostumerTable.getItems().addAll(filteredData);
	}
	public static void searchCostumerButtonByNameAndEmail(TableView<Costumer> CostumerTable,TextField name,TextField email)
	{
       String searchname = name.getText().toLowerCase(); // Get the search text
        String emailsearch=email.getText().toLowerCase();
		ArrayList<Costumer> allData = GroceryStore.costumerList;
		ArrayList<Costumer> filteredData = new ArrayList<>();

		for (int i = 0; i < allData.size(); i++)
		{
		    Costumer item = allData.get(i);
		    
		    if (item.getName().toLowerCase().contains(searchname) && item.getEmail().toLowerCase().contains(emailsearch))
		    {
		        filteredData.add(item);
		    }
		}

		CostumerTable.getItems().clear();
		CostumerTable.getItems().addAll(filteredData);
	}
	public static void searchCostumerButton(TableView<Costumer> CostumerTable,TextField name,TextField email,TextField surname)
	{
		String namesearch=name.getText().toLowerCase();
		String surnamesearch=surname.getText().toLowerCase();
		String emailsearch=email.getText().toLowerCase();
		
		ArrayList<Costumer> allData = GroceryStore.costumerList;
		ArrayList<Costumer> filteredData = new ArrayList<>();

		for (int i = 0; i < allData.size(); i++)
		{
		    Costumer item = allData.get(i);
		    
		    if (item.getName().toLowerCase().contains(namesearch) && item.getEmail().toLowerCase().contains(emailsearch) && item.getSurname().toLowerCase().contains(surnamesearch))
		    {
		        filteredData.add(item);
		    }
		}

		CostumerTable.getItems().clear();
		CostumerTable.getItems().addAll(filteredData);
	}
	public static void viewAll(TableView<Costumer> CostumerTable)
	{
		
		ArrayList<Costumer> allData = GroceryStore.costumerList;
		ArrayList<Costumer> filteredData = new ArrayList<>();

		for (int i = 0; i < allData.size(); i++)
		{
		    Costumer item = allData.get(i);
		    
		   
		        filteredData.add(item);
		 
		}

		CostumerTable.getItems().clear();
		CostumerTable.getItems().addAll(filteredData);
	}
	
}
