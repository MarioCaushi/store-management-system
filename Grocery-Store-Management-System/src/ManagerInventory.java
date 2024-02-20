import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.DoubleStringConverter;


public class ManagerInventory {
	
	public static void managerInventoryButtonAction(Button[] buttons,BorderPane ManagerHomeBP,Person person)
	{
		buttons[0].setDisable(false);
		buttons[1].setDisable(true);
		buttons[2].setDisable(false);
		buttons[3].setDisable(false);
		buttons[4].setDisable(false);
		
		try {
			GroceryStore.openPersonDatabaseWithoutMessage();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TableView<Product> productTable=new TableView<>();
		
		TableColumn<Product,String> categoryColumnProductTable=new TableColumn<Product,String>("Category");
		categoryColumnProductTable.setCellValueFactory(new PropertyValueFactory<Product,String>("category"));
		
		TableColumn<Product, String> nameColumnProductTable = new TableColumn<>("Name");
		nameColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameColumnProductTable.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumnProductTable.setOnEditCommit(event -> {
		    Product product = event.getRowValue();
		    product.setName(event.getNewValue());
		    GroceryStore.storeInPersonDatabase();
		});
		
		TableColumn<Product, Integer> quantityColumnProductTable = new TableColumn<>("Quantity");
		quantityColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		quantityColumnProductTable.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		quantityColumnProductTable.setOnEditCommit(event -> {
		    Product product = event.getRowValue();
		    product.setQuantity(event.getNewValue());
		    GroceryStore.storeInPersonDatabase();
		});

		TableColumn<Product, Double> priceColumnProductTable = new TableColumn<>("Price");
		priceColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("price"));
		priceColumnProductTable.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		priceColumnProductTable.setOnEditCommit(event -> {
		    Product product = event.getRowValue();
		    product.setPrice(event.getNewValue());
		    GroceryStore.storeInPersonDatabase();
		});

		TableColumn<Product, String> supplierColumnProductTable = new TableColumn<>("Supplier");
		supplierColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("supplier"));
		supplierColumnProductTable.setCellFactory(TextFieldTableCell.forTableColumn());
		supplierColumnProductTable.setOnEditCommit(event -> {
		    Product product = event.getRowValue();
		    product.setSupplier(event.getNewValue());
		    GroceryStore.storeInPersonDatabase();
		});

		
		TableColumn<Product,Integer> serialnumberColumnProductTable=new TableColumn<Product,Integer>("SerialNo");
		serialnumberColumnProductTable.setCellValueFactory(new PropertyValueFactory<Product,Integer>("serialNumber"));
		
		TableColumn<Product,String> dateAddedColumnProductTable=new TableColumn<Product,String>("Date Added");
		dateAddedColumnProductTable.setCellValueFactory(new PropertyValueFactory<Product,String>("dateAdded"));
		
		productTable.getColumns().addAll(categoryColumnProductTable,nameColumnProductTable,
				quantityColumnProductTable,priceColumnProductTable,supplierColumnProductTable,serialnumberColumnProductTable,dateAddedColumnProductTable);
		
		for(int i=0;i<GroceryStore.productList.size();i++)
		{
			
			if(GroceryStore.productList.get(i) instanceof ProductSold)
			{
				continue;
			}
			else
			{
				productTable.getItems().addAll(GroceryStore.productList.get(i));
			}
		}

		
		productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		productTable.setStyle("-fx-background-color:transparent");
		productTable.setEditable(true);
		
		//The add a product part
		
		ComboBox <String>categoryProduct =new ComboBox<>();
		categoryProduct.setPromptText("Category");
		categoryProduct.getItems().addAll("Fruit","Vegetable","Beverages","Bakery","Dairy","Meat & Fish","Freezer","Alcoholics",
				"Health & Beauty","Snacks");
		
		TextField nameProduct=new TextField();
		nameProduct.setPromptText("Name");
		nameProduct.setPrefColumnCount(1);
		nameProduct.setPrefWidth(100);
		
