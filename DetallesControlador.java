import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DetallesControlador {

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblEdad;

    @FXML
    private Label lblCarrera;

    public void mostrarDatos(Estudiante estudiante) {

        lblNombre.setText(estudiante.getNombre());

        lblApellido.setText(estudiante.getApellido());

        lblEdad.setText(String.valueOf(estudiante.getEdad()));

        lblCarrera.setText(estudiante.getCarrera());

    }

    @FXML
    private void cerrar() {

        Stage ventana = (Stage) lblNombre.getScene().getWindow();

        ventana.close();

    }

}