import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoCitas {

    private File archivo;

    public ArchivoCitas() {
        archivo = new File("citas.txt");
    }

    public void guardar(ObservableList<Cita> lista) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (Cita c : lista) {

            String linea = c.getCodigo() + ";" +
                    c.getPaciente() + ";" +
                    c.getCedula() + ";" +
                    c.getTelefono() + ";" +
                    c.getMedico() + ";" +
                    c.getEspecialidad() + ";" +
                    c.getFecha() + ";" +
                    c.getHora() + ";" +
                    c.getMotivo() + ";" +
                    c.getEstado();

            bw.write(linea);
            bw.newLine();
        }

        bw.close();
    }

    public ObservableList<Cita> cargar() throws IOException {

        ObservableList<Cita> lista = FXCollections.observableArrayList();

        if (!archivo.exists()) {
            return lista;
        }

        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String linea;

        while ((linea = br.readLine()) != null) {

            String[] datos = linea.split(";");

            if (datos.length == 10) {

                Cita cita = new Cita(
                        datos[0],
                        datos[1],
                        datos[2],
                        datos[3],
                        datos[4],
                        datos[5],
                        datos[6],
                        datos[7],
                        datos[8],
                        datos[9]);

                lista.add(cita);
            }
        }

        br.close();

        return lista;
    }

}