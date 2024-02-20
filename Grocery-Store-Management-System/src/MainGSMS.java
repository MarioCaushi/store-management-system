import java.io.IOException;

import javafx.application.*;
import javafx.stage.Stage;

public class MainGSMS extends Application {

	//The start/beginning
	//The login form
	@Override
	public void start(Stage primaryStage)
	{
		
		Login.login(primaryStage);
		
	}  
 
	public static void main(String[] args) 
	{
		
		GroceryStore grocerystore=new GroceryStore();
		    
		try {  
			GroceryStore.openPersonDatabase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GroceryStore.arrangeDatabase();
		
	
		launch(args);
	}

}
