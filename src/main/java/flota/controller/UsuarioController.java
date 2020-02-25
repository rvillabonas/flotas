package flota.controller;

import flota.gateway.base.UsuarioMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

/**
 * 
 * @author rvs
 *
 */
public class UsuarioController {
	private UsuarioMapper us;
	@FXML
	Button btnLogin = new Button();
	@FXML
	private TextField txUser;
	@FXML
	private TextField txPassword;

	@FXML
	public void login(ActionEvent event) {
		us = new UsuarioMapper();
		String user = us.login(txUser.getText(), txPassword.getText());
		String  rol; 
		Alert alert = new Alert(AlertType.INFORMATION);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
		dialogPane.getStyleClass().add("dialog-pane");
		alert.setTitle("Inforrmación");
		if (!user.equals("")) {
			alert.setHeaderText("Bienvenido " + user +"!!!" );
			alert.setContentText("Aquí podrá gestionar su flota!!!");

		} else {
			alert.setHeaderText("Usuario o clave incorrectos.");
			alert.setContentText("Por favor verifique!");
		}
		alert.showAndWait();
		rol=us.obtenerRol(user); 
		
        System.out.println("here "  + rol);
		
	}

}
