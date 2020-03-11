package flota.controller;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import com.jfoenix.controls.JFXButton;

import flota.constantes.Mensaje;
import flota.entity.Conductor;
import flota.entity.Flota;
import flota.entity.Persona;
import flota.entity.Vehiculo;
import flota.gateway.base.ConductorMapper;
import flota.gateway.base.FlotaMapper;
import flota.gateway.base.VehiculoMapper;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class FlotaController {
	private FlotaMapper fm;
	private VehiculoMapper vm;
	private ConductorMapper cm;
	private Persona p;
	private int idFlota;
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
	private TableColumn<Vehiculo, Integer> clModelo;
	@FXML
	private TableColumn<Vehiculo, Double> clTopeVeh; // ojo
	@FXML
	private TableColumn<Vehiculo, String> clIdConductor;
	@FXML
	private TableView<Conductor> tvwConduct;
	@FXML
	private TableColumn<Conductor, String> clIdCConduct;
	@FXML
	private TableColumn<Conductor, String> clCondNombre1;
	@FXML
	private TableColumn<Conductor, String> clCondApe1;
	@FXML
	private TableColumn<Conductor, String> clCondApe2;
	@FXML
	private TableColumn<Conductor, String> clCondEstado;

	ObservableList<Flota> flotaObLista = FXCollections.observableArrayList();
	ObservableList<Vehiculo> vehiculoObLista = FXCollections.observableArrayList();
	ObservableList<Conductor> conductoObLista = FXCollections.observableArrayList();

	@FXML
	private Pane pnlCond, pnlVehi, pnlGest;
	@FXML
	private JFXButton btnAdd, btnUpd, btnDel, btnAddVe, btnAddCo, btnAddVeh, btnAddConduct, btnNew;

	@FXML
	public void initialize() {

		Platform.runLater(() -> {
			fm = new FlotaMapper();
			clIdFlota.setCellValueFactory(new PropertyValueFactory<Flota, Integer>("idFlota"));
			clNombre.setCellValueFactory(new PropertyValueFactory<Flota, String>("nombre"));
			clDescript.setCellValueFactory(new PropertyValueFactory<Flota, String>("descripcion"));
			clFecCrea.setCellValueFactory(new PropertyValueFactory<Flota, Date>("fechaCreacion"));
			flotaObLista = FXCollections.observableArrayList(fm.findFlotaByClient(this.p.getPerDni()));
			tvFlotas.setItems(flotaObLista);
			btnUpd.setDisable(true);
			btnDel.setDisable(true);
			// Vehiculos
			vm = new VehiculoMapper();
			clPlaca.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("placa"));
			clMarca.setCellValueFactory(new PropertyValueFactory<Vehiculo, String>("marca"));
			clModelo.setCellValueFactory(new PropertyValueFactory<Vehiculo, Integer>("anioModelo"));
			clTopeVeh.setCellValueFactory(new PropertyValueFactory<Vehiculo, Double>("tope"));
			clIdConductor.setCellValueFactory(
					cellData -> new SimpleObjectProperty<>(cellData.getValue().getTgfConductor().getDniConductor()));			
			vehiculoObLista = FXCollections.observableArrayList(vm.findByIdClient(this.p.getPerDni()));
			tvwVehiculos.setItems(vehiculoObLista);
			
			// Conductores
			cm = new ConductorMapper();
			clIdCConduct.setCellValueFactory(new PropertyValueFactory<Conductor, String>("dniConductor"));
			clCondNombre1.setCellValueFactory(new PropertyValueFactory<Conductor, String>("nombre1"));
			clCondApe1.setCellValueFactory(new PropertyValueFactory<Conductor, String>("apellido1"));
			clCondApe2.setCellValueFactory(new PropertyValueFactory<Conductor, String>("apellido2"));
			clCondEstado.setCellValueFactory(new PropertyValueFactory<Conductor, String>("estado"));
			conductoObLista = FXCollections.observableArrayList(cm.findByClient(this.p.getPerDni()));
			tvwConduct.setItems(conductoObLista);
		});

		/*
		 * btnUpd.setDisable(true); btnDel.setDisable(true);
		 */
	}

	/**
	 * Contruye la persona
	 * 
	 * @param per
	 */
	public void setPersona(Persona per) {
		this.p = per;
	}

	@FXML
	private void gestionarCli(ActionEvent event) {
		if (event.getSource() == btnAdd) {
			pnlGest.toFront();
			if (tfNombreFlota.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				DialogPane dp = alert.getDialogPane();
				dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
				dp.getStyleClass().add("dialog-pane");
				alert.setTitle(Mensaje.ERROR);
				alert.setHeaderText(Mensaje.OBLIGA);
				alert.setContentText(Mensaje.CONTEXT_INFO);
				alert.showAndWait();
			} else {
				fm = new FlotaMapper();
				Calendar cal = Calendar.getInstance();
				Flota fl = new Flota();
				fl.setNombre(tfNombreFlota.getText());
				fl.setDescripcion(txADescript.getText());
				fl.setTgfPersona(this.p);
				fl.setFechaCreacion(new java.sql.Date(cal.getTimeInMillis()));

				if (fm.save(fl)) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					DialogPane dp = alert.getDialogPane();
					dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
					dp.getStyleClass().add("dialog-pane");
					alert.setTitle(Mensaje.INFO);
					alert.setHeaderText(Mensaje.EXITO);
					alert.setContentText(Mensaje.CONTEXT_INFO_CRUD);
					alert.showAndWait();
					flotaObLista.add(fl);
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
			if (tfNombreFlota.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR);
				DialogPane dp = alert.getDialogPane();
				dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
				dp.getStyleClass().add("dialog-pane");
				alert.setTitle(Mensaje.ERROR);
				alert.setHeaderText(Mensaje.OBLIGA);
				alert.setContentText(Mensaje.CONTEXT_INFO);
				alert.showAndWait();
			} else {
				fm = new FlotaMapper();
				Calendar cal = Calendar.getInstance();
				Flota fl = new Flota();
				fl.setNombre(tfNombreFlota.getText());
				fl.setDescripcion(txADescript.getText());
				fl.setTgfPersona(this.p);
				fl.setFechaCreacion(new java.sql.Date(cal.getTimeInMillis()));
				fl.setIdFlota(this.idFlota);
				if (fm.update(fl)) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					DialogPane dp = alert.getDialogPane();
					dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
					dp.getStyleClass().add("dialog-pane");
					alert.setTitle(Mensaje.INFO);
					alert.setHeaderText(Mensaje.EXITO);
					alert.setContentText(Mensaje.CONTEXT_INFO_CRUD);
					alert.showAndWait();
					flotaObLista.set(tvFlotas.getSelectionModel().getSelectedIndex(), fl);
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
			fm = new FlotaMapper();
			Flota fl = new Flota();
			fl = tvFlotas.getSelectionModel().getSelectedItem();
			if (fm.remove(fl)) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				DialogPane dp = alert.getDialogPane();
				dp.getStylesheets().add(getClass().getResource("/css/dialog.css").toExternalForm());
				dp.getStyleClass().add("dialog-pane");
				alert.setTitle(Mensaje.INFO);
				alert.setHeaderText(Mensaje.EXITO);
				alert.setContentText(Mensaje.CONTEXT_INFO_CRUD);
				alert.showAndWait();
				flotaObLista.remove(tvFlotas.getSelectionModel().getSelectedIndex());
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

		} else if (event.getSource() == btnAddVe) {
			pnlVehi.toFront();
			btnDel.setDisable(true);
			btnUpd.setDisable(true);

		} else if (event.getSource() == btnAddCo) {
			pnlCond.toFront();
			btnDel.setDisable(true);
			btnUpd.setDisable(true);

		} else if (event.getSource() == btnNew) {
			pnlGest.toFront();
			btnAdd.setDisable(false);
			tfNombreFlota.setText("");
			txADescript.setText("");
		}

	}

	@FXML
	private void manageEvents() {
		tvFlotas.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Flota>() {
			@Override
			public void changed(ObservableValue<? extends Flota> observable, Flota oldValue, Flota newValue) {
				if (newValue != null) {
					tfNombreFlota.setText(newValue.getNombre());
					txADescript.setText(newValue.getDescripcion());
					idFlota = newValue.getIdFlota();
					btnAdd.setDisable(true);
					btnUpd.setDisable(false);
					btnDel.setDisable(false);				
				}

			}

		});

	}
	
	@FXML
	private void manageEventsVehic() {
		tvwVehiculos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Vehiculo>() {
			@Override
			public void changed(ObservableValue<? extends Vehiculo> observable, Vehiculo oldValue, Vehiculo newValue) {
				// TODO Auto-generated method stub
				System.out.println( " placa "+ newValue.getPlaca() );
			}
	

		});

	}
	
	

}
