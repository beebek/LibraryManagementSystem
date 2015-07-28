package controler;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class LoginControler implements Initializable {
	@FXML
	TextField txtUserName;
	@FXML
	TextField txtPassword;
	@FXML
	Button btnLogin;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction(event -> {
			// System.out.println(txtUserName.getText());
			// System.out.println(txtPassword.getText());
			DataAccess access = new DataAccessFacade();
			Auth check = access.login(txtUserName.getText(),
					txtPassword.getText());
			if (check != null) {
				JOptionPane.showMessageDialog(null, "Login Successfully");
				try {
					Stage primaryStage = new Stage();
					Parent root = FXMLLoader.load(getClass().getResource(
							"../fxml/form/Form.fxml"));
					Scene scene = new Scene(root, 600, 500);
					primaryStage.setScene(scene);
					primaryStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Login Fail");
				txtUserName.setText(" ");
				txtPassword.setText("");
			}

		});

	}

}
