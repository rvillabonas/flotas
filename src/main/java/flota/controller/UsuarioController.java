package flota.controller;

import flota.gateway.base.UsuarioMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
	public void login(ActionEvent event) {

		System.out.println("Hola");

	}

}
