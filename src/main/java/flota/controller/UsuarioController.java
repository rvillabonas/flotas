package flota.controller;

import flota.gateway.base.UsuarioMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
		us.login(txUser.getText(), txPassword.getText()); 

	}

}
