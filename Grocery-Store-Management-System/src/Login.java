import java.io.File;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Login {

	public static void login(Stage primaryStage)
	{
		 
		//Creating the first layout of the log-in form components
		BorderPane borderpane=new BorderPane();
		
		//Create label to put titleText inside of
		Label titleLabel=new Label("Grocery-Store-Management-System");
		titleLabel.setAlignment(Pos.CENTER);
		titleLabel.setFont(Font.font("Times New Roman", 35)); // Set font size to 20
		titleLabel.setStyle("-fx-font-weight: bold;"); // Set font weight to bold
		titleLabel.setTextFill(Color.LIGHTCORAL); // Set text color to blue
		
		//Create a pane to put label in
		StackPane titlePane=new StackPane();
		titlePane.getChildren().add(titleLabel);
		StackPane.setAlignment(titleLabel, Pos.CENTER); // Align the label in the center
		
		borderpane.setTop(titlePane);
		
		//Create a VBox to put the other components in
		VBox loginFormPane=new VBox();
		loginFormPane.setPadding(new Insets(150));
		loginFormPane.setSpacing(10);
		
		Label loginLabel1=new Label("Welcome");
		loginLabel1.setAlignment(Pos.BASELINE_CENTER);
		loginLabel1.setFont(Font.font("Arial", 30)); // Set font size to 20
		loginLabel1.setStyle("-fx-font-weight: bold;"); // Set font weight to bold
		
		Label loginLabel2=new Label("Enter username and password to login");
		loginLabel2.setAlignment(Pos.BASELINE_CENTER);
		loginLabel2.setFont(Font.font("Arial", 15)); // Set font size to 20
		
		//Create VBOX to put loginLabel1 and loginLabel2 in
		VBox loginLabelsPane=new VBox();
		loginLabelsPane.getChildren().addAll(loginLabel1,loginLabel2);
		loginLabelsPane.setAlignment(Pos.CENTER);
		loginLabelsPane.setSpacing(5);
		
		TextField usernametxfl=new TextField();
		usernametxfl.setPrefColumnCount(1);
		usernametxfl.setAlignment(Pos.BASELINE_LEFT);
		usernametxfl.setPromptText("Username");
		
		PasswordField passwordtxfl=new PasswordField();
		passwordtxfl.setPrefColumnCount(1);
		passwordtxfl.setAlignment(Pos.BASELINE_LEFT);
		passwordtxfl.setPromptText("Password");
		
	 
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
		
		//Setting action on the register button
		registerBtn.setOnAction(e -> Register.registerBtnAction(primaryStage));
		 
		//Create VBOX to put the buttons in
		VBox loginButtonsPane=new VBox();
		loginButtonsPane.getChildren().addAll(loginbtn,orLabel,registerBtn);
		loginButtonsPane.setAlignment(Pos.CENTER);
		loginButtonsPane.setSpacing(5);
		
		
		loginFormPane.getChildren().addAll(loginLabelsPane,createSpacer(5),usernametxfl,passwordtxfl,createSpacer(10),loginButtonsPane);

		borderpane.setCenter(loginFormPane);
		
		
		//Create scene
		Scene loginScene=new Scene(borderpane,600,600);
		
		//Add scene to stage to display
		primaryStage.setTitle("OOP-Project");
		primaryStage.setScene(loginScene);
		primaryStage.setResizable(true);
		primaryStage.show();
		
		loginbtn.setOnAction(e -> {
			try {
				loginActionBtn(usernametxfl, passwordtxfl,primaryStage);
			} catch (ClassNotFoundException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		});
		
		
	}
	
	//A method to create a blank region of a specified height to stimulate manual spacing
		private static Region createSpacer(double height) 
		{
		    Region spacer = new Region();
		    spacer.setPrefHeight(height);
		    return spacer;
		}
		
		private static boolean checkValidityLogin(TextField usernametxfl, TextField passwordtxfl) throws ClassNotFoundException, IOException {

		    for (int i = 0; i < GroceryStore.personList.size(); i++) {
		        if (usernametxfl.getText().equals(GroceryStore.personList.get(i).getUsername()) &&
		            passwordtxfl.getText().equals(GroceryStore.personList.get(i).getPassword())) {
		            return true; // Credentials match, return true immediately
		        }
		    }
		    
		    return false; // No match found in the entire list
		}

	
	private static boolean isManagerLogin(TextField usernametxfl)
	{
		boolean x=false;
		for(int i=0;i<GroceryStore.personList.size();i++)
		{
			if(usernametxfl.getText().equals(GroceryStore.personList.get(i).getUsername()))
			{
				if(GroceryStore.personList.get(i) instanceof Manager)
				{
					x=true;
				}
			}
		}
		return x;
	}
	
	private static void loginActionBtn(TextField usernametxfl,TextField passwordtxfl,Stage primaryStage) throws ClassNotFoundException, IOException 
	{
		Stage stage=new Stage();
		stage.setTitle("Login Message");
		Text text=new Text();
		if(checkValidityLogin(usernametxfl,passwordtxfl)) 
		{
			if (isManagerLogin(usernametxfl))
			{
			    text.setText("Welcome Manager");
			    ManagerHome.loginManager(primaryStage, usernametxfl, passwordtxfl);
			} else 
			{
			    text.setText("Welcome Cashier");
			    CashierHome.loginCashier( primaryStage, usernametxfl, passwordtxfl);
			}

		}
		else 
		{
			text.setText("Invalid");
		}
		Button button=new Button("Close");
		button.setAlignment(Pos.CENTER);
		VBox pane=new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(text,button);
		pane.setSpacing(10);
		Scene scene=new Scene(pane,300,100);
		stage.setScene(scene);
		stage.setAlwaysOnTop(true);
		stage.show();
		
		button.setOnAction(e -> {
			stage.close();
		});
	}
	
	public static void databaseAvailability(File file)
	{
		
		Stage stage=new Stage();
		stage.setTitle("Database Message");
		Text text=new Text();	
		
	  if (file.exists() && file.length() > 0)
	  {
		text.setText("Database loaded...");	
	  }
	  else
	  {
		 text.setText("Database is empty...");	
	  }
	  
	  Button button=new Button("Close");
		button.setAlignment(Pos.CENTER);
		VBox pane=new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().addAll(text,button);
		pane.setSpacing(10);
		Scene scene=new Scene(pane,300,100);
		stage.setScene(scene);
		stage.setAlwaysOnTop(true);
		stage.show();

		
		button.setOnAction(e ->{
			stage.close();
		});
  }
	
	//a method to display an alert
	 public static void displayErrorAlert(String title, String content) {
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(content);
	        alert.showAndWait();
	    }  
	 //A method to display a success
	 public static void displaySuccessAlert(String title, String content) {
	        Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(content);
	        alert.showAndWait();
	    }
	 
	 public static void displayInfo(String title,String content)
	 {
		 Stage stage=new Stage();
			stage.setTitle(title);
			Text text=new Text(content);
			Button button=new Button("Close");
			button.setAlignment(Pos.CENTER);
			VBox pane=new VBox();
			pane.setAlignment(Pos.CENTER);
			pane.getChildren().addAll(text,button);
			pane.setSpacing(10);
			Scene scene=new Scene(pane,300,100);
			stage.setScene(scene);
			stage.setAlwaysOnTop(true);
			stage.show();
			
			button.setOnAction(e -> {
				stage.close();
			});
	 }
	 
}
