package flota.controller;

import java.sql.Date;

import com.jfoenix.controls.JFXButton;

import flota.config.Mensaje;
import flota.entity.Rol;
import flota.entity.Usuario;
import flota.gateway.base.RolMapper;
import flota.gateway.base.UsuarioMapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class RolController {
	private RolMapper rol;
	private UsuarioMapper up;
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
	private Pane pnlGest, pnlSearh;
	@FXML
	private JFXButton btnSearch, btnAdd, btnUpd, btnDel, btnNew;
	@FXML
	private TextField tfUsuNue;
	@FXML
	private TextField tfClaveNue;
	@FXML
	private ComboBox<String> rolCbxItem;

	@FXML
	public void initialize() {
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
		btnUpd.setDisable(true);
		btnDel.setDisable(true);
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

	/**
	 * Desplegar opciones sde acuerdo el rol.
	 * 
	 * @param event
	 */
	@FXML
	private void gestionarUsu(ActionEvent event) {
		if (event.getSource() == btnSearch) {
			pnlSearh.toFront();
		} else if (event.getSource() == btnAdd) {
			pnlGest.toFront();
			if (tfUsuNue.getText().isEmpty() || tfClaveNue.getText().isEmpty() || rolCbxItem.getValue() == null) {
				Alert alert = new Alert(AlertType.ERROR);
				DialogPane dp = alert.getDialogPane();
				dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
				dp.getStyleClass().add("dialog-pane");
				alert.setTitle(Mensaje.ERROR);
				alert.setHeaderText(Mensaje.OBLIGA);
				alert.setContentText(Mensaje.CONTEXT_INFO);
				alert.showAndWait();
			}

			else {
				rol = new RolMapper();
				Usuario us = new Usuario();
				us.setNickname(tfUsuNue.getText());
				us.setPassword(tfClaveNue.getText());
				us.setIdRol(rol.getById(rol.obtenerRol(rolCbxItem.getValue())));
				up = new UsuarioMapper();
				if (up.save(us)) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					DialogPane dp = alert.getDialogPane();
					dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
					dp.getStyleClass().add("dialog-pane");
					alert.setTitle(Mensaje.INFO);
					alert.setHeaderText(Mensaje.EXITO);
					alert.setContentText(Mensaje.CONTEXT_INFO_CRUD);
					alert.showAndWait();
					usuarioObLista.add(us);
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					DialogPane dp = alert.getDialogPane();
					dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
					dp.getStyleClass().add("dialog-pane");
					alert.setTitle(Mensaje.ERROR);
					alert.setHeaderText(Mensaje.ERROR);
					alert.setContentText(Mensaje.CONTEXT_INFO_CRUD_ERROR);
					alert.showAndWait();
				}
			}

		} else if (event.getSource() == btnUpd) {
			pnlGest.toFront();
			tfUsuNue.setEditable(false);
			if (tfUsuNue.getText().isEmpty() || tfClaveNue.getText().isEmpty() || rolCbxItem.getValue() == null) {
				Alert alert = new Alert(AlertType.ERROR);
				DialogPane dp = alert.getDialogPane();
				dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
				dp.getStyleClass().add("dialog-pane");
				alert.setTitle(Mensaje.ERROR);
				alert.setHeaderText(Mensaje.OBLIGA);
				alert.setContentText(Mensaje.CONTEXT_INFO);
				alert.showAndWait();
			} else {
				rol = new RolMapper();
				Usuario us = new Usuario();
				us.setNickname(tfUsuNue.getText());
				us.setPassword(tfClaveNue.getText());
				us.setIdRol(rol.getById(rol.obtenerRol(rolCbxItem.getValue())));
				up = new UsuarioMapper();
				if (up.update(us)) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					DialogPane dp = alert.getDialogPane();
					dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
					dp.getStyleClass().add("dialog-pane");
					alert.setTitle(Mensaje.INFO);
					alert.setHeaderText(Mensaje.EXITO);
					alert.setContentText(Mensaje.CONTEXT_INFO_CRUD);
					alert.showAndWait();
					usuarioObLista.set(usuarioTBL.getSelectionModel().getSelectedIndex(), us);
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					DialogPane dp = alert.getDialogPane();
					dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
					dp.getStyleClass().add("dialog-pane");
					alert.setTitle(Mensaje.ERROR);
					alert.setHeaderText(Mensaje.ERROR);
					alert.setContentText(Mensaje.CONTEXT_INFO_CRUD_ERROR);
					alert.showAndWait();
				}
			}

		} else if (event.getSource() == btnDel) {
			pnlGest.toFront();
			Usuario us = new Usuario();
			us = usuarioTBL.getSelectionModel().getSelectedItem();
			up = new UsuarioMapper();
			if (up.remove(us)) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				DialogPane dp = alert.getDialogPane();
				dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
				dp.getStyleClass().add("dialog-pane");
				alert.setTitle(Mensaje.INFO);
				alert.setHeaderText(Mensaje.EXITO);
				alert.setContentText(Mensaje.CONTEXT_INFO_CRUD);
				alert.showAndWait();
				usuarioObLista.remove(usuarioTBL.getSelectionModel().getSelectedIndex());
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				DialogPane dp = alert.getDialogPane();
				dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
				dp.getStyleClass().add("dialog-pane");
				alert.setTitle(Mensaje.ERROR);
				alert.setHeaderText(Mensaje.ERROR);
				alert.setContentText(Mensaje.CONTEXT_INFO_CRUD_ERROR);
				alert.showAndWait();
			}

		}

		else if (event.getSource() == btnNew) {
			pnlGest.toFront();
			btnAdd.setDisable(false);
			tfUsuNue.setText("");
			tfClaveNue.setText("");
			rolCbxItem.setValue(null);
			tfUsuNue.setEditable(true);
		}
	}

	@FXML
	private void manageEvents() {
		usuarioTBL.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Usuario>() {
			@Override
			public void changed(ObservableValue<? extends Usuario> observable, Usuario oldValue, Usuario newValue) {
				if (newValue != null) {
					tfUsuNue.setEditable(true);
					tfUsuNue.setText(newValue.getNickname());
					tfUsuNue.setEditable(false);
					tfClaveNue.setText(newValue.getPassword());
					rolCbxItem.setValue(newValue.getIdRol().getNombre());
					btnAdd.setDisable(true);
					btnUpd.setDisable(false);
					btnDel.setDisable(false);
				}
			}
		});

	}

}
