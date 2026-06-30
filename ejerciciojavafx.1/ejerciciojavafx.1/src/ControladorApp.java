import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ControladorApp {

    @FXML
    private TextField txtCliente;

    @FXML
    private ComboBox<String> cmbBebida;

    @FXML
    private TextField txtCantidad;

    @FXML
    private CheckBox chkPostre;

    @FXML
    private Button btnCalcular;

    @FXML
    private Button btnLimpiar;

    @FXML
    private Label lblResumen;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {

        cmbBebida.getItems().addAll(
                "Café americano",
                "Cappuccino",
                "Chocolate caliente",
                "Jugo natural");

        lblResumen.setText("");
        lblMensaje.setText("Esperando datos de la compra...");
    }

    @FXML
    private void calcularCompra() {

        String cliente = txtCliente.getText().trim();
        String bebida = cmbBebida.getValue();
        String textoCantidad = txtCantidad.getText().trim();

        if (cliente.isEmpty()) {
            lblMensaje.setText("Debe escribir el nombre del cliente.");
            return;
        }

        if (bebida == null) {
            lblMensaje.setText("Seleccione una bebida.");
            return;
        }

        if (textoCantidad.isEmpty()) {
            lblMensaje.setText("Debe escribir la cantidad.");
            return;
        }

        int cantidad;

        try {
            cantidad = Integer.parseInt(textoCantidad);
        } catch (NumberFormatException e) {
            lblMensaje.setText("La cantidad debe ser numérica.");
            return;
        }

        if (cantidad <= 0) {
            lblMensaje.setText("La cantidad debe ser mayor que cero.");
            return;
        }

        double precio = 0;

        switch (bebida) {

            case "Café americano":
                precio = 100;
                break;

            case "Cappuccino":
                precio = 150;
                break;

            case "Chocolate caliente":
                precio = 130;
                break;

            case "Jugo natural":
                precio = 120;
                break;
        }

        double subtotal = precio * cantidad;
        double total = subtotal;

        String postre = "No";

        if (chkPostre.isSelected()) {
            total += 75;
            postre = "Sí";
        }

        String resumen = "";
        resumen += "Cliente: " + cliente;
        resumen += "\nProducto: " + bebida;
        resumen += "\nCantidad: " + cantidad;
        resumen += "\nSubtotal: RD$" + String.format("%.2f", subtotal);
        resumen += "\nPostre: " + postre;
        resumen += "\n--------------------------";
        resumen += "\nTotal: RD$" + String.format("%.2f", total);

        lblResumen.setText(resumen);

        lblMensaje.setText("Compra calculada correctamente.");

    }

    @FXML
    private void limpiar() {

        txtCliente.clear();
        txtCantidad.clear();

        cmbBebida.getSelectionModel().clearSelection();

        chkPostre.setSelected(false);

        lblResumen.setText("");

        lblMensaje.setText("Esperando datos de la compra...");

        txtCliente.requestFocus();
    }

    @FXML
    private void mostrarAyuda(MouseEvent event) {

        lblMensaje.setText("Presione para calcular el total de la compra.");

    }

    @FXML
    private void ocultarAyuda(MouseEvent event) {

        lblMensaje.setText("Esperando datos de la compra...");

    }

    @FXML
    private void calcularConEnter(KeyEvent event) {

        if (event.getCode() == KeyCode.ENTER) {
            calcularCompra();
        }

    }

}