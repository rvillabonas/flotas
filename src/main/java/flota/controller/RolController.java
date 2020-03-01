package flota.controller;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class RolController {
	@FXML
	private Pane pnlSearch, pnlAdd, pnlUpd, pnlDel;
	@FXML
	private JFXButton btnSearch, btnAdd, btnUpd, btnDel;

	@FXML
	private void gestionaAdmin(ActionEvent event) {

		if (event.getSource() == btnDel) {
			pnlDel.toFront();

		} else if (event.getSource() == btnAdd) {
			pnlAdd.toFront();

		} else if (event.getSource() == btnUpd) {
			pnlUpd.toFront();

		} else {
			pnlSearch.toFront();
		}

	}

}
