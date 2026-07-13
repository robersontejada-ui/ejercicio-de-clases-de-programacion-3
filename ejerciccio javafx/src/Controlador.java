import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controlador {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtPaciente;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtHora;

    @FXML
    private ComboBox<String> cbMedico;

    @FXML
    private ComboBox<String> cbEspecialidad;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TextArea txtMotivo;

    @FXML
    private TableView<Cita> tabla;

    @FXML
    private TableColumn<Cita, String> colCodigo;

    @FXML
    private TableColumn<Cita, String> colPaciente;

    @FXML
    private TableColumn<Cita, String> colMedico;

    @FXML
    private TableColumn<Cita, String> colEspecialidad;

    @FXML
    private TableColumn<Cita, String> colFecha;

    @FXML
    private TableColumn<Cita, String> colHora;

    @FXML
    private TableColumn<Cita, String> colEstado;

    private ObservableList<Cita> lista;

    private ArchivoCitas archivo;

    @FXML
    public void initialize() {

        lista = FXCollections.observableArrayList();
        archivo = new ArchivoCitas();

        cbMedico.getItems().addAll(
                "Dr. Pérez",
                "Dra. García",
                "Dr. Rodríguez",
                "Dra. Martínez");

        cbEspecialidad.getItems().addAll(
                "Medicina General",
                "Cardiología",
                "Pediatría",
                "Dermatología");

        cbEstado.getItems().addAll(
                "Programada",
                "Atendida",
                "Cancelada");

        cbEstado.setValue("Programada");

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colPaciente.setCellValueFactory(new PropertyValueFactory<>("paciente"));
        colMedico.setCellValueFactory(new PropertyValueFactory<>("medico"));
        colEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tabla.setItems(lista);
    }

    @FXML
    public void registrar() {

        try {

            if (txtCodigo.getText().trim().isEmpty()
                    || txtPaciente.getText().trim().isEmpty()
                    || txtCedula.getText().trim().isEmpty()
                    || txtTelefono.getText().trim().isEmpty()
                    || txtHora.getText().trim().isEmpty()
                    || txtMotivo.getText().trim().isEmpty()
                    || dpFecha.getValue() == null
                    || cbMedico.getValue() == null
                    || cbEspecialidad.getValue() == null) {

                mensaje("Debe completar todos los campos.");
                return;
            }

            if (!txtCedula.getText().matches("\\d+")) {
                mensaje("La cédula solo debe contener números.");
                return;
            }

            if (!txtTelefono.getText().matches("\\d+")) {
                mensaje("El teléfono solo debe contener números.");
                return;
            }

            if (!txtHora.getText().matches("([01]?\\d|2[0-3]):[0-5]\\d")) {
                mensaje("La hora debe tener el formato HH:mm");
                return;
            }

            if (dpFecha.getValue().isBefore(LocalDate.now())) {
                mensaje("La fecha no puede ser anterior a hoy.");
                return;
            }

            for (Cita c : lista) {

                if (c.getCodigo().equalsIgnoreCase(txtCodigo.getText())) {
                    mensaje("El código ya existe.");
                    return;
                }

                if (c.getMedico().equals(cbMedico.getValue())
                        && c.getFecha().equals(dpFecha.getValue().toString())
                        && c.getHora().equals(txtHora.getText())) {

                    throw new HorarioOcupadoException(
                            "Ese médico ya tiene una cita en ese horario.");
                }
            }

            Cita cita = new Cita(
                    txtCodigo.getText(),
                    txtPaciente.getText(),
                    txtCedula.getText(),
                    txtTelefono.getText(),
                    cbMedico.getValue(),
                    cbEspecialidad.getValue(),
                    dpFecha.getValue().toString(),
                    txtHora.getText(),
                    txtMotivo.getText(),
                    cbEstado.getValue());

            lista.add(cita);

            limpiar();

            mensaje("Cita registrada correctamente.");

        } catch (HorarioOcupadoException e) {

            mensaje(e.getMessage());

        } catch (Exception e) {

            mensaje("Ocurrió un error al registrar la cita.");
        }
    }

    @FXML
    public void cancelar() {

        try {

            Cita cita = tabla.getSelectionModel().getSelectedItem();

            if (cita == null) {
                mensaje("Seleccione una cita.");
                return;
            }

            cita.setEstado("Cancelada");
            tabla.refresh();

            mensaje("La cita fue cancelada.");

        } catch (Exception e) {

            mensaje("Error al cancelar la cita.");
        }

    }

    @FXML
    public void limpiar() {

        txtCodigo.clear();
        txtPaciente.clear();
        txtCedula.clear();
        txtTelefono.clear();
        txtHora.clear();
        txtMotivo.clear();

        dpFecha.setValue(null);

        cbMedico.getSelectionModel().clearSelection();
        cbEspecialidad.getSelectionModel().clearSelection();
        cbEstado.setValue("Programada");

    }

    @FXML
    public void guardar() {

        try {

            archivo.guardar(lista);

            mensaje("Las citas fueron guardadas correctamente.");

        } catch (IOException e) {

            mensaje("Error al guardar el archivo.");
        }

    }

    @FXML
    public void cargar() {

        try {

            lista.clear();

            lista.addAll(archivo.cargar());

            tabla.refresh();

            mensaje("Las citas fueron cargadas correctamente.");

        } catch (IOException e) {

            mensaje("Error al cargar el archivo.");
        }

    }

    private void mensaje(String texto) {

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Sistema");
        alerta.setHeaderText(null);
        alerta.setContentText(texto);

        alerta.showAndWait();

    }

}