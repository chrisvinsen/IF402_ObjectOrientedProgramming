package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class InputFormController implements Initializable {
	@FXML
	public TextField txtId, txtProductName, txtPrice, txtStock;
	@FXML
	public ComboBox<String> cboCategory;

	ObservableList<String> categoryLists = FXCollections.observableArrayList("Bakery", "Makanan Kaleng", "Makanan Ringan", "Makanan Instan", "Minuman", "Sembako");

	ObservableList<Item> items;

	@FXML
	public void handleBtnAdd(){
		int id = Integer.parseInt(txtId.getText());
		String productName = txtProductName.getText();
		int price = Integer.parseInt(txtPrice.getText());
		String category = cboCategory.getValue().toString();
		int stock = Integer.parseInt(txtStock.getText());
		Item i = new Item(id, productName, price, category, stock);
		items.add(i);
	}

	public void setListItem(ObservableList<Item> items){
		this.items = items;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cboCategory.setItems(categoryLists);

	}

}
