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
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class SalesReport {

	public static void salesButtonAction(BorderPane managerHomeBP,Button[] buttons)
	{
		buttons[0].setDisable(false);
		buttons[1].setDisable(false);
		buttons[2].setDisable(false);
		buttons[3].setDisable(true);
		buttons[4].setDisable(false);
		
		try {
			GroceryStore.openPersonDatabaseWithoutMessage();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GroceryStore.arrangeProductDatabase();
		
		//Creating four buttons to choose what table to view
				Button dailyTableButton=new Button("Daily");
				dailyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				dailyTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					dailyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				dailyTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					dailyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				
				Button weeklyTableButton=new Button("Weekly");
				weeklyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				weeklyTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					weeklyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				weeklyTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					weeklyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				
				Button monthlyTableButton=new Button("Monthly");
				monthlyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				monthlyTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					monthlyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				monthlyTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					monthlyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				Button yearlyTableButton=new Button("Yearly");
				yearlyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				yearlyTableButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					yearlyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				yearlyTableButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					yearlyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				
				Button[] buttonsArr= {dailyTableButton,weeklyTableButton,monthlyTableButton,yearlyTableButton};
				
				buttonsArr[0].setDisable(true);
				buttonsArr[1].setDisable(false);
				buttonsArr[2].setDisable(false);
				buttonsArr[3].setDisable(false);
				
				
				HBox managementButtons=new HBox();
				managementButtons.setAlignment(Pos.TOP_CENTER);
				managementButtons.setSpacing( 10);
				managementButtons.getChildren().addAll(dailyTableButton,weeklyTableButton,monthlyTableButton,yearlyTableButton);
		
				TableView<ProductSold> salesTable=new TableView<>();
				
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
				
				TableColumn<ProductSold,String> datesoldColumnProductTable=new TableColumn<ProductSold,String>("Date Sold");
				datesoldColumnProductTable.setCellValueFactory(new PropertyValueFactory<ProductSold,String>("dateSold"));
				
				
				salesTable.getColumns().addAll(categoryColumnProductTable,nameColumnProductTable,
						quantityColumnProductTable,priceColumnProductTable,supplierColumnProductTable,serialnumberColumnProductTable,datesoldColumnProductTable);


					salesTable.getItems().addAll(GroceryStore.dailySalesList);

				
				salesTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
				salesTable.setStyle("-fx-background-color:transparent");
				salesTable.setEditable(false);
				

				ComboBox<String> categoryProductSearch =new ComboBox<>();
				categoryProductSearch.setPromptText("Category");
				categoryProductSearch.getItems().addAll("Fruit","Vegetable","Beverages","Bakery","Dairy","Meat & Fish","Freezer","Alcoholics",
						"Health & Beauty","Snacks");
				
				TextField nameProductSearch=new TextField();
				nameProductSearch.setPromptText("Name");
				nameProductSearch.setPrefColumnCount(1 );
				nameProductSearch.setPrefWidth( 150);
				
				TextField supplierProductSearch=new TextField();
				supplierProductSearch.setPromptText("Supplier");
				supplierProductSearch.setPrefColumnCount(1 );
				supplierProductSearch.setPrefWidth( 150);
				
				TextField serialnoProductSearch=new TextField();
				serialnoProductSearch.setPromptText("Serial Number");
				serialnoProductSearch.setPrefColumnCount( 1);
				serialnoProductSearch.setPrefWidth( 150);
				
				
				
				Button searchProductButton=new Button("Search");
				searchProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
				searchProductButton.setPrefWidth( 100);
				
				searchProductButton.setOnMousePressed(e  -> {
		            // Apply different style or effect when pressed
					searchProductButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				searchProductButton.setOnMouseReleased(e  -> {
		            // Reset style when mouse is released
					searchProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width:  1px;");
		        });
				
				searchProductButton.setOnAction(e  -> {
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

				    ArrayList<ProductSold> allData = GroceryStore.dailySalesList;
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

				    salesTable.getItems().clear();
				    salesTable.getItems().addAll(filteredData);

				    // Clear search fields after filtering
				    nameProductSearch.setText("");
				    supplierProductSearch.setText("");
				    categoryProductSearch.setValue(null);
				});

				HBox searchProduct=new HBox();
				searchProduct.setSpacing( 12);
				searchProduct.setAlignment(Pos.CENTER);
				searchProduct.getChildren().addAll(categoryProductSearch,nameProductSearch,supplierProductSearch,serialnoProductSearch,searchProductButton);
				
				Button calculateProfit=new Button("Calculate Profit");
				calculateProfit.setStyle("-fx-background-color: #8080FF; -fx-text-fill:white;");
				calculateProfit.setPrefWidth( 100);
				
				calculateProfit.setOnMousePressed(e2 -> {
		            // Apply different style or effect when pressed
					calculateProfit.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				calculateProfit.setOnMouseReleased(e2 -> {
		            // Reset style when mouse is released
					calculateProfit.setStyle("-fx-background-color: #8080FF; -fx-text-fill:white;");
		        });
				
				calculateProfit.setOnAction(e -> {
					
					Stage profitStage=new Stage();
					
					double sum=0;
					
					for (int i=0;i<GroceryStore.dailySalesList.size();i++)
					{
						sum=sum+(GroceryStore.dailySalesList.get(i).getPrice()*GroceryStore.dailySalesList.get(i).getQuantity());
					}
					
					Label profitLabel =new Label("Daily Profit: "+sum);
					profitLabel.setStyle("-fx-font-weight:bold;-fx-font-size: 10pt;");
					
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
					cancelSelect.setOnAction(e1  -> {
						profitStage.close();
					});
					
					VBox profitVB=new VBox();
					profitVB.setAlignment(Pos.CENTER);
					profitVB.setSpacing(20);
					profitVB.getChildren().addAll(profitLabel,cancelSelect);
					
					Scene profitScene=new Scene(profitVB,300,200);
					profitStage.setTitle("Profit");
					profitStage.setScene(profitScene);
					profitStage.setResizable(false);
					profitStage.show();
					
					
				});
				
				VBox salesLayout=new VBox();
				salesLayout.setSpacing(10);
				salesLayout.setAlignment(Pos.CENTER);
				salesLayout.getChildren().addAll(managementButtons,salesTable,searchProduct,calculateProfit);
				
				managerHomeBP.setCenter(salesLayout);

				
				weeklyTableButton.setOnAction(e -> {
					weeklyButton(managerHomeBP,buttons);
				});
				
				monthlyTableButton.setOnAction(e -> {
					monthlyButton(managerHomeBP,buttons);
				});
				
				yearlyTableButton.setOnAction(e -> {
					yearlyButton( managerHomeBP,buttons);
				});
				
	}
	
	public static void weeklyButton(BorderPane managerHomeBP,Button[] buttons)
	{
		
		//Creating four buttons to choose what table to view
		Button dailyTableButton=new Button("Daily");
		dailyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		dailyTableButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			dailyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		dailyTableButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			dailyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button weeklyTableButton=new Button("Weekly");
		weeklyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		weeklyTableButton.setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			weeklyTableButton .setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		weeklyTableButton .setOnMouseReleased(e -> {
            // Reset style when mouse is released
			weeklyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button monthlyTableButton =new Button("Monthly");
		monthlyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		monthlyTableButton.setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			monthlyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		monthlyTableButton.setOnMouseReleased(e  -> {
            // Reset style when mouse is released
			monthlyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		Button yearlyTableButton =new Button("Yearly");
		yearlyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		yearlyTableButton .setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			yearlyTableButton .setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		yearlyTableButton .setOnMouseReleased(e  -> {
            // Reset style when mouse is released
			yearlyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button[] buttonsArr = {dailyTableButton ,weeklyTableButton ,monthlyTableButton ,yearlyTableButton };
		
		buttonsArr[0].setDisable(false);
		buttonsArr[1].setDisable(true);
		buttonsArr[2].setDisable(false);
		buttonsArr[3].setDisable(false);
		
		
		HBox managementButtons =new HBox();
		managementButtons .setAlignment(Pos.TOP_CENTER);
		managementButtons .setSpacing( 10);
		managementButtons .getChildren().addAll(dailyTableButton ,weeklyTableButton ,monthlyTableButton ,yearlyTableButton );

		TableView<ProductSold> salesTable =new TableView<>();
		
		TableColumn<ProductSold,String> categoryColumnProductTable =new TableColumn<ProductSold,String>("Category");
		categoryColumnProductTable .setCellValueFactory(new PropertyValueFactory<ProductSold,String>("category"));
		
		TableColumn<ProductSold, String> nameColumnProductTable  = new TableColumn<>("Name");
		nameColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<ProductSold, Integer> quantityColumnProductTable  = new TableColumn<>("Quantity");
		quantityColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("quantity"));

		TableColumn<ProductSold, Double> priceColumnProductTable  = new TableColumn<>("Price");
		priceColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<ProductSold, String> supplierColumnProductTable  = new TableColumn<>("Supplier");
		supplierColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("supplier"));
		
		TableColumn<ProductSold,Integer> serialnumberColumnProductTable =new TableColumn<ProductSold,Integer>("SerialNo");
		serialnumberColumnProductTable .setCellValueFactory(new PropertyValueFactory<ProductSold,Integer>("serialNumber"));
		
		TableColumn<ProductSold,String> datesoldColumnProductTable =new TableColumn<ProductSold,String>("Date Sold");
		datesoldColumnProductTable .setCellValueFactory(new PropertyValueFactory<ProductSold,String>("dateSold"));
		
		
		salesTable .getColumns().addAll(categoryColumnProductTable ,nameColumnProductTable ,
				quantityColumnProductTable ,priceColumnProductTable ,supplierColumnProductTable ,serialnumberColumnProductTable ,datesoldColumnProductTable );


			salesTable .getItems().addAll(GroceryStore.weeklySalesList);

		
		salesTable .setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		salesTable .setStyle("-fx-background-color:transparent");
		salesTable .setEditable(false);
		

		ComboBox<String> categoryProductSearch  =new ComboBox<>();
		categoryProductSearch .setPromptText("Category");
		categoryProductSearch .getItems().addAll("Fruit","Vegetable","Beverages","Bakery","Dairy","Meat & Fish","Freezer","Alcoholics",
				"Health & Beauty","Snacks");
		
		TextField nameProductSearch=new TextField();
		nameProductSearch.setPromptText("Name");
		nameProductSearch.setPrefColumnCount(1 );
		nameProductSearch.setPrefWidth( 150);
		
		TextField supplierProductSearch=new TextField();
		supplierProductSearch.setPromptText("Supplier");
		supplierProductSearch.setPrefColumnCount( 1);
		supplierProductSearch.setPrefWidth( 150);
		
		TextField serialnoProductSearch=new TextField();
		serialnoProductSearch.setPromptText("Serial Number");
		serialnoProductSearch.setPrefColumnCount( 1);
		serialnoProductSearch.setPrefWidth( 150);
		
		
		
		Button searchWeeklyProductButton=new Button("Search");
		searchWeeklyProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
		searchWeeklyProductButton.setPrefWidth( 100);
		
		searchWeeklyProductButton.setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			searchWeeklyProductButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		searchWeeklyProductButton.setOnMouseReleased(e  -> {
            // Reset style when mouse is released
			searchWeeklyProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
        });
		
		searchWeeklyProductButton.setOnAction(e  -> {
		    String name = nameProductSearch .getText().toLowerCase();
		    String supplier = supplierProductSearch .getText().toLowerCase();
		    String category = categoryProductSearch .getValue();
		    int serialNo = 0;

		    try {
		        serialNo = Integer.parseInt(serialnoProductSearch .getText());
		    } catch (NumberFormatException ex) {
		        
		    }

		    ArrayList<ProductSold> allData = GroceryStore.weeklySalesList;
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

		    salesTable .getItems().clear();
		    salesTable .getItems().addAll(filteredData);

		    // Clear search fields after filtering
		    nameProductSearch .setText("");
		    supplierProductSearch .setText("");
		    categoryProductSearch .setValue(null);
		});

		HBox searchWeeklyProduct=new HBox();
		searchWeeklyProduct.setSpacing(12);
		searchWeeklyProduct.setAlignment(Pos.CENTER);
		searchWeeklyProduct.getChildren().addAll(categoryProductSearch ,nameProductSearch ,supplierProductSearch ,serialnoProductSearch ,searchWeeklyProductButton);
		
		Button  calculateWeeklyProfit=new Button("Calculate Profit");
		 calculateWeeklyProfit.setStyle("-fx-background-color: #8080FF; -fx-text-fill:white;");
		 calculateWeeklyProfit.setPrefWidth( 100);
		
		 calculateWeeklyProfit.setOnMousePressed(e2 -> {
            // Apply different style or effect when pressed
			 calculateWeeklyProfit.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		 calculateWeeklyProfit.setOnMouseReleased(e2 -> {
            // Reset style when mouse is released
			 calculateWeeklyProfit.setStyle("-fx-background-color: #8080FF; -fx-text-fill:white;");
        });
		
		 calculateWeeklyProfit.setOnAction(e  -> {
			
			Stage profitStage=new Stage();
			
			double sum=0;
			
			for (int i=0;i<GroceryStore.weeklySalesList.size();i++)
			{
				sum=sum+(GroceryStore.weeklySalesList.get(i).getPrice()*GroceryStore.weeklySalesList.get(i).getQuantity());
			}
			
			Label profitLabel  =new Label("Weekly Profit: "+sum);
			profitLabel .setStyle("-fx-font-weight:bold;-fx-font-size: 10pt;");
			
			Button cancelSelect=new Button("Cancel");
			cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
			cancelSelect.setPrefWidth( 100);
			
			cancelSelect.setOnMousePressed(e2 -> {
	            // Apply different style or effect when pressed
				cancelSelect.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
			cancelSelect.setOnMouseReleased(e2 -> {
	            // Reset style when mouse is released
				cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
	        });
			cancelSelect.setOnAction(e2 -> {
				profitStage.close();
			});
			
			VBox profitVB=new VBox();
			profitVB.setAlignment(Pos.CENTER);
			profitVB.setSpacing(20);
			profitVB.getChildren().addAll(profitLabel ,cancelSelect);
			
			Scene profitScene=new Scene(profitVB,300,200);
			profitStage.setTitle("Profit");
			profitStage.setScene(profitScene);
			profitStage.setResizable(false);
			profitStage.show();
			
			
		});
		
		VBox salesWeeklyLayout=new VBox();
		salesWeeklyLayout.setSpacing( 10);
		salesWeeklyLayout.setAlignment(Pos.CENTER);
		salesWeeklyLayout.getChildren().addAll(managementButtons ,salesTable ,searchWeeklyProduct,calculateWeeklyProfit);
		
		managerHomeBP.setCenter(salesWeeklyLayout);

		
		dailyTableButton.setOnAction(e -> {
			
			salesButtonAction( managerHomeBP,buttons);
		});
		
		monthlyTableButton.setOnAction(e -> {
			monthlyButton(managerHomeBP, buttons);
		});
		
		yearlyTableButton.setOnAction(e -> {
			yearlyButton(managerHomeBP, buttons);
		});
		
	}
	
	public static void monthlyButton(BorderPane managerHomeBP,Button[] buttons)
	{	
		
		//Creating four buttons to choose what table to view
		Button dailyTableButton=new Button("Daily");
		dailyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		dailyTableButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			dailyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		dailyTableButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			dailyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button weeklyTableButton=new Button("Weekly");
		weeklyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		weeklyTableButton.setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			weeklyTableButton .setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		weeklyTableButton .setOnMouseReleased(e -> {
            // Reset style when mouse is released
			weeklyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button monthlyTableButton =new Button("Monthly");
		monthlyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		monthlyTableButton.setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			monthlyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		monthlyTableButton.setOnMouseReleased(e  -> {
            // Reset style when mouse is released
			monthlyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		Button yearlyTableButton =new Button("Yearly");
		yearlyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		yearlyTableButton .setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			yearlyTableButton .setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		yearlyTableButton .setOnMouseReleased(e  -> {
            // Reset style when mouse is released
			yearlyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button[] buttonsArr = {dailyTableButton ,weeklyTableButton ,monthlyTableButton ,yearlyTableButton };
		
		buttonsArr[0].setDisable(false);
		buttonsArr[1].setDisable(false);
		buttonsArr[2].setDisable(true);
		buttonsArr[3].setDisable(false);
		
		
		HBox managementButtons =new HBox();
		managementButtons .setAlignment(Pos.TOP_CENTER);
		managementButtons .setSpacing( 10);
		managementButtons .getChildren().addAll(dailyTableButton ,weeklyTableButton ,monthlyTableButton ,yearlyTableButton );

		TableView<ProductSold> salesTable =new TableView<>();
		
		TableColumn<ProductSold,String> categoryColumnProductTable =new TableColumn<ProductSold,String>("Category");
		categoryColumnProductTable .setCellValueFactory(new PropertyValueFactory<ProductSold,String>("category"));
		
		TableColumn<ProductSold, String> nameColumnProductTable  = new TableColumn<>("Name");
		nameColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<ProductSold, Integer> quantityColumnProductTable  = new TableColumn<>("Quantity");
		quantityColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("quantity"));

		TableColumn<ProductSold, Double> priceColumnProductTable  = new TableColumn<>("Price");
		priceColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<ProductSold, String> supplierColumnProductTable  = new TableColumn<>("Supplier");
		supplierColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("supplier"));
		
		TableColumn<ProductSold,Integer> serialnumberColumnProductTable =new TableColumn<ProductSold,Integer>("SerialNo");
		serialnumberColumnProductTable .setCellValueFactory(new PropertyValueFactory<ProductSold,Integer>("serialNumber"));
		
		TableColumn<ProductSold,String> datesoldColumnProductTable =new TableColumn<ProductSold,String>("Date Sold");
		datesoldColumnProductTable .setCellValueFactory(new PropertyValueFactory<ProductSold,String>("dateSold"));
		
		
		salesTable .getColumns().addAll(categoryColumnProductTable ,nameColumnProductTable ,
				quantityColumnProductTable ,priceColumnProductTable ,supplierColumnProductTable ,serialnumberColumnProductTable ,datesoldColumnProductTable );


			salesTable .getItems().addAll(GroceryStore.monthlySalesList);

		
		salesTable .setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		salesTable .setStyle("-fx-background-color:transparent");
		salesTable .setEditable(false);
		

		ComboBox<String> categoryProductSearch  =new ComboBox<>();
		categoryProductSearch .setPromptText("Category");
		categoryProductSearch .getItems().addAll("Fruit","Vegetable","Beverages","Bakery","Dairy","Meat & Fish","Freezer","Alcoholics",
				"Health & Beauty","Snacks");
		
		TextField nameProductSearch=new TextField();
		nameProductSearch.setPromptText("Name");
		nameProductSearch.setPrefColumnCount(1 );
		nameProductSearch.setPrefWidth( 150);
		
		TextField supplierProductSearch=new TextField();
		supplierProductSearch.setPromptText("Supplier");
		supplierProductSearch.setPrefColumnCount( 1);
		supplierProductSearch.setPrefWidth( 150);
		
		TextField serialnoProductSearch=new TextField();
		serialnoProductSearch.setPromptText("Serial Number");
		serialnoProductSearch.setPrefColumnCount( 1);
		serialnoProductSearch.setPrefWidth( 150);
		
		
		
		Button searchWeeklyProductButton=new Button("Search");
		searchWeeklyProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
		searchWeeklyProductButton.setPrefWidth( 100);
		
		searchWeeklyProductButton.setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			searchWeeklyProductButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		searchWeeklyProductButton.setOnMouseReleased(e  -> {
            // Reset style when mouse is released
			searchWeeklyProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
        });
		
		searchWeeklyProductButton.setOnAction(e  -> {
		    String name = nameProductSearch .getText().toLowerCase();
		    String supplier = supplierProductSearch .getText().toLowerCase();
		    String category = categoryProductSearch .getValue();
		    int serialNo = 0;

		    try {
		        serialNo = Integer.parseInt(serialnoProductSearch .getText());
		    } catch (NumberFormatException ex) {
		        
		    }

		    ArrayList<ProductSold> allData = GroceryStore.monthlySalesList;
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

		    salesTable .getItems().clear();
		    salesTable .getItems().addAll(filteredData);

		    // Clear search fields after filtering
		    nameProductSearch .setText("");
		    supplierProductSearch .setText("");
		    categoryProductSearch .setValue(null);
		});

		HBox searchWeeklyProduct=new HBox();
		searchWeeklyProduct.setSpacing(12);
		searchWeeklyProduct.setAlignment(Pos.CENTER);
		searchWeeklyProduct.getChildren().addAll(categoryProductSearch ,nameProductSearch ,supplierProductSearch ,serialnoProductSearch ,searchWeeklyProductButton);
		
		Button  calculateWeeklyProfit=new Button("Calculate Profit");
		 calculateWeeklyProfit.setStyle("-fx-background-color: #8080FF; -fx-text-fill:white;");
		 calculateWeeklyProfit.setPrefWidth( 100);
		
		 calculateWeeklyProfit.setOnMousePressed(e2 -> {
            // Apply different style or effect when pressed
			 calculateWeeklyProfit.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		 calculateWeeklyProfit.setOnMouseReleased(e2 -> {
            // Reset style when mouse is released
			 calculateWeeklyProfit.setStyle("-fx-background-color: #8080FF; -fx-text-fill:white;");
        });
		
		 calculateWeeklyProfit.setOnAction(e  -> {
			
			Stage profitStage=new Stage();
			
			double sum=0;
			
			for (int i=0;i<GroceryStore.monthlySalesList.size();i++)
			{
				sum=sum+(GroceryStore.monthlySalesList.get(i).getPrice()*GroceryStore.monthlySalesList.get(i).getQuantity());
			}
			
			Label profitLabel  =new Label("Monthly Profit: "+sum);
			profitLabel .setStyle("-fx-font-weight:bold;-fx-font-size: 10pt;");
			
			Button cancelSelect=new Button("Cancel");
			cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
			cancelSelect.setPrefWidth( 100);
			
			cancelSelect.setOnMousePressed(e2 -> {
	            // Apply different style or effect when pressed
				cancelSelect.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
			cancelSelect.setOnMouseReleased(e2 -> {
	            // Reset style when mouse is released
				cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
	        });
			cancelSelect.setOnAction(e2 -> {
				profitStage.close();
			});
			
			VBox profitVB=new VBox();
			profitVB.setAlignment(Pos.CENTER);
			profitVB.setSpacing(20);
			profitVB.getChildren().addAll(profitLabel ,cancelSelect);
			
			Scene profitScene=new Scene(profitVB,300,200);
			profitStage.setTitle("Profit");
			profitStage.setScene(profitScene);
			profitStage.setResizable(false);
			profitStage.show();
			
			
		});
		
		VBox salesWeeklyLayout=new VBox();
		salesWeeklyLayout.setSpacing( 10);
		salesWeeklyLayout.setAlignment(Pos.CENTER);
		salesWeeklyLayout.getChildren().addAll(managementButtons ,salesTable ,searchWeeklyProduct,calculateWeeklyProfit);
		
		managerHomeBP.setCenter(salesWeeklyLayout);

		
		dailyTableButton.setOnAction(e -> {
			
			salesButtonAction( managerHomeBP,buttons);
		});
		
		weeklyTableButton.setOnAction(e -> {
			weeklyButton(managerHomeBP, buttons);
		});
		
		yearlyTableButton.setOnAction(e -> {
			yearlyButton( managerHomeBP, buttons);
		});
		
	}
	
	public static void yearlyButton(BorderPane managerHomeBP,Button[] buttons)
	{
		
		//Creating four buttons to choose what table to view
		Button dailyTableButton=new Button("Daily");
		dailyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		dailyTableButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			dailyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		dailyTableButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			dailyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button weeklyTableButton=new Button("Weekly");
		weeklyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		weeklyTableButton.setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			weeklyTableButton .setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		weeklyTableButton .setOnMouseReleased(e -> {
            // Reset style when mouse is released
			weeklyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button monthlyTableButton =new Button("Monthly");
		monthlyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		monthlyTableButton.setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			monthlyTableButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		monthlyTableButton.setOnMouseReleased(e  -> {
            // Reset style when mouse is released
			monthlyTableButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		Button yearlyTableButton =new Button("Yearly");
		yearlyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		yearlyTableButton .setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			yearlyTableButton .setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		yearlyTableButton .setOnMouseReleased(e  -> {
            // Reset style when mouse is released
			yearlyTableButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button[] buttonsArr = {dailyTableButton ,weeklyTableButton ,monthlyTableButton ,yearlyTableButton };
		
		buttonsArr[0].setDisable(false);
		buttonsArr[1].setDisable(false);
		buttonsArr[2].setDisable(false);
		buttonsArr[3].setDisable(true);
		
		
		HBox managementButtons =new HBox();
		managementButtons .setAlignment(Pos.TOP_CENTER);
		managementButtons .setSpacing( 10);
		managementButtons .getChildren().addAll(dailyTableButton ,weeklyTableButton ,monthlyTableButton ,yearlyTableButton );

		TableView<ProductSold> salesTable =new TableView<>();
		
		TableColumn<ProductSold,String> categoryColumnProductTable =new TableColumn<ProductSold,String>("Category");
		categoryColumnProductTable .setCellValueFactory(new PropertyValueFactory<ProductSold,String>("category"));
		
		TableColumn<ProductSold, String> nameColumnProductTable  = new TableColumn<>("Name");
		nameColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("name"));
		
		TableColumn<ProductSold, Integer> quantityColumnProductTable  = new TableColumn<>("Quantity");
		quantityColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("quantity"));

		TableColumn<ProductSold, Double> priceColumnProductTable  = new TableColumn<>("Price");
		priceColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<ProductSold, String> supplierColumnProductTable  = new TableColumn<>("Supplier");
		supplierColumnProductTable .setCellValueFactory(new PropertyValueFactory<>("supplier"));
		
		TableColumn<ProductSold,Integer> serialnumberColumnProductTable =new TableColumn<ProductSold,Integer>("SerialNo");
		serialnumberColumnProductTable .setCellValueFactory(new PropertyValueFactory<ProductSold,Integer>("serialNumber"));
		
		TableColumn<ProductSold,String> datesoldColumnProductTable =new TableColumn<ProductSold,String>("Date Sold");
		datesoldColumnProductTable .setCellValueFactory(new PropertyValueFactory<ProductSold,String>("dateSold"));
		
		
		salesTable .getColumns().addAll(categoryColumnProductTable ,nameColumnProductTable ,
				quantityColumnProductTable ,priceColumnProductTable ,supplierColumnProductTable ,serialnumberColumnProductTable ,datesoldColumnProductTable );


			salesTable .getItems().addAll(GroceryStore.yearlySalesList);

		
		salesTable .setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		salesTable .setStyle("-fx-background-color:transparent");
		salesTable .setEditable(false);
		

		ComboBox<String> categoryProductSearch  =new ComboBox<>();
		categoryProductSearch .setPromptText("Category");
		categoryProductSearch .getItems().addAll("Fruit","Vegetable","Beverages","Bakery","Dairy","Meat & Fish","Freezer","Alcoholics",
				"Health & Beauty","Snacks");
		
		TextField nameProductSearch=new TextField();
		nameProductSearch.setPromptText("Name");
		nameProductSearch.setPrefColumnCount(1 );
		nameProductSearch.setPrefWidth( 150);
		
		TextField supplierProductSearch=new TextField();
		supplierProductSearch.setPromptText("Supplier");
		supplierProductSearch.setPrefColumnCount( 1);
		supplierProductSearch.setPrefWidth( 150);
		
		TextField serialnoProductSearch=new TextField();
		serialnoProductSearch.setPromptText("Serial Number");
		serialnoProductSearch.setPrefColumnCount( 1);
		serialnoProductSearch.setPrefWidth( 150);
		
		
		
		Button searchWeeklyProductButton=new Button("Search");
		searchWeeklyProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
		searchWeeklyProductButton.setPrefWidth( 100);
		
		searchWeeklyProductButton.setOnMousePressed(e  -> {
            // Apply different style or effect when pressed
			searchWeeklyProductButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		searchWeeklyProductButton.setOnMouseReleased(e  -> {
            // Reset style when mouse is released
			searchWeeklyProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
        });
		
		searchWeeklyProductButton.setOnAction(e  -> {
		    String name = nameProductSearch .getText().toLowerCase();
		    String supplier = supplierProductSearch .getText().toLowerCase();
		    String category = categoryProductSearch .getValue();
		    int serialNo = 0;

		    try {
		        serialNo = Integer.parseInt(serialnoProductSearch .getText());
		    } catch (NumberFormatException ex) {
		        
		    }

		    ArrayList<ProductSold> allData = GroceryStore.yearlySalesList;
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

		    salesTable .getItems().clear();
		    salesTable .getItems().addAll(filteredData);

		    // Clear search fields after filtering
		    nameProductSearch .setText("");
		    supplierProductSearch .setText("");
		    categoryProductSearch .setValue(null);
		});

		HBox searchWeeklyProduct=new HBox();
		searchWeeklyProduct.setSpacing(12);
		searchWeeklyProduct.setAlignment(Pos.CENTER);
		searchWeeklyProduct.getChildren().addAll(categoryProductSearch ,nameProductSearch ,supplierProductSearch ,serialnoProductSearch ,searchWeeklyProductButton);
		
		Button  calculateWeeklyProfit=new Button("Calculate Profit");
		 calculateWeeklyProfit.setStyle("-fx-background-color: #8080FF; -fx-text-fill:white;");
		 calculateWeeklyProfit.setPrefWidth( 100);
		
		 calculateWeeklyProfit.setOnMousePressed(e2 -> {
            // Apply different style or effect when pressed
			 calculateWeeklyProfit.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		 calculateWeeklyProfit.setOnMouseReleased(e2 -> {
            // Reset style when mouse is released
			 calculateWeeklyProfit.setStyle("-fx-background-color: #8080FF; -fx-text-fill:white;");
        });
		
		 calculateWeeklyProfit.setOnAction(e  -> {
			
			Stage profitStage=new Stage();
			
			double sum=0;
			
			for (int i=0;i<GroceryStore.yearlySalesList.size();i++)
			{
				sum=sum+(GroceryStore.yearlySalesList.get(i).getPrice()*GroceryStore.yearlySalesList.get(i).getQuantity());
			}
			
			Label profitLabel  =new Label("Yearly Profit: "+sum);
			profitLabel .setStyle("-fx-font-weight:bold;-fx-font-size: 10pt;");
			
			Button cancelSelect=new Button("Cancel");
			cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
			cancelSelect.setPrefWidth( 100);
			
			cancelSelect.setOnMousePressed(e2 -> {
	            // Apply different style or effect when pressed
				cancelSelect.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
			cancelSelect.setOnMouseReleased(e2 -> {
	            // Reset style when mouse is released
				cancelSelect.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
	        });
			cancelSelect.setOnAction(e2 -> {
				profitStage.close();
			});
			
			VBox profitVB=new VBox();
			profitVB.setAlignment(Pos.CENTER);
			profitVB.setSpacing(20);
			profitVB.getChildren().addAll(profitLabel ,cancelSelect);
			
			Scene profitScene=new Scene(profitVB,300,200);
			profitStage.setTitle("Profit");
			profitStage.setScene(profitScene);
			profitStage.setResizable(false);
			profitStage.show();
			
			
		});
		
		VBox salesWeeklyLayout=new VBox();
		salesWeeklyLayout.setSpacing( 10);
		salesWeeklyLayout.setAlignment(Pos.CENTER);
		salesWeeklyLayout.getChildren().addAll(managementButtons ,salesTable ,searchWeeklyProduct,calculateWeeklyProfit);
		
		managerHomeBP.setCenter(salesWeeklyLayout);

		
		dailyTableButton.setOnAction(e -> {
			
			salesButtonAction( managerHomeBP,buttons);
		});
		
		weeklyTableButton.setOnAction(e -> {
			weeklyButton(managerHomeBP, buttons);
		});
		
		monthlyTableButton.setOnAction(e -> {
			monthlyButton(managerHomeBP,buttons);
		});
			
		}

}
