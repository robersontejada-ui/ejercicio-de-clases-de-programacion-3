import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistroControlador {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtEdad;

    @FXML
    private ComboBox<String> cmbCarrera;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {

        cmbCarrera.getItems().addAll(
                "Ingeniería en Sistemas",
                "Administración",
                "Contabilidad",
                "Derecho",
                "Medicina");

    }

    @FXML
    private void registrar() {

        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        String edadTexto = txtEdad.getText().trim();
        String carrera = cmbCarrera.getValue();

        if (nombre.isEmpty() || apellido.isEmpty() || edadTexto.isEmpty() || carrera == null) {

            lblMensaje.setText("Complete todos los campos.");

            return;
        }

        int edad;

        try {

            edad = Integer.parseInt(edadTexto);

        } catch (NumberFormatException e) {

            lblMensaje.setText("La edad debe ser un número.");

            return;

        }

        Estudiante estudiante = new Estudiante(nombre, apellido, edad, carrera);

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("detalles.fxml"));

            Scene scene = new Scene(loader.load());

            DetallesControlador controlador = loader.getController();

            controlador.mostrarDatos(estudiante);

            Stage ventana = new Stage();

            ventana.setTitle("Datos del Estudiante");

            ventana.setScene(scene);

            ventana.setResizable(false);

            ventana.show();

        } catch (IOException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setHeaderText(null);

            alert.setContentText("No se pudo abrir la ventana.");

            alert.showAndWait();

        }

    }

    @FXML
    private void limpiar() {

        txtNombre.clear();
        txtApellido.clear();
        txtEdad.clear();

        cmbCarrera.getSelectionModel().clearSelection();

        lblMensaje.setText("Complete los datos del estudiante.");

        txtNombre.requestFocus();

    }

}
