import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

public class CashierPOS {

	public static void cashierPOSButton(Button[] buttons,BorderPane ManagerHomeBP,Person person,TableView<Costumer> CostumerTable)
	{
		buttons[0].setDisable(false);
		buttons[1].setDisable(false);
		buttons[2].setDisable(false);
		buttons[3].setDisable(false);
		buttons[4].setDisable(true);
		
		ObservableList<Costumer> costumerSelected = CostumerTable.getSelectionModel().getSelectedItems();
		Costumer costumer=costumerSelected.get(0);
	   
		//Creating three buttons to choose what table to view
				Button inventoryButton =new Button("Inventory");
				inventoryButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				inventoryButton .setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					inventoryButton .setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				inventoryButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					inventoryButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				
				Button POSButton =new Button("POS");
				POSButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
				
				POSButton.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					POSButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				POSButton.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					POSButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		        });
				
				Button[] managementButtonsArr= {inventoryButton ,POSButton};
				
				managementButtonsArr[0].setDisable(true);
				managementButtonsArr[1].setDisable(false);
				
				
				HBox managementButtons=new HBox();
				managementButtons.setAlignment(Pos.TOP_CENTER);
				managementButtons.setSpacing(10);
				managementButtons.getChildren().addAll(inventoryButton ,POSButton);
				
		
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
				productTable.setEditable(false);
				

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
				
				Button addToPOS=new Button("Add to POS");
				addToPOS.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
				addToPOS.setPrefWidth(100);
				
				addToPOS.setOnMousePressed(e -> {
		            // Apply different style or effect when pressed
					addToPOS.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				addToPOS.setOnMouseReleased(e -> {
		            // Reset style when mouse is released
					addToPOS.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
		        });
				
				addToPOS.setOnAction(e -> {
					
					ObservableList<Product> productSelected = productTable.getSelectionModel().getSelectedItems();
					Product product=productSelected.get(0);		
					
					Stage selectPOS=new Stage();
					
					ComboBox<Integer> selectQuantity=Register.createComboBox(1, product.getQuantity());
					selectQuantity.setPromptText("Quantity");
				
					Button continueSelect=new Button("Continue");
					continueSelect.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
					continueSelect.setPrefWidth(100);
					
					continueSelect.setOnMousePressed(e1 -> {
			            // Apply different style or effect when pressed
						continueSelect.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
			        });
					continueSelect.setOnMouseReleased(e1 -> {
			            // Reset style when mouse is released
						continueSelect.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
			        });
					
					
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
					
					
					VBox selectQuantityVB=new VBox();
					selectQuantityVB.setAlignment(Pos.CENTER);
					selectQuantityVB.setSpacing(20);
					selectQuantityVB.getChildren().addAll(selectQuantity,continueSelect,cancelSelect);
					
					Scene selectQuantityScene=new Scene(selectQuantityVB,300,200);
					
					selectPOS.setTitle("POS Select Quantity");
					selectPOS.setResizable(false);
					selectPOS.setScene(selectQuantityScene);
					selectPOS.show();
						
					cancelSelect.setOnAction(e3 -> {
						selectPOS.close();
					});
			
					continueSelect.setOnAction(e4 -> {
						
						if(selectQuantity.getValue() ==null)
						{
							Login.displayInfo("Quantity Select Message", "Select quantity");
						}
						else
						{
							if(GroceryStore.isSupplierEmpty(product))
							{
								ProductSold productSold=new ProductSold(product.getName(),product.getCategory(),product.getPrice(),selectQuantity.getValue());
								productSold.setSerialNumber(product.getSerialNumber());
								GroceryStore.salesList.add(productSold);
							}
							else
							{
								ProductSold productSold=new ProductSold(product.getName(),product.getCategory(),product.getPrice(),selectQuantity.getValue(),product.getSupplier());
								productSold.setSerialNumber(product.getSerialNumber());
								GroceryStore.salesList.add(productSold);
							}
						selectPOS.close();
						}
						
					});
										
				});
				
				Text selectButtonInstr=new Text("To add to POS select an item first.");
				
				VBox selectPOS=new VBox();
				selectPOS.setAlignment(Pos.CENTER);
				selectPOS.setSpacing(5);
				selectPOS.getChildren().addAll(addToPOS,selectButtonInstr);
				
				
				  VBox POSSelectLayout =new VBox();
				  POSSelectLayout.setSpacing(20);
				  POSSelectLayout.setAlignment(Pos.CENTER);
				  POSSelectLayout.setPadding(new Insets(5));
				  POSSelectLayout.getChildren().addAll(managementButtons,productTable,searchProduct,selectPOS);
			
				  Login.displayInfo("POS Inventory Message", "Cashiers cannot edit here");
				  
				ManagerHomeBP.setCenter(POSSelectLayout);		
				
				POSButton.setOnAction(e ->{
					continueButtonActionn(buttons, costumer,ManagerHomeBP,person,CostumerTable);
				});
	}
	
	public static void continueButtonActionn(Button[] buttons,Costumer costumer,BorderPane managerHomeBP,Person person,TableView<Costumer> CostumerTable)
	{
		buttons[0].setDisable(false);
		buttons[1].setDisable(false);
		buttons[2].setDisable(false);
		buttons[3].setDisable(false);
		buttons[4].setDisable(true);
		
		
		
		Button inventoryButton =new Button("Inventory");
		inventoryButton .setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		inventoryButton .setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			inventoryButton .setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		inventoryButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			inventoryButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		
		Button POSButton =new Button("POS");
		POSButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
		
		POSButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			POSButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		POSButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			POSButton.setStyle("-fx-background-color:#BA55D3; -fx-text-fill:white;");
        });
		
		Button[] managementButtonsArr= {inventoryButton ,POSButton};
		
		managementButtonsArr[0].setDisable(false);
		managementButtonsArr[1].setDisable(true);
		
		
		HBox managementButtons=new HBox();
		managementButtons.setAlignment(Pos.TOP_CENTER);
		managementButtons.setSpacing(10);
		managementButtons.getChildren().addAll(inventoryButton ,POSButton);
		
		Label costumerInfo=new Label(costumer.toString(true));
		costumerInfo.setStyle("-fx-font-weight:bold;-fx-font-size:10pt;");
		

		TableView<ProductSold> productSoldTable=new TableView<>();
		
		TableColumn<ProductSold,String> categoryColumnProductTable=new TableColumn<ProductSold,String>("Category");
		categoryColumnProductTable.setCellValueFactory(new PropertyValueFactory<ProductSold,String>("category"));
		
		TableColumn<ProductSold, String> nameColumnProductTable = new TableColumn<>("Name");
		nameColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameColumnProductTable.setCellFactory(TextFieldTableCell.forTableColumn());
		nameColumnProductTable.setOnEditCommit(event -> {
		    ProductSold product = event.getRowValue();
		    product.setName(event.getNewValue());
		    GroceryStore.storeInPersonDatabase();
		});
		
		TableColumn<ProductSold, Integer> quantityColumnProductTable = new TableColumn<>("Quantity");
		quantityColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		quantityColumnProductTable.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		quantityColumnProductTable.setOnEditCommit(event -> {
			ProductSold product = event.getRowValue();
		    product.setQuantity(event.getNewValue());
		    GroceryStore.storeInPersonDatabase();
		});

		TableColumn<ProductSold, Double> priceColumnProductTable = new TableColumn<>("Price");
		priceColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("price"));
		priceColumnProductTable.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
		priceColumnProductTable.setOnEditCommit(event -> {
			ProductSold product = event.getRowValue();
		    product.setPrice(event.getNewValue());
		    GroceryStore.storeInPersonDatabase();
		});

		TableColumn<ProductSold, String> supplierColumnProductTable = new TableColumn<>("Supplier");
		supplierColumnProductTable.setCellValueFactory(new PropertyValueFactory<>("supplier"));
		supplierColumnProductTable.setCellFactory(TextFieldTableCell.forTableColumn());
		supplierColumnProductTable.setOnEditCommit(event -> {
			ProductSold product = event.getRowValue();
		    product.setSupplier(event.getNewValue());
		    GroceryStore.storeInPersonDatabase();
		});

		
		TableColumn<ProductSold,Integer> serialnumberColumnProductTable=new TableColumn<ProductSold,Integer>("SerialNo");
		serialnumberColumnProductTable.setCellValueFactory(new PropertyValueFactory<ProductSold,Integer>("serialNumber"));
		
		TableColumn<ProductSold,String> dateAddedColumnProductTable=new TableColumn<ProductSold,String>("Date Added");
		dateAddedColumnProductTable.setCellValueFactory(new PropertyValueFactory<ProductSold,String>("dateAdded"));
		
		productSoldTable.getColumns().addAll(categoryColumnProductTable,nameColumnProductTable,
				quantityColumnProductTable,priceColumnProductTable,supplierColumnProductTable,serialnumberColumnProductTable,dateAddedColumnProductTable);
		
		productSoldTable.getItems().addAll(GroceryStore.salesList);
		
		productSoldTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
		productSoldTable.setStyle("-fx-background-color:transparent");
		productSoldTable.setEditable(false);
		

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

		    ArrayList<ProductSold> allData = GroceryStore.salesList;
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

		    productSoldTable.getItems().clear();
		    productSoldTable.getItems().addAll(filteredData);

		    // Clear search fields after filtering
		    nameProductSearch.setText("");
		    supplierProductSearch.setText("");
		    categoryProductSearch.setValue(null);
		});

		HBox searchProduct=new HBox();
		searchProduct.setSpacing(12);
		searchProduct.setAlignment(Pos.CENTER);
		searchProduct.getChildren().addAll(categoryProductSearch,nameProductSearch,supplierProductSearch,serialnoProductSearch,searchProductButton);
		
		Button sellButton=new Button("Sell");
		sellButton.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
		sellButton.setPrefWidth(100);
		
		sellButton.setOnMousePressed(e -> {
            // Apply different style or effect when pressed
			sellButton.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
        });
		sellButton.setOnMouseReleased(e -> {
            // Reset style when mouse is released
			sellButton.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
        });
		
		
		VBox POSLayout =new VBox();
		 POSLayout.setSpacing(15);
		 POSLayout.setAlignment(Pos.CENTER);
		 POSLayout.setPadding(new Insets(5));
		 POSLayout.getChildren().addAll(managementButtons,costumerInfo,productSoldTable,searchProduct,sellButton);
		
		 managerHomeBP.setCenter(POSLayout);		
	    
		  managementButtonsArr[0].setOnAction(e -> {
			  cashierPOSButton( buttons,managerHomeBP, person,CostumerTable);
			});
		  
		  
		  
		  
		  sellButton.setOnAction(e -> {
			  
			  if(GroceryStore.salesList.size()==0)
			  {
				  Login.displayInfo("POS Sell Message", "Select products");
			  }
			  else
			  {
				Stage sellPOS=new Stage();
				
				Label priceWIthoutDiscount=new Label("Price without Discount: "+GroceryStore.calculateCostWithoutDiscount());
				Label priceWithDiscount=new Label("Price with Discount:  "+GroceryStore.calculateCostWithDiscount(costumer));
		
			
				Button continueSelect=new Button("Continue");
				continueSelect.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
				continueSelect.setPrefWidth(100);
				
				continueSelect.setOnMousePressed(e1 -> {
		            // Apply different style or effect when pressed
					continueSelect.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-border-color: black;");
		        });
				continueSelect.setOnMouseReleased(e1 -> {
		            // Reset style when mouse is released
					continueSelect.setStyle("-fx-background-color:#6699CC; -fx-text-fill:white;");
		        });
				
				
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
				
				
				VBox selectQuantityVB=new VBox();
				selectQuantityVB.setAlignment(Pos.CENTER);
				selectQuantityVB.setSpacing(20);
				selectQuantityVB.getChildren().addAll(priceWIthoutDiscount,priceWithDiscount,continueSelect,cancelSelect);
				
				Scene selectQuantityScene=new Scene(selectQuantityVB,300,200);
				
				sellPOS.setTitle("POS Sell");
				sellPOS.setResizable(false);
				sellPOS.setScene(selectQuantityScene);
				sellPOS.show();
					
				cancelSelect.setOnAction(e3 -> {
					sellPOS.close();
				});
				
				continueSelect.setOnAction(e1 -> {
					
					LocalDate currentDate = LocalDate.now();
					
			        int year = currentDate.getYear();
			        int month = currentDate.getMonthValue();
			        int day = currentDate.getDayOfMonth();
			        
			        for (int i = 0; i < GroceryStore.salesList.size(); i++) 
			        {
			            int soldQuantity = GroceryStore.salesList.get(i).getQuantity();

			            GroceryStore.salesList.get(i).setYearSold(year);
			            GroceryStore.salesList.get(i).setMonthSold(month);
			            GroceryStore.salesList.get(i).setDaySold(day);

			            GroceryStore.productList.add(GroceryStore.salesList.get(i));
			            costumer.addBoughtItems(GroceryStore.salesList.get(i));

			            Product product = null;

			            for (int j = 0; j < GroceryStore.productList.size(); j++) 
			            {
			                if (GroceryStore.productList.get(j).getSerialNumber() == GroceryStore.salesList.get(i).getSerialNumber()) 
			                {
			                    product = GroceryStore.productList.get(j);
			                    break;
			                }
			            }

			            if (product != null)
			            {
			                if ((product.getQuantity() - soldQuantity == 0 ) || (product.getQuantity() - soldQuantity < 0 ))
			                {
			                    GroceryStore.productList.remove(product);
			                } 
			                else 
			                {
			                    product.setQuantity(product.getQuantity() - soldQuantity);
			                }
			            }
			        }
			        
			        int index=GroceryStore.personList.indexOf(costumer);
			        GroceryStore.personList.set(index, costumer);
			        
			        GroceryStore.storeInPersonDatabase();
			        
			        sellPOS.close();
			        
			        productSoldTable.getItems().clear();
			        GroceryStore.salesList.clear();
				});
			  }
		  });
	    
	}
	
	
}