		TextField quantityProduct=new TextField();
		quantityProduct.setPromptText("Quantity");
		quantityProduct.setPrefColumnCount(1);
		quantityProduct.setPrefWidth(100);
		
		TextField priceProduct=new TextField();
		priceProduct.setPromptText("Price");
		priceProduct.setPrefColumnCount(1);
		priceProduct.setPrefWidth(100);
		
		TextField supplierProduct=new TextField();
		supplierProduct.setPromptText("Supplier-Not Obligatory");
		supplierProduct.setPrefColumnCount(1);
		supplierProduct.setPrefWidth(150);
		
		Button addProductButton=new Button("Add");
		if(person instanceof Manager)
		{
		addProductButton.setStyle("-fx-background-color:#7FEE7E; -fx-text-fill:white;");
		addProductButton.setPrefWidth(100);
		
		addProductButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			addProductButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		addProductButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			addProductButton.setStyle("-fx-background-color:#7FEE7E; -fx-text-fill:white;");
        });
		}
		else
		{
			addProductButton.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
			addProductButton.setPrefWidth(100);
			
			addProductButton.setOnMousePressed(e -> {
	            // Apply different style or effect when pressed
				addProductButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
	        });
			addProductButton.setOnMouseReleased(e -> {
	            // Reset style when mouse is released
				addProductButton.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
	        });
		}
		
		addProductButton.setOnAction(e ->{
			
			if(nameProduct.getText().isBlank() || quantityProduct.getText().isBlank() || priceProduct.getText().isBlank() ||
			        (categoryProduct.getValue() == null || categoryProduct.getValue().isBlank())) 
			{
				Login.displayInfo("Add Product Message", "You need to complete all the obligatory fields");
			}
			else
			{
				try {
					
				double price= Double.parseDouble(priceProduct.getText());
				int quantity=Integer.parseInt(quantityProduct.getText());
				
				if(!supplierProduct.getText().isBlank())
				{	
					if(GroceryStore.productList.isEmpty())
					{
						Product product=new Product(nameProduct.getText(),categoryProduct.getValue(),price,quantity, supplierProduct.getText());
						product.setSerialNumber((int) (Math.random() * 99000) + 1000);
						GroceryStore.productList.add(product);
						GroceryStore.storeInPersonDatabase();
						
						productTable.getItems().add(product);
						
						nameProduct.setText("");
						quantityProduct.setText("");
						priceProduct.setText("");
						supplierProduct.setText("");
						
					}
					else
					{
						Product product=new Product(nameProduct.getText(),categoryProduct.getValue(),price,quantity, supplierProduct.getText());
						
						int serialno;
						boolean x;

						do {
						    serialno = ((int) (Math.random() * 99000) + 1000);
						    x = false; // Reset the flag for each new serial number generated
						    
						    for (int i = 0; i < GroceryStore.productList.size(); i++) {
						        if (serialno == GroceryStore.productList.get(i).getSerialNumber()) {
						            x = true; 
						            break; 
						        }
						    }
						} while (x); 
						
						product.setSerialNumber(serialno);
						GroceryStore.productList.add(product);
						GroceryStore.storeInPersonDatabase();
						
						productTable.getItems().add(product);
						
						nameProduct.setText("");
						quantityProduct.setText("");
						priceProduct.setText("");
						supplierProduct.setText("");
		
					}
				}
				else
				{
					if(GroceryStore.productList.isEmpty())
					{
						Product product=new Product(nameProduct.getText(),categoryProduct.getValue(),price,quantity);
						product.setSerialNumber((int) (Math.random() * 99000) + 1000);
						GroceryStore.productList.add(product);
						GroceryStore.storeInPersonDatabase();
						
						productTable.getItems().add(product);
						
						nameProduct.setText("");
						quantityProduct.setText("");
						priceProduct.setText("");
						supplierProduct.setText("");			
					}
					else
					{
						Product product=new Product(nameProduct.getText(),categoryProduct.getValue(),price,quantity);
						
						int serialno;
						boolean x;

						do {
						    serialno = ((int) (Math.random() * 99000) + 1000);
						    x = false; // Reset the flag for each new serial number generated
						    
						    for (int i = 0; i < GroceryStore.productList.size(); i++) {
						        if (serialno == GroceryStore.productList.get(i).getSerialNumber()) {
						            x = true; 
						            break; 
						        }
						    }
						} while (x); 
						
						product.setSerialNumber(serialno);
						GroceryStore.productList.add(product);
						GroceryStore.storeInPersonDatabase();
						
						productTable.getItems().add(product);
						
						nameProduct.setText("");
						quantityProduct.setText("");
						priceProduct.setText("");
						supplierProduct.setText("");
					}
				}
			
				
				}
	
				catch(IllegalArgumentException e1)
				{
					Login.displayErrorAlert("Update Error","Enter Numbers not Strings into the TextFields");
				}
				
			}
		});
		
		
		HBox addProduct=new HBox();
		addProduct.setSpacing(10);
		addProduct.setAlignment(Pos.CENTER);
		addProduct.getChildren().addAll(categoryProduct,nameProduct,quantityProduct,priceProduct,supplierProduct,addProductButton);
		
		//The search a product part
		
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
		
		searchProductButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			searchProductButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		searchProductButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			searchProductButton.setStyle( "-fx-background-color: #E0E0E0; -fx-text-fill: black;-fx-border-color: black; -fx-border-width: 1px;");
        });
		
		searchProductButton.setOnAction(e -> {
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

		    ArrayList<Product> allData = GroceryStore.productList;
		    ArrayList<Product> filteredData = new ArrayList<>();

		    for (Product item : allData) {
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

		    productTable.getItems().clear();
		    productTable.getItems().addAll(filteredData);

		    // Clear search fields after filtering
		    nameProductSearch.setText("");
		    supplierProductSearch.setText("");
		    categoryProductSearch.setValue(null);
		});

		HBox searchProduct=new HBox();
		searchProduct.setSpacing(12);
		searchProduct.setAlignment(Pos.CENTER);
		searchProduct.getChildren().addAll(categoryProductSearch,nameProductSearch,supplierProductSearch,serialnoProductSearch,searchProductButton);
		
		//The delete product part
		
		Button deleteProduct =new Button("Delete");
		deleteProduct.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
		deleteProduct.setPrefWidth(100);
		
		deleteProduct.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			deleteProduct.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		deleteProduct.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			deleteProduct.setStyle("-fx-background-color: #FF8080; -fx-text-fill:white;");
        });
		
		deleteProduct.setOnAction(e -> {
			deleteInventoryButton(productTable);
		});
		
		 
	   Text deleteButtonInstr=new Text("To delete an item select it first.");
	   
	   //A VBox to put the buttons and textfields
	   VBox costumiseProduct=new VBox();
	   costumiseProduct.setSpacing(10);
	   costumiseProduct.setAlignment(Pos.CENTER);
	   costumiseProduct.getChildren().addAll(addProduct,searchProduct,deleteProduct,deleteButtonInstr);  
	   
	   //A VBox to put everything in the layout in
	   VBox inventoryLayout=new VBox();
	   inventoryLayout.setSpacing(20);
	   inventoryLayout.setAlignment(Pos.CENTER);
	   inventoryLayout.setPadding(new Insets(5));
	   inventoryLayout.getChildren().addAll(productTable,costumiseProduct);
	   
	   ManagerHomeBP.setCenter(inventoryLayout);
	   
	   Login.displaySuccessAlert("Attention!!!", "You can only edit Name,Quantiy,Price and Supplier Information \nDouble-Click to Edit\nPress Enter to Store");
	   
	}
	public static void deleteInventoryButton(TableView<Product> productTable)
	{
	    ObservableList<Product> productSelected = productTable.getSelectionModel().getSelectedItems();
	    GroceryStore.productList.removeAll(productSelected);

	    GroceryStore.storeInPersonDatabase();
	    productTable.getItems().removeAll(productSelected);
	}
}
