package controler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import business.Book;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class FormControler implements Initializable {

	@FXML
	TableView<Book> tblDataView;
	@FXML
	TextField txtSearch;
	@FXML
	TableColumn<Book, String> isbn;
	@FXML
	TableColumn<Book, String> title;

	public void searchBook() {
		// System.out.println("Books ");
		DataAccess access = new DataAccessFacade();
		Book b = access.searchBook(txtSearch.getText());
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(b);
		if (b != null) {
			// System.out.println(b.getIsbn());
			// tblDataView.setItems(FXCollections.observableArrayList(b));
			isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
			title.setCellValueFactory(new PropertyValueFactory<>("title"));
			tblDataView.getItems().setAll(bookList);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
