package flota.controller;

import java.sql.Date;

import com.jfoenix.controls.JFXButton;

import flota.entity.Rol;
import flota.entity.Usuario;
import flota.gateway.base.RolMapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class RolController {

	@FXML
	private TableView<Usuario> usuarioTBL;
	@FXML
	private TableColumn<Usuario, String> usuarioCL;
	@FXML
	private TableColumn<Usuario, String> claveCL;
	@FXML
	private TableColumn<Usuario, Date> ultIngCL;
	@FXML
	private TableColumn<Usuario, String> nombreRolCL;

	ObservableList<Usuario> usuarioObLista = FXCollections.observableArrayList();
	ObservableList<Rol> usuarioObListRoles = FXCollections.observableArrayList();

	@FXML
	private Pane pnlSearch, pnlAdd, pnlUpd, pnlDel;
	@FXML
	private JFXButton btnSearch, btnAdd, btnUpd, btnDel;
	@FXML
	private TextField tfUsuNue;
	@FXML
	private TextField tfClaveNue;
	@FXML
	private ComboBox<String> rolCbxItem;

	@FXML
	public void initialize() {
		System.out.println("ENTRO ");
		RolMapper rol;
		rol = new RolMapper();
		usuarioCL.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nickname"));
		claveCL.setCellValueFactory(new PropertyValueFactory<Usuario, String>("password"));
		ultIngCL.setCellValueFactory(new PropertyValueFactory<Usuario, Date>("fechaUltIngreso"));
		nombreRolCL.setCellValueFactory(
				cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdRol().getNombre()));

		usuarioObLista = FXCollections.observableArrayList(rol.findAll());
		usuarioTBL.setItems(usuarioObLista);
		getRoles(rol).forEach(r -> {
			rolCbxItem.getItems().add(r.getNombre());

		});

	}

	/**
	 * Retornal la lista de roles del aplicacion.
	 * 
	 * @param rol
	 * @return
	 */
	public ObservableList<Rol> getRoles(RolMapper rol) {
		usuarioObListRoles = FXCollections.observableArrayList(rol.buscarTodo());
		return usuarioObListRoles;
	}

	@FXML
	private void gestionarUsu(ActionEvent event) {
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

	@FXML
	public void crearUsuario() {
		Usuario us = new Usuario();

		System.out.println("Datos " + rolCbxItem.getSelectionModel().getSelectedItem());

		System.out.println("Hola");
	}

}
