package flota.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;

import flota.entity.Rol;
import flota.entity.Usuario;
import flota.gateway.base.RolMapper;
import flota.view.tables.UsuarioTableView;
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
	private TableView<UsuarioTableView> usuarioTBL;
	@FXML
	private TableColumn<UsuarioTableView, String> usuarioCL;
	@FXML
	private TableColumn<UsuarioTableView, String> claveCL;
	@FXML
	private TableColumn<UsuarioTableView, Date> ultIngCL;
	@FXML
	private TableColumn<UsuarioTableView, String> nombreRolCL;

	ObservableList<UsuarioTableView> usuarioObLista = FXCollections.observableArrayList();
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
		List<Usuario> us = new ArrayList<Usuario>();
		usuarioCL.setCellValueFactory(new PropertyValueFactory<UsuarioTableView, String>("usuNickname"));
		claveCL.setCellValueFactory(new PropertyValueFactory<UsuarioTableView, String>("usuClave"));
		ultIngCL.setCellValueFactory(new PropertyValueFactory<UsuarioTableView, Date>("usuIngreso"));
		nombreRolCL.setCellValueFactory(new PropertyValueFactory<UsuarioTableView, String>("nombreRol"));
		us = rol.findAll();

		for (Usuario i : us) {
			UsuarioTableView utv = new UsuarioTableView();
			utv.setUsuNickname(i.getNickname());
			utv.setUsuClave(i.getPassword());
			utv.setUsuIngreso(i.getFechaUltIngreso());
			utv.setNombreRol(i.getIdRol().getNombre());
			usuarioObLista.add(utv);
			}

		usuarioTBL.setItems(usuarioObLista);
		getRoles(rol).forEach(r -> {
			rolCbxItem.getItems().add(r.getIdRol() + " - "+  r.getNombre() );
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
	public void crearUsuario () {
	 Usuario us = new Usuario(); 
	 
	 System.out.println("Datos " + rolCbxItem.getValue().substring(0,1)   );
		
		
		
		
		System.out.println("Hola");
	}
	

}
