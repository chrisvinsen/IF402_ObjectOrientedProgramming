package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller {

	@FXML private TableView<Item> tableItem;

	@FXML
	private TableColumn<Item, Integer> colId, colProductName, colPrice, colCategory, colStock;

	@FXML
	private TextField searchField;

	@FXML
	private ObservableList<Item> items = FXCollections.observableArrayList(
			new Item(1, "Minyak Goreng Bimoli 1.5L", 25800, "Sembako", 100),
			new Item(2, "Beras Ramos 5kg", 66500, "Sembako", 50),
			new Item(3, "Kratingdeng", 5300, "Minuman", 200),
			new Item(4, "Sarden ABC Ukuran Besar", 22300, "Makanan Kaleng", 40),
			new Item(5, "Miatos Rasa Jagung Bakar 120g", 9800, "Makanan Ringan", 200),
			new Item(6, "Indomie Goreng Rasa Ayam", 2200, "Sembako", 2000),
			new Item(7, "Ultramilk UHT 1L", 13200, "Minuman", 50),
			new Item(8, "Roti Tawar 12 Potong", 12300, "Bakery", 10),
			new Item(9, "Roti Tawar 24 Potong", 22000, "Bakery", 15)
	);



	@FXML
	public void initialize(){
		colId.setCellValueFactory(new PropertyValueFactory<>("id"));
		colProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
		colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
		colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
		colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
//		tableItem.setItems(items);

		FilteredList<Item> filteredData = new FilteredList<>(items, p -> true);

		searchField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(item -> {
				if(newValue == null || newValue.isEmpty()){
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if(item.getProductName().toLowerCase().contains(lowerCaseFilter)){
					return true;
				}else if(item.getCategory().toLowerCase().contains(lowerCaseFilter)){
					return true;
				}else if(Integer.toString(item.getId()).contains(lowerCaseFilter) ){
					return true;
				}else if(Integer.toString(item.getPrice()).contains(lowerCaseFilter)){
					return true;
				}else if(Integer.toString(item.getStock()).contains(lowerCaseFilter)){
					return true;
				}

				return false;
			});
		});

		SortedList<Item> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tableItem.comparatorProperty());

		tableItem.setItems(sortedData);
	}

	@FXML void handleBtnEntry(){
		try{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("entryForm.fxml"));
			Parent entryForm = loader.load();
			Stage entryStage = new Stage();
			entryStage.setTitle("New Item");
			entryStage.setScene(new Scene(entryForm, 250, 250));
			entryStage.show();
			entryStage.requestFocus();
			InputFormController ec = loader.getController();
			ec.setListItem(items);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@FXML
	public void handleBtnDelete(){
		Item selectedItem = tableItem.getSelectionModel().getSelectedItem();
		items.remove(selectedItem);
	}


}
