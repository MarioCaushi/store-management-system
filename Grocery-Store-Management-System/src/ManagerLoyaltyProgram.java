import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;



public class ManagerLoyaltyProgram {

	public static void managerLoyaltyPointsButton(Button[] buttons,BorderPane ManagerHomeBP,Person person)
	{
		buttons[0].setDisable(false);
		buttons[1].setDisable(false);
		buttons[2].setDisable(false);
		buttons[3].setDisable(false);
		buttons[4].setDisable(true);
		
		Label welcomeLabel=new Label("Welcome");
		welcomeLabel.setAlignment(Pos.CENTER);
		welcomeLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 25pt;");
		
		Text instrtext=new Text("This is the Loyalty Program.");
		Text instrtext1=new Text("Here managers set the conditions for Loyalty Points and Discounts");
		
		VBox loyaltyInstr=new VBox();
		loyaltyInstr.setAlignment(Pos.CENTER);
		loyaltyInstr.setSpacing(10);
		loyaltyInstr.setPadding(new Insets(20));
		loyaltyInstr.getChildren().addAll(welcomeLabel,instrtext,instrtext1);
		
		Text text1=new Text("A costumer needs to have bought: ");
		
		TextField numberOfItemsBought=new TextField();
		numberOfItemsBought.setPromptText("No. of Items bought");
		
		Text text2=new Text(" items, to achieve: ");
		
		TextField numberLoyaltyPoints=new TextField();
		numberLoyaltyPoints.setPromptText("No. of Loyalty Points");
		
		Text text3=new Text(" Loyalty Points ");
		
		HBox firstRow =new HBox();
		firstRow.setAlignment(Pos.CENTER);
		firstRow.setSpacing(5);
		firstRow.getChildren().addAll(text1,numberOfItemsBought,text2,numberLoyaltyPoints,text3);
		
        Text text4=new Text("A costumer needs to have: ");
		
		TextField txfl1=new TextField();
		txfl1.setPromptText("No. of Loyalty Points");
		
		Text text5=new Text(" Loyalty Points to qualify for:  ");
		
		TextField numberLoyaltyPoints1=new TextField();
		numberLoyaltyPoints1.setPromptText(" Dicsount percentage");
		
		Text text6=new Text(" % Discount. ");
		
		HBox secondRow =new HBox();
		secondRow.setAlignment(Pos.CENTER);
	    secondRow.setSpacing(5);
		secondRow.getChildren().addAll(text4,txfl1,text5,numberLoyaltyPoints1,text6);
		
		VBox rowsLP=new VBox();
		rowsLP.setAlignment(Pos.CENTER);
		rowsLP.setSpacing(10);
		rowsLP.getChildren().addAll(firstRow,secondRow);
		
		
		Button updateStats=new Button("Update");
		
		updateStats.setStyle("-fx-background-color:#7FEE7E; -fx-text-fill:white;");
		updateStats.setPrefWidth(100);
		
		updateStats.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			updateStats.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		updateStats.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			updateStats.setStyle("-fx-background-color:#7FEE7E; -fx-text-fill:white;");
		});
		
		updateStats.setOnAction(e -> {
			
			if(numberOfItemsBought.getText().isBlank() || numberLoyaltyPoints.getText().isBlank() || 
					txfl1.getText().isBlank() || numberLoyaltyPoints1.getText().isBlank())
			{
				Login.displayInfo("Update Information!", "Complete all the fields first");
			}
			else
			{
				try {
					int noitems=Integer.valueOf(numberOfItemsBought.getText());
					int noLP=Integer.valueOf(numberLoyaltyPoints.getText());
					int noLP1=Integer.valueOf(txfl1.getText());
					double percentage=Double.parseDouble(numberLoyaltyPoints1.getText());
					
					GroceryStore.setNoOfItems(noitems);
					GroceryStore.setDiscount(percentage);
					GroceryStore.setLoyaltyPoints(noLP1);
				
					
					for(int i=0;i<GroceryStore.personList.size();i++)
					{
						if(GroceryStore.personList.get(i) instanceof Costumer)
						{
							Costumer costumer =(Costumer)GroceryStore.personList.get(i);
							
							try {
							    int x = (costumer.sizeItemsBought() / GroceryStore.getNoOfItems()) * noLP;
							    costumer.setLoyaltyPoints(x);
							} catch (ArithmeticException ex) {
							    // Handle the divide-by-zero scenario
							    int x = 1 * noLP; // For example, set some default value
							    costumer.setLoyaltyPoints(x);
							}

							
						if(costumer.getLoyaltyPoints() >= GroceryStore.getLoyaltyPoints())
						{
							costumer.setDiscount(GroceryStore.getDiscount());
						}
						else
						{
							costumer.setDiscount(0);
						}
						
						GroceryStore.personList.set(i, costumer);
					}
	
				}
					GroceryStore.storeInPersonDatabase();
					
				}
				catch(IllegalArgumentException e1)
				{
					Login.displayErrorAlert("Update Error","Enter Numbers not Strings into the TextFields");
				}
			}
				
		});
		
		VBox managerLP=new VBox();
		managerLP.setAlignment(Pos.CENTER);
		managerLP.setSpacing(30);
		managerLP.getChildren().addAll(loyaltyInstr,rowsLP,updateStats);
		
		ManagerHomeBP.setCenter(managerLP);
	}
}
	
