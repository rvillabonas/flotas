package flota.controller;

import java.sql.Date;

import com.jfoenix.controls.JFXButton;

import flota.entity.Conductor;
import flota.entity.Flota;
import flota.entity.Vehiculo;
import flota.gateway.base.FlotaMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class FlotaController {
	private FlotaMapper floMap;

	@FXML
	private TableView<Flota> tvFlotas;
	@FXML
	private TableColumn<Flota, Integer> clIdFlota;
	@FXML
	private TableColumn<Flota, String> clNombre;
	@FXML
	private TableColumn<Flota, String> clDescript;
	@FXML
	private TableColumn<Flota, Date> clFecCrea;
	@FXML
	private TextField tfNombreFlota;
	@FXML
	private TextArea txADescript;
	@FXML
	private TableView<Vehiculo> tvwVehiculos;
	@FXML
	private TableColumn<Vehiculo, String> clPlaca;
	@FXML
	private TableColumn<Vehiculo, String> clMarca;
	@FXML
	private TableColumn<Vehiculo, String> clModelo;
	@FXML
	private TableColumn<Vehiculo, Double> clTopeVeh; // ojo
	@FXML
	private TableColumn<Vehiculo, Integer> clIdConductor;
	@FXML
	private TableView<Conductor> tvwConduct;
	@FXML
	private TableColumn<Conductor, String> clIdCConduct;
	@FXML
	private TableColumn<Conductor, String> clCondNombre1;
	@FXML
	private TableColumn<Conductor, String> clCondApe1 ;
	@FXML
	private TableColumn<Conductor, String> clCondApe2 ;
	@FXML
	private TableColumn<Conductor, String> clCondEstado;

	ObservableList<Flota> flotaObLista = FXCollections.observableArrayList();
	ObservableList<Vehiculo> vehiculoObLista = FXCollections.observableArrayList();
	ObservableList<Conductor> conductoObLista = FXCollections.observableArrayList();

	@FXML
	private Pane pnlCond, pnlVehi, pnlGest;
	@FXML
	private JFXButton btnAdd, btnUpd, btnDel, btnAddVe, btnAddCo, btnAddVeh, btnAddConduct;

	@FXML
	public void initialize() {
		floMap = new FlotaMapper();
		clIdFlota.setCellValueFactory(new PropertyValueFactory<Flota, Integer>(""));
		clNombre.setCellValueFactory(new PropertyValueFactory<Flota, String>(""));
		clDescript.setCellValueFactory(new PropertyValueFactory<Flota, String>(""));
		clFecCrea.setCellValueFactory(new PropertyValueFactory<Flota, Date>(""));
	
		flotaObLista = FXCollections.observableArrayList(floMap.getAllFlotas());
		
		/*btnUpd.setDisable(true);
		btnDel.setDisable(true);*/
	}

	
	
}
