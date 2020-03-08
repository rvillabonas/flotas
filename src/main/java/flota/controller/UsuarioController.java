package flota.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import flota.entity.Usuario;
import flota.gateway.base.UsuarioMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 
 * @author rvs
 *
 */
public class UsuarioController {
	private UsuarioMapper us;
	@FXML
	private JFXButton btnLogin = new JFXButton();
	@FXML
	private TextField txUser;
	@FXML
	private TextField txPassword;

	@FXML
	private void login(ActionEvent event) throws IOException {
		us = new UsuarioMapper();
		Usuario usApp = us.login(txUser.getText().toUpperCase(), txPassword.getText());
		if (usApp == null)  {
			Alert alert2 = new Alert(AlertType.INFORMATION);
			DialogPane dialogPane2 = alert2.getDialogPane();
			dialogPane2.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
			dialogPane2.getStyleClass().add("dialog-pane");
			alert2.setTitle("Inforrmación");
			alert2.setHeaderText("Usuario o clave incorrectos.");
			alert2.setContentText("Por favor verifique!");
			alert2.showAndWait();
		}	
		else  {
			Alert alert1 = new Alert(AlertType.INFORMATION);
			DialogPane dialogPane1 = alert1.getDialogPane();
			dialogPane1.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
			dialogPane1.getStyleClass().add("dialog-pane");
			alert1.setTitle("Inforrmación");
			alert1.setHeaderText("Bienvenido " + usApp.getNickname() +" .Su rol es: " + usApp.getIdRol().getNombre() + "!!!");
			alert1.setContentText("Aquí podrá gestionar su flota!!!");
			alert1.showAndWait();
			Stage stage2 = new Stage();

			switch (usApp.getIdRol().getIdRol()) {
			case 0:
				break;
			case 1:
				Parent menu1 = FXMLLoader.load(getClass().getResource("/view/Administrador.fxml"));
				Scene scene = new Scene(menu1, 1100, 800);
				scene.getStylesheets().add(getClass().getResource("/css/flota_style.css").toExternalForm());
				stage2.setMaximized(false);
				stage2.setResizable(false);
				stage2.setTitle("Sistema de control de  flotas");
				stage2.setScene(scene);
				stage2.show();
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
			}

		} 
	}

}
